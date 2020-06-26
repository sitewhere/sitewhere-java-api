/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi;

import java.io.File;
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

/**
 * Interface for SiteWhere client calls.
 */
public interface ISiteWhereClient {

    /**
     * Initialize the client.
     * 
     * @return Initialized ISiteWhereClient.
     * @throws SiteWhereException
     */
    ISiteWhereClient initialize() throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Area Types
    // ------------------------------------------------------------------------

    /**
     * List area types matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     *                           Search criteria object used for filtering Area Type
     *                           results.
     * @return <code>SearchResuts</code> object containing area type matching the
     *         criteria provided.
     * @throws SiteWhereException
     */
    SearchResults<AreaType> listAreaTypes(ITenantAuthentication tenant, AreaTypeSearchCriteria searchCriteria)
	    throws SiteWhereException;

    /**
     * Get a area type by token.
     * 
     * @param tenant
     *                          Tenant authentication information. Tenant
     *                          authentication information.
     * @param areaTypeToken
     * @return
     * @throws SiteWhereException
     */
    MarshaledAreaType getAreaTypeByToken(ITenantAuthentication tenant, String areaTypeToken) throws SiteWhereException;

    /**
     * Create a new area type.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    AreaType createAreaType(ITenantAuthentication tenant, AreaTypeCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing area type.
     * 
     * @param tenant
     *                          Tenant authentication information. Tenant
     *                          authentication information.
     * @param areaTypeToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    AreaType updateAreaType(ITenantAuthentication tenant, String areaTypeToken, AreaTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing area type.
     * 
     * @param tenant
     *                          Tenant authentication information. Tenant
     *                          authentication information.
     * @param areaTypeToken
     * @return
     * @throws SiteWhereException
     */
    AreaType deleteAreaType(ITenantAuthentication tenant, String areaTypeToken) throws SiteWhereException;

    /**
     * Get label for area type.
     * 
     * @param tenant
     *                          Tenant authentication information. Tenant
     *                          authentication information.
     * @param areaTypeToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForAreaType(ITenantAuthentication tenant, String areaTypeToken, String generatorId)
	    throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Areas
    // ------------------------------------------------------------------------

    /**
     * List areas matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<Area> listAreas(ITenantAuthentication tenant, AreaSearchCriteria searchCriteria,
	    AreaResponseFormat responseFormat) throws SiteWhereException;

    /**
     * Get a area by token.
     * 
     * @param tenant
     *                      Tenant authentication information. Tenant authentication
     *                      information.
     * @param areaToken
     * @return
     * @throws SiteWhereException
     */
    MarshaledArea getAreaByToken(ITenantAuthentication tenant, String areaToken) throws SiteWhereException;

    /**
     * Create a new area type.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Area createArea(ITenantAuthentication tenant, AreaCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing area type.
     * 
     * @param tenant
     *                      Tenant authentication information. Tenant authentication
     *                      information.
     * @param areaToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Area updateArea(ITenantAuthentication tenant, String areaToken, AreaCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing area type.
     * 
     * @param tenant
     *                      Tenant authentication information. Tenant authentication
     *                      information.
     * @param areaToken
     * @return
     * @throws SiteWhereException
     */
    Area deleteArea(ITenantAuthentication tenant, String areaToken) throws SiteWhereException;

    /**
     * List alerts for an area.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceAlertWithAsset> listAlertsForArea(ITenantAuthentication tenant, String areaToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List device assignments for an area.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<MarshaledDeviceAssignment> listDeviceAssignmentsForArea(ITenantAuthentication tenant,
	    String areaToken, DeviceAssignmentSearchCriteria searchCriteria,
	    DeviceAssignmentResponseFormat responseFormat) throws SiteWhereException;

    /**
     * List command invocations for an area.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandInvocation> listCommandInvocationsForArea(ITenantAuthentication tenant, String areaToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Get label for area.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param areaToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForArea(ITenantAuthentication tenant, String areaToken, String generatorId)
	    throws SiteWhereException;

    /**
     * List locations for an area.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceLocationWithAsset> listLocationsForArea(ITenantAuthentication tenant, String areaToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List locations for an area.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceMeasurementWithAsset> listMeasurementsForArea(ITenantAuthentication tenant, String areaToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List command responses for an area.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandResponseWithAsset> listCommandResponsesForArea(ITenantAuthentication tenant,
	    String areaToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List state changes for an area.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param areaToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceStateChangeWithAsset> listStateChangesForArea(ITenantAuthentication tenant, String areaToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List all areas in tree format.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @return
     * @throws SiteWhereException
     */
    List<TreeNode> areaTree(ITenantAuthentication tenant) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Asset Types
    // ------------------------------------------------------------------------

