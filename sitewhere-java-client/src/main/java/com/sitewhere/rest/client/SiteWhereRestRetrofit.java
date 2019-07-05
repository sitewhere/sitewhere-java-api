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
import com.sitewhere.rest.model.area.request.AreaCreateRequest;
import com.sitewhere.rest.model.area.request.AreaTypeCreateRequest;
import com.sitewhere.rest.model.asset.Asset;
import com.sitewhere.rest.model.asset.AssetType;
import com.sitewhere.rest.model.asset.request.AssetCreateRequest;
import com.sitewhere.rest.model.asset.request.AssetTypeCreateRequest;
import com.sitewhere.rest.model.batch.BatchOperation;
import com.sitewhere.rest.model.customer.CustomerType;
import com.sitewhere.rest.model.customer.request.CustomerTypeCreateRequest;
import com.sitewhere.rest.model.device.DeviceAssignment;
import com.sitewhere.rest.model.device.DeviceType;
import com.sitewhere.rest.model.device.request.DeviceAssignmentCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceTypeCreateRequest;
import com.sitewhere.rest.model.system.Version;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Retrofit API for SiteWhere REST APIs.
 * 
 * @author Derek
 */
public interface SiteWhereRestRetrofit {

    @GET("system/version")
    Call<Version> getVersion();
    
    // ------------------------------------------------------------------------
    // Area Types 
    // ------------------------------------------------------------------------
    
    @GET("/areatypes/{areaTypeToken}")
    Call<AreaType> getAreaTypeByToken(@Path("areaTypeToken") String areaTypeToken, @HeaderMap Map<String, String> headers);

    @POST("areatypes")
    Call<AreaType> createAreaType(@Body AreaTypeCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("areatypes/{areaTypeToken}")
    Call<AreaType> updateAreaType(@Path("areaTypeToken") String areaTypeToken, @Body AreaTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("areatypes/{areaTypeToken}")
    Call<AreaType> deleteAreaType(@Path("areaTypeToken") String areaTypeToken, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Areas  
    // ------------------------------------------------------------------------
    
    @GET("/areas/{areaToken}")
    Call<Area> getAreaByToken(@Path("areaToken") String areaToken, @HeaderMap Map<String, String> headers);

    @POST("areas")
    Call<Area> createArea(@Body AreaCreateRequest request, @HeaderMap Map<String, String> headers);

    @PUT("areas/{areaToken}")
    Call<Area> updateArea(@Path("areaToken") String areaToken, @Body AreaCreateRequest request,
	    @HeaderMap Map<String, String> headers);

    @DELETE("areas/{areaToken}")
    Call<Area> deleteArea(@Path("areaToken") String areaToken, @HeaderMap Map<String, String> headers);
    
    // ------------------------------------------------------------------------
    // Asset Types  
    // ------------------------------------------------------------------------
    
    @GET("/assettypes/{assetTypeToken}")
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
    
    @GET("/assets/{assetToken}")
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
    
    @GET("/assignments/{token}")
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

    @GET("/batch/{batchToken}")
    Call<BatchOperation> getBatchOperationByToken(@Path("batchToken") String batchToken, @HeaderMap Map<String, String> headers);

    // ------------------------------------------------------------------------
    // Command Invocations
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Customer Types
    // ------------------------------------------------------------------------

    @GET("/customertypes/{customerTypeToken}")
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
    // Device Types 
    // ------------------------------------------------------------------------
    
    @POST("devicetypes")
    Call<DeviceType> createDeviceType(@Body DeviceTypeCreateRequest request, @HeaderMap Map<String, String> headers);

    @GET("devicetypes/{token}")
    Call<DeviceType> getDeviceTypeByToken(@Path("token") String token, @HeaderMap Map<String, String> headers);

    @PUT("devicetypes/{token}")
    Call<DeviceType> updateDeviceType(@Path("token") String token, @Body DeviceTypeCreateRequest request,
	    @HeaderMap Map<String, String> headers);
}
