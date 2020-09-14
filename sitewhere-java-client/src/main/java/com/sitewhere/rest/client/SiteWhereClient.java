/**
 * Copyright © 2014-2020 The SiteWhere Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sitewhere.rest.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.sitewhere.rest.model.area.Area;
import com.sitewhere.rest.model.area.AreaType;
import com.sitewhere.rest.model.area.Zone;
import com.sitewhere.rest.model.area.request.AreaCreateRequest;
import com.sitewhere.rest.model.area.request.AreaTypeCreateRequest;
import com.sitewhere.rest.model.area.request.ZoneCreateRequest;
import com.sitewhere.rest.model.asset.Asset;
import com.sitewhere.rest.model.asset.AssetType;
import com.sitewhere.rest.model.asset.marshaling.MarshaledAsset;
import com.sitewhere.rest.model.asset.request.AssetCreateRequest;
import com.sitewhere.rest.model.asset.request.AssetTypeCreateRequest;
import com.sitewhere.rest.model.batch.BatchElement;
import com.sitewhere.rest.model.batch.BatchOperation;
import com.sitewhere.rest.model.batch.request.BatchCommandInvocationRequest;
import com.sitewhere.rest.model.batch.request.InvocationByDeviceCriteriaRequest;
import com.sitewhere.rest.model.customer.Customer;
import com.sitewhere.rest.model.customer.CustomerType;
import com.sitewhere.rest.model.customer.request.CustomerCreateRequest;
import com.sitewhere.rest.model.customer.request.CustomerTypeCreateRequest;
import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.DeviceElementMapping;
import com.sitewhere.rest.model.device.DeviceStatus;
import com.sitewhere.rest.model.device.DeviceType;
import com.sitewhere.rest.model.device.asset.DeviceAlertWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceCommandResponseWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceEventWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceLocationWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceMeasurementWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceStateChangeWithAsset;
import com.sitewhere.rest.model.device.charting.ChartSeries;
import com.sitewhere.rest.model.device.command.DeviceCommand;
import com.sitewhere.rest.model.device.command.DeviceCommandNamespace;
import com.sitewhere.rest.model.device.event.DeviceCommandInvocation;
import com.sitewhere.rest.model.device.event.DeviceCommandResponse;
import com.sitewhere.rest.model.device.event.DeviceEventBatch;
import com.sitewhere.rest.model.device.event.DeviceEventBatchResponse;
import com.sitewhere.rest.model.device.event.request.DeviceAlertCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceCommandInvocationCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceCommandResponseCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceLocationCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceMeasurementCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceStateChangeCreateRequest;
import com.sitewhere.rest.model.device.event.view.DeviceCommandInvocationSummary;
import com.sitewhere.rest.model.device.group.DeviceGroup;
import com.sitewhere.rest.model.device.group.DeviceGroupElement;
import com.sitewhere.rest.model.device.marshaling.MarshaledArea;
import com.sitewhere.rest.model.device.marshaling.MarshaledAreaType;
import com.sitewhere.rest.model.device.marshaling.MarshaledCustomer;
import com.sitewhere.rest.model.device.marshaling.MarshaledDevice;
import com.sitewhere.rest.model.device.marshaling.MarshaledDeviceAssignment;
import com.sitewhere.rest.model.device.request.DeviceAssignmentBulkRequest;
import com.sitewhere.rest.model.device.request.DeviceAssignmentCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceCommandCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceGroupCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceGroupElementCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceStatusCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceTypeCreateRequest;
import com.sitewhere.rest.model.device.state.DeviceState;
import com.sitewhere.rest.model.scheduling.Schedule;
import com.sitewhere.rest.model.scheduling.ScheduledJob;
import com.sitewhere.rest.model.scheduling.request.ScheduleCreateRequest;
import com.sitewhere.rest.model.scheduling.request.ScheduledJobCreateRequest;
import com.sitewhere.rest.model.search.DateRangeSearchCriteria;
import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.TreeNode;
import com.sitewhere.rest.model.search.area.AreaResponseFormat;
import com.sitewhere.rest.model.search.area.AreaSearchCriteria;
import com.sitewhere.rest.model.search.area.AreaTypeSearchCriteria;
import com.sitewhere.rest.model.search.asset.AssetSearchCriteria;
import com.sitewhere.rest.model.search.asset.AssetTypeSearchCriteria;
import com.sitewhere.rest.model.search.batch.BatchOperationSearchCriteria;
import com.sitewhere.rest.model.search.customer.CustomerResponseFormat;
import com.sitewhere.rest.model.search.customer.CustomerSearchCriteria;
import com.sitewhere.rest.model.search.customer.CustomerTypeResponseFormat;
import com.sitewhere.rest.model.search.customer.CustomerTypeSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceAssignmentResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceAssignmentSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceByGroupResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceCommandSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceGroupElementResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceGroupElementSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceGroupSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceStateResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceStateSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceStatusSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceTypeResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceTypeSearchCriteria;
import com.sitewhere.rest.model.search.device.ZoneSearchCriteria;
import com.sitewhere.rest.model.search.scheduling.ScheduleResponseFormat;
import com.sitewhere.rest.model.search.scheduling.ScheduleSearchCriteria;
import com.sitewhere.rest.model.search.scheduling.ScheduledJobResponseFormat;
import com.sitewhere.rest.model.search.scheduling.ScheduledJobSearchCriteria;
import com.sitewhere.rest.model.search.tenant.TenantSearchCriteria;
import com.sitewhere.rest.model.system.Version;
import com.sitewhere.rest.model.tenant.Tenant;
import com.sitewhere.rest.model.tenant.request.TenantCreateRequest;
import com.sitewhere.rest.model.user.GrantedAuthority;
import com.sitewhere.rest.model.user.GrantedAuthorityHierarchyNode;
import com.sitewhere.rest.model.user.User;
import com.sitewhere.rest.model.user.request.GrantedAuthorityCreateRequest;
import com.sitewhere.rest.model.user.request.UserCreateRequest;
import com.sitewhere.spi.ISiteWhereClient;
import com.sitewhere.spi.ITenantAuthentication;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.web.ISiteWhereWebConstants;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Client for interacting with SiteWhere REST services.
 */
public class SiteWhereClient implements ISiteWhereClient {

    /** ISO 8601 Date Fromatter */
    private static DateTimeFormatter ISO8601_FORMATTER = ISODateTimeFormat.dateTime();

    /** Default protocol for REST services */
    public static final String DEFAULT_PROTOCOL = "http";

    /** Default hostname for REST services */
    public static final String DEFAULT_HOSTNAME = "localhost";

    /** Default port for REST services */
    public static final int DEFAULT_PORT = 80;

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

    /** HTTP Content-Disposition Header */
    private static final String CONTENT_DISPOSITION_HEADER = "content-disposition";

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