    /**
     * List asset types matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<AssetType> listAssetTypes(ITenantAuthentication tenant, AssetTypeSearchCriteria searchCriteria)
	    throws SiteWhereException;

    /**
     * Get a asset type by token.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param assetTypeToken
     * @return
     * @throws SiteWhereException
     */
    AssetType getAssetTypeByToken(ITenantAuthentication tenant, String assetTypeToken) throws SiteWhereException;

    /**
     * Create a new asset type type.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    AssetType createAssetType(ITenantAuthentication tenant, AssetTypeCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing asset type type.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param assetTypeToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    AssetType updateAssetType(ITenantAuthentication tenant, String assetTypeToken, AssetTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing asset type type.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param assetTypeToken
     * @return
     * @throws SiteWhereException
     */
    AssetType deleteAssetType(ITenantAuthentication tenant, String assetTypeToken) throws SiteWhereException;

    /**
     * Get label for asset type.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param assetTypeToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForAssetType(ITenantAuthentication tenant, String assetTypeToken, String generatorId)
	    throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Asset
    // ------------------------------------------------------------------------

    /**
     * List assets matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<Asset> listAssets(ITenantAuthentication tenant, AssetSearchCriteria searchCriteria)
	    throws SiteWhereException;

    /**
     * Get a asset by token.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param assetToken
     * @return
     * @throws SiteWhereException
     */
    MarshaledAsset getAssetByToken(ITenantAuthentication tenant, String assetToken) throws SiteWhereException;

    /**
     * Create a new asset.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Asset createAsset(ITenantAuthentication tenant, AssetCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing asset.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param assetToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Asset updateAsset(ITenantAuthentication tenant, String assetToken, AssetCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing asset.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param assetToken
     * @return
     * @throws SiteWhereException
     */
    Asset deleteAsset(ITenantAuthentication tenant, String assetToken) throws SiteWhereException;

    /**
     * Get label for asset.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param assetToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForAsset(ITenantAuthentication tenant, String assetToken, String generatorId)
	    throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Assignments
    // ------------------------------------------------------------------------

    /**
     * List device assignment matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param format
     * @return
     * @throws SiteWhereException
     */
    SearchResults<MarshaledDeviceAssignment> listDeviceAssignments(ITenantAuthentication tenant,
	    DeviceAssignmentSearchCriteria searchCriteria, DeviceAssignmentResponseFormat format)
	    throws SiteWhereException;

