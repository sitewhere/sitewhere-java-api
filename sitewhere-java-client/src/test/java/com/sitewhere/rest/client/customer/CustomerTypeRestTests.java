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
package com.sitewhere.rest.client.customer;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.customer.CustomerType;
import com.sitewhere.rest.model.customer.request.CustomerTypeCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.customer.CustomerTypeResponseFormat;
import com.sitewhere.rest.model.search.customer.CustomerTypeSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 */
public class CustomerTypeRestTests extends AbstractWithLabelCRUDRestTest<CustomerType, CustomerTypeCreateRequest> {

    @Override
    protected String knownEntityToken() {
	return "construction";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected CustomerTypeCreateRequest buildCreateRequest(String token) {
	CustomerTypeCreateRequest.Builder builder = new CustomerTypeCreateRequest.Builder(token, "test customer type");
	builder.withDescription("Some customer type description");
	return builder.build();
    }

    @Override
    protected CustomerType createEntity(CustomerTypeCreateRequest createRequest) throws SiteWhereException {
	return getClient().createCustomerType(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected CustomerType findEntityByToken(String token) throws SiteWhereException {
	return getClient().getCustomerTypeByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected CustomerTypeCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	CustomerTypeCreateRequest.Builder builder = new CustomerTypeCreateRequest.Builder(token, "test customer type");
	builder.withDescription("Some updated customer type description");
	return builder.build();
    }

    @Override
    protected CustomerType updateEntity(String token, CustomerTypeCreateRequest updateRequest)
	    throws SiteWhereException {
	return getClient().updateCustomerType(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected CustomerType deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteCustomerType(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<? extends CustomerType> listEntities() throws SiteWhereException {
	CustomerTypeSearchCriteria searchCriteria = new CustomerTypeSearchCriteria();
	CustomerTypeResponseFormat responseFormat = new CustomerTypeResponseFormat();
	return getClient().listCustomerTypes(getTenatAuthentication(), searchCriteria, responseFormat);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForCustomerType(getTenatAuthentication(), token, generatorId);
    }

}
