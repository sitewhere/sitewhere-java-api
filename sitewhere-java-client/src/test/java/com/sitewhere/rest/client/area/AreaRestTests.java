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
package com.sitewhere.rest.client.area;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.area.Area;
import com.sitewhere.rest.model.area.request.AreaCreateRequest;
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
import com.sitewhere.rest.model.search.area.AreaResponseFormat;
import com.sitewhere.rest.model.search.area.AreaSearchCriteria;
import com.sitewhere.rest.model.search.device.DeviceAssignmentResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceAssignmentSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 * Automated test for Area.
 * 
 * @author Jorge Villaverde
 *
 */
public class AreaRestTests extends AbstractWithLabelCRUDRestTest<Area, AreaCreateRequest> {

    private String areaTypeToken = "construction";

    private String parentToken = "southeast";

    private String name = "Test Area Name";

    @Override
    protected String knownEntityToken() {
	return parentToken;
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected AreaCreateRequest buildCreateRequest(String token) {
	AreaCreateRequest.Builder builder = new AreaCreateRequest.Builder(areaTypeToken, parentToken, token, name);

	builder.withDescription("Some area");

	return builder.build();
    }

    @Override
    protected Area createEntity(AreaCreateRequest createRequest) throws SiteWhereException {
	return getClient().createArea(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected Area findEntityByToken(String token) throws SiteWhereException {
	return getClient().getAreaByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected AreaCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	AreaCreateRequest.Builder builder = new AreaCreateRequest.Builder(areaTypeToken, parentToken, token, name);

	builder.withDescription("Some updated description");

	return builder.build();
    }

    @Override
    protected Area updateEntity(String token, AreaCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateArea(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected Area deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteArea(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<Area> listEntities() throws SiteWhereException {
	AreaSearchCriteria searchCriteria = new AreaSearchCriteria(0, 10);
	AreaResponseFormat responseFormat = new AreaResponseFormat();
	return getClient().listAreas(getTenatAuthentication(), searchCriteria, responseFormat);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForArea(getTenatAuthentication(), token, generatorId);
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
	SearchResults<DeviceAlertWithAsset> alerts = getClient().listAlertsForArea(getTenatAuthentication(),
		parentToken, searchCriteria);

	assertNotNull(alerts);
    }

    @Test
    public void testListAssignments() throws SiteWhereException {
	DeviceAssignmentSearchCriteria searchCriteria = new DeviceAssignmentSearchCriteria();
	DeviceAssignmentResponseFormat responseFormat = new DeviceAssignmentResponseFormat();
	responseFormat.setIncludeCustomer(true);
	SearchResults<MarshaledDeviceAssignment> assignments = getClient()
		.listDeviceAssignmentsForArea(getTenatAuthentication(), parentToken, searchCriteria, responseFormat);
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
		.listCommandInvocationsForArea(getTenatAuthentication(), parentToken, searchCriteria);

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
	SearchResults<DeviceLocationWithAsset> locations = getClient().listLocationsForArea(getTenatAuthentication(),
		parentToken, searchCriteria);

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
		.listMeasurementsForArea(getTenatAuthentication(), parentToken, searchCriteria);

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
		.listCommandResponsesForArea(getTenatAuthentication(), parentToken, searchCriteria);

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
		.listStateChangesForArea(getTenatAuthentication(), parentToken, searchCriteria);

	assertNotNull(stateChanges);
    }

    @Test
    public void testTree() throws SiteWhereException {
	List<TreeNode> tree = getClient().areaTree(getTenatAuthentication());
	assertNotNull(tree);
    }
}
