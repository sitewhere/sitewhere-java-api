/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitewhere.rest.model.area.Area;
import com.sitewhere.rest.model.area.AreaType;
import com.sitewhere.rest.model.area.Zone;
import com.sitewhere.rest.model.area.request.AreaCreateRequest;
import com.sitewhere.rest.model.area.request.AreaTypeCreateRequest;
import com.sitewhere.rest.model.area.request.ZoneCreateRequest;
import com.sitewhere.rest.model.batch.BatchOperation;
import com.sitewhere.rest.model.common.MetadataProvider;
import com.sitewhere.rest.model.datatype.JsonDateSerializer;
import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.DeviceAssignment;
import com.sitewhere.rest.model.device.DeviceType;
import com.sitewhere.rest.model.device.command.DeviceCommand;
import com.sitewhere.rest.model.device.event.DeviceAlert;
import com.sitewhere.rest.model.device.event.DeviceCommandInvocation;
import com.sitewhere.rest.model.device.event.DeviceEventBatch;
import com.sitewhere.rest.model.device.event.DeviceEventBatchResponse;
import com.sitewhere.rest.model.device.event.DeviceLocation;
import com.sitewhere.rest.model.device.event.DeviceMeasurement;
import com.sitewhere.rest.model.device.event.request.DeviceAlertCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceCommandInvocationCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceLocationCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceMeasurementCreateRequest;
import com.sitewhere.rest.model.device.group.DeviceGroup;
import com.sitewhere.rest.model.device.request.DeviceCommandCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceGroupCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceGroupElementCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceStreamCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceTypeCreateRequest;
import com.sitewhere.rest.model.device.streaming.DeviceStream;
import com.sitewhere.rest.model.search.AssetSearchResults;
import com.sitewhere.rest.model.search.DateRangeSearchCriteria;
import com.sitewhere.rest.model.search.DeviceAlertSearchResults;
import com.sitewhere.rest.model.search.DeviceAssignmentSearchResults;
import com.sitewhere.rest.model.search.DeviceCommandInvocationSearchResults;
import com.sitewhere.rest.model.search.DeviceCommandSearchResults;
import com.sitewhere.rest.model.search.DeviceGroupElementSearchResults;
import com.sitewhere.rest.model.search.DeviceGroupSearchResults;
import com.sitewhere.rest.model.search.DeviceLocationSearchResults;
import com.sitewhere.rest.model.search.DeviceSearchResults;
import com.sitewhere.rest.model.search.DeviceStreamSearchResults;
import com.sitewhere.rest.model.search.DeviceTypeSearchResults;
import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.ZoneSearchResults;
import com.sitewhere.rest.model.system.Version;
import com.sitewhere.spi.ISiteWhereClient;
import com.sitewhere.spi.ITenantAuthentication;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.device.event.IDeviceMeasurement;
import com.sitewhere.spi.device.request.IDeviceAssignmentCreateRequest;
import com.sitewhere.spi.web.ISiteWhereWebConstants;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Client for interacting with SiteWhere REST services.
 * 
 * @author dadams
 */
public class SiteWhereClient implements ISiteWhereClient {

    /** Default protocol for REST services */
    public static final String DEFAULT_PROTOCOL = "http";

    /** Default hostname for REST services */
    public static final String DEFAULT_HOSTNAME = "localhost";

    /** Default port for REST services */
    public static final int DEFAULT_PORT = 8080;

    /** Relative URI for SiteWhere authentication APIs */
    public static final String AUTH_RELATIVE_URL = "/sitewhere/authapi/";

    /** Relative URI for SiteWhere REST APIs */
    public static final String REST_RELATIVE_URL = "/sitewhere/api/";

    /** Default REST username */
    public static final String DEFAULT_USERNAME = "admin";

    /** Default REST password */
    public static final String DEFAULT_PASSWORD = "password";

