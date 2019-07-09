/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi;

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
import com.sitewhere.rest.model.asset.request.AssetCreateRequest;
import com.sitewhere.rest.model.asset.request.AssetTypeCreateRequest;
import com.sitewhere.rest.model.batch.BatchOperation;
import com.sitewhere.rest.model.common.MetadataProvider;
import com.sitewhere.rest.model.customer.Customer;
import com.sitewhere.rest.model.customer.CustomerType;
import com.sitewhere.rest.model.customer.request.CustomerCreateRequest;
import com.sitewhere.rest.model.customer.request.CustomerTypeCreateRequest;
import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.DeviceAssignment;
import com.sitewhere.rest.model.device.DeviceStatus;
import com.sitewhere.rest.model.device.DeviceType;
import com.sitewhere.rest.model.device.asset.DeviceAlertWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceCommandResponseWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceLocationWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceMeasurementWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceStateChangeWithAsset;
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
import com.sitewhere.rest.model.device.marshaling.MarshaledArea;
import com.sitewhere.rest.model.device.marshaling.MarshaledAreaType;
import com.sitewhere.rest.model.device.marshaling.MarshaledDeviceAssignment;
import com.sitewhere.rest.model.device.request.DeviceAssignmentCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceCommandCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceGroupCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceGroupElementCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceStatusCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceStreamCreateRequest;
import com.sitewhere.rest.model.device.request.DeviceTypeCreateRequest;
import com.sitewhere.rest.model.device.streaming.DeviceStream;
import com.sitewhere.rest.model.scheduling.Schedule;
import com.sitewhere.rest.model.scheduling.ScheduledJob;
import com.sitewhere.rest.model.scheduling.request.ScheduleCreateRequest;
import com.sitewhere.rest.model.scheduling.request.ScheduledJobCreateRequest;
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
import com.sitewhere.rest.model.search.area.AreaSearchCriteria;
import com.sitewhere.rest.model.search.area.AreaTypeSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceAssignmentForAreaSearchCriteria;
import com.sitewhere.rest.model.system.Version;
import com.sitewhere.rest.model.tenant.Tenant;
import com.sitewhere.rest.model.tenant.request.TenantCreateRequest;
import com.sitewhere.rest.model.user.User;
import com.sitewhere.rest.model.user.request.UserCreateRequest;
import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.device.event.IDeviceMeasurement;
import com.sitewhere.spi.device.request.IDeviceAssignmentCreateRequest;

/**
 * Interface for SiteWhere client calls.
 * 
 * @author Derek Adams
 */
public interface ISiteWhereClient {

    /**
     * Initialize the client.
     * 
     * @return
     * @throws SiteWhereException
     */
    public ISiteWhereClient initialize() throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Area Types 
    // ------------------------------------------------------------------------

    /**
     * List area types matching criteria
     * 
     * @param tenant
     * @param areaTypeToken
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<AreaType> listAreaTypes(ITenantAuthentication tenant, 
	    AreaTypeSearchCriteria searchCriteria) throws SiteWhereException;
    
    /**
     * Get a area type by token.
     * 
     * @param tenant
     * @param areaTypeToken
     * @return
     * @throws SiteWhereException
     */
    public MarshaledAreaType getAreaTypeByToken(ITenantAuthentication tenant, String areaTypeToken) throws SiteWhereException;
    
    /**
     * Create a new area type.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public AreaType createAreaType(ITenantAuthentication tenant, AreaTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing area type.
     * 
     * @param tenant
     * @param areaTypeToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public AreaType updateAreaType(ITenantAuthentication tenant, String areaTypeToken, AreaTypeCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing area type.
     * 
     * @param tenant
     * @param areaTypeToken
     * @return
     * @throws SiteWhereException
     */
    public AreaType deleteAreaType(ITenantAuthentication tenant, String areaTypeToken) throws SiteWhereException;
    
