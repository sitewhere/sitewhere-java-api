
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.device;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.device.group.DeviceGroup;
import com.sitewhere.rest.model.device.request.DeviceGroupCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.device.DeviceGroupSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class DeviceGroupRestTests extends AbstractWithLabelCRUDRestTest<DeviceGroup, DeviceGroupCreateRequest> {

    @Override
    protected String knownEntityToken() {
	return "e137a55b-7c50-42f9-9dd7-c0c02e84b80e";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceGroupCreateRequest buildCreateRequest(String token) {
	String name = "test group";
	DeviceGroupCreateRequest.Builder builder = new DeviceGroupCreateRequest.Builder(token, name);
	builder.withRole("primary");
	builder.withDescription("Some description");
	return builder.build();
    }

    @Override
    protected DeviceGroup createEntity(DeviceGroupCreateRequest createRequest) throws SiteWhereException {
	return getClient().createDeviceGroup(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected DeviceGroup findEntityByToken(String token) throws SiteWhereException {
	return getClient().getDeviceGroupByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceGroupCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	String name = "test group";
	DeviceGroupCreateRequest.Builder builder = new DeviceGroupCreateRequest.Builder(token, name);
	builder.withRole("primary");
	builder.withDescription("Some updated description");
	return builder.build();
    }

    @Override
    protected DeviceGroup updateEntity(String token, DeviceGroupCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateDeviceGroup(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceGroup deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteDeviceGroup(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<DeviceGroup> listEntities() throws SiteWhereException {
	DeviceGroupSearchCriteria searchCriteria = new DeviceGroupSearchCriteria(1, 1);
	return getClient().listDeviceGroups(getTenatAuthentication(), searchCriteria);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForDeviceGroup(getTenatAuthentication(), token, generatorId);
    }

}
