/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client;

import java.util.Map;

import com.sitewhere.rest.model.area.Area;
import com.sitewhere.rest.model.area.AreaType;
import com.sitewhere.rest.model.area.Zone;
import com.sitewhere.rest.model.area.request.AreaCreateRequest;
import com.sitewhere.rest.model.area.request.AreaTypeCreateRequest;
import com.sitewhere.rest.model.area.request.ZoneCreateRequest;
import com.sitewhere.rest.model.asset.Asset;
import com.sitewhere.rest.model.asset.AssetType;
import com.sitewhere.rest.model.asset.request.AssetCreateRequest;
import com.sitewhere.rest.model.asset.request.AssetTypeCreateRequest;
import com.sitewhere.rest.model.batch.BatchOperation;
import com.sitewhere.rest.model.customer.Customer;
import com.sitewhere.rest.model.customer.CustomerType;
import com.sitewhere.rest.model.customer.request.CustomerCreateRequest;
import com.sitewhere.rest.model.customer.request.CustomerTypeCreateRequest;
import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.DeviceAssignment;
import com.sitewhere.rest.model.device.DeviceStatus;
import com.sitewhere.rest.model.device.DeviceType;
import com.sitewhere.rest.model.device.asset.DeviceAlertWithAsset;
import com.sitewhere.rest.model.device.command.DeviceCommand;
import com.sitewhere.rest.model.device.group.DeviceGroup;
import com.sitewhere.rest.model.device.marshaling.MarshaledArea;
import com.sitewhere.rest.model.device.marshaling.MarshaledAreaType;
import com.sitewhere.rest.model.device.marshaling.MarshaledDeviceAssignment;
import com.sitewhere.rest.model.device.request.DeviceAssignmentCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceCommandCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceGroupCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceStatusCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceTypeCreateRequest;
import com.sitewhere.rest.model.scheduling.Schedule;
import com.sitewhere.rest.model.scheduling.ScheduledJob;
import com.sitewhere.rest.model.scheduling.request.ScheduleCreateRequest;
import com.sitewhere.rest.model.scheduling.request.ScheduledJobCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.system.Version;
import com.sitewhere.rest.model.tenant.Tenant;
import com.sitewhere.rest.model.tenant.request.TenantCreateRequest;
import com.sitewhere.rest.model.user.User;
import com.sitewhere.rest.model.user.request.UserCreateRequest;

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
 * 
 * @author Derek
 * @author Jorge Villaverde
 */
public interface SiteWhereRestRetrofit {
        
    // ------------------------------------------------------------------------
    // Area Types 
    // ------------------------------------------------------------------------
    
    @GET("areatypes")
    Call<SearchResults<AreaType>> listAreaTypes(
	    @Query("includeContainedAreaTypes") Boolean includeContainedAreaTypes, 
	    @Query("page") Integer page, 
	    @Query("pageSize") Integer pageSize, 
	    @HeaderMap Map<String, String> headers);    
    
    @GET("areatypes/{areaTypeToken}")
    Call<MarshaledAreaType> getAreaTypeByToken(@Path("areaTypeToken") String areaTypeToken, @HeaderMap Map<String, String> headers);

