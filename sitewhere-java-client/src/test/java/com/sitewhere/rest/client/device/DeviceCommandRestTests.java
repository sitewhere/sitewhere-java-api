
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.device;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractCRUDRestClientTests;
import com.sitewhere.rest.model.device.command.DeviceCommand;
import com.sitewhere.rest.model.device.command.DeviceCommandNamespace;
import com.sitewhere.rest.model.device.request.DeviceCommandCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.device.DeviceCommandSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class DeviceCommandRestTests extends AbstractCRUDRestClientTests<DeviceCommand, DeviceCommandCreateRequest> {

    @Override
    protected String knownEntityToken() {
	// TODO Auto-generated method stub
	return null;
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------
    
    @Override
    protected DeviceCommandCreateRequest buildCreateRequest(String token) {
	String deviceTypeToken = "iphone6s";
	String namespace = "default";
	String name = "test command";
	DeviceCommandCreateRequest.Builder builder = new DeviceCommandCreateRequest.Builder(deviceTypeToken, token, namespace, name);
	builder.withDescription("Some description");
	return builder.build();
    }

    @Override
    protected DeviceCommand createEntity(DeviceCommandCreateRequest createRequest) throws SiteWhereException {
	return getClient().createDeviceCommand(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------
    
    @Override
    protected DeviceCommand findEntityByToken(String token) throws SiteWhereException {
	return getClient().getDeviceCommandByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------
    
    @Override
    protected DeviceCommandCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	String deviceTypeToken = "iphone6s";
	String namespace = "default";
	String name = "test command";
	DeviceCommandCreateRequest.Builder builder = new DeviceCommandCreateRequest.Builder(deviceTypeToken, token, namespace, name);
	builder.withDescription("Some updated description");
	return builder.build();
    }

    @Override
    protected DeviceCommand updateEntity(String token, DeviceCommandCreateRequest updateRequest)
	    throws SiteWhereException {
	return getClient().updateDeviceCommand(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceCommand deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteDeviceCommand(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------
    
   @Override
    protected SearchResults<? extends DeviceCommand> listEntities() throws SiteWhereException {
	DeviceCommandSearchCriteria searchCriteria = new DeviceCommandSearchCriteria(1, 1);
	return getClient().listDeviceCommands(getTenatAuthentication(), searchCriteria);
    }

   // ------------------------------------------------------------------------
   // OTHER TESTS
   // ------------------------------------------------------------------------

   @Test
   public void testListByNamespace() throws SiteWhereException {
	DeviceCommandSearchCriteria searchCriteria = new DeviceCommandSearchCriteria(1, 1);
	searchCriteria.setDeviceTypeToken("iphone6s");
	SearchResults<DeviceCommandNamespace> l = getClient().listDeviceCommandsByNamesapce(getTenatAuthentication(), searchCriteria);
	assertNotNull(l);
   }
}
