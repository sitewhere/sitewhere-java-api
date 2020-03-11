
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.DeviceElementMapping;
import com.sitewhere.rest.model.device.event.DeviceEventBatch;
import com.sitewhere.rest.model.device.event.DeviceEventBatchResponse;
import com.sitewhere.rest.model.device.event.request.DeviceLocationCreateRequest;
import com.sitewhere.rest.model.device.marshaling.MarshaledDevice;
import com.sitewhere.rest.model.device.marshaling.MarshaledDeviceAssignment;
import com.sitewhere.rest.model.device.request.DeviceCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.device.DeviceAssignmentResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceAssignmentSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceByGroupResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceSearchCriteria;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.event.request.IDeviceLocationCreateRequest;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class DeviceRestTests extends AbstractWithLabelCRUDRestTest<Device, DeviceCreateRequest> {

    @Override
    protected String knownEntityToken() {
	return "46553-IPHONE6S-1898078";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceCreateRequest buildCreateRequest(String token) {
	String deviceType = "iphone6s";
	DeviceCreateRequest.Builder builder = new DeviceCreateRequest.Builder(deviceType, token);
	return builder.build();
    }

    @Override
    protected Device createEntity(DeviceCreateRequest createRequest) throws SiteWhereException {
	return getClient().createDevice(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected Device findEntityByToken(String token) throws SiteWhereException {
	return getClient().getDeviceByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	String deviceType = "iphone6s";
	DeviceCreateRequest.Builder builder = new DeviceCreateRequest.Builder(deviceType, token);
	return builder.build();
    }

    @Override
    protected Device updateEntity(String token, DeviceCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateDevice(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected Device deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteDevice(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<Device> listEntities() throws SiteWhereException {
	DeviceSearchCriteria searchCriteria = new DeviceSearchCriteria(1, 1, null, null);
	DeviceResponseFormat responseFormat = new DeviceResponseFormat();
	return getClient().listDevices(getTenatAuthentication(), searchCriteria, responseFormat);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForDevice(getTenatAuthentication(), token, generatorId);
    }

    // ------------------------------------------------------------------------
    // OTHER TESTS
    // ------------------------------------------------------------------------

    @Test
    public void testListAssignments() throws SiteWhereException {
	DeviceAssignmentSearchCriteria searchCriteria = new DeviceAssignmentSearchCriteria();
	DeviceAssignmentResponseFormat responseFormat = new DeviceAssignmentResponseFormat();
	SearchResults<MarshaledDeviceAssignment> assignments = getClient().listDeviceAssignmentsForDevice(
		getTenatAuthentication(), knownEntityToken(), searchCriteria, responseFormat);
	assertNotNull(assignments);
    }

    @Test
    public void testAddMultipleEventsForDevice() throws SiteWhereException {
	DeviceEventBatch batch = new DeviceEventBatch();
	batch.setDeviceToken("60737-MT90-4178968");
	batch.getLocations().add(deviceLocationCreateRequest());
	DeviceEventBatchResponse response = getClient().addMultipleEventsForDevice(getTenatAuthentication(),
		"60737-MT90-4178968", batch);
	assertNotNull(response);
    }

    private IDeviceLocationCreateRequest deviceLocationCreateRequest() {
	DeviceLocationCreateRequest.Builder builder = new DeviceLocationCreateRequest.Builder(22.2, 33.3);
	return builder.build();
    }

    @Test
    public void testCreateDeviceMappings() throws SiteWhereException {
	DeviceElementMapping request = new DeviceElementMapping();
	request.setDeviceToken(knownEntityToken());
	request.setDeviceElementSchemaPath("someschema");
	MarshaledDevice device = getClient().createDeviceMappings(getTenatAuthentication(), knownEntityToken(),
		request);
	assertNotNull(device);
    }

    @Test
    public void testDeleteDeviceMappings() throws SiteWhereException {
	MarshaledDevice device = getClient().deleteDeviceMappings(getTenatAuthentication(), knownEntityToken(),
		"someschema");
	assertNotNull(device);
    }

    @Test
    public void testListDevicesByDeviceGroup() throws SiteWhereException {
	String groupToken = "e137a55b-7c50-42f9-9dd7-c0c02e84b80e";
	DeviceSearchCriteria searchCriteria = new DeviceSearchCriteria(1, 1, null, null);
	DeviceByGroupResponseFormat responseFormat = new DeviceByGroupResponseFormat();
	SearchResults<Device> result = getClient().listDevicesByDeviceGroup(getTenatAuthentication(), groupToken,
		searchCriteria, responseFormat);
	assertNotNull(result);
    }

    @Test
    public void testListDevicesByDeviceGroupWithRole() throws SiteWhereException {
	String role = "master";
	DeviceSearchCriteria searchCriteria = new DeviceSearchCriteria(1, 100, null, null);
	DeviceByGroupResponseFormat responseFormat = new DeviceByGroupResponseFormat();
	SearchResults<Device> result = getClient().listDevicesByDeviceGroupWithRole(getTenatAuthentication(), role,
		searchCriteria, responseFormat);
	assertNotNull(result);
    }

    @Test
    public void testFindDeviceByToken() throws SiteWhereException {
	MarshaledDevice device = getClient().getDeviceByToken(getTenatAuthentication(), knownEntityToken());
	assertNotNull(device);
    }

    @Test
    public void testUpdateDeviceWithAssigment() throws SiteWhereException {
	String token = knownEntityToken();

	String deviceType = "iphone6s";

	DeviceCreateRequest.Builder builder = new DeviceCreateRequest.Builder(deviceType, token);
	String comments = "Some comments";
	builder.withComment(comments);
	DeviceCreateRequest request = builder.build();

	MarshaledDevice device = getClient().updateDevice(getTenatAuthentication(), knownEntityToken(), request);
	assertNotNull(device);

	assertEquals(device.getComments(), comments);
    }
}