    /**
     * Get label for area type
     * 
     * @param tenant
     * @param areaTypeToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    public byte[] getLabelForAreaType(ITenantAuthentication tenant, 
	    String areaTypeToken,
	    String generatorId) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Areas  
    // ------------------------------------------------------------------------

    /**
     * List areas matching criteria
     * 
     * @param tenant
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<Area> listAreas(ITenantAuthentication tenant, 
	    AreaSearchCriteria searchCriteria) throws SiteWhereException;
    
    /**
     * Get a area by token.
     * 
     * @param tenant
     * @param areaToken
     * @return
     * @throws SiteWhereException
     */
    public MarshaledArea getAreaByToken(ITenantAuthentication tenant, String areaToken) throws SiteWhereException;
    
    /**
     * Create a new area type.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Area createArea(ITenantAuthentication tenant, AreaCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing area type.
     * 
     * @param tenant
     * @param areaToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Area updateArea(ITenantAuthentication tenant, String areaToken, AreaCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing area type.
     * 
     * @param tenant
     * @param areaToken
     * @return
     * @throws SiteWhereException
     */
    public Area deleteArea(ITenantAuthentication tenant, String areaToken) throws SiteWhereException;
    
    /**
     * List alerts for an area
     * 
     * @param tenant
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<DeviceAlertWithAsset> listAlertsForArea(ITenantAuthentication tenant, 
	    String areaToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;
    
    /**
     * List device assignments for an area
     * 
     * @param tenant
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<MarshaledDeviceAssignment> listDeviceAssignmentsForArea(
	    ITenantAuthentication tenant, 
	    String areaToken,
	    DeviceAssignmentForAreaSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List command invocations for an area
     * 
     * @param tenant
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<DeviceCommandInvocation> listCommandInvocationsForArea(
	    ITenantAuthentication tenant, 
	    String areaToken, 
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;
    
    /**
     * Get label for area.
     * 
     * @param tenant
     * @param areaToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    public byte[] getLabelForArea(ITenantAuthentication tenant, 
	    String areaToken,
	    String generatorId) throws SiteWhereException;

    /**
     * List locations for an area
     * 
     * @param tenant
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<DeviceLocationWithAsset> listLocationsForArea(
	    ITenantAuthentication tenant, 
	    String areaToken, 
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;
    
    /**
     * List locations for an area
     * 
     * @param tenant
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<DeviceMeasurementWithAsset> listMeasurementsForArea(
	    ITenantAuthentication tenant, 
	    String areaToken, 
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;
    
    /**
     * List command responses for an area
     * 
     * @param tenant
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<DeviceCommandResponseWithAsset> listCommandResponsesForArea(
	    ITenantAuthentication tenant, 
	    String areaToken, 
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List state changes for an area
     * 
     * @param tenant
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<DeviceStateChangeWithAsset> listStateChangesForArea(
	    ITenantAuthentication tenant, 
	    String areaToken, 
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Asset Types  
    // ------------------------------------------------------------------------

    /**
     * Get a asset type by token.
     * 
     * @param tenant
     * @param assetTypeToken
     * @return
     * @throws SiteWhereException
     */
    public AssetType getAssetTypeByToken(ITenantAuthentication tenant, String assetTypeToken) throws SiteWhereException;
    
    /**
     * Create a new asset type type.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public AssetType createAssetType(ITenantAuthentication tenant, AssetTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing asset type type.
     * 
     * @param tenant
     * @param assetTypeToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public AssetType updateAssetType(ITenantAuthentication tenant, String assetTypeToken, AssetTypeCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing asset type type.
     * 
     * @param tenant
     * @param assetTypeToken
     * @return
     * @throws SiteWhereException
     */
    public AssetType deleteAssetType(ITenantAuthentication tenant, String assetTypeToken) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Asset  
    // ------------------------------------------------------------------------