    /**
     * Get a device assignment by token.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    MarshaledDeviceAssignment getDeviceAssignmentByToken(ITenantAuthentication tenant, String token)
	    throws SiteWhereException;

    /**
     * Create a new device assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    MarshaledDeviceAssignment createDeviceAssignment(ITenantAuthentication tenant,
	    DeviceAssignmentCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing device assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    MarshaledDeviceAssignment updateDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceAssignmentCreateRequest request) throws SiteWhereException;

    /**
     * Delete an existing device assignment.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    MarshaledDeviceAssignment deleteDeviceAssignment(ITenantAuthentication tenant, String token)
	    throws SiteWhereException;

    /**
     * List alerts for a device assignment.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param token
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceAlertWithAsset> listAlertsForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Create alert event for device assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceAlertWithAsset createAlertForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceAlertCreateRequest request) throws SiteWhereException;

    /**
     * Release an active device assignment.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    MarshaledDeviceAssignment releaseDeviceAssignment(ITenantAuthentication tenant, String token)
	    throws SiteWhereException;

    /**
     * List command invocations for a device assignment.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param token
     * @param includeCommand
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandInvocation> listCommandInvocationsForDeviceAssignment(ITenantAuthentication tenant,
	    String token, Boolean includeCommand, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Create command invocation event for assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceCommandInvocation createCommandInvocationForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceCommandInvocationCreateRequest request) throws SiteWhereException;

    /**
     * Schedule command invocation.
     * 
     * @param tenant
     *                          Tenant authentication information. Tenant
     *                          authentication information.
     * @param token
     * @param scheduleToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    ScheduledJob scheduleCommandInvocation(ITenantAuthentication tenant, String token, String scheduleToken,
	    DeviceCommandInvocationCreateRequest request) throws SiteWhereException;

    /**
     * Get label for device assignment.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param token
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForDeviceAssignment(ITenantAuthentication tenant, String token, String generatorId)
	    throws SiteWhereException;

    /**
     * List location events for device assignment.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param token
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceLocationWithAsset> listLocationsForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Create location event for assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceLocationWithAsset createLocationForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceLocationCreateRequest request) throws SiteWhereException;

    /**
     * List measurement events for device assignment.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param token
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceMeasurementWithAsset> listMeasurementsForDeviceAssignment(ITenantAuthentication tenant,
	    String token, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Create location event for assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceMeasurementWithAsset createMeasurementForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceMeasurementCreateRequest request) throws SiteWhereException;

    /**
     * List assignment measurements as chart series.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param token
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    List<ChartSeries<Double>> listMeasurementsForDeviceAssignmentAsChartSeries(ITenantAuthentication tenant,
	    String token, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Mark device assignment as missing.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    MarshaledDeviceAssignment markMissingDeviceAssignment(ITenantAuthentication tenant, String token)
	    throws SiteWhereException;

    /**
     * List command response events for assignment.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param token
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandResponseWithAsset> listCommandResponsesForDeviceAssignment(ITenantAuthentication tenant,
	    String token, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Create command response event for assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceCommandResponseWithAsset createCommandResponseForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceCommandResponseCreateRequest request) throws SiteWhereException;

    /**
     * List state change events for assignment.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param token
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceStateChangeWithAsset> listStateChangesForDeviceAssignment(ITenantAuthentication tenant,
	    String token, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Create state change event for assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceStateChangeWithAsset createStateChangeForDeviceAssignment(ITenantAuthentication tenant, String token,
	    DeviceStateChangeCreateRequest request) throws SiteWhereException;

    /**
     * List alert events for device assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceAlertWithAsset> bulkListAlertsForDeviceAssignments(ITenantAuthentication tenant,
	    DeviceAssignmentBulkRequest request) throws SiteWhereException;

    /**
     * List command invocation events for assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandInvocation> bulkListCommandInvocationsForDeviceAssignments(ITenantAuthentication tenant,
	    DeviceAssignmentBulkRequest request) throws SiteWhereException;

    /**
     * List location events for device assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceLocationWithAsset> bulkListLocationsForDeviceAssignments(ITenantAuthentication tenant,
	    DeviceAssignmentBulkRequest request) throws SiteWhereException;

    /**
     * List measurement events for multiple assignments.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceMeasurementWithAsset> bulkListMeasurementsForDeviceAssignments(ITenantAuthentication tenant,
	    DeviceAssignmentBulkRequest request) throws SiteWhereException;

    /**
     * List measurements for multiple assignments as chart series.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Map<String, List<ChartSeries<Double>>> bulkListMeasurementsForDeviceAssignmentsAsChartSeries(
	    ITenantAuthentication tenant, DeviceAssignmentBulkRequest request) throws SiteWhereException;

    /**
     * List command response events for assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandResponseWithAsset> bulkListCommandResponsesForDeviceAssignments(
	    ITenantAuthentication tenant, DeviceAssignmentBulkRequest request) throws SiteWhereException;

    /**
     * List state change events for a device assignment.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceStateChangeWithAsset> bulkListStateChangesForDeviceAssignments(ITenantAuthentication tenant,
	    DeviceAssignmentBulkRequest request) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Authorities
    // ------------------------------------------------------------------------

    /**
     * List authorities that match criteria.
     * 
     * @return
     * @throws SiteWhereException
     */
    SearchResults<GrantedAuthority> listAuthorities(ITenantAuthentication tenant) throws SiteWhereException;

