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
package com.sitewhere.test;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.activemq.transport.stomp.StompConnection;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sitewhere.rest.model.device.event.DeviceEventBatch;
import com.sitewhere.rest.model.device.event.request.DeviceMeasurementCreateRequest;

/**
 * Test methods for sending messages over the Stomp protocol.
 * 
 * @author Derek
 */
public class StompTest {

    /** Hardware id for test message */
    private static final String HARDWARE_ID = "1f344aea-5db0-4904-8331-76a15540b24b";

    /** Mapper used for marshaling event create requests */
    private static ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void doStompTest() throws Exception {
	StompConnection connection = new StompConnection();
	connection.open("localhost", 2345);
	connection.connect("system", "manager");

	String payload = createMeasurementsJson(HARDWARE_ID);

	connection.begin("tx1");
	connection.send("/queue/SITEWHERE.STOMP", payload, "tx1", null);
	connection.commit("tx1");

	connection.disconnect();
    }

    /**
     * Create a JSON request for creating a new measurements event.
     * 
     * @param hardwareId
     * @return
     * @throws Exception
     */
    protected String createMeasurementsJson(String hardwareId) throws Exception {
	DeviceEventBatch batch = new DeviceEventBatch();
	batch.setDeviceToken(hardwareId);
	DeviceMeasurementCreateRequest request = new DeviceMeasurementCreateRequest();
	request.setEventDate(new Date());
	request.setName("engine.temp");
	request.setValue(new BigDecimal("98.76"));
	batch.getMeasurements().add(request);
	return MAPPER.writeValueAsString(batch);
    }
}