    /**
     * Get a asset by token.
     * 
     * @param tenant
     * @param assetToken
     * @return
     * @throws SiteWhereException
     */
    public Asset getAssetByToken(ITenantAuthentication tenant, String assetToken) throws SiteWhereException;
    
    /**
     * Create a new asset.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Asset createAsset(ITenantAuthentication tenant, AssetCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing asset.
     * 
     * @param tenant
     * @param assetToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Asset updateAsset(ITenantAuthentication tenant, String assetToken, AssetCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing asset.
     * 
     * @param tenant
     * @param assetToken
     * @return
     * @throws SiteWhereException
     */
    public Asset deleteAsset(ITenantAuthentication tenant, String assetToken) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Assignments  
    // ------------------------------------------------------------------------

    /**
     * Get a device assignment by token.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public DeviceAssignment getDeviceAssignmentByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;
    
    /**
     * Create a new device assignment.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceAssignment createDeviceAssignment(ITenantAuthentication tenant, DeviceAssignmentCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device assignment.
     * 
     * @param tenant
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceAssignment updateDeviceAssignment(ITenantAuthentication tenant, String token, DeviceAssignmentCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing device assignment.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public DeviceAssignment deleteDeviceAssignment(ITenantAuthentication tenant, String token) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Batch Operations  
    // ------------------------------------------------------------------------
    
    /**
     * Get a batch operation by token.
     * 
     * @param tenant
     * @param batchToken
     * @return
     * @throws SiteWhereException
     */
    public BatchOperation getBatchOperationByToken(ITenantAuthentication tenant, String batchToken) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Command Invocations
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Customer Types
    // ------------------------------------------------------------------------
    
    /**
     * Get a customer type by token.
     * 
     * @param tenant
     * @param customerTypeToken
     * @return
     * @throws SiteWhereException
     */
    public CustomerType getCustomerTypeByToken(ITenantAuthentication tenant, String customerTypeToken) throws SiteWhereException;
    
    /**
     * Create a new customer type.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public CustomerType createCustomerType(ITenantAuthentication tenant, CustomerTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing customer type.
     * 
     * @param tenant
     * @param customerTypeToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public CustomerType updateCustomerType(ITenantAuthentication tenant, String customerTypeToken, CustomerTypeCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing customer type.
     * 
     * @param tenant
     * @param customerTypeToken
     * @return
     * @throws SiteWhereException
     */
    public CustomerType deleteCustomerType(ITenantAuthentication tenant, String customerTypeToken) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Customer
    // ------------------------------------------------------------------------
    
    /**
     * Get a customer by token.
     * 
     * @param tenant
     * @param customerToken
     * @return
     * @throws SiteWhereException
     */
    public Customer getCustomerByToken(ITenantAuthentication tenant, String customerToken) throws SiteWhereException;
    
    /**
     * Create a new customer.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Customer createCustomer(ITenantAuthentication tenant, CustomerCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing customer.
     * 
     * @param tenant
     * @param customerToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Customer updateCustomer(ITenantAuthentication tenant, String customerToken, CustomerCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing customer.
     * 
     * @param tenant
     * @param customerToken
     * @return
     * @throws SiteWhereException
     */
    public Customer deleteCustomer(ITenantAuthentication tenant, String customerToken) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Device Commands
    // ------------------------------------------------------------------------

    /**
     * Get a device command by token.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public DeviceCommand getDeviceCommandByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;
    
    /**
     * Create a new device command.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceCommand createDeviceCommand(ITenantAuthentication tenant, DeviceCommandCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device command.
     * 
     * @param tenant
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceCommand updateDeviceCommand(ITenantAuthentication tenant, String token, DeviceCommandCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing device command.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public DeviceCommand deleteDeviceCommand(ITenantAuthentication tenant, String token) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Device Events
    // ------------------------------------------------------------------------
    
    // ------------------------------------------------------------------------
    // Device Groups
    // ------------------------------------------------------------------------

    /**
     * Get a device group by token.
     * 
     * @param tenant
     * @param groupToken
     * @return
     * @throws SiteWhereException
     */
    public DeviceGroup getDeviceGroupByToken(ITenantAuthentication tenant, String groupToken) throws SiteWhereException;
    