    /**
     * Get authority by name.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param name
     * @return
     * @throws SiteWhereException
     */
    GrantedAuthority getAuthorityByName(ITenantAuthentication tenant, String name) throws SiteWhereException;

    /**
     * Create a new authority.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    GrantedAuthority createAuthority(ITenantAuthentication tenant, GrantedAuthorityCreateRequest request)
	    throws SiteWhereException;

    /**
     * Get authorities hierarchy.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @return
     * @throws SiteWhereException
     */
    List<GrantedAuthorityHierarchyNode> getAuthoritiesHierarchy(ITenantAuthentication tenant) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Batch Operations
    // ------------------------------------------------------------------------

    /**
     * List batch operations.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<BatchOperation> listBatchOperations(ITenantAuthentication tenant,
	    BatchOperationSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Get a batch operation by token.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param batchToken
     * @return
     * @throws SiteWhereException
     */
    BatchOperation getBatchOperationByToken(ITenantAuthentication tenant, String batchToken) throws SiteWhereException;

    /**
     * List batch operation elements.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param operationToken
     * @return
     */
    SearchResults<BatchElement> listBatchOperationElements(ITenantAuthentication tenant, String operationToken)
	    throws SiteWhereException;

    /**
     * Create new batch command invocation.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    BatchOperation createBatchCommandInvocation(ITenantAuthentication tenant, BatchCommandInvocationRequest request)
	    throws SiteWhereException;

    /**
     * Create batch command operation based on criteria.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Object createBatchCommandOperationForCriteria(ITenantAuthentication tenant,
	    InvocationByDeviceCriteriaRequest request) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Command Invocations
    // ------------------------------------------------------------------------

    /**
     * Get command invocation by unique id.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param id
     * @return
     * @throws SiteWhereException
     */
    DeviceCommandInvocation getDeviceCommandInvocation(ITenantAuthentication tenant, String id)
	    throws SiteWhereException;

    /**
     * Get command invocation summary.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param id
     * @return
     * @throws SiteWhereException
     */
    DeviceCommandInvocationSummary getDeviceCommandInvocationSummary(ITenantAuthentication tenant, String id)
	    throws SiteWhereException;

    /**
     * List responses for command invocation.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param id
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandResponse> listCommandResponsesForCommandInvocation(ITenantAuthentication tenant,
	    String id) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Customer Types
    // ------------------------------------------------------------------------

    /**
     * List customer types matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<CustomerType> listCustomerTypes(ITenantAuthentication tenant,
	    CustomerTypeSearchCriteria searchCriteria, CustomerTypeResponseFormat responseFormat)
	    throws SiteWhereException;

    /**
     * Get a customer type by token.
     * 
     * @param tenant
     *                              Tenant authentication information. Tenant
     *                              authentication information.
     * @param customerTypeToken
     * @return
     * @throws SiteWhereException
     */
    CustomerType getCustomerTypeByToken(ITenantAuthentication tenant, String customerTypeToken)
	    throws SiteWhereException;

    /**
     * Create a new customer type.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    CustomerType createCustomerType(ITenantAuthentication tenant, CustomerTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing customer type.
     * 
     * @param tenant
     *                              Tenant authentication information. Tenant
     *                              authentication information.
     * @param customerTypeToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    CustomerType updateCustomerType(ITenantAuthentication tenant, String customerTypeToken,
	    CustomerTypeCreateRequest request) throws SiteWhereException;

    /**
     * Delete an existing customer type.
     * 
     * @param tenant
     *                              Tenant authentication information. Tenant
     *                              authentication information.
     * @param customerTypeToken
     * @return
     * @throws SiteWhereException
     */
    CustomerType deleteCustomerType(ITenantAuthentication tenant, String customerTypeToken) throws SiteWhereException;

    /**
     * Get label for customer type.
     * 
     * @param tenant
     *                              Tenant authentication information. Tenant
     *                              authentication information.
     * @param customerTypeToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForCustomerType(ITenantAuthentication tenant, String customerTypeToken, String generatorId)
	    throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Customer
    // ------------------------------------------------------------------------

    /**
     * List customers matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<Customer> listCustomers(ITenantAuthentication tenant, CustomerSearchCriteria searchCriteria,
	    CustomerResponseFormat responseFormat) throws SiteWhereException;

    /**
     * Get a customer by token.
     * 
     * @param tenant
     *                          Tenant authentication information. Tenant
     *                          authentication information.
     * @param customerToken
     * @return
     * @throws SiteWhereException
     */
    MarshaledCustomer getCustomerByToken(ITenantAuthentication tenant, String customerToken) throws SiteWhereException;

