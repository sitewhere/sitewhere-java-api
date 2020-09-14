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
	DeviceStatusCreateRequest request = DeviceStatusCreateRequest.newBuilder().withToken(token).withName("status01")
		.withDeviceTypeToken("iphone6s").withCode(token).build();
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
	DeviceStatusCreateRequest request = DeviceStatusCreateRequest.newBuilder().withToken(token)
		.withName("status01-updated").withDeviceTypeToken("iphone6s").withCode(token).build();
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
