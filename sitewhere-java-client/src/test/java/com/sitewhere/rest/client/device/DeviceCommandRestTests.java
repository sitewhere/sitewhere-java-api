/**
 * Copyright © 2014-2020 The SiteWhere Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
	DeviceCommandCreateRequest.Builder builder = new DeviceCommandCreateRequest.Builder(deviceTypeToken, token,
		namespace, name);
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
	DeviceCommandCreateRequest.Builder builder = new DeviceCommandCreateRequest.Builder(deviceTypeToken, token,
		namespace, name);
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
	SearchResults<DeviceCommandNamespace> l = getClient().listDeviceCommandsByNamesapce(getTenatAuthentication(),
		searchCriteria);
	assertNotNull(l);
    }
}