    /**
     * Create a new customer.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Customer createCustomer(ITenantAuthentication tenant, CustomerCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing customer.
     * 
     * @param tenant
     *                          Tenant authentication information. Tenant
     *                          authentication information.
     * @param customerToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Customer updateCustomer(ITenantAuthentication tenant, String customerToken, CustomerCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing customer.
     * 
     * @param tenant
     *                          Tenant authentication information. Tenant
     *                          authentication information.
     * @param customerToken
     * @return
     * @throws SiteWhereException
     */
    Customer deleteCustomer(ITenantAuthentication tenant, String customerToken) throws SiteWhereException;

    /**
     * List alerts for a customer.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param customerToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceAlertWithAsset> listAlertsForCustomer(ITenantAuthentication tenant, String customerToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List device assignments for a customer.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param customerToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<MarshaledDeviceAssignment> listDeviceAssignmentsForCustomer(ITenantAuthentication tenant,
	    String customerToken, DeviceAssignmentSearchCriteria searchCriteria,
	    DeviceAssignmentResponseFormat responseFormat) throws SiteWhereException;

    /**
     * List command invocations for a customer.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param customerToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandInvocation> listCommandInvocationsForCustomer(ITenantAuthentication tenant,
	    String customerToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Get label for customer.
     * 
     * @param tenant
     *                              Tenant authentication information. Tenant
     *                              authentication information.
     * @param customerTypeToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForCustomer(ITenantAuthentication tenant, String customerTypeToken, String generatorId)
	    throws SiteWhereException;

    /**
     * List locations for a customer.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param customerToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceLocationWithAsset> listLocationsForCustomer(ITenantAuthentication tenant, String customerToken,
	    DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List locations for a customer.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param customerToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceMeasurementWithAsset> listMeasurementsForCustomer(ITenantAuthentication tenant,
	    String customerToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List command responses for a customer.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param customerToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandResponseWithAsset> listCommandResponsesForCustomer(ITenantAuthentication tenant,
	    String customerToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List state changes for a customer.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param customerToken
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceStateChangeWithAsset> listStateChangesForCustomer(ITenantAuthentication tenant,
	    String customerToken, DateRangeSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * List all customer in tree format.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @return
     * @throws SiteWhereException
     */
    List<TreeNode> customerTree(ITenantAuthentication tenant) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Device Commands
    // ------------------------------------------------------------------------

    /**
     * List device commands matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommand> listDeviceCommands(ITenantAuthentication tenant,
	    DeviceCommandSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Get a device command by token.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    DeviceCommand getDeviceCommandByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Create a new device command.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceCommand createDeviceCommand(ITenantAuthentication tenant, DeviceCommandCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device command.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceCommand updateDeviceCommand(ITenantAuthentication tenant, String token, DeviceCommandCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing device command.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    DeviceCommand deleteDeviceCommand(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * List device commands by namespace.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceCommandNamespace> listDeviceCommandsByNamesapce(ITenantAuthentication tenant,
	    DeviceCommandSearchCriteria searchCriteria) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Device Events
    // ------------------------------------------------------------------------

    /**
     * Get a device event by alternate Id.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param alternateId
     * @return
     * @throws SiteWhereException
     */
    DeviceEventWithAsset getDeviceEventByAlternateId(ITenantAuthentication tenant, String alternateId)
	    throws SiteWhereException;

    /**
     * Get a device event by Id.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param eventId
     * @return
     * @throws SiteWhereException
     */
    DeviceEventWithAsset getDeviceEventById(ITenantAuthentication tenant, String eventId) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Device Groups
    // ------------------------------------------------------------------------

    /**
     * List device groups matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceGroup> listDeviceGroups(ITenantAuthentication tenant, DeviceGroupSearchCriteria searchCriteria)
	    throws SiteWhereException;

    /**
     * Get a device group by token.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param groupToken
     * @return
     * @throws SiteWhereException
     */
    DeviceGroup getDeviceGroupByToken(ITenantAuthentication tenant, String groupToken) throws SiteWhereException;

