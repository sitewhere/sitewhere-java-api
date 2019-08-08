/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client;

import java.util.List;
import java.util.Map;

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
import com.sitewhere.rest.model.batch.request.InvocationByDeviceCriteriaRequest;
import com.sitewhere.rest.model.batch.request.BatchCommandInvocationRequest;
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
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.TreeNode;
import com.sitewhere.rest.model.search.device.DeviceStateSearchCriteria;
import com.sitewhere.rest.model.system.Version;
import com.sitewhere.rest.model.tenant.Tenant;
import com.sitewhere.rest.model.tenant.request.TenantCreateRequest;
import com.sitewhere.rest.model.user.GrantedAuthority;
import com.sitewhere.rest.model.user.GrantedAuthorityHierarchyNode;
import com.sitewhere.rest.model.user.User;
import com.sitewhere.rest.model.user.request.GrantedAuthorityCreateRequest;
import com.sitewhere.rest.model.user.request.UserCreateRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit API for SiteWhere REST APIs.
 */
public interface SiteWhereRestRetrofit {

    // ------------------------------------------------------------------------
    // Area Types
    // ------------------------------------------------------------------------

    @GET("areatypes")
    Call<SearchResults<AreaType>> listAreaTypes(@Query("includeContainedAreaTypes") Boolean includeContainedAreaTypes,
	    @Query("page") Integer page, @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("areatypes/{areaTypeToken}")
    Call<MarshaledAreaType> getAreaTypeByToken(@Path("areaTypeToken") String areaTypeToken,
	    @HeaderMap Map<String, String> headers);

    @POST("areatypes")
    Call<AreaType> createAreaType(@Body AreaTypeCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("areatypes/{areaTypeToken}")
    Call<AreaType> updateAreaType(@Path("areaTypeToken") String areaTypeToken, @Body AreaTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("areatypes/{areaTypeToken}")
    Call<AreaType> deleteAreaType(@Path("areaTypeToken") String areaTypeToken, @HeaderMap Map<String, String> headers);

    @GET("areatypes/{areaTypeToken}/label/{generatorId}")
    Call<ResponseBody> getLabelForAreaType(@Path("areaTypeToken") String areaTypeToken,
	    @Path("generatorId") String generatorId, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Areas
    // ------------------------------------------------------------------------

    @GET("areas")
    Call<SearchResults<Area>> listAreas(@Query("areaTypeToken") String areaTypeToken,
	    @Query("includeAreaType") Boolean includeAreaType, @Query("includeAssignments") Boolean includeAssignments,
	    @Query("includeZones") Boolean includeZones, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @Query("parentAreaToken") String parentAreaToken,
	    @Query("rootOnly") Boolean rootOnly, @HeaderMap Map<String, String> headers);

    @GET("areas/{areaToken}")
    Call<MarshaledArea> getAreaByToken(@Path("areaToken") String areaToken, @HeaderMap Map<String, String> headers);

    @POST("areas")
    Call<Area> createArea(@Body AreaCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("areas/{areaToken}")
    Call<Area> updateArea(@Path("areaToken") String areaToken, @Body AreaCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("areas/{areaToken}")
    Call<Area> deleteArea(@Path("areaToken") String areaToken, @HeaderMap Map<String, String> headers);

    @GET("areas/{areaToken}/alerts")
    Call<SearchResults<DeviceAlertWithAsset>> listAlertsForArea(@Path("areaToken") String areaToken,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("areas/{areaToken}/assignments")
    Call<SearchResults<MarshaledDeviceAssignment>> listDeviceAssignmentsForArea(@Path("areaToken") String areaToken,
	    @Query("status") String status, @Query("includeDevice") Boolean includeDevice,
	    @Query("includeCustomer") Boolean includeCustomer, @Query("includeArea") Boolean includeArea,
	    @Query("includeAsset") Boolean includeAsset, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("areas/{areaToken}/invocations")
    Call<SearchResults<DeviceCommandInvocation>> listCommandInvocationsForArea(@Path("areaToken") String areaToken,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("areas/{areaToken}/label/{generatorId}")
    Call<ResponseBody> getLabelForArea(@Path("areaToken") String areaToken, @Path("generatorId") String generatorId,
	    @HeaderMap Map<String, String> headers);

    @GET("areas/{areaToken}/locations")
    Call<SearchResults<DeviceLocationWithAsset>> listLocationsForArea(@Path("areaToken") String areaToken,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("areas/{areaToken}/measurements")
    Call<SearchResults<DeviceMeasurementWithAsset>> listMeasurementsForArea(@Path("areaToken") String areaToken,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("areas/{areaToken}/responses")
    Call<SearchResults<DeviceCommandResponseWithAsset>> listCommandResponsesForArea(@Path("areaToken") String areaToken,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("areas/{areaToken}/statechanges")
    Call<SearchResults<DeviceStateChangeWithAsset>> listStateChangesForArea(@Path("areaToken") String areaToken,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("areas/tree")
    Call<List<TreeNode>> areaTree(@HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Asset Types
    // ------------------------------------------------------------------------

    @GET("assettypes")
    Call<SearchResults<AssetType>> listAssetTypes(@Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    @GET("assettypes/{assetTypeToken}")
    Call<AssetType> getAssetTypeByToken(@Path("assetTypeToken") String assetTypeToken,
	    @HeaderMap Map<String, String> headers);

    @POST("assettypes")
    Call<AssetType> createAssetType(@Body AssetTypeCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("assettypes/{assetTypeToken}")
    Call<AssetType> updateAssetType(@Path("assetTypeToken") String assetTypeToken, @Body AssetTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("assettypes/{assetTypeToken}")
    Call<AssetType> deleteAssetType(@Path("assetTypeToken") String assetTypeToken,
	    @HeaderMap Map<String, String> headers);

    @GET("assettypes/{assetTypeToken}/label/{generatorId}")
    Call<ResponseBody> getLabelForAssetType(@Path("assetTypeToken") String assetTypeToken,
	    @Path("generatorId") String generatorId, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Asset
    // ------------------------------------------------------------------------

    @GET("assets")
    Call<SearchResults<Asset>> listAssets(@Query("assetTypeToken") String assetTypeToken,
	    @Query("includeAssetType") Boolean includeAssetType, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("assets/{assetToken}")
    Call<MarshaledAsset> getAssetByToken(@Path("assetToken") String assetToken, @HeaderMap Map<String, String> headers);

    @POST("assets")
    Call<Asset> createAsset(@Body AssetCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("assets/{assetToken}")
    Call<Asset> updateAsset(@Path("assetToken") String assetToken, @Body AssetCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("assets/{assetToken}")
    Call<Asset> deleteAsset(@Path("assetToken") String assetToken, @HeaderMap Map<String, String> headers);

    @GET("assets/{assetToken}/label/{generatorId}")
    Call<ResponseBody> getLabelForAsset(@Path("assetToken") String assetToken, @Path("generatorId") String generatorId,
	    @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Assignments
    // ------------------------------------------------------------------------

    @GET("assignments")
    Call<SearchResults<MarshaledDeviceAssignment>> listDeviceAssignments(@Query("areaToken") String areaToken,
	    @Query("includeArea") Boolean includeArea, @Query("assetToken") String assetToken,
	    @Query("includeAsset") Boolean includeAsset, @Query("customerToken") String customerToken,
	    @Query("includeCustomer") Boolean includeCustomer, @Query("deviceToken") String deviceToken,
	    @Query("includeDevice") Boolean includeDevice, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("assignments/{token}")
    Call<MarshaledDeviceAssignment> getDeviceAssignmentByToken(@Path("token") String token,
	    @HeaderMap Map<String, String> headers);

    @POST("assignments")
    Call<MarshaledDeviceAssignment> createDeviceAssignment(@Body DeviceAssignmentCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @PUT("assignments/{token}")
    Call<MarshaledDeviceAssignment> updateDeviceAssignment(@Path("token") String token,
	    @Body DeviceAssignmentCreateRequest request, @HeaderMap Map<String, String> headers);

    @DELETE("assignments/{token}")
    Call<MarshaledDeviceAssignment> deleteDeviceAssignment(@Path("token") String token,
	    @HeaderMap Map<String, String> headers);

    @GET("assignments/{token}/alerts")
    Call<SearchResults<DeviceAlertWithAsset>> listAlertsForDeviceAssignment(@Path("token") String token,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @POST("assignments/{token}/alerts")
    Call<DeviceAlertWithAsset> createAlertForDeviceAssignment(@Path("token") String token,
	    @Body DeviceAlertCreateRequest request, @HeaderMap Map<String, String> headers);

    @POST("assignments/{token}/end")
    Call<MarshaledDeviceAssignment> releaseDeviceAssignment(@Path("token") String token,
	    @HeaderMap Map<String, String> headers);

    @GET("assignments/{token}/invocations")
    Call<SearchResults<DeviceCommandInvocation>> listCommandInvocationsForDeviceAssignment(@Path("token") String token,
	    @Query("includeCommand") Boolean includeCommand, @Query("startDate") String startDate,
	    @Query("endDate") String endDate, @Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    @POST("assignments/{token}/invocations")
    Call<DeviceCommandInvocation> createCommandInvocationForDeviceAssignment(@Path("token") String token,
	    @Body DeviceCommandInvocationCreateRequest request, @HeaderMap Map<String, String> headers);

    @POST("assignments/{token}/invocations/schedules/{scheduleToken}")
    Call<ScheduledJob> scheduleCommandInvocation(@Path("token") String token,
	    @Path("scheduleToken") String scheduleToken, @Body DeviceCommandInvocationCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @GET("assignments/{token}/label/{generatorId}")
    Call<ResponseBody> getLabelForDeviceAssignment(@Path("token") String token, @Path("generatorId") String generatorId,
	    @HeaderMap Map<String, String> headers);

    @GET("assignments/{token}/locations")
    Call<SearchResults<DeviceLocationWithAsset>> listLocationsForDeviceAssignment(@Path("token") String token,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @POST("assignments/{token}/locations")
    Call<DeviceLocationWithAsset> createLocationForDeviceAssignment(@Path("token") String token,
	    @Body DeviceLocationCreateRequest request, @HeaderMap Map<String, String> headers);

    @GET("assignments/{token}/measurements")
    Call<SearchResults<DeviceMeasurementWithAsset>> listMeasurementsForDeviceAssignment(@Path("token") String token,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @POST("assignments/{token}/measurements")
    Call<DeviceMeasurementWithAsset> createMeasurementForDeviceAssignment(@Path("token") String token,
	    @Body DeviceMeasurementCreateRequest request, @HeaderMap Map<String, String> headers);

    @GET("assignments/{token}/measurements/series")
    Call<List<ChartSeries<Double>>> listMeasurementsForDeviceAssignmentAsChartSeries(@Path("token") String token,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @POST("assignments/{token}/missing")
    Call<MarshaledDeviceAssignment> markMissingDeviceAssignment(@Path("token") String token,
	    @HeaderMap Map<String, String> headers);

    @GET("assignments/{token}/responses")
    Call<SearchResults<DeviceCommandResponseWithAsset>> listCommandResponsesForDeviceAssignment(
	    @Path("token") String token, @Query("startDate") String startDate, @Query("endDate") String endDate,
	    @Query("page") Integer page, @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @POST("assignments/{token}/responses")
    Call<DeviceCommandResponseWithAsset> createCommandResponseForDeviceAssignment(@Path("token") String token,
	    @Body DeviceCommandResponseCreateRequest request, @HeaderMap Map<String, String> headers);

    @GET("assignments/{token}/statechanges")
    Call<SearchResults<DeviceStateChangeWithAsset>> listStateChangesForDeviceAssignment(@Path("token") String token,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @POST("assignments/{token}/statechanges")
    Call<DeviceStateChangeWithAsset> createStateChangeForDeviceAssignment(@Path("token") String token,
	    @Body DeviceStateChangeCreateRequest request, @HeaderMap Map<String, String> headers);

    @POST("assignments/bulk/alerts")
    Call<SearchResults<DeviceAlertWithAsset>> bulkListAlertsForDeviceAssignments(
	    @Body DeviceAssignmentBulkRequest request, @HeaderMap Map<String, String> headers);

    @POST("assignments/bulk/invocations")
    Call<SearchResults<DeviceCommandInvocation>> bulkListCommandInvocationsForDeviceAssignments(
	    @Body DeviceAssignmentBulkRequest request, @HeaderMap Map<String, String> headers);

    @POST("assignments/bulk/locations")
    Call<SearchResults<DeviceLocationWithAsset>> bulkListLocationsForDeviceAssignments(
	    @Body DeviceAssignmentBulkRequest request, @HeaderMap Map<String, String> headers);

    @POST("assignments/bulk/measurements")
    Call<SearchResults<DeviceMeasurementWithAsset>> bulkListMeasurementsForDeviceAssignments(
	    @Body DeviceAssignmentBulkRequest request, @HeaderMap Map<String, String> headers);

    @POST("assignments/bulk/measurements/series")
    Call<Map<String, List<ChartSeries<Double>>>> bulkListMeasurementsForDeviceAssignmentsAsChartSeries(
	    @Body DeviceAssignmentBulkRequest request, @HeaderMap Map<String, String> headers);

    @POST("assignments/bulk/responses")
    Call<SearchResults<DeviceCommandResponseWithAsset>> bulkListCommandResponsesForDeviceAssignments(
	    @Body DeviceAssignmentBulkRequest request, @HeaderMap Map<String, String> headers);

    @POST("assignments/bulk/statechanges")
    Call<SearchResults<DeviceStateChangeWithAsset>> bulkListStateChangesForDeviceAssignments(
	    @Body DeviceAssignmentBulkRequest request, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Authorities
    // ------------------------------------------------------------------------

    @GET("authorities")
    Call<SearchResults<GrantedAuthority>> listAuthorities(@HeaderMap Map<String, String> headers);

    @POST("authorities")
    Call<GrantedAuthority> createAuthority(@Body GrantedAuthorityCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @GET("authorities/{name}")
    Call<GrantedAuthority> getAuthorityByName(@Path("name") String name, @HeaderMap Map<String, String> headers);

    @GET("authorities/hierarchy")
    Call<List<GrantedAuthorityHierarchyNode>> getAuthoritiesHierarchy(@HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Batch Operations
    // ------------------------------------------------------------------------

    @GET("batch")
    Call<SearchResults<BatchOperation>> listBatchOperations(@Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("batch/{batchToken}")
    Call<BatchOperation> getBatchOperationByToken(@Path("batchToken") String batchToken,
	    @HeaderMap Map<String, String> headers);

    @GET("batch/{operationToken}/elements")
    Call<SearchResults<BatchElement>> listBatchOperationElements(@Path("operationToken") String operationToken,
	    @HeaderMap Map<String, String> headers);

    @POST("batch/command")
    Call<BatchOperation> createBatchCommandInvocation(@Body BatchCommandInvocationRequest request,
	    @HeaderMap Map<String, String> headers);

    @POST("batch/command/criteria")
    Call<Object> createBatchCommandOperationForCriteria(@Body InvocationByDeviceCriteriaRequest request,
	    @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Command Invocations
    // ------------------------------------------------------------------------

    @GET("invocations/id/{id}")
    Call<DeviceCommandInvocation> getDeviceCommandInvocation(@Path("id") String id,
	    @HeaderMap Map<String, String> headers);

    @GET("invocations/id/{id}/summary")
    Call<DeviceCommandInvocationSummary> getDeviceCommandInvocationSummary(@Path("id") String id,
	    @HeaderMap Map<String, String> headers);

    @GET("invocations/id/{invocationId}/responses")
    Call<SearchResults<DeviceCommandResponse>> listCommandResponsesForCommandInvocation(
	    @Path("invocationId") String invocationId, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Customer Types
    // ------------------------------------------------------------------------

    @GET("customertypes")
    Call<SearchResults<CustomerType>> listCustomerTypes(
	    @Query("includeContainedCustomerTypes") Boolean includeContainedCustomerTypes, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("customertypes/{customerTypeToken}")
    Call<CustomerType> getCustomerTypeByToken(@Path("customerTypeToken") String customerTypeToken,
	    @HeaderMap Map<String, String> headers);

    @POST("customertypes")
    Call<CustomerType> createCustomerType(@Body CustomerTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @PUT("customertypes/{customerTypeToken}")
    Call<CustomerType> updateCustomerType(@Path("customerTypeToken") String customerTypeToken,
	    @Body CustomerTypeCreateRequest request, @HeaderMap Map<String, String> headers);

    @DELETE("customertypes/{customerTypeToken}")
    Call<CustomerType> deleteCustomerType(@Path("customerTypeToken") String customerTypeToken,
	    @HeaderMap Map<String, String> headers);

    @GET("customertypes/{customerTypeToken}/label/{generatorId}")
    Call<ResponseBody> getLabelForCustomerType(@Path("customerTypeToken") String customerTypeToken,
	    @Path("generatorId") String generatorId, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Customer
    // ------------------------------------------------------------------------

    @GET("customers")
    Call<SearchResults<Customer>> listCustomers(@Query("customerTypeToken") String customerTypeToken,
	    @Query("parentCustomerToken") String parentCustomerToken, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @Query("includeCustomerType") Boolean includeCustomerType,
	    @Query("rootOnly") Boolean rootOnly, @HeaderMap Map<String, String> headers);

    @GET("customers/{customerToken}")
    Call<MarshaledCustomer> getCustomerByToken(@Path("customerToken") String customerToken,
	    @HeaderMap Map<String, String> headers);

    @POST("customers")
    Call<Customer> createCustomer(@Body CustomerCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("customers/{customerToken}")
    Call<Customer> updateCustomer(@Path("customerToken") String customerToken, @Body CustomerCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("customers/{customerToken}")
    Call<Customer> deleteCustomer(@Path("customerToken") String customerToken, @HeaderMap Map<String, String> headers);

    @GET("customers/{customerToken}/alerts")
    Call<SearchResults<DeviceAlertWithAsset>> listAlertsForCustomer(@Path("customerToken") String customerToken,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("customers/{customerToken}/assignments")
    Call<SearchResults<MarshaledDeviceAssignment>> listDeviceAssignmentsForCustomer(
	    @Path("customerToken") String customerToken, @Query("status") String status,
	    @Query("includeDevice") Boolean includeDevice, @Query("includeCustomer") Boolean includeCustomer,
	    @Query("includeArea") Boolean includeArea, @Query("includeAsset") Boolean includeAsset,
	    @Query("page") Integer page, @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("customers/{customerToken}/invocations")
    Call<SearchResults<DeviceCommandInvocation>> listCommandInvocationsForCustomer(
	    @Path("customerToken") String customerToken, @Query("startDate") String startDate,
	    @Query("endDate") String endDate, @Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    @GET("customers/{customerToken}/label/{generatorId}")
    Call<ResponseBody> getLabelForCustomer(@Path("customerToken") String customerToken,
	    @Path("generatorId") String generatorId, @HeaderMap Map<String, String> headers);

    @GET("customers/{customerToken}/locations")
    Call<SearchResults<DeviceLocationWithAsset>> listLocationsForCustomer(@Path("customerToken") String customerToken,
	    @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("customers/{customerToken}/measurements")
    Call<SearchResults<DeviceMeasurementWithAsset>> listMeasurementsForCustomer(
	    @Path("customerToken") String customerToken, @Query("startDate") String startDate,
	    @Query("endDate") String endDate, @Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    @GET("customers/{customerToken}/responses")
    Call<SearchResults<DeviceCommandResponseWithAsset>> listCommandResponsesForCustomer(
	    @Path("customerToken") String customerToken, @Query("startDate") String startDate,
	    @Query("endDate") String endDate, @Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    @GET("customers/{customerToken}/statechanges")
    Call<SearchResults<DeviceStateChangeWithAsset>> listStateChangesForCustomer(
	    @Path("customerToken") String customerToken, @Query("startDate") String startDate,
	    @Query("endDate") String endDate, @Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    @GET("customers/tree")
    Call<List<TreeNode>> customerTree(@HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Device Commands
    // ------------------------------------------------------------------------

    @GET("commands")
    Call<SearchResults<DeviceCommand>> listDeviceCommands(@Query("deviceTypeToken") String deviceTypeToken,
	    @Query("page") Integer page, @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("commands/{token}")
    Call<DeviceCommand> getDeviceCommandByToken(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @POST("commands")
    Call<DeviceCommand> createDeviceCommand(@Body DeviceCommandCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @PUT("commands/{token}")
    Call<DeviceCommand> updateDeviceCommand(@Path("token") String token, @Body DeviceCommandCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("commands/{token}")
    Call<DeviceCommand> deleteDeviceCommand(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @GET("commands/namespaces")
    Call<SearchResults<DeviceCommandNamespace>> listDeviceCommandsByNamesapce(
	    @Query("deviceTypeToken") String deviceTypeToken, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Device Events
    // ------------------------------------------------------------------------

    @GET("events/alternate/{alternateId}")
    Call<DeviceEventWithAsset> getDeviceEventByAlternateId(@Path("alternateId") String alternateId,
	    @HeaderMap Map<String, String> headers);

    @GET("events/id/{eventId}")
    Call<DeviceEventWithAsset> getDeviceEventById(@Path("eventId") String eventId,
	    @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Device Groups
    // ------------------------------------------------------------------------

    @GET("devicegroups")
    Call<SearchResults<DeviceGroup>> listDeviceGroups(@Query("role") String role, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("devicegroups/{groupToken}")
    Call<DeviceGroup> getDeviceGroupByToken(@Path("groupToken") String groupToken,
	    @HeaderMap Map<String, String> headers);

    @POST("devicegroups")
    Call<DeviceGroup> createDeviceGroup(@Body DeviceGroupCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("devicegroups/{groupToken}")
    Call<DeviceGroup> updateDeviceGroup(@Path("groupToken") String groupToken, @Body DeviceGroupCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("devicegroups/{groupToken}")
    Call<DeviceGroup> deleteDeviceGroup(@Path("groupToken") String groupToken, @HeaderMap Map<String, String> headers);

    @GET("devicegroups/{groupToken}/elements")
    Call<SearchResults<DeviceGroupElement>> listDeviceGroupElements(@Path("groupToken") String groupToken,
	    @Query("includeDetails") Boolean includeDetails, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @POST("devicegroups/{groupToken}/elements")
    Call<SearchResults<DeviceGroupElement>> addElementsToDdeviceGroup(@Path("groupToken") String groupToken,
	    @Body List<DeviceGroupElementCreateRequest> requests, @HeaderMap Map<String, String> headers);

    @DELETE("devicegroups/{groupToken}/elements")
    Call<SearchResults<DeviceGroupElement>> deleteDeviceGroupElements(@Path("groupToken") String groupToken,
	    @Body List<String> elementIds, @HeaderMap Map<String, String> headers);

    @DELETE("devicegroups/{groupToken}/elements/{elementId}")
    Call<SearchResults<DeviceGroupElement>> deleteDeviceGroupElement(@Path("groupToken") String groupToken,
	    @Path("elementId") String elementId, @HeaderMap Map<String, String> headers);

    @GET("devicegroups/{groupToken}/label/{generatorId}")
    Call<ResponseBody> getLabelForDeviceGroup(@Path("groupToken") String groupToken,
	    @Path("generatorId") String generatorId, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Device States
    // ------------------------------------------------------------------------

    @POST("devicestates/search")
    Call<SearchResults<DeviceState>> listDeviceStates(@Body DeviceStateSearchCriteria criteria,
	    @Query("includeArea") Boolean includeArea, @Query("includeAsset") Boolean includeAsset,
	    @Query("includeCustomer") Boolean includeCustomer, @Query("includeDevice") Boolean includeDevice,
	    @Query("includeDeviceAssignment") Boolean includeDeviceAssignment,
	    @Query("includeDeviceType") Boolean includeDeviceType,
	    @Query("includeEventDetails") Boolean includeEventDetails, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Device Statuses
    // ------------------------------------------------------------------------

    @GET("statuses")
    Call<SearchResults<DeviceStatus>> listDeviceStatuses(@Query("code") String code,
	    @Query("deviceTypeToken") String deviceTypeToken, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("statuses/{token}")
    Call<DeviceStatus> getDeviceStatusByToken(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @POST("statuses")
    Call<DeviceStatus> createDeviceStatus(@Body DeviceStatusCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @PUT("statuses/{token}")
    Call<DeviceStatus> updateDeviceStatus(@Path("token") String token, @Body DeviceStatusCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("statuses/{token}")
    Call<DeviceStatus> deleteDeviceStatus(@Path("token") String token, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Device Types
    // ------------------------------------------------------------------------

    @GET("devicetypes")
    Call<SearchResults<DeviceType>> listDeviceTypes(@Query("includeAsset") Boolean includeAsset,
	    @Query("page") Integer page, @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("devicetypes/{token}")
    Call<DeviceType> getDeviceTypeByToken(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @POST("devicetypes")
    Call<DeviceType> createDeviceType(@Body DeviceTypeCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("devicetypes/{token}")
    Call<DeviceType> updateDeviceType(@Path("token") String token, @Body DeviceTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("devicetypes/{token}")
    Call<DeviceType> deleteDeviceType(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @GET("devicetypes/{token}/label/{generatorId}")
    Call<ResponseBody> getLabelForDeviceType(@Path("token") String token, @Path("generatorId") String generatorId,
	    @HeaderMap Map<String, String> headers);

    @GET("devicetypes/{token}/proto")
    Call<ResponseBody> getDeviceTypeGPBSpecification(@Path("token") String token,
	    @HeaderMap Map<String, String> headers);

    @GET("devicetypes/{token}/spec.proto")
    Call<ResponseBody> downlaodDeviceTypeGPBSpecification(@Path("token") String token,
	    @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Devices
    // ------------------------------------------------------------------------

    @GET("devices")
    Call<SearchResults<Device>> listDevices(@Query("deviceType") String deviceType,
	    @Query("excludeAssigned") Boolean excludeAssigned, @Query("includeAssignment") Boolean includeAssignment,
	    @Query("includeDeviceType") Boolean includeDeviceType, @Query("startDate") String startDate,
	    @Query("endDate") String endDate, @Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    @GET("devices/{deviceToken}")
    Call<MarshaledDevice> getDeviceByToken(@Path("deviceToken") String deviceToken,
	    @HeaderMap Map<String, String> headers);

    @POST("devices")
    Call<MarshaledDevice> createDevice(@Body DeviceCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("devices/{deviceToken}")
    Call<MarshaledDevice> updateDevice(@Path("deviceToken") String deviceToken, @Body DeviceCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("devices/{deviceToken}")
    Call<MarshaledDevice> deleteDevice(@Path("deviceToken") String deviceToken, @HeaderMap Map<String, String> headers);

    @GET("devices/{deviceToken}/assignments")
    Call<SearchResults<MarshaledDeviceAssignment>> listDeviceAssignmentsForDevice(
	    @Path("deviceToken") String deviceToken, @Query("includeArea") Boolean includeArea,
	    @Query("includeAsset") Boolean includeAsset, @Query("includeCustomer") Boolean includeCustomer,
	    @Query("includeDevice") Boolean includeDevice, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("devices/{deviceToken}/assignments/active")
    Call<List<MarshaledDeviceAssignment>> getActiveAssignmentsForDevice(@Path("deviceToken") String deviceToken,
	    @Query("includeArea") Boolean includeArea, @Query("includeAsset") Boolean includeAsset,
	    @Query("includeCustomer") Boolean includeCustomer, @Query("includeDevice") Boolean includeDevice,
	    @Query("page") Integer page, @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @POST("devices/{deviceToken}/batch")
    Call<DeviceEventBatchResponse> addMultipleEventsForDevice(@Path("deviceToken") String deviceToken,
	    @Body DeviceEventBatch batch, @HeaderMap Map<String, String> headers);

    @GET("devices/{deviceToken}/label/{generatorId}")
    Call<ResponseBody> getLabelForDevice(@Path("deviceToken") String deviceToken,
	    @Path("generatorId") String generatorId, @HeaderMap Map<String, String> headers);

    @POST("devices/{deviceToken}/mappings")
    Call<MarshaledDevice> createDeviceMappings(@Path("deviceToken") String deviceToken,
	    @Body DeviceElementMapping request, @HeaderMap Map<String, String> headers);

    @DELETE("devices/{deviceToken}/mappings")
    Call<MarshaledDevice> deleteDeviceMappings(@Path("deviceToken") String deviceToken, @Path("path") String path,
	    @HeaderMap Map<String, String> headers);

    // @GET("devices/{hardwareId}/symbol")
    // Call<ResponseBody> getDeviceHardwareSymbol(@Path("hardwareId") String
    // hardwareId, @HeaderMap Map<String, String> headers);

    @GET("devices/group/{groupToken}")
    Call<SearchResults<Device>> listDevicesByDeviceGroup(@Path("groupToken") String groupToken,
	    @Query("deviceType") String deviceType, @Query("excludeAssigned") Boolean excludeAssigned,
	    @Query("includeAssignment") Boolean includeAssignment, @Query("includeDeleted") Boolean includeDeleted,
	    @Query("includeDeviceType") Boolean includeDeviceType, @Query("startDate") String startDate,
	    @Query("endDate") String endDate, @Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    @GET("devices/grouprole/{role}")
    Call<SearchResults<Device>> listDevicesByDeviceGroupWithRole(@Path("role") String role,
	    @Query("deviceType") String deviceType, @Query("excludeAssigned") Boolean excludeAssigned,
	    @Query("includeAssignment") Boolean includeAssignment, @Query("includeDeleted") Boolean includeDeleted,
	    @Query("includeDeviceType") Boolean includeDeviceType, @Query("startDate") String startDate,
	    @Query("endDate") String endDate, @Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // External Search
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Instance
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Scheduled Jobs
    // ------------------------------------------------------------------------

    @GET("jobs")
    Call<SearchResults<ScheduledJob>> listScheduledJobs(@Query("includeContext") Boolean includeContext,
	    @Query("page") Integer page, @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("jobs/{token}")
    Call<ScheduledJob> getScheduledJobByToken(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @POST("jobs")
    Call<ScheduledJob> createScheduledJob(@Body ScheduledJobCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @PUT("jobs/{token}")
    Call<ScheduledJob> updateScheduledJob(@Path("token") String token, @Body ScheduledJobCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("jobs/{token}")
    Call<ScheduledJob> deleteScheduledJob(@Path("token") String token, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Schedules
    // ------------------------------------------------------------------------

    @GET("schedules")
    Call<SearchResults<Schedule>> listSchedules(@Query("page") Integer page, @Query("pageSize") Integer pageSize,
	    @HeaderMap Map<String, String> headers);

    @GET("schedules/{token}")
    Call<Schedule> getScheduleByToken(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @POST("schedules")
    Call<Schedule> createSchedule(@Body ScheduleCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("schedules/{token}")
    Call<Schedule> updateSchedule(@Path("token") String token, @Body ScheduleCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("schedules/{token}")
    Call<Schedule> deleteSchedule(@Path("token") String token, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // System
    // ------------------------------------------------------------------------

    @GET("system/version")
    Call<Version> getVersion();

    // ------------------------------------------------------------------------
    // Tenants
    // ------------------------------------------------------------------------

    @GET("tenants")
    Call<SearchResults<Tenant>> listTenants(@Query("authUserId") String authUserId,
	    @Query("textSearch") String textSearch, @Query("includeRuntimeInfo") Boolean includeRuntimeInfo,
	    @Query("page") Integer page, @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("tenants/{tenantToken}")
    Call<Tenant> getTenantByToken(@Path("tenantToken") String tenantToken, @HeaderMap Map<String, String> headers);

    @POST("tenants")
    Call<Tenant> createTenant(@Body TenantCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("tenants/{tenantToken}")
    Call<Tenant> updateTenant(@Path("tenantToken") String tenantToken, @Body TenantCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("tenants/{tenantToken}")
    Call<Tenant> deleteTenant(@Path("tenantToken") String tenantToken, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Users
    // ------------------------------------------------------------------------

    @GET("users")
    Call<SearchResults<User>> listUsers(@HeaderMap Map<String, String> headers);

    @GET("users/{username}")
    Call<User> getUserByUsername(@Path("username") String username, @HeaderMap Map<String, String> headers);

    @POST("users")
    Call<User> createUser(@Body UserCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("users/{username}")
    Call<User> updateUser(@Path("username") String username, @Body UserCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("users/{username}")
    Call<User> deleteUser(@Path("username") String username, @HeaderMap Map<String, String> headers);

    @GET("users/{username}/authorities")
    Call<SearchResults<GrantedAuthority>> listUserAuthorities(@Path("username") String username,
	    @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Zones
    // ------------------------------------------------------------------------

    @GET("zones")
    Call<SearchResults<Zone>> listZones(@Query("areaToken") String areaToken, @Query("page") Integer page,
	    @Query("pageSize") Integer pageSize, @HeaderMap Map<String, String> headers);

    @GET("zones/{zoneToken}")
    Call<Zone> getZoneByToken(@Path("zoneToken") String zoneToken, @HeaderMap Map<String, String> headers);

    @POST("zones")
    Call<Zone> createZone(@Body ZoneCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("zones/{zoneToken}")
    Call<Zone> updateZone(@Path("zoneToken") String zoneToken, @Body ZoneCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("zones/{zoneToken}")
    Call<Zone> deleteZone(@Path("zoneToken") String zoneToken, @HeaderMap Map<String, String> headers);

}
