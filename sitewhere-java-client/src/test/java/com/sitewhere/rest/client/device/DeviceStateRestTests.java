
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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
	
	SearchResults<DeviceState> list = getClient().listDeviceStates(getTenatAuthentication(), searchCriteria, responseFormat);
	assertNotNull(list);
    }
}
