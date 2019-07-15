
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.client;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.customer.Customer;
import com.sitewhere.rest.model.customer.request.CustomerCreateRequest;
import com.sitewhere.rest.model.device.asset.DeviceAlertWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceCommandResponseWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceLocationWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceMeasurementWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceStateChangeWithAsset;
import com.sitewhere.rest.model.device.event.DeviceCommandInvocation;
import com.sitewhere.rest.model.device.marshaling.MarshaledDeviceAssignment;
import com.sitewhere.rest.model.search.DateRangeSearchCriteria;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.TreeNode;
import com.sitewhere.rest.model.search.customer.CustomerResponseFormat;
import com.sitewhere.rest.model.search.customer.CustomerSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceAssignmentResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceAssignmentSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class CustomerRestTests extends AbstractWithLabelCRUDRestTest<Customer, CustomerCreateRequest> {

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

    // ------------------------------------------------------------------------
    // OTHER TESTS
    // ------------------------------------------------------------------------
    
    @Test
    public void testListAlerts() throws SiteWhereException {
	Calendar cal = Calendar.getInstance();
	
	cal.setTime(new Date());
	cal.add(Calendar.YEAR, -1);
	
	Date startDate = cal.getTime();
	Date endDate = new Date();
	
	DateRangeSearchCriteria searchCriteria = new DateRangeSearchCriteria(1, 10, startDate, endDate);
	SearchResults<DeviceAlertWithAsset> alerts = getClient()
		.listAlertsForCustomer(getTenatAuthentication(), knownEntityToken(), searchCriteria);
	
	assertNotNull(alerts);
    }

    @Test
    public void testListAssignments() throws SiteWhereException {
	DeviceAssignmentSearchCriteria searchCriteria = new DeviceAssignmentSearchCriteria();
	DeviceAssignmentResponseFormat responseFormat = new DeviceAssignmentResponseFormat();
	SearchResults<MarshaledDeviceAssignment> assignments = 
		getClient().listDeviceAssignmentsForCustomer(
			getTenatAuthentication(), knownEntityToken(), searchCriteria, responseFormat);
	assertNotNull(assignments);
    }
    
    @Test
    public void testListCommandInvocations() throws SiteWhereException {
	Calendar cal = Calendar.getInstance();
	
	cal.setTime(new Date());
	cal.add(Calendar.YEAR, -1);
	
	Date startDate = cal.getTime();
	Date endDate = new Date();
	
	DateRangeSearchCriteria searchCriteria = new DateRangeSearchCriteria(1, 10, startDate, endDate);
	SearchResults<DeviceCommandInvocation> commandInvocations = getClient()
		.listCommandInvocationsForCustomer(getTenatAuthentication(), knownEntityToken(), searchCriteria);
	
	assertNotNull(commandInvocations);
    }

    @Test
    public void testListLocations() throws SiteWhereException {
	Calendar cal = Calendar.getInstance();
	
	cal.setTime(new Date());
	cal.add(Calendar.YEAR, -1);
	
	Date startDate = cal.getTime();
	Date endDate = new Date();
	
	DateRangeSearchCriteria searchCriteria = new DateRangeSearchCriteria(1, 10, startDate, endDate);
	SearchResults<DeviceLocationWithAsset> locations = getClient()
		.listLocationsForCustomer(getTenatAuthentication(), knownEntityToken(), searchCriteria);
	
	assertNotNull(locations);
    }    

    @Test
    public void testListMeasurements() throws SiteWhereException {
	Calendar cal = Calendar.getInstance();
	
	cal.setTime(new Date());
	cal.add(Calendar.YEAR, -1);
	
	Date startDate = cal.getTime();
	Date endDate = new Date();
	
	DateRangeSearchCriteria searchCriteria = new DateRangeSearchCriteria(1, 10, startDate, endDate);
	SearchResults<DeviceMeasurementWithAsset> measurements = getClient()
		.listMeasurementsForCustomer(getTenatAuthentication(), knownEntityToken(), searchCriteria);
	
	assertNotNull(measurements);
    }    

    @Test
    public void testListCommandResponses() throws SiteWhereException {
	Calendar cal = Calendar.getInstance();
	
	cal.setTime(new Date());
	cal.add(Calendar.YEAR, -1);
	
	Date startDate = cal.getTime();
	Date endDate = new Date();
	
	DateRangeSearchCriteria searchCriteria = new DateRangeSearchCriteria(1, 10, startDate, endDate);
	SearchResults<DeviceCommandResponseWithAsset> commandResponses = getClient()
		.listCommandResponsesForCustomer(getTenatAuthentication(), knownEntityToken(), searchCriteria);
	
	assertNotNull(commandResponses);
    }    

    @Test
    public void testListStateChanges() throws SiteWhereException {
	Calendar cal = Calendar.getInstance();
	
	cal.setTime(new Date());
	cal.add(Calendar.YEAR, -1);
	
	Date startDate = cal.getTime();
	Date endDate = new Date();
	
	DateRangeSearchCriteria searchCriteria = new DateRangeSearchCriteria(1, 10, startDate, endDate);
	SearchResults<DeviceStateChangeWithAsset> stateChanges = getClient()
		.listStateChangesForCustomer(getTenatAuthentication(), knownEntityToken(), searchCriteria);
	
	assertNotNull(stateChanges);
    }    

    @Test
    public void testTree() throws SiteWhereException {
	List<TreeNode> tree = getClient().customerTree(getTenatAuthentication());
	assertNotNull(tree);
    }    
}