    /**
     * Create a new device group.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceGroup createDeviceGroup(ITenantAuthentication tenant, DeviceGroupCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device group.
     * 
     * @param tenant
     * @param groupToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceGroup updateDeviceGroup(ITenantAuthentication tenant, String groupToken, DeviceGroupCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing device group.
     * 
     * @param tenant
     * @param groupToken
     * @return
     * @throws SiteWhereException
     */
    public DeviceGroup deleteDeviceGroup(ITenantAuthentication tenant, String groupToken) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Device States
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Device Statuses
    // ------------------------------------------------------------------------

    /**
     * Get a device status by token.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public DeviceStatus getDeviceStatusByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;
    
    /**
     * Create a new device status.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceStatus createDeviceStatus(ITenantAuthentication tenant, DeviceStatusCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device status.
     * 
     * @param tenant
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceStatus updateDeviceStatus(ITenantAuthentication tenant, String token, DeviceStatusCreateRequest request)
	    throws SiteWhereException;
    
    /**
     * Delete an existing device status.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public DeviceStatus deleteDeviceStatus(ITenantAuthentication tenant, String token) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Device Types 
    // ------------------------------------------------------------------------
    
    /**
     * Get a device type by token.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public DeviceType getDeviceTypeByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Create a new device type.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceType createDeviceType(ITenantAuthentication tenant, DeviceTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device type.
     * 
     * @param tenant
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceType updateDeviceType(ITenantAuthentication tenant, String token, DeviceTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing device type.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public DeviceType deleteDeviceType(ITenantAuthentication tenant, String token) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Devices
    // ------------------------------------------------------------------------
    
    /**
     * Get a device by token.
     * 
     * @param tenant
     * @param deviceToken
     * @return
     * @throws SiteWhereException
     */
    public Device getDeviceByToken(ITenantAuthentication tenant, String deviceToken) throws SiteWhereException;

    /**
     * Create a new device.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Device createDevice(ITenantAuthentication tenant, DeviceCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device.
     * 
     * @param tenant
     * @param deviceToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Device updateDevice(ITenantAuthentication tenant, String deviceToken, DeviceCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing device.
     * 
     * @param tenant
     * @param deviceToken
     * @return
     * @throws SiteWhereException
     */
    public Device deleteDevice(ITenantAuthentication tenant, String deviceToken) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // External Search
    // ------------------------------------------------------------------------
    
    // ------------------------------------------------------------------------
    // Instance
    // ------------------------------------------------------------------------
    
    // ------------------------------------------------------------------------
    // Scheduled Jobs
    // ------------------------------------------------------------------------

    /**
     * Get a schedule job by token.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public ScheduledJob getScheduledJobByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Create a new schedule job.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public ScheduledJob createScheduledJob(ITenantAuthentication tenant, ScheduledJobCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing schedule job.
     * 
     * @param tenant
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public ScheduledJob updateScheduledJob(ITenantAuthentication tenant, String token, ScheduledJobCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing schedule job.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public ScheduledJob deleteScheduledJob(ITenantAuthentication tenant, String token) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Schedules
    // ------------------------------------------------------------------------
    
    /**
     * Get a schedule by token.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public Schedule getScheduleByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Create a new schedule.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Schedule createSchedule(ITenantAuthentication tenant, ScheduleCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing schedule.
     * 
     * @param tenant
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Schedule updateSchedule(ITenantAuthentication tenant, String token, ScheduleCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing schedule.
     * 
     * @param tenant
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public Schedule deleteSchedule(ITenantAuthentication tenant, String token) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // System
    // ------------------------------------------------------------------------

    /**
     * Get SiteWhere version information.
     * 
     * @return
     * @throws SiteWhereException
     */
    public Version getSiteWhereVersion() throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Tenants
    // ------------------------------------------------------------------------

