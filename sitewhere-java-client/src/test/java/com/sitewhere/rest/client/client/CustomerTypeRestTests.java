/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.client;

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
