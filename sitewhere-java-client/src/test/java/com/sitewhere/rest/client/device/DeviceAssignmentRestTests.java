/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.device;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.device.marshaling.MarshaledDeviceAssignment;
import com.sitewhere.rest.model.device.request.DeviceAssignmentCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.device.DeviceAssignmentSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class DeviceAssignmentRestTests extends AbstractWithLabelCRUDRestTest<MarshaledDeviceAssignment, DeviceAssignmentCreateRequest> {

    private static final String deviceToken = "15737-UNO-7576364";
    
    private static final String customerToken = "acme";
    
    private static final String areaToken = "southeast"; 
    
    private static final String assetToken = "derek.adams@sitewhere.com";

    @Override
    protected String knownEntityToken() {
	return "193aa75b-5f2e-40ed-8261-cb5f662b6f7a";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceAssignmentCreateRequest buildCreateRequest(String token) {
	DeviceAssignmentCreateRequest.Builder builder = 
		new DeviceAssignmentCreateRequest.Builder(deviceToken, customerToken, areaToken, assetToken);
	DeviceAssignmentCreateRequest request = builder.build();
	request.setToken(token);
	return request;
    }

    @Override
    protected MarshaledDeviceAssignment createEntity(DeviceAssignmentCreateRequest createRequest) throws SiteWhereException {
	return getClient().createDeviceAssignment(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected MarshaledDeviceAssignment findEntityByToken(String token) throws SiteWhereException {
	return getClient().getDeviceAssignmentByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceAssignmentCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	DeviceAssignmentCreateRequest.Builder builder = 
		new DeviceAssignmentCreateRequest.Builder(deviceToken, customerToken, areaToken, assetToken);
	DeviceAssignmentCreateRequest request = builder.build();
	request.setToken(token);
	return request;
    }

    @Override
    protected MarshaledDeviceAssignment updateEntity(String token, DeviceAssignmentCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateDeviceAssignment(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected MarshaledDeviceAssignment deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteDeviceAssignment(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<? extends MarshaledDeviceAssignment> listEntities() throws SiteWhereException {
	DeviceAssignmentSearchCriteria searchCriteria = new DeviceAssignmentSearchCriteria(1, 1);
	return getClient().listDeviceAssignments(getTenatAuthentication(), searchCriteria);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForDeviceAssignment(getTenatAuthentication(), token, generatorId);
    }

}