    /** Default connection timeout in milliseconds */
    public static final int DEFAULT_CONNECT_TIMEOUT = 3 * 1000;

    /** Protocol used */
    private String protocol = DEFAULT_PROTOCOL;

    /** Hostname used */
    private String hostname = DEFAULT_HOSTNAME;

    /** Port used */
    private int port = DEFAULT_PORT;

    /** Username used for REST calls */
    private String username = DEFAULT_USERNAME;

    /** Password used for REST calls */
    private String password = DEFAULT_PASSWORD;

    /** Connect timeout */
    private int connectTimeout = DEFAULT_CONNECT_TIMEOUT;

    /** Retrofit interface for SiteWhere authentication */
    private AuthenticationRetrofit authRetrofit;

    /** Retrofit interface for SiteWhere global REST APIs */
    private SiteWhereRestRetrofit restRetrofit;

    /** JWT for authenticating with server */
    private String jwt;

    /**
     * Get new builder class.
     * 
     * @return
     */
    public static Builder newBuilder() {
	return new Builder();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getSiteWhereVersion()
     */
    @Override
    public Version getSiteWhereVersion() throws SiteWhereException {
	Call<Version> call = getRestRetrofit().getVersion();
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#createDeviceType(com.sitewhere.spi.
     * ITenantAuthentication,
     * com.sitewhere.rest.model.device.request.DeviceTypeCreateRequest)
     */
    @Override
    public DeviceType createDeviceType(ITenantAuthentication tenant, DeviceTypeCreateRequest request)
	    throws SiteWhereException {
	Call<DeviceType> call = getRestRetrofit().createDeviceType(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see
     * com.sitewhere.spi.ISiteWhereClient#getDeviceTypeByToken(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String)
     */
    @Override
    public DeviceType getDeviceTypeByToken(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<DeviceType> call = getRestRetrofit().getDeviceTypeByToken(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#updateDeviceType(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String,
     * com.sitewhere.rest.model.device.request.DeviceTypeCreateRequest)
     */
    @Override
    public DeviceType updateDeviceType(ITenantAuthentication tenant, String token, DeviceTypeCreateRequest request)
	    throws SiteWhereException {
	Call<DeviceType> call = getRestRetrofit().updateDeviceType(token, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    @Override
    public DeviceTypeSearchResults listDeviceTypes(boolean includeDeleted, boolean includeDetailedAssetInfo,
	    SearchCriteria criteria) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceType deleteDeviceType(String token, boolean deletePermanently) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceCommand createDeviceCommand(String specificationToken, DeviceCommandCreateRequest request)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceCommandSearchResults listDeviceCommands(String specificationToken, boolean includeDeleted)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Area createArea(AreaCreateRequest request) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Area getAreaByToken(String token) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    
    @Override
    public AreaType getAreaTypeByToken(ITenantAuthentication tenant, String areaTypeToken) throws SiteWhereException {
	Call<AreaType> call = getRestRetrofit().getAreaTypeByToken(areaTypeToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    @Override
    public AreaType createAreaType(ITenantAuthentication tenant, AreaTypeCreateRequest request)
	    throws SiteWhereException {
	Call<AreaType> call = getRestRetrofit().createAreaType(request, createHeadersFor(tenant));
	return processRestCall(call);
    }
    
    @Override
    public AreaType updateAreaType(ITenantAuthentication tenant, String areaTypeToken, AreaTypeCreateRequest request)
	    throws SiteWhereException {
	Call<AreaType> call = getRestRetrofit().updateAreaType(areaTypeToken, request, createHeadersFor(tenant));
	return processRestCall(call);
    }


    @Override
    public AreaType deleteAreaType(ITenantAuthentication tenant, String areaTypeToken) throws SiteWhereException {
	Call<AreaType> call = getRestRetrofit().deleteAreaType(areaTypeToken, createHeadersFor(tenant));
	return processRestCall(call);
    }
    
    @Override
    public Zone createZone(String siteToken, ZoneCreateRequest request) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ZoneSearchResults listZonesForSite(String siteToken) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Device createDevice(DeviceCreateRequest request) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Device getDeviceByHardwareId(String hardwareId) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Device updateDevice(String hardwareId, DeviceCreateRequest request) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceSearchResults listDevices(boolean includeDeleted, boolean excludeAssigned,
	    boolean populateSpecification, boolean populateAssignment, DateRangeSearchCriteria criteria)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Device deleteDevice(String hardwareId, boolean force) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAssignment getCurrentAssignmentForDevice(String hardwareId) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAssignmentSearchResults listDeviceAssignmentHistory(String hardwareId) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAssignmentSearchResults getAssignmentsForAsset(String siteToken, String assetModuleId, String assetId,
	    DeviceAssignmentStatus status, SearchCriteria criteria) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceEventBatchResponse addDeviceEventBatch(String hardwareId, DeviceEventBatch batch)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAssignment createDeviceAssignment(IDeviceAssignmentCreateRequest request) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAssignment getDeviceAssignmentByToken(String assignmentToken) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAssignmentSearchResults listAssignmentsForSite(String token) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAssignment deleteDeviceAssignment(String assignmentToken, boolean force) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAssignment updateDeviceAssignmentMetadata(String token, MetadataProvider metadata)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceMeasurement createDeviceMeasurements(String assignmentToken,
	    DeviceMeasurementCreateRequest measurements) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public SearchResults<IDeviceMeasurement> listDeviceMeasurements(String assignmentToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceLocation createDeviceLocation(String assignmentToken, DeviceLocationCreateRequest request)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceLocationSearchResults listDeviceLocations(String assignmentToken, DateRangeSearchCriteria criteria)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAlert createDeviceAlert(String assignmentToken, DeviceAlertCreateRequest request)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceAlertSearchResults listDeviceAlerts(String assignmentToken, DateRangeSearchCriteria criteria)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceCommandInvocation createDeviceCommandInvocation(String assignmentToken,
	    DeviceCommandInvocationCreateRequest request) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceCommandInvocationSearchResults listDeviceCommandInvocations(String assignmentToken,
	    DateRangeSearchCriteria criteria) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceStream createDeviceStream(String assignmentToken, DeviceStreamCreateRequest request)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceStream getDeviceStream(String assignmentToken, String streamId) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceStreamSearchResults listDeviceStreams(String assignmentToken, DateRangeSearchCriteria criteria)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void addDeviceStreamData(String assignmentToken, String streamId, long sequenceNumber, byte[] data)
	    throws SiteWhereException {
	// TODO Auto-generated method stub

    }

    @Override
    public byte[] getDeviceStreamData(String assignmentToken, String streamId, long sequenceNumber)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public byte[] listDeviceStreamData(String assignmentToken, String streamId, DateRangeSearchCriteria criteria)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public BatchOperation createBatchCommandInvocation(String batchToken, String commandToken,
	    Map<String, String> parameters, List<String> hardwareIds) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceGroup createDeviceGroup(DeviceGroupCreateRequest request) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceGroup getDeviceGroupByToken(String token) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceGroup deleteDeviceGroup(String token) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceGroupSearchResults listDeviceGroups(String role, SearchCriteria criteria, boolean includeDeleted)
	    throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceGroupElementSearchResults addDeviceGroupElements(String groupToken,
	    List<DeviceGroupElementCreateRequest> elements) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceGroupElementSearchResults listDeviceGroupElements(String groupToken, boolean includeDetails,
	    SearchCriteria criteria) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DeviceGroupElementSearchResults deleteDeviceGroupElements(String groupToken,
	    List<DeviceGroupElementCreateRequest> elements) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public AssetSearchResults getAssetsByModuleId(String moduleId, String criteria) throws SiteWhereException {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     * Authentication for default tenant.
     * 
     * @return
     */
    public static ITenantAuthentication defaultTenant() {
	TenantAuthentication auth = new TenantAuthentication();
	auth.setTenantToken("default");
	auth.setTenantAuthToken("sitewhere1234567890");
	return auth;
    }

    /**
     * Authentication for specific tenant.
     * 
     * @param tenantToken
     * @param tenantAuthToken
     * @return
     */
    public static ITenantAuthentication forTenant(String tenantToken, String tenantAuthToken) {
	TenantAuthentication auth = new TenantAuthentication();
	auth.setTenantToken(tenantToken);
	auth.setTenantAuthToken(tenantAuthToken);
	return auth;
    }

    /**
     * Common processing logic for REST calls.
     * 
     * @param call
     * @return
     * @throws SiteWhereException
     */
    protected <T> T processRestCall(Call<T> call) throws SiteWhereException {
	try {
	    Response<T> response = call.execute();
	    if (response.isSuccessful()) {
		return response.body();
	    } else {
		throw new SiteWhereException(response.toString());
	    }
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#initialize()
     */
    @Override
    public ISiteWhereClient initialize() throws SiteWhereException {
	Retrofit authRetrofitSettings = new Retrofit.Builder().baseUrl(getAuthApiUrl()).client(buildBasicAuthClient())
		.build();
	this.authRetrofit = authRetrofitSettings.create(AuthenticationRetrofit.class);

	Retrofit restRetrofitSettings = new Retrofit.Builder().baseUrl(getRestApiUrl()).client(buildGlobalClient())
		.addConverterFactory(JacksonConverterFactory.create()).build();
	this.restRetrofit = restRetrofitSettings.create(SiteWhereRestRetrofit.class);

	try {
	    Response<Void> jwtResponse = getAuthRetrofit().getJwt().execute();
	    if (!jwtResponse.isSuccessful()) {
		throw new SiteWhereException("Error obtaining JWT: " + jwtResponse);
	    }

	    Headers headers = jwtResponse.headers();
	    List<String> jwts = headers.values(ISiteWhereWebConstants.HEADER_JWT);
	    if (jwts.size() > 0) {
		this.jwt = jwts.get(0);
	    } else {
		throw new SiteWhereException("No JWT returned in server response.");
	    }

	    return this;
	} catch (IOException e) {
	    throw new SiteWhereException("Exception obtaining JWT.", e);
	}
    }

    /**
     * Build client that includes a HTTP basic auth header.
     * 
     * @return
     */
    protected OkHttpClient buildBasicAuthClient() {
	OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	httpClient.addInterceptor(new Interceptor() {
	    @Override
	    public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
		Request original = chain.request();

		// Request customization: add request headers
		Request.Builder requestBuilder = original.newBuilder().header("Authorization", getAuthHeader());
		Request request = requestBuilder.build();
		return chain.proceed(request);
	    }
	});
	return httpClient.build();
    }

    /**
     * Build client that adds headers needed for global calls.
     * 
     * @return
     */
    protected OkHttpClient buildGlobalClient() {
	OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	httpClient.addInterceptor(new Interceptor() {
	    @Override
	    public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
		Request original = chain.request();

		// Request customization: add request headers
		Request.Builder requestBuilder = original.newBuilder().header("Authorization",
			"Bearer " + SiteWhereClient.this.jwt);
		Request request = requestBuilder.build();
		return chain.proceed(request);
	    }
	});
	return httpClient.build();
    }

    /**
     * Create headers based on tenant authentication information.
     * 
     * @param tenant
     * @return
     */
    protected Map<String, String> createHeadersFor(ITenantAuthentication tenant) {
	Map<String, String> headers = new HashMap<>();
	headers.put(ISiteWhereWebConstants.HEADER_TENANT_ID, tenant.getTenantToken());
	headers.put(ISiteWhereWebConstants.HEADER_TENANT_AUTH, tenant.getTenantAuthToken());
	return headers;
    }

    /**
     * Builder class.
     */
    public static class Builder {

	private SiteWhereClient client = new SiteWhereClient();

	public ISiteWhereClient build() {
	    return client;
	}

	/**
	 * Set connection parameters for client.
	 * 
	 * @param protocol
	 * @param hostname
	 * @param port
	 * @return
	 */
	public Builder withConnectionTo(String protocol, String hostname, int port) {
	    client.setProtocol(protocol);
	    client.setHostname(hostname);
	    client.setPort(port);
	    return this;
	}

	public Builder forUser(String username, String password) {
	    client.setUsername(username);
	    client.setPassword(password);
	    return this;
	}
    }

    /**
     * Get fields associated with search criteria.
     * 
     * @return
     */
    protected String getSearchCriteriaFields(SearchCriteria criteria) {
	String result = "page={page}&pageSize={pageSize}";
	if (criteria instanceof DateRangeSearchCriteria) {
	    DateRangeSearchCriteria dates = (DateRangeSearchCriteria) criteria;
	    if (dates.getStartDate() != null) {
		result += "&startDate={startDate}";
	    }
	    if (dates.getEndDate() != null) {
		result += "&endDate={endDate}";
	    }
	}
	return result;
    }

    /**
     * Add fields from {@link SearchCriteria}.
     * 
     * @param vars
     * @param criteria
     */
    protected void addSearchCriteria(Map<String, String> vars, SearchCriteria criteria) {
	if (criteria != null) {
	    if (criteria.getPageNumber() != null) {
		vars.put("page", String.valueOf(criteria.getPageNumber()));
	    }

	    if (criteria.getPageSize() != null) {
		vars.put("pageSize", String.valueOf(criteria.getPageSize()));
	    }
	}
	if (criteria instanceof DateRangeSearchCriteria) {
	    DateRangeSearchCriteria dates = (DateRangeSearchCriteria) criteria;
	    if (dates.getStartDate() != null) {
		vars.put("startDate", JsonDateSerializer.serialize(dates.getStartDate()));
	    }

	    if (dates.getEndDate() != null) {
		vars.put("endDate", JsonDateSerializer.serialize(dates.getEndDate()));
	    }
	}
    }

    /**
     * Build URL for REST API access.
     * 
     * @return
     */
    protected String getRestApiUrl() {
	return getProtocol() + "://" + getHostname() + ":" + String.valueOf(getPort()) + REST_RELATIVE_URL;
    }

    /**
     * Build URL for authentication API access.
     * 
     * @return
     */
    protected String getAuthApiUrl() {
	return getProtocol() + "://" + getHostname() + ":" + String.valueOf(getPort()) + AUTH_RELATIVE_URL;
    }

    /**
     * Encode the username and password to make the authorization header.
     * 
     * @return
     */
    protected String getAuthHeader() {
	String token = getUsername() + ":" + getPassword();
	String encoded = new String(Base64.encode(token.getBytes()));
	return "Basic " + encoded;
    }

    public AuthenticationRetrofit getAuthRetrofit() {
	return authRetrofit;
    }

    public void setAuthRetrofit(AuthenticationRetrofit authRetrofit) {
	this.authRetrofit = authRetrofit;
    }

    public SiteWhereRestRetrofit getRestRetrofit() {
	return restRetrofit;
    }

    public void setRestRetrofit(SiteWhereRestRetrofit restRetrofit) {
	this.restRetrofit = restRetrofit;
    }

    public String getProtocol() {
	return protocol;
    }

    public void setProtocol(String protocol) {
	this.protocol = protocol;
    }

    public String getHostname() {
	return hostname;
    }

    public void setHostname(String hostname) {
	this.hostname = hostname;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public int getConnectTimeout() {
	return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
	this.connectTimeout = connectTimeout;
    }

    public String getJwt() {
	return jwt;
    }

    public void setJwt(String jwt) {
	this.jwt = jwt;
    }
}