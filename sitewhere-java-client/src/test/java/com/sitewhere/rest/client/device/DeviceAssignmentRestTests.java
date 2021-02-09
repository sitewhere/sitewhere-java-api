/**
 * Copyright © 2014-2021 The SiteWhere Authors
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.device.asset.DeviceAlertWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceCommandResponseWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceLocationWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceMeasurementWithAsset;
import com.sitewhere.rest.model.device.asset.DeviceStateChangeWithAsset;
import com.sitewhere.rest.model.device.charting.ChartSeries;
import com.sitewhere.rest.model.device.event.DeviceCommandInvocation;
import com.sitewhere.rest.model.device.event.request.DeviceAlertCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceCommandInvocationCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceCommandResponseCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceLocationCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceMeasurementCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceStateChangeCreateRequest;
import com.sitewhere.rest.model.device.marshaling.MarshaledDeviceAssignment;
import com.sitewhere.rest.model.device.request.DeviceAssignmentBulkRequest;
import com.sitewhere.rest.model.device.request.DeviceAssignmentCreateRequest;
import com.sitewhere.rest.model.scheduling.ScheduledJob;
import com.sitewhere.rest.model.search.DateRangeSearchCriteria;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.device.DeviceAssignmentResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceAssignmentSearchCriteria;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.device.event.CommandInitiator;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class DeviceAssignmentRestTests
	extends AbstractWithLabelCRUDRestTest<MarshaledDeviceAssignment, DeviceAssignmentCreateRequest> {

    private static final String deviceToken = "15737-UNO-7576364";

    private static final String customerToken = "acme";

    private static final String areaToken = "southeast";

    private static final String assetToken = "derek.adams@sitewhere.com";

    @Override
    protected String knownEntityToken() {
	return "0afa0529-120d-447e-926f-d08bf818e820";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceAssignmentCreateRequest buildCreateRequest(String token) {
	DeviceAssignmentCreateRequest.Builder builder = new DeviceAssignmentCreateRequest.Builder(deviceToken,
		customerToken, areaToken, assetToken);
	DeviceAssignmentCreateRequest request = builder.build();
	request.setToken(token);
	return request;
    }

    @Override
    protected MarshaledDeviceAssignment createEntity(DeviceAssignmentCreateRequest createRequest)
	    throws SiteWhereException {
	return getClient().createDeviceAssignment(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected MarshaledDeviceAssignment findEntityByToken(String token) throws SiteWhereException {
	return getClient().getDeviceAssignmentByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected DeviceAssignmentCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	DeviceAssignmentCreateRequest.Builder builder = new DeviceAssignmentCreateRequest.Builder(deviceToken,
		customerToken, areaToken, assetToken);
	DeviceAssignmentCreateRequest request = builder.build();
	request.setToken(token);
	return request;
    }

    @Override
    protected MarshaledDeviceAssignment updateEntity(String token, DeviceAssignmentCreateRequest updateRequest)
	    throws SiteWhereException {
	return getClient().updateDeviceAssignment(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected MarshaledDeviceAssignment deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteDeviceAssignment(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<? extends MarshaledDeviceAssignment> listEntities() throws SiteWhereException {
	DeviceAssignmentSearchCriteria searchCriteria = new DeviceAssignmentSearchCriteria(1, 1);
	DeviceAssignmentResponseFormat format = new DeviceAssignmentResponseFormat();
	return getClient().listDeviceAssignments(getTenatAuthentication(), searchCriteria, format);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForDeviceAssignment(getTenatAuthentication(), token, generatorId);
    }

    @Test
    public void testListAlerts() throws SiteWhereException {
	Calendar cal = Calendar.getInstance();

	cal.setTime(new Date());
	cal.add(Calendar.YEAR, -1);

	Date startDate = cal.getTime();
	Date endDate = new Date();

	DateRangeSearchCriteria searchCriteria = new DateRangeSearchCriteria(1, 10, startDate, endDate);
	SearchResults<DeviceAlertWithAsset> alerts = getClient().listAlertsForDeviceAssignment(getTenatAuthentication(),
		knownEntityToken(), searchCriteria);

	assertNotNull(alerts);
    }

    @Test
    public void testCreateAlert() throws SiteWhereException {
	DeviceAlertCreateRequest.Builder builder = new DeviceAlertCreateRequest.Builder("egine.overheat",
		"Engine Overheat");

	DeviceAlertCreateRequest request = builder.error().trackState().build();

	DeviceAlertWithAsset alert = getClient().createAlertForDeviceAssignment(getTenatAuthentication(),
		knownEntityToken(), request);

	assertNotNull(alert);
    }

    @Test
    public void testReleaseAssignment() throws SiteWhereException {
	MarshaledDeviceAssignment assignment = getClient().releaseDeviceAssignment(getTenatAuthentication(),
		knownEntityToken());
	assertNotNull(assignment);
	assertEquals(DeviceAssignmentStatus.Released, assignment.getStatus());
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
		.listCommandInvocationsForDeviceAssignment(getTenatAuthentication(), knownEntityToken(), false,
			searchCriteria);

	assertNotNull(commandInvocations);
    }

    @Test
    public void testCreateCommandInvocations() throws SiteWhereException {
	String commandToken = "ping";
	String target = "Assignment";
	String initiatorId = "REST";

	DeviceCommandInvocationCreateRequest.Builder builder = new DeviceCommandInvocationCreateRequest.Builder(
		commandToken, target);
	DeviceCommandInvocationCreateRequest request = builder.build();

	request.setInitiatorId(initiatorId);
	request.setInitiator(CommandInitiator.REST);

	DeviceCommandInvocation commandInvocation = getClient()
		.createCommandInvocationForDeviceAssignment(getTenatAuthentication(), knownEntityToken(), request);

	assertNotNull(commandInvocation);
    }

    @Test
    public void testScheduleCommandInvocation() throws SiteWhereException {
	String commandToken = "ping";
	String target = "Assignment";
	String initiatorId = "REST";
	String scheduleToken = "de305d54-75b4-431b-adb2-eb6b9e546014";

	DeviceCommandInvocationCreateRequest.Builder builder = new DeviceCommandInvocationCreateRequest.Builder(
		commandToken, target);
	DeviceCommandInvocationCreateRequest request = builder.build();

	request.setInitiatorId(initiatorId);
	request.setInitiator(CommandInitiator.REST);

	ScheduledJob scheduleJob = getClient().scheduleCommandInvocation(getTenatAuthentication(), knownEntityToken(),
		scheduleToken, request);

	assertNotNull(scheduleJob);
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
		.listLocationsForDeviceAssignment(getTenatAuthentication(), knownEntityToken(), searchCriteria);

	assertNotNull(locations);
    }

    @Test
    public void testCreateLocation() throws SiteWhereException {
	DeviceLocationCreateRequest.Builder builder = new DeviceLocationCreateRequest.Builder(
		new BigDecimal("-27.3313291"), new BigDecimal("-58.961281"));
	DeviceLocationCreateRequest request = builder.build();

	DeviceLocationWithAsset location = getClient().createLocationForDeviceAssignment(getTenatAuthentication(),
		knownEntityToken(), request);

	assertNotNull(location);
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
		.listMeasurementsForDeviceAssignment(getTenatAuthentication(), knownEntityToken(), searchCriteria);

	assertNotNull(measurements);
    }

    @Test
    public void testCreateMeasurement() throws SiteWhereException {
	DeviceMeasurementCreateRequest.Builder builder = new DeviceMeasurementCreateRequest.Builder();
	builder.measurement("engine.temp", new BigDecimal("50.0"));
	DeviceMeasurementCreateRequest request = builder.build();

	DeviceMeasurementWithAsset measurement = getClient()
		.createMeasurementForDeviceAssignment(getTenatAuthentication(), knownEntityToken(), request);

	assertNotNull(measurement);
    }

    @Test
    public void testListMeasurementsSeries() throws SiteWhereException {
	Calendar cal = Calendar.getInstance();

	cal.setTime(new Date());
	cal.add(Calendar.YEAR, -1);

	Date startDate = cal.getTime();
	Date endDate = new Date();

	DateRangeSearchCriteria searchCriteria = new DateRangeSearchCriteria(1, 10, startDate, endDate);

	List<ChartSeries<Double>> series = getClient().listMeasurementsForDeviceAssignmentAsChartSeries(
		getTenatAuthentication(), knownEntityToken(), searchCriteria);

	assertNotNull(series);
    }

    @Test
    public void testMarkMissingAssignment() throws SiteWhereException {
	MarshaledDeviceAssignment assignment = getClient().markMissingDeviceAssignment(getTenatAuthentication(),
		knownEntityToken());
	assertNotNull(assignment);
	assertEquals(DeviceAssignmentStatus.Missing, assignment.getStatus());
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
		.listCommandResponsesForDeviceAssignment(getTenatAuthentication(), knownEntityToken(), searchCriteria);

	assertNotNull(commandResponses);
    }

    @Test
    public void testCreateCommandResponse() throws SiteWhereException {
	DeviceCommandResponseCreateRequest request = new DeviceCommandResponseCreateRequest();
	request.setResponse("ok");
	request.setOriginatingEventId(UUID.randomUUID());

	DeviceCommandResponseWithAsset commandResponse = getClient()
		.createCommandResponseForDeviceAssignment(getTenatAuthentication(), knownEntityToken(), request);

	assertNotNull(commandResponse);
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
		.listStateChangesForDeviceAssignment(getTenatAuthentication(), knownEntityToken(), searchCriteria);

	assertNotNull(stateChanges);
    }

    @Test
    public void testCreateStateChange() throws SiteWhereException {
	DeviceStateChangeCreateRequest request = new DeviceStateChangeCreateRequest();
	request.setNewState("PRESENT");
	request.setAttribute("Attr");
	request.setType("t1");
	request.setUpdateState(true);

	DeviceStateChangeWithAsset stateChange = getClient()
		.createStateChangeForDeviceAssignment(getTenatAuthentication(), knownEntityToken(), request);

	assertNotNull(stateChange);
    }

    @Test
    public void testBulkListAlertsForDeviceAssignments() throws SiteWhereException {
	DeviceAssignmentBulkRequest request = new DeviceAssignmentBulkRequest();

	request.setDeviceAssignmentTokens(new ArrayList<String>());
	request.getDeviceAssignmentTokens().add(knownEntityToken());

	SearchResults<DeviceAlertWithAsset> bulk = getClient()
		.bulkListAlertsForDeviceAssignments(getTenatAuthentication(), request);
	assertNotNull(bulk);
    }

    @Test
    public void testBulkListCommandInvocationsForDeviceAssignments() throws SiteWhereException {
	DeviceAssignmentBulkRequest request = new DeviceAssignmentBulkRequest();

	request.setDeviceAssignmentTokens(new ArrayList<String>());
	request.getDeviceAssignmentTokens().add(knownEntityToken());

	SearchResults<DeviceCommandInvocation> bulk = getClient()
		.bulkListCommandInvocationsForDeviceAssignments(getTenatAuthentication(), request);
	assertNotNull(bulk);
    }

    @Test
    public void testBulkListLocationsForDeviceAssignments() throws SiteWhereException {
	DeviceAssignmentBulkRequest request = new DeviceAssignmentBulkRequest();

	request.setDeviceAssignmentTokens(new ArrayList<String>());
	request.getDeviceAssignmentTokens().add(knownEntityToken());

	SearchResults<DeviceLocationWithAsset> bulk = getClient()
		.bulkListLocationsForDeviceAssignments(getTenatAuthentication(), request);
	assertNotNull(bulk);
    }

    @Test
    public void testBulkListMeasurementsForDeviceAssignments() throws SiteWhereException {
	DeviceAssignmentBulkRequest request = new DeviceAssignmentBulkRequest();

	request.setDeviceAssignmentTokens(new ArrayList<String>());
	request.getDeviceAssignmentTokens().add(knownEntityToken());

	SearchResults<DeviceMeasurementWithAsset> bulk = getClient()
		.bulkListMeasurementsForDeviceAssignments(getTenatAuthentication(), request);
	assertNotNull(bulk);
    }

    @Test
    public void testBulkListMeasurementsForDeviceAssignmentsAsChartSeries() throws SiteWhereException {
	DeviceAssignmentBulkRequest request = new DeviceAssignmentBulkRequest();

	request.setDeviceAssignmentTokens(new ArrayList<String>());
	request.getDeviceAssignmentTokens().add(knownEntityToken());

	Map<String, List<ChartSeries<Double>>> series = getClient()
		.bulkListMeasurementsForDeviceAssignmentsAsChartSeries(getTenatAuthentication(), request);

	assertNotNull(series);
    }

    @Test
    public void testBulkListCommandResponsesForDeviceAssignments() throws SiteWhereException {
	DeviceAssignmentBulkRequest request = new DeviceAssignmentBulkRequest();

	request.setDeviceAssignmentTokens(new ArrayList<String>());
	request.getDeviceAssignmentTokens().add(knownEntityToken());

	SearchResults<DeviceCommandResponseWithAsset> bulk = getClient()
		.bulkListCommandResponsesForDeviceAssignments(getTenatAuthentication(), request);
	assertNotNull(bulk);
    }

    @Test
    public void testBulkListStateChangesForDeviceAssignments() throws SiteWhereException {
	DeviceAssignmentBulkRequest request = new DeviceAssignmentBulkRequest();

	request.setDeviceAssignmentTokens(new ArrayList<String>());
	request.getDeviceAssignmentTokens().add(knownEntityToken());

	SearchResults<DeviceStateChangeWithAsset> bulk = getClient()
		.bulkListStateChangesForDeviceAssignments(getTenatAuthentication(), request);
	assertNotNull(bulk);
    }
}