    // ------------------------------------------------------------------------
    // Area Types
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listAreaTypes()
     */
    @Override
    public SearchResults<AreaType> listAreaTypes(ITenantAuthentication tenant, AreaTypeSearchCriteria searchCriteria)
	    throws SiteWhereException {
	Call<SearchResults<AreaType>> call = getRestRetrofit().listAreaTypes(
		searchCriteria.getIncludeContainedAreaTypes(), searchCriteria.getPageNumber(),
		searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getAreaTypeByToken()
     */
    @Override
    public MarshaledAreaType getAreaTypeByToken(ITenantAuthentication tenant, String areaTypeToken)
	    throws SiteWhereException {
	Call<MarshaledAreaType> call = getRestRetrofit().getAreaTypeByToken(areaTypeToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createAreaType()
     */
    @Override
    public AreaType createAreaType(ITenantAuthentication tenant, AreaTypeCreateRequest request)
	    throws SiteWhereException {
	Call<AreaType> call = getRestRetrofit().createAreaType(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateAreaType()
     */
    @Override
    public AreaType updateAreaType(ITenantAuthentication tenant, String areaTypeToken, AreaTypeCreateRequest request)
	    throws SiteWhereException {
	Call<AreaType> call = getRestRetrofit().updateAreaType(areaTypeToken, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteAreaType()
     */
    @Override
    public AreaType deleteAreaType(ITenantAuthentication tenant, String areaTypeToken) throws SiteWhereException {
	Call<AreaType> call = getRestRetrofit().deleteAreaType(areaTypeToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForAreaType()
     */
    @Override
    public byte[] getLabelForAreaType(ITenantAuthentication tenant, String areaTypeToken, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForAreaType(areaTypeToken, generatorId,
		createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    // ------------------------------------------------------------------------
    // Areas
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listAreas()
     */
    @Override
    public SearchResults<Area> listAreas(ITenantAuthentication tenant, AreaSearchCriteria searchCriteria,
	    AreaResponseFormat responseFormat) throws SiteWhereException {
	Call<SearchResults<Area>> call = getRestRetrofit().listAreas(searchCriteria.getAreaTypeToken(),
		responseFormat.getIncludeAreaType(), responseFormat.getIncludeAssignments(),
		responseFormat.getIncludeZones(), searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
		searchCriteria.getParentAreaToken(), searchCriteria.getRootOnly(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getAreaByToken()
     */
    @Override
    public MarshaledArea getAreaByToken(ITenantAuthentication tenant, String areaToken) throws SiteWhereException {
	Call<MarshaledArea> call = getRestRetrofit().getAreaByToken(areaToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createArea()
     */
    @Override
    public Area createArea(ITenantAuthentication tenant, AreaCreateRequest request) throws SiteWhereException {
	Call<Area> call = getRestRetrofit().createArea(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateArea()
     */
    @Override
    public Area updateArea(ITenantAuthentication tenant, String areaToken, AreaCreateRequest request)
	    throws SiteWhereException {
	Call<Area> call = getRestRetrofit().updateArea(areaToken, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteArea()
     */
    @Override
    public Area deleteArea(ITenantAuthentication tenant, String areaToken) throws SiteWhereException {
	Call<Area> call = getRestRetrofit().deleteArea(areaToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listAlertsForArea()
     */
    @Override
    public SearchResults<DeviceAlertWithAsset> listAlertsForArea(ITenantAuthentication tenant, String areaToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceAlertWithAsset>> call = getRestRetrofit().listAlertsForArea(areaToken,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceAssignmentsForArea()
     */
    @Override
    public SearchResults<MarshaledDeviceAssignment> listDeviceAssignmentsForArea(ITenantAuthentication tenant,
	    String areaToken, DeviceAssignmentSearchCriteria searchCriteria,
	    DeviceAssignmentResponseFormat responseFormat) throws SiteWhereException {
	Call<SearchResults<MarshaledDeviceAssignment>> call = getRestRetrofit().listDeviceAssignmentsForArea(areaToken,
		assembleList(searchCriteria.getAssignmentStatuses()), responseFormat.getIncludeDevice(),
		responseFormat.getIncludeCustomer(), responseFormat.getIncludeArea(), responseFormat.getIncludeAsset(),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listCommandInvocationsForArea()
     */
    @Override
    public SearchResults<DeviceCommandInvocation> listCommandInvocationsForArea(ITenantAuthentication tenant,
	    String areaToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceCommandInvocation>> call = getRestRetrofit().listCommandInvocationsForArea(areaToken,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForArea()
     */
    @Override
    public byte[] getLabelForArea(ITenantAuthentication tenant, String areaToken, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForArea(areaToken, generatorId, createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listLocationsForArea()
     */
    @Override
    public SearchResults<DeviceLocationWithAsset> listLocationsForArea(ITenantAuthentication tenant, String areaToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceLocationWithAsset>> call = getRestRetrofit().listLocationsForArea(areaToken,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listMeasurementsForArea()
     */
    @Override
    public SearchResults<DeviceMeasurementWithAsset> listMeasurementsForArea(ITenantAuthentication tenant,
	    String areaToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceMeasurementWithAsset>> call = getRestRetrofit().listMeasurementsForArea(areaToken,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listCommandResponsesForArea()
     */
    @Override
    public SearchResults<DeviceCommandResponseWithAsset> listCommandResponsesForArea(ITenantAuthentication tenant,
	    String areaToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceCommandResponseWithAsset>> call = getRestRetrofit().listCommandResponsesForArea(
		areaToken, toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listStateChangesForArea()
     */
    @Override
    public SearchResults<DeviceStateChangeWithAsset> listStateChangesForArea(ITenantAuthentication tenant,
	    String areaToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceStateChangeWithAsset>> call = getRestRetrofit().listStateChangesForArea(areaToken,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#areaTree()
     */
    @Override
    public List<TreeNode> areaTree(ITenantAuthentication tenant) throws SiteWhereException {
	Call<List<TreeNode>> call = getRestRetrofit().areaTree(createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Asset Types
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listAssetTypes()
     */
    @Override
    public SearchResults<AssetType> listAssetTypes(ITenantAuthentication tenant, AssetTypeSearchCriteria searchCriteria)
	    throws SiteWhereException {
	Call<SearchResults<AssetType>> call = getRestRetrofit().listAssetTypes(searchCriteria.getPageNumber(),
		searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getAssetTypeByToken()
     */
    @Override
    public AssetType getAssetTypeByToken(ITenantAuthentication tenant, String assetTypeToken)
	    throws SiteWhereException {
	Call<AssetType> call = getRestRetrofit().getAssetTypeByToken(assetTypeToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createAssetType()
     */
    @Override
    public AssetType createAssetType(ITenantAuthentication tenant, AssetTypeCreateRequest request)
	    throws SiteWhereException {
	Call<AssetType> call = getRestRetrofit().createAssetType(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateAssetType()
     */
    @Override
    public AssetType updateAssetType(ITenantAuthentication tenant, String assetTypeToken,
	    AssetTypeCreateRequest request) throws SiteWhereException {
	Call<AssetType> call = getRestRetrofit().updateAssetType(assetTypeToken, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteAssetType()
     */
    @Override
    public AssetType deleteAssetType(ITenantAuthentication tenant, String assetTypeToken) throws SiteWhereException {
	Call<AssetType> call = getRestRetrofit().deleteAssetType(assetTypeToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForAssetType()
     */
    @Override
    public byte[] getLabelForAssetType(ITenantAuthentication tenant, String assetTypeToken, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForAssetType(assetTypeToken, generatorId,
		createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    // ------------------------------------------------------------------------
    // Asset
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listAssets()
     */
    @Override
    public SearchResults<Asset> listAssets(ITenantAuthentication tenant, AssetSearchCriteria searchCriteria)
	    throws SiteWhereException {
	Call<SearchResults<Asset>> call = getRestRetrofit().listAssets(searchCriteria.getAssetTypeToken(),
		searchCriteria.getIncludeAssetType(), searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getAssetByToken()
     */
    @Override
    public MarshaledAsset getAssetByToken(ITenantAuthentication tenant, String assetToken) throws SiteWhereException {
	Call<MarshaledAsset> call = getRestRetrofit().getAssetByToken(assetToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createAsset()
     */
    @Override
    public Asset createAsset(ITenantAuthentication tenant, AssetCreateRequest request) throws SiteWhereException {
	Call<Asset> call = getRestRetrofit().createAsset(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateAsset()
     */
    @Override
    public Asset updateAsset(ITenantAuthentication tenant, String assetToken, AssetCreateRequest request)
	    throws SiteWhereException {
	Call<Asset> call = getRestRetrofit().updateAsset(assetToken, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteAsset()
     */
    @Override
    public Asset deleteAsset(ITenantAuthentication tenant, String assetToken) throws SiteWhereException {
	Call<Asset> call = getRestRetrofit().deleteAsset(assetToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForAsset()
     */
    @Override
    public byte[] getLabelForAsset(ITenantAuthentication tenant, String assetToken, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForAsset(assetToken, generatorId, createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    // ------------------------------------------------------------------------
    // Assignments
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceAssignments()
     */
    @Override
    public SearchResults<MarshaledDeviceAssignment> listDeviceAssignments(ITenantAuthentication tenant,
	    DeviceAssignmentSearchCriteria searchCriteria, DeviceAssignmentResponseFormat format)
	    throws SiteWhereException {
	Call<SearchResults<MarshaledDeviceAssignment>> call = getRestRetrofit().listDeviceAssignments(
		assembleTokenList(searchCriteria.getAreaTokens()), format.getIncludeArea(),
		assembleTokenList(searchCriteria.getAssetTokens()), format.getIncludeAsset(),
		assembleTokenList(searchCriteria.getCustomerTokens()), format.getIncludeCustomer(),
		assembleTokenList(searchCriteria.getDeviceTokens()), format.getIncludeDevice(),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceAssignmentByToken()
     */
    @Override
    public MarshaledDeviceAssignment getDeviceAssignmentByToken(ITenantAuthentication tenant, String token)
	    throws SiteWhereException {
	Call<MarshaledDeviceAssignment> call = getRestRetrofit().getDeviceAssignmentByToken(token,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createDeviceAssignment()
     */
    @Override
    public MarshaledDeviceAssignment createDeviceAssignment(ITenantAuthentication tenant,
	    DeviceAssignmentCreateRequest request) throws SiteWhereException {
	Call<MarshaledDeviceAssignment> call = getRestRetrofit().createDeviceAssignment(request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateDeviceAssignment()
     */
    @Override
    public MarshaledDeviceAssignment updateDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceAssignmentCreateRequest request) throws SiteWhereException {
	Call<MarshaledDeviceAssignment> call = getRestRetrofit().updateDeviceAssignment(token, request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteDeviceAssignment()
     */
    @Override
    public MarshaledDeviceAssignment deleteDeviceAssignment(ITenantAuthentication tenant, String token)
	    throws SiteWhereException {
	Call<MarshaledDeviceAssignment> call = getRestRetrofit().deleteDeviceAssignment(token,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listAlertsForDeviceAssignment()
     */
    @Override
    public SearchResults<DeviceAlertWithAsset> listAlertsForDeviceAssignment(ITenantAuthentication tenant,
	    String areaToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceAlertWithAsset>> call = getRestRetrofit().listAlertsForDeviceAssignment(areaToken,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createAlertForDeviceAssignment()
     */
    @Override
    public DeviceAlertWithAsset createAlertForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceAlertCreateRequest request) throws SiteWhereException {
	Call<DeviceAlertWithAsset> call = getRestRetrofit().createAlertForDeviceAssignment(token, request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#releaseDeviceAssignment()
     */
    @Override
    public MarshaledDeviceAssignment releaseDeviceAssignment(ITenantAuthentication tenant, String token)
	    throws SiteWhereException {
	Call<MarshaledDeviceAssignment> call = getRestRetrofit().releaseDeviceAssignment(token,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listCommandInvocationsForArea()
     */
    @Override
    public SearchResults<DeviceCommandInvocation> listCommandInvocationsForDeviceAssignment(
	    ITenantAuthentication tenant, String token, Boolean includeCommand, DateRangeSearchCriteria searchCriteria)
	    throws SiteWhereException {
	Call<SearchResults<DeviceCommandInvocation>> call = getRestRetrofit().listCommandInvocationsForDeviceAssignment(
		token, includeCommand, toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.ISiteWhereClient#createCommandInvocationForDeviceAssignment
     * ()
     */
    @Override
    public DeviceCommandInvocation createCommandInvocationForDeviceAssignment(ITenantAuthentication tenant,
	    String token, DeviceCommandInvocationCreateRequest request) throws SiteWhereException {
	Call<DeviceCommandInvocation> call = getRestRetrofit().createCommandInvocationForDeviceAssignment(token,
		request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#scheduleCommandInvocation()
     */
    @Override
    public ScheduledJob scheduleCommandInvocation(ITenantAuthentication tenant, String token, String scheduleToken,
	    DeviceCommandInvocationCreateRequest request) throws SiteWhereException {
	Call<ScheduledJob> call = getRestRetrofit().scheduleCommandInvocation(token, scheduleToken, request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForDeviceAssignment()
     */
    @Override
    public byte[] getLabelForDeviceAssignment(ITenantAuthentication tenant, String token, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForDeviceAssignment(token, generatorId,
		createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listLocationsForDeviceAssignment()
     */
    @Override
    public SearchResults<DeviceLocationWithAsset> listLocationsForDeviceAssignment(ITenantAuthentication tenant,
	    String token, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceLocationWithAsset>> call = getRestRetrofit().listLocationsForDeviceAssignment(token,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createLocationForDeviceAssignment()
     */
    @Override
    public DeviceLocationWithAsset createLocationForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceLocationCreateRequest request) throws SiteWhereException {
	Call<DeviceLocationWithAsset> call = getRestRetrofit().createLocationForDeviceAssignment(token, request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listMeasurementsForDeviceAssignment()
     */
    @Override
    public SearchResults<DeviceMeasurementWithAsset> listMeasurementsForDeviceAssignment(ITenantAuthentication tenant,
	    String token, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceMeasurementWithAsset>> call = getRestRetrofit().listMeasurementsForDeviceAssignment(
		token, toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createLocationForDeviceAssignment()
     */
    @Override
    public DeviceMeasurementWithAsset createMeasurementForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceMeasurementCreateRequest request) throws SiteWhereException {
	Call<DeviceMeasurementWithAsset> call = getRestRetrofit().createMeasurementForDeviceAssignment(token, request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#
     * listMeasurementsForDeviceAssignmentAsChartSeries()
     */
    @Override
    public List<ChartSeries<Double>> listMeasurementsForDeviceAssignmentAsChartSeries(ITenantAuthentication tenant,
	    String token, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<List<ChartSeries<Double>>> call = getRestRetrofit().listMeasurementsForDeviceAssignmentAsChartSeries(token,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#markMissingDeviceAssignment()
     */
    @Override
    public MarshaledDeviceAssignment markMissingDeviceAssignment(ITenantAuthentication tenant, String token)
	    throws SiteWhereException {
	Call<MarshaledDeviceAssignment> call = getRestRetrofit().markMissingDeviceAssignment(token,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.ISiteWhereClient#listCommandResponsesForDeviceAssignment()
     */
    @Override
    public SearchResults<DeviceCommandResponseWithAsset> listCommandResponsesForDeviceAssignment(
	    ITenantAuthentication tenant, String token, DateRangeSearchCriteria searchCriteria)
	    throws SiteWhereException {
	Call<SearchResults<DeviceCommandResponseWithAsset>> call = getRestRetrofit()
		.listCommandResponsesForDeviceAssignment(token, toISO8601(searchCriteria.getStartDate()),
			toISO8601(searchCriteria.getEndDate()), searchCriteria.getPageNumber(),
			searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.ISiteWhereClient#createCommandResponseForDeviceAssignment()
     */
    public DeviceCommandResponseWithAsset createCommandResponseForDeviceAssignment(ITenantAuthentication tenant,
	    String token, DeviceCommandResponseCreateRequest request) throws SiteWhereException {
	Call<DeviceCommandResponseWithAsset> call = getRestRetrofit().createCommandResponseForDeviceAssignment(token,
		request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listStateChangesForDeviceAssignment()
     */
    @Override
    public SearchResults<DeviceStateChangeWithAsset> listStateChangesForDeviceAssignment(ITenantAuthentication tenant,
	    String token, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceStateChangeWithAsset>> call = getRestRetrofit().listStateChangesForDeviceAssignment(
		token, toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.ISiteWhereClient#createStateChangeForDeviceAssignment()
     */
    public DeviceStateChangeWithAsset createStateChangeForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceStateChangeCreateRequest request) throws SiteWhereException {
	Call<DeviceStateChangeWithAsset> call = getRestRetrofit().createStateChangeForDeviceAssignment(token, request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#bulkListAlertsForDeviceAssignments()
     */
    public SearchResults<DeviceAlertWithAsset> bulkListAlertsForDeviceAssignments(ITenantAuthentication tenant,
	    DeviceAssignmentBulkRequest request) throws SiteWhereException {
	Call<SearchResults<DeviceAlertWithAsset>> call = getRestRetrofit().bulkListAlertsForDeviceAssignments(request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#
     * bulkListCommandInvocationsForDeviceAssignments()
     */
    public SearchResults<DeviceCommandInvocation> bulkListCommandInvocationsForDeviceAssignments(
	    ITenantAuthentication tenant, DeviceAssignmentBulkRequest request) throws SiteWhereException {
	Call<SearchResults<DeviceCommandInvocation>> call = getRestRetrofit()
		.bulkListCommandInvocationsForDeviceAssignments(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#
     * bulkListLocationsForDeviceAssignments()
     */
    public SearchResults<DeviceLocationWithAsset> bulkListLocationsForDeviceAssignments(ITenantAuthentication tenant,
	    DeviceAssignmentBulkRequest request) throws SiteWhereException {
	Call<SearchResults<DeviceLocationWithAsset>> call = getRestRetrofit()
		.bulkListLocationsForDeviceAssignments(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#
     * bulkListCommandInvocationsForDeviceAssignments()
     */
    public SearchResults<DeviceMeasurementWithAsset> bulkListMeasurementsForDeviceAssignments(
	    ITenantAuthentication tenant, DeviceAssignmentBulkRequest request) throws SiteWhereException {
	Call<SearchResults<DeviceMeasurementWithAsset>> call = getRestRetrofit()
		.bulkListMeasurementsForDeviceAssignments(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#
     * bulkListMeasurementsForDeviceAssignmentsAsChartSeries()
     */
    public Map<String, List<ChartSeries<Double>>> bulkListMeasurementsForDeviceAssignmentsAsChartSeries(
	    ITenantAuthentication tenant, DeviceAssignmentBulkRequest request) throws SiteWhereException {
	Call<Map<String, List<ChartSeries<Double>>>> call = getRestRetrofit()
		.bulkListMeasurementsForDeviceAssignmentsAsChartSeries(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#
     * bulkListCommandResponsesForDeviceAssignments()
     */
    public SearchResults<DeviceCommandResponseWithAsset> bulkListCommandResponsesForDeviceAssignments(
	    ITenantAuthentication tenant, DeviceAssignmentBulkRequest request) throws SiteWhereException {
	Call<SearchResults<DeviceCommandResponseWithAsset>> call = getRestRetrofit()
		.bulkListCommandResponsesForDeviceAssignments(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#
     * bulkListStateChangesForDeviceAssignments()
     */
    public SearchResults<DeviceStateChangeWithAsset> bulkListStateChangesForDeviceAssignments(
	    ITenantAuthentication tenant, DeviceAssignmentBulkRequest request) throws SiteWhereException {
	Call<SearchResults<DeviceStateChangeWithAsset>> call = getRestRetrofit()
		.bulkListStateChangesForDeviceAssignments(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Authorities
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listAuthorities()
     */
    public SearchResults<GrantedAuthority> listAuthorities(ITenantAuthentication tenant) throws SiteWhereException {
	Call<SearchResults<GrantedAuthority>> call = getRestRetrofit().listAuthorities(createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getAuthorityByName()
     */
    public GrantedAuthority getAuthorityByName(ITenantAuthentication tenant, String name) throws SiteWhereException {
	Call<GrantedAuthority> call = getRestRetrofit().getAuthorityByName(name, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createAuthority()
     */
    public GrantedAuthority createAuthority(ITenantAuthentication tenant, GrantedAuthorityCreateRequest request)
	    throws SiteWhereException {
	Call<GrantedAuthority> call = getRestRetrofit().createAuthority(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getAuthoritiesHierarchy()
     */
    public List<GrantedAuthorityHierarchyNode> getAuthoritiesHierarchy(ITenantAuthentication tenant)
	    throws SiteWhereException {
	Call<List<GrantedAuthorityHierarchyNode>> call = getRestRetrofit()
		.getAuthoritiesHierarchy(createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Batch Operations
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listBatchOperations()
     */
    @Override
    public SearchResults<BatchOperation> listBatchOperations(ITenantAuthentication tenant,
	    BatchOperationSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<BatchOperation>> call = getRestRetrofit().listBatchOperations(searchCriteria.getPageNumber(),
		searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getBatchOperationByToken()
     */
    @Override
    public BatchOperation getBatchOperationByToken(ITenantAuthentication tenant, String batchToken)
	    throws SiteWhereException {
	Call<BatchOperation> call = getRestRetrofit().getBatchOperationByToken(batchToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listBatchOperationElements()
     */
    @Override
    public SearchResults<BatchElement> listBatchOperationElements(ITenantAuthentication tenant, String operationToken)
	    throws SiteWhereException {
	Call<SearchResults<BatchElement>> call = getRestRetrofit().listBatchOperationElements(operationToken,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createBatchCommandInvocation()
     */
    @Override
    public BatchOperation createBatchCommandInvocation(ITenantAuthentication tenant,
	    BatchCommandInvocationRequest request) throws SiteWhereException {
	Call<BatchOperation> call = getRestRetrofit().createBatchCommandInvocation(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.ISiteWhereClient#createBatchCommandOperationForCriteria()
     */
    @Override
    public Object createBatchCommandOperationForCriteria(ITenantAuthentication tenant,
	    InvocationByDeviceCriteriaRequest request) throws SiteWhereException {
	Call<Object> call = getRestRetrofit().createBatchCommandOperationForCriteria(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Command Invocations
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceCommandInvocation()
     */
    @Override
    public DeviceCommandInvocation getDeviceCommandInvocation(ITenantAuthentication tenant, String id)
	    throws SiteWhereException {
	Call<DeviceCommandInvocation> call = getRestRetrofit().getDeviceCommandInvocation(id, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceCommandInvocationSummary()
     */
    @Override
    public DeviceCommandInvocationSummary getDeviceCommandInvocationSummary(ITenantAuthentication tenant, String id)
	    throws SiteWhereException {
	Call<DeviceCommandInvocationSummary> call = getRestRetrofit().getDeviceCommandInvocationSummary(id,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.ISiteWhereClient#listCommandResponsesForCommandInvocation()
     */
    @Override
    public SearchResults<DeviceCommandResponse> listCommandResponsesForCommandInvocation(ITenantAuthentication tenant,
	    String id) throws SiteWhereException {
	Call<SearchResults<DeviceCommandResponse>> call = getRestRetrofit().listCommandResponsesForCommandInvocation(id,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Customer Types
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listCustomerTypes()
     */
    @Override
    public SearchResults<CustomerType> listCustomerTypes(ITenantAuthentication tenant,
	    CustomerTypeSearchCriteria searchCriteria, CustomerTypeResponseFormat responseFormat)
	    throws SiteWhereException {
	Call<SearchResults<CustomerType>> call = getRestRetrofit().listCustomerTypes(
		responseFormat.getIncludeContainedCustomerTypes(), searchCriteria.getPageNumber(),
		searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getCustomerTypeByToken()
     */
    @Override
    public CustomerType getCustomerTypeByToken(ITenantAuthentication tenant, String customerTypeToken)
	    throws SiteWhereException {
	Call<CustomerType> call = getRestRetrofit().getCustomerTypeByToken(customerTypeToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createCustomerType()
     */
    @Override
    public CustomerType createCustomerType(ITenantAuthentication tenant, CustomerTypeCreateRequest request)
	    throws SiteWhereException {
	Call<CustomerType> call = getRestRetrofit().createCustomerType(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateCustomerType()
     */
    @Override
    public CustomerType updateCustomerType(ITenantAuthentication tenant, String customerTypeToken,
	    CustomerTypeCreateRequest request) throws SiteWhereException {
	Call<CustomerType> call = getRestRetrofit().updateCustomerType(customerTypeToken, request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteCustomerType()
     */
    @Override
    public CustomerType deleteCustomerType(ITenantAuthentication tenant, String customerTypeToken)
	    throws SiteWhereException {
	Call<CustomerType> call = getRestRetrofit().deleteCustomerType(customerTypeToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForCustomerType()
     */
    @Override
    public byte[] getLabelForCustomerType(ITenantAuthentication tenant, String customerTypeToken, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForCustomerType(customerTypeToken, generatorId,
		createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    // ------------------------------------------------------------------------
    // Customer
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listCustomers()
     */
    @Override
    public SearchResults<Customer> listCustomers(ITenantAuthentication tenant, CustomerSearchCriteria searchCriteria,
	    CustomerResponseFormat responseFormat) throws SiteWhereException {
	Call<SearchResults<Customer>> call = getRestRetrofit().listCustomers(searchCriteria.getCustomerTypeToken(),
		searchCriteria.getParentCustomerToken(), searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
		responseFormat.getIncludeCustomerType(), searchCriteria.getRootOnly(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getCustomerByToken()
     */
    @Override
    public MarshaledCustomer getCustomerByToken(ITenantAuthentication tenant, String customerToken)
	    throws SiteWhereException {
	Call<MarshaledCustomer> call = getRestRetrofit().getCustomerByToken(customerToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createCustomer()
     */
    @Override
    public Customer createCustomer(ITenantAuthentication tenant, CustomerCreateRequest request)
	    throws SiteWhereException {
	Call<Customer> call = getRestRetrofit().createCustomer(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateCustomer()
     */
    @Override
    public Customer updateCustomer(ITenantAuthentication tenant, String customerToken, CustomerCreateRequest request)
	    throws SiteWhereException {
	Call<Customer> call = getRestRetrofit().updateCustomer(customerToken, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteCustomer()
     */
    @Override
    public Customer deleteCustomer(ITenantAuthentication tenant, String customerToken) throws SiteWhereException {
	Call<Customer> call = getRestRetrofit().deleteCustomer(customerToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForCustomerType()
     */
    @Override
    public SearchResults<DeviceAlertWithAsset> listAlertsForCustomer(ITenantAuthentication tenant, String customerToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceAlertWithAsset>> call = getRestRetrofit().listAlertsForCustomer(customerToken,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceAssignmentsForCustomer()
     */
    @Override
    public SearchResults<MarshaledDeviceAssignment> listDeviceAssignmentsForCustomer(ITenantAuthentication tenant,
	    String customerToken, DeviceAssignmentSearchCriteria searchCriteria,
	    DeviceAssignmentResponseFormat responseFormat) throws SiteWhereException {
	Call<SearchResults<MarshaledDeviceAssignment>> call = getRestRetrofit().listDeviceAssignmentsForCustomer(
		customerToken, assembleList(searchCriteria.getAssignmentStatuses()), responseFormat.getIncludeDevice(),
		responseFormat.getIncludeCustomer(), responseFormat.getIncludeArea(), responseFormat.getIncludeAsset(),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listCommandInvocationsForCustomer()
     */
    @Override
    public SearchResults<DeviceCommandInvocation> listCommandInvocationsForCustomer(ITenantAuthentication tenant,
	    String customerToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceCommandInvocation>> call = getRestRetrofit().listCommandInvocationsForCustomer(
		customerToken, toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForCustomer()
     */
    @Override
    public byte[] getLabelForCustomer(ITenantAuthentication tenant, String customerToken, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForCustomer(customerToken, generatorId,
		createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listLocationsForCustomer()
     */
    @Override
    public SearchResults<DeviceLocationWithAsset> listLocationsForCustomer(ITenantAuthentication tenant,
	    String customerToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceLocationWithAsset>> call = getRestRetrofit().listLocationsForCustomer(customerToken,
		toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listMeasurementsForCustomer()
     */
    @Override
    public SearchResults<DeviceMeasurementWithAsset> listMeasurementsForCustomer(ITenantAuthentication tenant,
	    String customerToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceMeasurementWithAsset>> call = getRestRetrofit().listMeasurementsForCustomer(
		customerToken, toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listCommandResponsesForCustomer()
     */
    @Override
    public SearchResults<DeviceCommandResponseWithAsset> listCommandResponsesForCustomer(ITenantAuthentication tenant,
	    String customerToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceCommandResponseWithAsset>> call = getRestRetrofit().listCommandResponsesForCustomer(
		customerToken, toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listStateChangesForCustomer()
     */
    @Override
    public SearchResults<DeviceStateChangeWithAsset> listStateChangesForCustomer(ITenantAuthentication tenant,
	    String customerToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceStateChangeWithAsset>> call = getRestRetrofit().listStateChangesForCustomer(
		customerToken, toISO8601(searchCriteria.getStartDate()), toISO8601(searchCriteria.getEndDate()),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#customerTree()
     */
    @Override
    public List<TreeNode> customerTree(ITenantAuthentication tenant) throws SiteWhereException {
	Call<List<TreeNode>> call = getRestRetrofit().areaTree(createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Device Commands
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceCommands()
     */
    @Override
    public SearchResults<DeviceCommand> listDeviceCommands(ITenantAuthentication tenant,
	    DeviceCommandSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceCommand>> call = getRestRetrofit().listDeviceCommands(
		searchCriteria.getDeviceTypeToken(), searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceCommandByToken()
     */
    @Override
    public DeviceCommand getDeviceCommandByToken(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<DeviceCommand> call = getRestRetrofit().getDeviceCommandByToken(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createDeviceCommand()
     */
    @Override
    public DeviceCommand createDeviceCommand(ITenantAuthentication tenant, DeviceCommandCreateRequest request)
	    throws SiteWhereException {
	Call<DeviceCommand> call = getRestRetrofit().createDeviceCommand(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateDeviceCommand()
     */
    @Override
    public DeviceCommand updateDeviceCommand(ITenantAuthentication tenant, String token,
	    DeviceCommandCreateRequest request) throws SiteWhereException {
	Call<DeviceCommand> call = getRestRetrofit().updateDeviceCommand(token, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteDeviceCommand()
     */
    @Override
    public DeviceCommand deleteDeviceCommand(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<DeviceCommand> call = getRestRetrofit().deleteDeviceCommand(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceCommands()
     */
    @Override
    public SearchResults<DeviceCommandNamespace> listDeviceCommandsByNamesapce(ITenantAuthentication tenant,
	    DeviceCommandSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceCommandNamespace>> call = getRestRetrofit().listDeviceCommandsByNamesapce(
		searchCriteria.getDeviceTypeToken(), searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Device Events
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceEventByAlternateId()
     */
    @Override
    public DeviceEventWithAsset getDeviceEventByAlternateId(ITenantAuthentication tenant, String alternateId)
	    throws SiteWhereException {
	Call<DeviceEventWithAsset> call = getRestRetrofit().getDeviceEventByAlternateId(alternateId,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceEventById()
     */
    @Override
    public DeviceEventWithAsset getDeviceEventById(ITenantAuthentication tenant, String eventId)
	    throws SiteWhereException {
	Call<DeviceEventWithAsset> call = getRestRetrofit().getDeviceEventById(eventId, createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Device Groups
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceGroups()
     */
    @Override
    public SearchResults<DeviceGroup> listDeviceGroups(ITenantAuthentication tenant,
	    DeviceGroupSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceGroup>> call = getRestRetrofit().listDeviceGroups(searchCriteria.getRole(),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceGroupByToken()
     */
    @Override
    public DeviceGroup getDeviceGroupByToken(ITenantAuthentication tenant, String groupToken)
	    throws SiteWhereException {
	Call<DeviceGroup> call = getRestRetrofit().getDeviceGroupByToken(groupToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createDeviceGroup()
     */
    @Override
    public DeviceGroup createDeviceGroup(ITenantAuthentication tenant, DeviceGroupCreateRequest request)
	    throws SiteWhereException {
	Call<DeviceGroup> call = getRestRetrofit().createDeviceGroup(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateDeviceGroup()
     */
    @Override
    public DeviceGroup updateDeviceGroup(ITenantAuthentication tenant, String groupToken,
	    DeviceGroupCreateRequest request) throws SiteWhereException {
	Call<DeviceGroup> call = getRestRetrofit().updateDeviceGroup(groupToken, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteDeviceGroup()
     */
    @Override
    public DeviceGroup deleteDeviceGroup(ITenantAuthentication tenant, String groupToken) throws SiteWhereException {
	Call<DeviceGroup> call = getRestRetrofit().deleteDeviceGroup(groupToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceGroupElements()
     */
    @Override
    public SearchResults<DeviceGroupElement> listDeviceGroupElements(ITenantAuthentication tenant,
	    DeviceGroupElementSearchCriteria searchCriteria, DeviceGroupElementResponseFormat responseFormat)
	    throws SiteWhereException {
	Call<SearchResults<DeviceGroupElement>> call = getRestRetrofit().listDeviceGroupElements(
		searchCriteria.getGroupToken(), responseFormat.getIncludeDetails(), searchCriteria.getPageNumber(),
		searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#addElementsToDdeviceGroup()
     */
    @Override
    public SearchResults<DeviceGroupElement> addElementsToDdeviceGroup(ITenantAuthentication tenant, String groupToken,
	    List<DeviceGroupElementCreateRequest> requests) throws SiteWhereException {
	Call<SearchResults<DeviceGroupElement>> call = getRestRetrofit().addElementsToDdeviceGroup(groupToken, requests,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteDeviceGroupElements()
     */
    @Override
    public SearchResults<DeviceGroupElement> deleteDeviceGroupElements(ITenantAuthentication tenant, String groupToken,
	    List<String> elementIds) throws SiteWhereException {
	Call<SearchResults<DeviceGroupElement>> call = getRestRetrofit().deleteDeviceGroupElements(groupToken,
		elementIds, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteDeviceGroupElement()
     */
    @Override
    public SearchResults<DeviceGroupElement> deleteDeviceGroupElement(ITenantAuthentication tenant, String groupToken,
	    String elementId) throws SiteWhereException {
	Call<SearchResults<DeviceGroupElement>> call = getRestRetrofit().deleteDeviceGroupElement(groupToken, elementId,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForDeviceGroup()
     */
    @Override
    public byte[] getLabelForDeviceGroup(ITenantAuthentication tenant, String groupToken, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForDeviceGroup(groupToken, generatorId,
		createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    // ------------------------------------------------------------------------
    // Device States
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceStates()
     */
    @Override
    public SearchResults<DeviceState> listDeviceStates(ITenantAuthentication tenant,
	    DeviceStateSearchCriteria searchCriteria, DeviceStateResponseFormat responseFormat)
	    throws SiteWhereException {
	Call<SearchResults<DeviceState>> call = getRestRetrofit().listDeviceStates(searchCriteria,
		responseFormat.getIncludeArea(), responseFormat.getIncludeAsset(), responseFormat.getIncludeCustomer(),
		responseFormat.getIncludeDevice(), responseFormat.getIncludeDeviceAssignment(),
		responseFormat.getIncludeDeviceType(), responseFormat.getIncludeEventDetails(),
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Device Statuses
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceStatuses()
     */
    @Override
    public SearchResults<DeviceStatus> listDeviceStatuses(ITenantAuthentication tenant,
	    DeviceStatusSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<DeviceStatus>> call = getRestRetrofit().listDeviceStatuses(searchCriteria.getCode(),
		searchCriteria.getDeviceTypeToken(), searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceStatusByToken()
     */
    @Override
    public DeviceStatus getDeviceStatusByToken(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<DeviceStatus> call = getRestRetrofit().getDeviceStatusByToken(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createDeviceStatus()
     */
    @Override
    public DeviceStatus createDeviceStatus(ITenantAuthentication tenant, DeviceStatusCreateRequest request)
	    throws SiteWhereException {
	Call<DeviceStatus> call = getRestRetrofit().createDeviceStatus(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#updateDeviceStatus()
     */
    @Override
    public DeviceStatus updateDeviceStatus(ITenantAuthentication tenant, String token,
	    DeviceStatusCreateRequest request) throws SiteWhereException {
	Call<DeviceStatus> call = getRestRetrofit().updateDeviceStatus(token, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteDeviceStatus()
     */
    @Override
    public DeviceStatus deleteDeviceStatus(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<DeviceStatus> call = getRestRetrofit().deleteDeviceStatus(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Device Types
    // ------------------------------------------------------------------------

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceTypes()
     */
    @Override
    public SearchResults<DeviceType> listDeviceTypes(ITenantAuthentication tenant,
	    DeviceTypeSearchCriteria searchCriteria, DeviceTypeResponseFormat responseFormat)
	    throws SiteWhereException {
	Call<SearchResults<DeviceType>> call = getRestRetrofit().listDeviceTypes(responseFormat.getIncludeAsset(),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
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

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteDeviceType()
     */
    @Override
    public DeviceType deleteDeviceType(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<DeviceType> call = getRestRetrofit().deleteDeviceType(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForDeviceType()
     */
    @Override
    public byte[] getLabelForDeviceType(ITenantAuthentication tenant, String token, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForDeviceType(token, generatorId, createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceTypeGPBSpecification()
     */
    @Override
    public String getDeviceTypeGPBSpecification(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getDeviceTypeGPBSpecification(token, createHeadersFor(tenant));
	try {
	    return new String(processRestCall(call).bytes());
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#downlaodDeviceTypeGPBSpecification()
     */
    @Override
    public File downlaodDeviceTypeGPBSpecification(ITenantAuthentication tenant, String token)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().downlaodDeviceTypeGPBSpecification(token, createHeadersFor(tenant));
	try {
	    Response<ResponseBody> response = call.execute();
	    if (response.isSuccessful()) {
		String fileName = extractFileName(response.headers().get(CONTENT_DISPOSITION_HEADER));

		return Files.write(new File(fileName).toPath(), response.body().bytes()).toFile();
	    } else {
		throw new SiteWhereException(response.toString());
	    }
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    // ------------------------------------------------------------------------
    // Devices
    // ------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDevices()
     */
    @Override
    public SearchResults<Device> listDevices(ITenantAuthentication tenant, DeviceSearchCriteria searchCriteria,
	    DeviceResponseFormat responseFormat) throws SiteWhereException {
	Call<SearchResults<Device>> call = getRestRetrofit().listDevices(searchCriteria.getDeviceTypeToken(),
		searchCriteria.isExcludeAssigned(), responseFormat.getIncludeAssignment(),
		responseFormat.getIncludeDeviceType(), toISO8601(searchCriteria.getStartDate()),
		toISO8601(searchCriteria.getEndDate()), searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#getDeviceByToken(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String)
     */
    @Override
    public MarshaledDevice getDeviceByToken(ITenantAuthentication tenant, String deviceToken)
	    throws SiteWhereException {
	Call<MarshaledDevice> call = getRestRetrofit().getDeviceByToken(deviceToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#createDevice(com.sitewhere.spi.
     * ITenantAuthentication,
     * com.sitewhere.rest.model.device.request.DeviceCreateRequest)
     */
    @Override
    public MarshaledDevice createDevice(ITenantAuthentication tenant, DeviceCreateRequest request)
	    throws SiteWhereException {
	Call<MarshaledDevice> call = getRestRetrofit().createDevice(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#updateDevice(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String,
     * com.sitewhere.rest.model.device.request.DeviceCreateRequest)
     */
    @Override
    public MarshaledDevice updateDevice(ITenantAuthentication tenant, String deviceToken, DeviceCreateRequest request)
	    throws SiteWhereException {
	Call<MarshaledDevice> call = getRestRetrofit().updateDevice(deviceToken, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteDevice()
     */
    @Override
    public MarshaledDevice deleteDevice(ITenantAuthentication tenant, String deviceToken) throws SiteWhereException {
	Call<MarshaledDevice> call = getRestRetrofit().deleteDevice(deviceToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#addMultipleEventsForDevice()
     */
    @Override
    public DeviceEventBatchResponse addMultipleEventsForDevice(ITenantAuthentication tenant, String deviceToken,
	    DeviceEventBatch batch) throws SiteWhereException {
	Call<DeviceEventBatchResponse> call = getRestRetrofit().addMultipleEventsForDevice(deviceToken, batch,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDeviceAssignmentsForDevice()
     */
    @Override
    public SearchResults<MarshaledDeviceAssignment> listDeviceAssignmentsForDevice(ITenantAuthentication tenant,
	    String deviceToken, DeviceAssignmentSearchCriteria searchCriteria,
	    DeviceAssignmentResponseFormat responseFormat) throws SiteWhereException {
	Call<SearchResults<MarshaledDeviceAssignment>> call = getRestRetrofit().listDeviceAssignmentsForDevice(
		deviceToken, responseFormat.getIncludeArea(), responseFormat.getIncludeAsset(),
		responseFormat.getIncludeCustomer(), responseFormat.getIncludeDevice(), searchCriteria.getPageNumber(),
		searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#getLabelForDevice()
     */
    @Override
    public byte[] getLabelForDevice(ITenantAuthentication tenant, String deviceToken, String generatorId)
	    throws SiteWhereException {
	Call<ResponseBody> call = getRestRetrofit().getLabelForDevice(deviceToken, generatorId,
		createHeadersFor(tenant));
	try {
	    return processRestCall(call).bytes();
	} catch (IOException e) {
	    throw new SiteWhereException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#createDeviceMappings()
     */
    @Override
    public MarshaledDevice createDeviceMappings(ITenantAuthentication tenant, String deviceToken,
	    DeviceElementMapping request) throws SiteWhereException {
	Call<MarshaledDevice> call = getRestRetrofit().createDeviceMappings(deviceToken, request,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteDeviceMappings()
     */
    @Override
    public MarshaledDevice deleteDeviceMappings(ITenantAuthentication tenant, String deviceToken, String path)
	    throws SiteWhereException {
	Call<MarshaledDevice> call = getRestRetrofit().deleteDeviceMappings(deviceToken, path,
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDevicesByDeviceGroup()
     */
    @Override
    public SearchResults<Device> listDevicesByDeviceGroup(ITenantAuthentication tenant, String groupToken,
	    DeviceSearchCriteria searchCriteria, DeviceByGroupResponseFormat responseFormat) throws SiteWhereException {
	Call<SearchResults<Device>> call = getRestRetrofit().listDevicesByDeviceGroup(groupToken,
		searchCriteria.getDeviceTypeToken(), searchCriteria.isExcludeAssigned(),
		responseFormat.getIncludeAssignment(), responseFormat.getIncludeDeleted(),
		responseFormat.getIncludeDeviceType(), toISO8601(searchCriteria.getStartDate()),
		toISO8601(searchCriteria.getEndDate()), searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listDevicesByDeviceGroupWithRole()
     */
    @Override
    public SearchResults<Device> listDevicesByDeviceGroupWithRole(ITenantAuthentication tenant, String role,
	    DeviceSearchCriteria searchCriteria, DeviceByGroupResponseFormat responseFormat) throws SiteWhereException {
	Call<SearchResults<Device>> call = getRestRetrofit().listDevicesByDeviceGroupWithRole(role,
		searchCriteria.getDeviceTypeToken(), searchCriteria.isExcludeAssigned(),
		responseFormat.getIncludeAssignment(), responseFormat.getIncludeDeleted(),
		responseFormat.getIncludeDeviceType(), toISO8601(searchCriteria.getStartDate()),
		toISO8601(searchCriteria.getEndDate()), searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
		createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // External Search
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Instance
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Scheduled Jobs
    // ------------------------------------------------------------------------

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#listScheduledJobs()
     */
    @Override
    public SearchResults<ScheduledJob> listScheduledJobs(ITenantAuthentication tenant,
	    ScheduledJobSearchCriteria searchCriteria, ScheduledJobResponseFormat responseFormat)
	    throws SiteWhereException {
	Call<SearchResults<ScheduledJob>> call = getRestRetrofit().listScheduledJobs(responseFormat.getIncludeContext(),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see
     * com.sitewhere.spi.ISiteWhereClient#getScheduledJobByToken(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String)
     */
    @Override
    public ScheduledJob getScheduledJobByToken(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<ScheduledJob> call = getRestRetrofit().getScheduledJobByToken(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#createScheduledJob(com.sitewhere.spi.
     * ITenantAuthentication,
     * com.sitewhere.rest.model.device.request.ScheduledJobCreateRequest)
     */
    @Override
    public ScheduledJob createScheduledJob(ITenantAuthentication tenant, ScheduledJobCreateRequest request)
	    throws SiteWhereException {
	Call<ScheduledJob> call = getRestRetrofit().createScheduledJob(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#updateScheduledJob(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String,
     * com.sitewhere.rest.model.device.request.ScheduledJobCreateRequest)
     */
    @Override
    public ScheduledJob updateScheduledJob(ITenantAuthentication tenant, String token,
	    ScheduledJobCreateRequest request) throws SiteWhereException {
	Call<ScheduledJob> call = getRestRetrofit().updateScheduledJob(token, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteScheduledJob()
     */
    @Override
    public ScheduledJob deleteScheduledJob(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<ScheduledJob> call = getRestRetrofit().deleteScheduledJob(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Schedules
    // ------------------------------------------------------------------------

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#getScheduleByToken(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String)
     */
    @Override
    public SearchResults<Schedule> listSchedules(ITenantAuthentication tenant, ScheduleSearchCriteria searchCriteria,
	    ScheduleResponseFormat responseFormat) throws SiteWhereException {
	Call<SearchResults<Schedule>> call = getRestRetrofit().listSchedules(searchCriteria.getPageNumber(),
		searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#getScheduleByToken(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String)
     */
    @Override
    public Schedule getScheduleByToken(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<Schedule> call = getRestRetrofit().getScheduleByToken(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#createSchedule(com.sitewhere.spi.
     * ITenantAuthentication,
     * com.sitewhere.rest.model.device.request.ScheduleCreateRequest)
     */
    @Override
    public Schedule createSchedule(ITenantAuthentication tenant, ScheduleCreateRequest request)
	    throws SiteWhereException {
	Call<Schedule> call = getRestRetrofit().createSchedule(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#updateSchedule(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String,
     * com.sitewhere.rest.model.device.request.ScheduleCreateRequest)
     */
    @Override
    public Schedule updateSchedule(ITenantAuthentication tenant, String token, ScheduleCreateRequest request)
	    throws SiteWhereException {
	Call<Schedule> call = getRestRetrofit().updateSchedule(token, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteSchedule()
     */
    @Override
    public Schedule deleteSchedule(ITenantAuthentication tenant, String token) throws SiteWhereException {
	Call<Schedule> call = getRestRetrofit().deleteSchedule(token, createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // System
    // ------------------------------------------------------------------------

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

    // ------------------------------------------------------------------------
    // Tenants
    // ------------------------------------------------------------------------

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#listTenants()
     */
    @Override
    public SearchResults<Tenant> listTenants(TenantSearchCriteria searchCriteria) throws SiteWhereException {
	Call<SearchResults<Tenant>> call = getRestRetrofit().listTenants(searchCriteria.getUserId(),
		searchCriteria.getTextSearch(), searchCriteria.isIncludeRuntimeInfo(), searchCriteria.getPageNumber(),
		searchCriteria.getPageSize(), createDefaulHeaders());
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#getTenantByToken()
     */
    @Override
    public Tenant getTenantByToken(String tenantToken) throws SiteWhereException {
	Call<Tenant> call = getRestRetrofit().getTenantByToken(tenantToken, createDefaulHeaders());
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#createTenant()
     */
    @Override
    public Tenant createTenant(TenantCreateRequest request) throws SiteWhereException {
	Call<Tenant> call = getRestRetrofit().createTenant(request, createDefaulHeaders());
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#updateTenant(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String,
     * com.sitewhere.rest.model.device.request.TenantCreateRequest)
     */
    @Override
    public Tenant updateTenant(String tenantToken, TenantCreateRequest request) throws SiteWhereException {
	Call<Tenant> call = getRestRetrofit().updateTenant(tenantToken, request, createDefaulHeaders());
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteTenant()
     */
    @Override
    public Tenant deleteTenant(String tenantToken) throws SiteWhereException {
	Call<Tenant> call = getRestRetrofit().deleteTenant(tenantToken, createDefaulHeaders());
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Users
    // ------------------------------------------------------------------------

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#listUsers()
     */
    @Override
    public SearchResults<User> listUsers() throws SiteWhereException {
	Call<SearchResults<User>> call = getRestRetrofit().listUsers(createDefaulHeaders());
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#getUserByUsername(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String)
     */
    @Override
    public User getUserByUsername(String username) throws SiteWhereException {
	Call<User> call = getRestRetrofit().getUserByUsername(username, createDefaulHeaders());
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#createUser(com.sitewhere.spi.
     * ITenantAuthentication,
     * com.sitewhere.rest.model.device.request.UserCreateRequest)
     */
    @Override
    public User createUser(UserCreateRequest request) throws SiteWhereException {
	Call<User> call = getRestRetrofit().createUser(request, createDefaulHeaders());
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#updateUser(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String,
     * com.sitewhere.rest.model.device.request.UserCreateRequest)
     */
    @Override
    public User updateUser(String username, UserCreateRequest request) throws SiteWhereException {
	Call<User> call = getRestRetrofit().updateUser(username, request, createDefaulHeaders());
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteUser()
     */
    @Override
    public User deleteUser(String username) throws SiteWhereException {
	Call<User> call = getRestRetrofit().deleteUser(username, createDefaulHeaders());
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#listUserAuthorities()
     */
    @Override
    public SearchResults<GrantedAuthority> listUserAuthorities(String username) throws SiteWhereException {
	Call<SearchResults<GrantedAuthority>> call = getRestRetrofit().listUserAuthorities(username,
		createDefaulHeaders());
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------
    // Zones
    // ------------------------------------------------------------------------

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#listZones()
     */
    @Override
    public SearchResults<Zone> listZones(ITenantAuthentication tenant, ZoneSearchCriteria searchCriteria)
	    throws SiteWhereException {
	Call<SearchResults<Zone>> call = getRestRetrofit().listZones(searchCriteria.getAreaToken(),
		searchCriteria.getPageNumber(), searchCriteria.getPageSize(), createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#getZoneByToken(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String)
     */
    @Override
    public Zone getZoneByToken(ITenantAuthentication tenant, String zoneToken) throws SiteWhereException {
	Call<Zone> call = getRestRetrofit().getZoneByToken(zoneToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#createZone(com.sitewhere.spi.
     * ITenantAuthentication,
     * com.sitewhere.rest.model.device.request.ZoneCreateRequest)
     */
    @Override
    public Zone createZone(ITenantAuthentication tenant, ZoneCreateRequest request) throws SiteWhereException {
	Call<Zone> call = getRestRetrofit().createZone(request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * @see com.sitewhere.spi.ISiteWhereClient#updateZone(com.sitewhere.spi.
     * ITenantAuthentication, java.lang.String,
     * com.sitewhere.rest.model.device.request.ZoneCreateRequest)
     */
    @Override
    public Zone updateZone(ITenantAuthentication tenant, String zoneToken, ZoneCreateRequest request)
	    throws SiteWhereException {
	Call<Zone> call = getRestRetrofit().updateZone(zoneToken, request, createHeadersFor(tenant));
	return processRestCall(call);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.ISiteWhereClient#deleteZone()
     */
    @Override
    public Zone deleteZone(ITenantAuthentication tenant, String zoneToken) throws SiteWhereException {
	Call<Zone> call = getRestRetrofit().deleteZone(zoneToken, createHeadersFor(tenant));
	return processRestCall(call);
    }

    // ------------------------------------------------------------------------

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
     * Create default headers.
     * 
     * @return
     */
    protected Map<String, String> createDefaulHeaders() {
	Map<String, String> headers = new HashMap<>();
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
		vars.put("startDate", ISO8601_FORMATTER.print(dates.getStartDate().getTime()));
	    }

	    if (dates.getEndDate() != null) {
		vars.put("endDate", ISO8601_FORMATTER.print(dates.getEndDate().getTime()));
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

    /**
     * Convert date to ISO 8601 String
     * 
     * @param startDate
     * @return
     */
    protected String toISO8601(Date date) {
	if (date == null)
	    return "";
	return ISO8601_FORMATTER.print(date.getTime());
    }

    protected static String assembleTokenList(List<String> tokenList) {
	if (tokenList == null || tokenList.isEmpty())
	    return null;
	StringBuilder builder = new StringBuilder();
	String sep = "";
	for (String token : tokenList) {
	    builder.append(sep);
	    builder.append(token);
	    sep = ", ";
	}
	return builder.toString();
    }

    protected static <T> String assembleList(List<T> list) {
	if (list == null || list.isEmpty())
	    return null;
	StringBuilder builder = new StringBuilder();
	String sep = "";
	for (T token : list) {
	    builder.append(sep);
	    builder.append(token.toString());
	    sep = ", ";
	}
	return builder.toString();
    }

    private static String extractFileName(String content) {
	if (content == null || content.isEmpty())
	    return "file.name";
	int index = content.indexOf("filename=");
	if (index == -1)
	    return "file.name";
	String filename = content.substring(index + 9);
	return filename;
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