    /**
     * Create a new device group.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceGroup createDeviceGroup(ITenantAuthentication tenant, DeviceGroupCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device group.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param groupToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceGroup updateDeviceGroup(ITenantAuthentication tenant, String groupToken, DeviceGroupCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing device group.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param groupToken
     * @return
     * @throws SiteWhereException
     */
    DeviceGroup deleteDeviceGroup(ITenantAuthentication tenant, String groupToken) throws SiteWhereException;

    /**
     * List elements in a device group.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceGroupElement> listDeviceGroupElements(ITenantAuthentication tenant,
	    DeviceGroupElementSearchCriteria searchCriteria, DeviceGroupElementResponseFormat responseFormat)
	    throws SiteWhereException;

    /**
     * Add elements to device group.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param groupToken
     * @param requests
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceGroupElement> addElementsToDdeviceGroup(ITenantAuthentication tenant, String groupToken,
	    List<DeviceGroupElementCreateRequest> requests) throws SiteWhereException;

    /**
     * Delete elements from device group.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param groupToken
     * @param elementIds
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceGroupElement> deleteDeviceGroupElements(ITenantAuthentication tenant, String groupToken,
	    List<String> elementIds) throws SiteWhereException;

    /**
     * Delete elements from device group.
     * 
     * @param tenant
     *                       Tenant authentication information. Tenant
     *                       authentication information.
     * @param groupToken
     * @param elementId
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceGroupElement> deleteDeviceGroupElement(ITenantAuthentication tenant, String groupToken,
	    String elementId) throws SiteWhereException;

    /**
     * Get label for device group.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param groupToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForDeviceGroup(ITenantAuthentication tenant, String groupToken, String generatorId)
	    throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Device States
    // ------------------------------------------------------------------------

    /**
     * List device states matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceState> listDeviceStates(ITenantAuthentication tenant, DeviceStateSearchCriteria searchCriteria,
	    DeviceStateResponseFormat responseFormat) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Device Statuses
    // ------------------------------------------------------------------------

    /**
     * List device statuses that match criteria..
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceStatus> listDeviceStatuses(ITenantAuthentication tenant,
	    DeviceStatusSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Get a device status by token.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    DeviceStatus getDeviceStatusByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Create a new device status.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceStatus createDeviceStatus(ITenantAuthentication tenant, DeviceStatusCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device status.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceStatus updateDeviceStatus(ITenantAuthentication tenant, String token, DeviceStatusCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing device status.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    DeviceStatus deleteDeviceStatus(ITenantAuthentication tenant, String token) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Device Types
    // ------------------------------------------------------------------------

    /**
     * List device types that match criteria..
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<DeviceType> listDeviceTypes(ITenantAuthentication tenant, DeviceTypeSearchCriteria searchCriteria,
	    DeviceTypeResponseFormat responseFormat) throws SiteWhereException;

    /**
     * Get a device type by token.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    DeviceType getDeviceTypeByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Create a new device type.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceType createDeviceType(ITenantAuthentication tenant, DeviceTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing device type.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    DeviceType updateDeviceType(ITenantAuthentication tenant, String token, DeviceTypeCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing device type.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    DeviceType deleteDeviceType(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Get label for device type.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param token
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForDeviceType(ITenantAuthentication tenant, String token, String generatorId)
	    throws SiteWhereException;

    /**
     * Get device type specification GPB by unique token.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    String getDeviceTypeGPBSpecification(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Download device type specification GPB by unique token.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    File downlaodDeviceTypeGPBSpecification(ITenantAuthentication tenant, String token) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Devices
    // ------------------------------------------------------------------------

    /**
     * List devices that match criteria..
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<Device> listDevices(ITenantAuthentication tenant, DeviceSearchCriteria searchCriteria,
	    DeviceResponseFormat responseFormat) throws SiteWhereException;

    /**
     * Get a device by token.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param deviceToken
     * @return
     * @throws SiteWhereException
     */
    MarshaledDevice getDeviceByToken(ITenantAuthentication tenant, String deviceToken) throws SiteWhereException;

