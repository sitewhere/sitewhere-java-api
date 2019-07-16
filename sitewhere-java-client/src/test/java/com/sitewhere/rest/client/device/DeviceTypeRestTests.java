
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.device;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.device.DeviceType;
import com.sitewhere.rest.model.device.request.DeviceTypeCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.device.DeviceTypeResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceTypeSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class DeviceTypeRestTests extends AbstractWithLabelCRUDRestTest<DeviceType, DeviceTypeCreateRequest> {

    @Override
    protected String knownEntityToken() {
	return "iphone6s";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceTypeCreateRequest buildCreateRequest(String token) {
	String name = "test type";
	DeviceTypeCreateRequest.Builder builder = new DeviceTypeCreateRequest.Builder(token, name);
	builder.withDescription("Some description");
	return builder.build();
    }

    @Override
    protected DeviceType createEntity(DeviceTypeCreateRequest createRequest) throws SiteWhereException {
	return getClient().createDeviceType(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected DeviceType findEntityByToken(String token) throws SiteWhereException {
	return getClient().getDeviceTypeByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceTypeCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	String name = "test group";
	DeviceTypeCreateRequest.Builder builder = new DeviceTypeCreateRequest.Builder(token, name);
	builder.withDescription("Some updated description");
	return builder.build();
    }

    @Override
    protected DeviceType updateEntity(String token, DeviceTypeCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateDeviceType(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceType deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteDeviceType(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<DeviceType> listEntities() throws SiteWhereException {
	DeviceTypeSearchCriteria searchCriteria = new DeviceTypeSearchCriteria(1, 1);
	DeviceTypeResponseFormat responseFormat = new DeviceTypeResponseFormat();
	return getClient().listDeviceTypes(getTenatAuthentication(), searchCriteria, responseFormat);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForDeviceType(getTenatAuthentication(), token, generatorId);
    }

    // ------------------------------------------------------------------------
    // OTHER TESTS
    // ------------------------------------------------------------------------
    
    @Test
    public void testGetDeviceTypeGPBSpecification() throws SiteWhereException {
	String spec = getClient().getDeviceTypeGPBSpecification(getTenatAuthentication(), knownEntityToken());
	assertNotNull(spec);
    }

    @Test
    public void testDownloadDeviceTypeGPBSpecification() throws SiteWhereException {
	File file = getClient().downlaodDeviceTypeGPBSpecification(getTenatAuthentication(), knownEntityToken());
	assertNotNull(file);
    }
}