    @POST("areatypes")
    Call<AreaType> createAreaType(@Body AreaTypeCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("areatypes/{areaTypeToken}")
    Call<AreaType> updateAreaType(@Path("areaTypeToken") String areaTypeToken, @Body AreaTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("areatypes/{areaTypeToken}")
    Call<AreaType> deleteAreaType(@Path("areaTypeToken") String areaTypeToken, @HeaderMap Map<String, String> headers);
    
    @GET("areatypes/{areaTypeToken}/label/{generatorId}")
    Call<byte[]> getLabelForAreaType(@Path("areaTypeToken") String areaTypeToken,
	    @Path("generatorId") String generatorId,
	    @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // Areas  
    // ------------------------------------------------------------------------

    @GET("areas")
    Call<SearchResults<Area>> listAreas(
	    @Query("areaTypeToken") String areaTypeToken,
	    @Query("includeAreaType") Boolean includeAreaType, 
	    @Query("includeAssignments") Boolean includeAssignments, 
	    @Query("includeZones") Boolean includeZones, 	    
	    @Query("page") Integer page, 
	    @Query("pageSize") Integer pageSize, 
	    @Query("parentAreaToken") String parentAreaToken,
	    @Query("rootOnly") Boolean rootOnly, 
	    @HeaderMap Map<String, String> headers);    
    
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
    Call<SearchResults<DeviceAlertWithAsset>> listAlertsForArea(
	    @Path("areaToken") String areaToken,
	    @Query("startDate") String startDate,
	    @Query("endDate") String endDate,
	    @Query("page") Integer page, 
	    @Query("pageSize") Integer pageSize, 
	    @HeaderMap Map<String, String> headers);
    
    @GET("areas/{areaToken}/assignments")
    Call<SearchResults<MarshaledDeviceAssignment>> listDeviceAssignmentsForArea(
	    @Path("areaToken") String areaToken,
	    @Query("status") String status,
	    @Query("includeDevice") Boolean includeDevice,
	    @Query("includeCustomer") Boolean includeCustomer,
	    @Query("includeArea") Boolean includeArea,
	    @Query("includeAsset") Boolean includeAsset,
	    @Query("page") Integer page, 
	    @Query("pageSize") Integer pageSize, 
	    @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // Asset Types  
    // ------------------------------------------------------------------------
    
    @GET("assettypes/{assetTypeToken}")
    Call<AssetType> getAssetTypeByToken(@Path("assetTypeToken") String assetTypeToken, @HeaderMap Map<String, String> headers);

    @POST("assettypes")
    Call<AssetType> createAssetType(@Body AssetTypeCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("assettypes/{assetTypeToken}")
    Call<AssetType> updateAssetType(@Path("assetTypeToken") String assetTypeToken, @Body AssetTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("assettypes/{assetTypeToken}")
    Call<AssetType> deleteAssetType(@Path("assetTypeToken") String assetTypeToken, @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // Asset  
    // ------------------------------------------------------------------------
    
    @GET("assets/{assetToken}")
    Call<Asset> getAssetByToken(@Path("assetToken") String assetToken, @HeaderMap Map<String, String> headers);

    @POST("assets")
    Call<Asset> createAsset(@Body AssetCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("assets/{assetToken}")
    Call<Asset> updateAsset(@Path("assetToken") String assetToken, @Body AssetCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("assets/{assetToken}")
    Call<Asset> deleteAsset(@Path("assetToken") String assetToken, @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // Assignments  
    // ------------------------------------------------------------------------
    
    @GET("assignments/{token}")
    Call<DeviceAssignment> getDeviceAssignmentByToken(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @POST("assignments")
    Call<DeviceAssignment> createDeviceAssignment(@Body DeviceAssignmentCreateRequest request, 
	    @HeaderMap Map<String, String> headers);

    @PUT("assignments/{token}")
    Call<DeviceAssignment> updateDeviceAssignment(@Path("token") String token, @Body DeviceAssignmentCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("assignments/{token}")
    Call<DeviceAssignment> deleteDeviceAssignment(@Path("token") String token, @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // Batch Operations  
    // ------------------------------------------------------------------------

    @GET("batch/{batchToken}")
    Call<BatchOperation> getBatchOperationByToken(@Path("batchToken") String batchToken, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Command Invocations
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Customer Types
    // ------------------------------------------------------------------------

    @GET("customertypes/{customerTypeToken}")
    Call<CustomerType> getCustomerTypeByToken(@Path("customerTypeToken") String customerTypeToken, @HeaderMap Map<String, String> headers);

    @POST("customertypes")
    Call<CustomerType> createCustomerType(@Body CustomerTypeCreateRequest request, 
	    @HeaderMap Map<String, String> headers);

    @PUT("customertypes/{customerTypeToken}")
    Call<CustomerType> updateCustomerType(@Path("customerTypeToken") String customerTypeToken, @Body CustomerTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("customertypes/{customerTypeToken}")
    Call<CustomerType> deleteCustomerType(@Path("customerTypeToken") String customerTypeToken, @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // Customer
    // ------------------------------------------------------------------------

    @GET("customers/{customerToken}")
    Call<Customer> getCustomerByToken(@Path("customerToken") String customerToken, @HeaderMap Map<String, String> headers);

    @POST("customers")
    Call<Customer> createCustomer(@Body CustomerCreateRequest request, 
	    @HeaderMap Map<String, String> headers);

    @PUT("customers/{customerToken}")
    Call<Customer> updateCustomer(@Path("customerToken") String customerToken, @Body CustomerCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("customers/{customerToken}")
    Call<Customer> deleteCustomer(@Path("customerToken") String customerToken, @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // Device Commands
    // ------------------------------------------------------------------------
    
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
    
    // ------------------------------------------------------------------------
    // Device Events
    // ------------------------------------------------------------------------
    
    // ------------------------------------------------------------------------
    // Device Groups
    // ------------------------------------------------------------------------
    
    @GET("devicegroups/{groupToken}")
    Call<DeviceGroup> getDeviceGroupByToken(@Path("groupToken") String groupToken, @HeaderMap Map<String, String> headers);

    @POST("devicegroups")
    Call<DeviceGroup> createDeviceGroup(@Body DeviceGroupCreateRequest request, 
	    @HeaderMap Map<String, String> headers);

    @PUT("devicegroups/{groupToken}")
    Call<DeviceGroup> updateDeviceGroup(@Path("groupToken") String groupToken, @Body DeviceGroupCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("devicegroups/{groupToken}")
    Call<DeviceGroup> deleteDeviceGroup(@Path("groupToken") String groupToken, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Device States
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Device Statuses
    // ------------------------------------------------------------------------
    
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
    
    @GET("devicetypes/{token}")
    Call<DeviceType> getDeviceTypeByToken(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @POST("devicetypes")
    Call<DeviceType> createDeviceType(@Body DeviceTypeCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("devicetypes/{token}")
    Call<DeviceType> updateDeviceType(@Path("token") String token, @Body DeviceTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("devicetypes/{token}")
    Call<DeviceType> deleteDeviceType(@Path("token") String token, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Devices
    // ------------------------------------------------------------------------

    @GET("devices/{deviceToken}")
    Call<Device> getDeviceByToken(@Path("deviceToken") String deviceToken, @HeaderMap Map<String, String> headers);

    @POST("devices")
    Call<Device> createDevice(@Body DeviceCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("devices/{deviceToken}")
    Call<Device> updateDevice(@Path("deviceToken") String deviceToken, @Body DeviceCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("devices/{deviceToken}")
    Call<Device> deleteDevice(@Path("deviceToken") String deviceToken, @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // External Search
    // ------------------------------------------------------------------------
    
    // ------------------------------------------------------------------------
    // Instance
    // ------------------------------------------------------------------------
    
    // ------------------------------------------------------------------------
    // Scheduled Jobs
    // ------------------------------------------------------------------------

    @GET("jobs/{token}")
    Call<ScheduledJob> getScheduledJobByToken(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @POST("jobs")
    Call<ScheduledJob> createScheduledJob(@Body ScheduledJobCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("jobs/{token}")
    Call<ScheduledJob> updateScheduledJob(@Path("token") String token, @Body ScheduledJobCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("jobs/{token}")
    Call<ScheduledJob> deleteScheduledJob(@Path("token") String token, @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // Schedules
    // ------------------------------------------------------------------------
    
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
    
    @GET("users/{username}")
    Call<User> getUserByUsername(@Path("username") String username, @HeaderMap Map<String, String> headers);

    @POST("users")
    Call<User> createUser(@Body UserCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("users/{username}")
    Call<User> updateUser(@Path("username") String username, @Body UserCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("users/{username}")
    Call<User> deleteUser(@Path("username") String username, @HeaderMap Map<String, String> headers); 
    
    // ------------------------------------------------------------------------
    // Zones
    // ------------------------------------------------------------------------
    
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