    /**
     * Create a new device.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    MarshaledDevice createDevice(ITenantAuthentication tenant, DeviceCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing device.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param deviceToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    MarshaledDevice updateDevice(ITenantAuthentication tenant, String deviceToken, DeviceCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing device.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param deviceToken
     * @return
     * @throws SiteWhereException
     */
    MarshaledDevice deleteDevice(ITenantAuthentication tenant, String deviceToken) throws SiteWhereException;

    /**
     * List assignment history for device.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param deviceToken
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<MarshaledDeviceAssignment> listDeviceAssignmentsForDevice(ITenantAuthentication tenant,
	    String deviceToken, DeviceAssignmentSearchCriteria searchCriteria,
	    DeviceAssignmentResponseFormat responseFormat) throws SiteWhereException;

    /**
     * Add multiple events for device.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param deviceToken
     * @param batch
     * @return
     * @throws SiteWhereException
     */
    DeviceEventBatchResponse addMultipleEventsForDevice(ITenantAuthentication tenant, String deviceToken,
	    DeviceEventBatch batch) throws SiteWhereException;

    /**
     * Get label for device.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param deviceToken
     * @param generatorId
     * @return
     * @throws SiteWhereException
     */
    byte[] getLabelForDevice(ITenantAuthentication tenant, String deviceToken, String generatorId)
	    throws SiteWhereException;

    /**
     * Create new device element mapping.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param deviceToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    MarshaledDevice createDeviceMappings(ITenantAuthentication tenant, String deviceToken, DeviceElementMapping request)
	    throws SiteWhereException;

    /**
     * Delete existing device element mapping.
     * 
     * @param tenant
     *                        Tenant authentication information. Tenant
     *                        authentication information.
     * @param deviceToken
     * @param path
     * @return
     * @throws SiteWhereException
     */
    MarshaledDevice deleteDeviceMappings(ITenantAuthentication tenant, String deviceToken, String path)
	    throws SiteWhereException;

    /**
     * List devices in device group.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param groupToken
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<Device> listDevicesByDeviceGroup(ITenantAuthentication tenant, String groupToken,
	    DeviceSearchCriteria searchCriteria, DeviceByGroupResponseFormat responseFormat) throws SiteWhereException;

    /**
     * List devices in device group with role.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param role
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<Device> listDevicesByDeviceGroupWithRole(ITenantAuthentication tenant, String role,
	    DeviceSearchCriteria searchCriteria, DeviceByGroupResponseFormat responseFormat) throws SiteWhereException;

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
     * List scheduled jobs matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<ScheduledJob> listScheduledJobs(ITenantAuthentication tenant,
	    ScheduledJobSearchCriteria searchCriteria, ScheduledJobResponseFormat responseFormat)
	    throws SiteWhereException;

    /**
     * Get a schedule job by token.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    ScheduledJob getScheduledJobByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Create a new schedule job.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    ScheduledJob createScheduledJob(ITenantAuthentication tenant, ScheduledJobCreateRequest request)
	    throws SiteWhereException;

    /**
     * Update an existing schedule job.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    ScheduledJob updateScheduledJob(ITenantAuthentication tenant, String token, ScheduledJobCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing schedule job.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    ScheduledJob deleteScheduledJob(ITenantAuthentication tenant, String token) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Schedules
    // ------------------------------------------------------------------------

    /**
     * List schedules matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information. Tenant
     *                           authentication information.
     * @param searchCriteria
     * @param responseFormat
     * @return
     * @throws SiteWhereException
     */
    SearchResults<Schedule> listSchedules(ITenantAuthentication tenant, ScheduleSearchCriteria searchCriteria,
	    ScheduleResponseFormat responseFormat) throws SiteWhereException;

    /**
     * Get a schedule by token.
     * 
     * @param tenant
     *                   Tenant authentication information. Tenant authentication
     *                   information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    Schedule getScheduleByToken(ITenantAuthentication tenant, String token) throws SiteWhereException;

    /**
     * Create a new schedule.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Schedule createSchedule(ITenantAuthentication tenant, ScheduleCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing schedule.
     * 
     * @param tenant
     *                    Tenant authentication information. Tenant authentication
     *                    information.
     * @param token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Schedule updateSchedule(ITenantAuthentication tenant, String token, ScheduleCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing schedule.
     * 
     * @param tenant
     *                   Tenant authentication information.
     * @param token
     * @return
     * @throws SiteWhereException
     */
    Schedule deleteSchedule(ITenantAuthentication tenant, String token) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // System
    // ------------------------------------------------------------------------

