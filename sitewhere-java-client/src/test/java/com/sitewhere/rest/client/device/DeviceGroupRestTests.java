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
