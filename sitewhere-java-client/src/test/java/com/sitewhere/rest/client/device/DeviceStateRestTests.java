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

import org.junit.Test;

import com.sitewhere.rest.client.AbstractRestTest;
import com.sitewhere.rest.model.device.state.DeviceState;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.device.DeviceStateResponseFormat;
import com.sitewhere.rest.model.search.device.DeviceStateSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class DeviceStateRestTests extends AbstractRestTest {

    @Test
    public void testList() throws SiteWhereException {
	DeviceStateSearchCriteria searchCriteria = new DeviceStateSearchCriteria(1, 1);
	DeviceStateResponseFormat responseFormat = new DeviceStateResponseFormat();

	SearchResults<DeviceState> list = getClient().listDeviceStates(getTenatAuthentication(), searchCriteria,
		responseFormat);
	assertNotNull(list);
    }
}