    /**
     * Get SiteWhere version information.
     * 
     * @return
     * @throws SiteWhereException
     */
    Version getSiteWhereVersion() throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Tenants
    // ------------------------------------------------------------------------

    /**
     * List tenants that match criteria.
     * 
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<Tenant> listTenants(TenantSearchCriteria searchCriteria) throws SiteWhereException;

    /**
     * Get a tenant by token.
     * 
     * @param tenant
     *                   Tenant authentication information.Token
     * @return
     * @throws SiteWhereException
     */
    Tenant getTenantByToken(String tenantToken) throws SiteWhereException;

    /**
     * Create a new tenant.
     * 
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Tenant createTenant(TenantCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing tenant.
     * 
     * @param tenant
     *                    Tenant authentication information.Token
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Tenant updateTenant(String tenantToken, TenantCreateRequest request) throws SiteWhereException;

    /**
     * Delete an existing tenant.
     * 
     * @param tenant
     *                   Tenant authentication information.Token
     * @return
     * @throws SiteWhereException
     */
    Tenant deleteTenant(String tenantToken) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Users
    // ------------------------------------------------------------------------

    /**
     * List users matching criteria.
     * 
     * @param tenant
     *                   Tenant authentication information.
     * @return
     * @throws SiteWhereException
     */
    SearchResults<User> listUsers() throws SiteWhereException;

    /**
     * Get a user by username.
     * 
     * @param tenant
     *                     Tenant authentication information.
     * @param username
     * @return
     * @throws SiteWhereException
     */
    User getUserByUsername(String username) throws SiteWhereException;

    /**
     * Create a new user.
     * 
     * @param tenant
     *                    Tenant authentication information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    User createUser(UserCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing user.
     * 
     * @param tenant
     *                     Tenant authentication information.
     * @param username
     * @param request
     * @return
     * @throws SiteWhereException
     */
    User updateUser(String username, UserCreateRequest request) throws SiteWhereException;

    /**
     * Delete an existing user.
     * 
     * @param tenant
     *                     Tenant authentication information.
     * @param username
     * @return
     * @throws SiteWhereException
     */
    User deleteUser(String username) throws SiteWhereException;

    /**
     * Get authorities for user.
     * 
     * @param tenant
     *                     Tenant authentication information.
     * @param username
     * @return
     * @throws SiteWhereException
     */
    SearchResults<GrantedAuthority> listUserAuthorities(String username) throws SiteWhereException;

    // ------------------------------------------------------------------------
    // Zones
    // ------------------------------------------------------------------------

    /**
     * List zones matching criteria.
     * 
     * @param tenant
     *                           Tenant authentication information.
     * @param searchCriteria
     * @return
     * @throws SiteWhereException
     */
    SearchResults<Zone> listZones(ITenantAuthentication tenant, ZoneSearchCriteria searchCriteria)
	    throws SiteWhereException;

    /**
     * Get a zone by token.
     * 
     * @param tenant
     *                      Tenant authentication information.
     * @param zoneToken
     * @return
     * @throws SiteWhereException
     */
    Zone getZoneByToken(ITenantAuthentication tenant, String zoneToken) throws SiteWhereException;

    /**
     * Create a new zone.
     * 
     * @param tenant
     *                    Tenant authentication information.
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Zone createZone(ITenantAuthentication tenant, ZoneCreateRequest request) throws SiteWhereException;

    /**
     * Update an existing zone.
     * 
     * @param tenant
     *                      Tenant authentication information.
     * @param zoneToken
     * @param request
     * @return
     * @throws SiteWhereException
     */
    Zone updateZone(ITenantAuthentication tenant, String zoneToken, ZoneCreateRequest request)
	    throws SiteWhereException;

    /**
     * Delete an existing zone.
     * 
     * @param tenant
     *                      Tenant authentication information.
     * @param zoneToken
     * @return
     * @throws SiteWhereException
     */
    Zone deleteZone(ITenantAuthentication tenant, String zoneToken) throws SiteWhereException;
}