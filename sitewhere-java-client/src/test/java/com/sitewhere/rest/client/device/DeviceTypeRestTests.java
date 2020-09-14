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
