
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.client;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.customer.Customer;
import com.sitewhere.rest.model.customer.request.CustomerCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.customer.CustomerResponseFormat;
import com.sitewhere.rest.model.search.customer.CustomerSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class CustomerRestTest extends AbstractWithLabelCRUDRestTest<Customer, CustomerCreateRequest> {

    @Override
    protected String knownEntityToken() {
	return "acme";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected CustomerCreateRequest buildCreateRequest(String token) {
	String customerTypeToken = "construction";
	String parentToken = "acme";
	String name = "Test Customer";
	CustomerCreateRequest.Builder builder = new CustomerCreateRequest.Builder(customerTypeToken, parentToken, token, name);
	builder.withDescription("Some customer description");
	return builder.build();
    }

    @Override
    protected Customer createEntity(CustomerCreateRequest createRequest) throws SiteWhereException {
	return getClient().createCustomer(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------
    
    @Override
    protected Customer findEntityByToken(String token) throws SiteWhereException {
	return getClient().getCustomerByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------
    
    @Override
    protected CustomerCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	String customerTypeToken = "construction";
	String parentToken = "acme";
	String name = "Test Customer";
	CustomerCreateRequest.Builder builder = new CustomerCreateRequest.Builder(customerTypeToken, parentToken, token, name);
	builder.withDescription("Some updated customer description");
	return builder.build();
    }

    @Override
    protected Customer updateEntity(String token, CustomerCreateRequest updateRequest)
	    throws SiteWhereException {
	return getClient().updateCustomer(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected Customer deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteCustomer(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<? extends Customer> listEntities() throws SiteWhereException {
	CustomerSearchCriteria searchCriteria = new CustomerSearchCriteria(1, 1);
	CustomerResponseFormat responseFormat = new CustomerResponseFormat();
	return getClient().listCustomers(getTenatAuthentication(), searchCriteria, responseFormat);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForCustomer(getTenatAuthentication(), token, generatorId);
    }
}