    /**
     * Get a tenant by token.
     * 
     * @param tenant
     * @param tenantToken
     * @return
     * @throws SiteWhereException
     */
    public Tenant getTenantByToken(String tenantToken) throws SiteWhereException;

    /**
     * Create a new tenant.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Tenant createTenant(TenantCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing tenant.
     * 
     * @param tenant
     * @param tenantToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Tenant updateTenant(String tenantToken, TenantCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing tenant.
     * 
     * @param tenant
     * @param tenantToken
     * @return
     * @throws SiteWhereException
     */
    public Tenant deleteTenant(String tenantToken) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    // Users
    // ------------------------------------------------------------------------
    
    /**
     * Get a user by username.
     * 
     * @param tenant
     * @param username
     * @return
     * @throws SiteWhereException
     */
    public User getUserByUsername(ITenantAuthentication tenant, String username) throws SiteWhereException;

    /**
     * Create a new user.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public User createUser(ITenantAuthentication tenant, UserCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing user.
     * 
     * @param tenant
     * @param username
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public User updateUser(ITenantAuthentication tenant, String username, UserCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing user.
     * 
     * @param tenant
     * @param username
     * @return
     * @throws SiteWhereException
     */
    public User deleteUser(ITenantAuthentication tenant, String username) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Zones
    // ------------------------------------------------------------------------
    
    /**
     * Get a zone by token.
     * 
     * @param tenant
     * @param zoneToken
     * @return
     * @throws SiteWhereException
     */
    public Zone getZoneByToken(ITenantAuthentication tenant, String zoneToken) throws SiteWhereException;

    /**
     * Create a new zone.
     * 
     * @param tenant
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Zone createZone(ITenantAuthentication tenant, ZoneCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing zone.
     * 
     * @param tenant
     * @param zoneToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public Zone updateZone(ITenantAuthentication tenant, String zoneToken, ZoneCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing zone.
     * 
     * @param tenant
     * @param zoneToken
     * @return
     * @throws SiteWhereException
     */
    public Zone deleteZone(ITenantAuthentication tenant, String zoneToken) throws SiteWhereException;
    
    // ------------------------------------------------------------------------
    /**
     * List device types that meet the given criteria.
     * 
     * @param includeDeleted
     * @param includeDetailedAssetInfo
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    public DeviceTypeSearchResults listDeviceTypes(boolean includeDeleted, boolean includeDetailedAssetInfo,
	    SearchCriteria criteria) throws SiteWhereException;

    /**
     * Create a new device command for a specification.
     * 
     * @param specificationToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceCommand createDeviceCommand(String specificationToken, DeviceCommandCreateRequest request)
	    throws SiteWhereException;

    /**
     * List all device commands for a device specification.
     * 
     * @param specificationToken
     * @param includeDeleted
     * @return
     * @throws SiteWhereException
     */
    public DeviceCommandSearchResults listDeviceCommands(String specificationToken, boolean includeDeleted)
	    throws SiteWhereException;

    /**
     * List zones associated with a given site.
     * 
     * @param siteToken
     * @return
     * @throws SiteWhereException
     */
    public ZoneSearchResults listZonesForSite(String siteToken) throws SiteWhereException;

    /**
     * List devices that meet the given criteria.
     * 
     * @param includeDeleted
     * @param excludeAssigned
     * @param populateSpecification
     * @param populateAssignment
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    public DeviceSearchResults listDevices(boolean includeDeleted, boolean excludeAssigned,
	    boolean populateSpecification, boolean populateAssignment, DateRangeSearchCriteria criteria)
	    throws SiteWhereException;

    /**
     * Get current device assignment for a device based on hardware id.
     * 
     * @param hardwareId
     *                       unique hardware id of device
     * @return device assignment information
     * @throws SiteWhereException
     */
    public DeviceAssignment getCurrentAssignmentForDevice(String hardwareId) throws SiteWhereException;

