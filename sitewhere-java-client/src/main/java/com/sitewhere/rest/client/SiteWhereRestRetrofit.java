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
import com.sitewhere.rest.model.device.DeviceType;
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
