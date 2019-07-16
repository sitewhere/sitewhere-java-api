
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.device;

import com.sitewhere.rest.client.AbstractCRUDRestClientTests;
import com.sitewhere.rest.model.device.DeviceStatus;
import com.sitewhere.rest.model.device.request.DeviceStatusCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.device.DeviceStatusSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class DeviceStatusRestTests extends AbstractCRUDRestClientTests<DeviceStatus, DeviceStatusCreateRequest> {

    @Override
    protected String knownEntityToken() {
	return "status01";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------
    
    @Override
    protected DeviceStatusCreateRequest buildCreateRequest(String token) {
	DeviceStatusCreateRequest request = new DeviceStatusCreateRequest();
	request.setToken(token);
	request.setName("status01");
	request.setDeviceTypeToken("iphone6s");
	request.setCode(token);
	request.setBackgroundColor("#FF00FF");
	request.setForegroundColor("#00FF00");
	request.setBorderColor("#000000");
	request.setIcon("fa-question");
	return request;
    }

    @Override
    protected DeviceStatus createEntity(DeviceStatusCreateRequest createRequest) throws SiteWhereException {
	return getClient().createDeviceStatus(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------
    
    @Override
    protected DeviceStatus findEntityByToken(String token) throws SiteWhereException {
	return getClient().getDeviceStatusByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------
    
    @Override
    protected DeviceStatusCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	DeviceStatusCreateRequest request = new DeviceStatusCreateRequest();
	request.setToken(token);
	request.setName("status01-update");
	request.setDeviceTypeToken("iphone6s");
	request.setCode(token);
	request.setBackgroundColor("#FF00FF");
	request.setForegroundColor("#00FF00");
	request.setBorderColor("#000000");
	request.setIcon("fa-question");
	return request;
    }

    @Override
    protected DeviceStatus updateEntity(String token, DeviceStatusCreateRequest updateRequest)
	    throws SiteWhereException {
	return getClient().updateDeviceStatus(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceStatus deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteDeviceStatus(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<? extends DeviceStatus> listEntities() throws SiteWhereException {
	DeviceStatusSearchCriteria searchCriteria = new DeviceStatusSearchCriteria(1, 1);
	return getClient().listDeviceStatuses(getTenatAuthentication(), searchCriteria);
    }

}