    /**
     * Get the history of device assignments for a given hardware id.
     * 
     * @param hardwareId
     * @return
     * @throws SiteWhereException
     */
    public DeviceAssignmentSearchResults listDeviceAssignmentHistory(String hardwareId) throws SiteWhereException;

    /**
     * Get all assignments at a site that are associated with a given asset.
     * 
     * @param siteToken
     * @param assetModuleId
     * @param assetId
     * @param status
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    public DeviceAssignmentSearchResults getAssignmentsForAsset(String siteToken, String assetModuleId, String assetId,
	    DeviceAssignmentStatus status, SearchCriteria criteria) throws SiteWhereException;

    /**
     * Add a batch of events to the current assignment for the given hardware id.
     * 
     * @param hardwareId
     *                       hardware id whose assignment will have events added
     * @param batch
     *                       batch of events that will be added
     * @return response of events that were created
     * @throws SiteWhereException
     */
    public DeviceEventBatchResponse addDeviceEventBatch(String hardwareId, DeviceEventBatch batch)
	    throws SiteWhereException;

    /**
     * Create a new device assignment based on the given inputs.
     * 
     * @param request
     *                    information about the new assignment
     * @return the assignment that was created.
     * @throws SiteWhereException
     */
    public DeviceAssignment createDeviceAssignment(IDeviceAssignmentCreateRequest request) throws SiteWhereException;

    /**
     * Get a device assignment by its unique token.
     * 
     * @param assignmentToken
     *                            unique assignment token
     * @return the device assignment
     * @throws SiteWhereException
     */
    public DeviceAssignment getDeviceAssignmentByToken(String assignmentToken) throws SiteWhereException;

    /**
     * List all assignments for a site.
     * 
     * @param token
     * @return
     * @throws SiteWhereException
     */
    public DeviceAssignmentSearchResults listAssignmentsForSite(String token) throws SiteWhereException;

    /**
     * Update the metadata for an existing device assignment.
     * 
     * @param token
     * @param metadata
     * @return
     * @throws SiteWhereException
     */
    public DeviceAssignment updateDeviceAssignmentMetadata(String token, MetadataProvider metadata)
	    throws SiteWhereException;

    /**
     * Create measurements for an assignment.
     * 
     * @param assignmentToken
     * @param measurements
     * @return
     * @throws SiteWhereException
     */
    public DeviceMeasurement createDeviceMeasurements(String assignmentToken,
	    DeviceMeasurementCreateRequest measurements) throws SiteWhereException;

    /**
     * Get most recent device measurements for a given assignment.
     * 
     * @param assignmentToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    public SearchResults<IDeviceMeasurement> listDeviceMeasurements(String assignmentToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Create a new device location for an assignment.
     * 
     * @param assignmentToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceLocation createDeviceLocation(String assignmentToken, DeviceLocationCreateRequest request)
	    throws SiteWhereException;

    /**
     * Get most recent device locations for a given assignment.
     * 
     * @param assignmentToken
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    public DeviceLocationSearchResults listDeviceLocations(String assignmentToken, DateRangeSearchCriteria criteria)
	    throws SiteWhereException;

    /**
     * Create a new alert for a device assignment.
     * 
     * @param assignmentToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceAlert createDeviceAlert(String assignmentToken, DeviceAlertCreateRequest request)
	    throws SiteWhereException;

    /**
     * Get most recent device alerts for a given assignment.
     * 
     * @param assignmentToken
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    public DeviceAlertSearchResults listDeviceAlerts(String assignmentToken, DateRangeSearchCriteria criteria)
	    throws SiteWhereException;

    /**
     * Create a new device command invocation for a device assignment.
     * 
     * @param assignmentToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceCommandInvocation createDeviceCommandInvocation(String assignmentToken,
	    DeviceCommandInvocationCreateRequest request) throws SiteWhereException;

    /**
     * List device command invocations that match the given criteria.
     * 
     * @param assignmentToken
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    public DeviceCommandInvocationSearchResults listDeviceCommandInvocations(String assignmentToken,
	    DateRangeSearchCriteria criteria) throws SiteWhereException;

    /**
     * Create a stream that will be associated with a device assignment.
     * 
     * @param assignmentToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public DeviceStream createDeviceStream(String assignmentToken, DeviceStreamCreateRequest request)
	    throws SiteWhereException;

    /**
     * Get a stream from an assignment based on unique id.
     * 
     * @param assignmentToken
     * @param streamId
     * @return
     * @throws SiteWhereException
     */
    public DeviceStream getDeviceStream(String assignmentToken, String streamId) throws SiteWhereException;

    /**
     * List device streams for an assignment.
     * 
     * @param assignmentToken
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    public DeviceStreamSearchResults listDeviceStreams(String assignmentToken, DateRangeSearchCriteria criteria)
	    throws SiteWhereException;

    /**
     * Add a chunk of data to a device stream.
     * 
     * @param assignmentToken
     * @param streamId
     * @param sequenceNumber
     * @param data
     * @throws SiteWhereException
     */
    public void addDeviceStreamData(String assignmentToken, String streamId, long sequenceNumber, byte[] data)
	    throws SiteWhereException;

    /**
     * Get a chunk of data from a device stream.
     * 
     * @param assignmentToken
     * @param streamId
     * @param sequenceNumber
     * @return
     * @throws SiteWhereException
     */
    public byte[] getDeviceStreamData(String assignmentToken, String streamId, long sequenceNumber)
	    throws SiteWhereException;

    /**
     * List device stream data that meets the given criteria.
     * 
     * @param assignmentToken
     * @param streamId
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    public byte[] listDeviceStreamData(String assignmentToken, String streamId, DateRangeSearchCriteria criteria)
	    throws SiteWhereException;

    /**
     * Invokes a command on a list of devices as a batch operation.
     * 
     * @param batchToken
     * @param commandToken
     * @param parameters
     * @param hardwareIds
     * @return
     * @throws SiteWhereException
     */
    public BatchOperation createBatchCommandInvocation(String batchToken, String commandToken,
	    Map<String, String> parameters, List<String> hardwareIds) throws SiteWhereException;

    /**
     * List device groups that meet the given criteria.
     * 
     * @param role
     * @param criteria
     * @param includeDeleted
     * @return
     * @throws SiteWhereException
     */
    public DeviceGroupSearchResults listDeviceGroups(String role, SearchCriteria criteria, boolean includeDeleted)
	    throws SiteWhereException;

    /**
     * Add elements to an existing device group.
     * 
     * @param groupToken
     * @param elements
     * @return
     * @throws SiteWhereException
     */
    public DeviceGroupElementSearchResults addDeviceGroupElements(String groupToken,
	    List<DeviceGroupElementCreateRequest> elements) throws SiteWhereException;

    /**
     * List device group elements that meet the given criteria.
     * 
     * @param groupToken
     * @param includeDetails
     * @param criteria
     * @return
     * @throws SiteWhereException
     */
    public DeviceGroupElementSearchResults listDeviceGroupElements(String groupToken, boolean includeDetails,
	    SearchCriteria criteria) throws SiteWhereException;

    /**
     * Delete elements from an existing device group.
     * 
     * @param groupToken
     * @param elements
     * @return
     * @throws SiteWhereException
     */
    public DeviceGroupElementSearchResults deleteDeviceGroupElements(String groupToken,
	    List<DeviceGroupElementCreateRequest> elements) throws SiteWhereException;

    /**
     * List all assets in a given asset module that meet the given criteria.
     * 
     * @param moduleId
     * @return
     * @throws SiteWhereException
     */
    public AssetSearchResults getAssetsByModuleId(String moduleId, String criteria) throws SiteWhereException;
}