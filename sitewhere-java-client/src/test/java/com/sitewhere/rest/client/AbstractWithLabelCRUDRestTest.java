
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public abstract class AbstractWithLabelCRUDRestTest<T extends PersistentEntity, CR extends PersistentEntityCreateRequest> 
	extends AbstractCRUDRestClientTests<T, CR> {
    
    protected static final String QR_GENERATIO_ID = "qrcode";
    
    @Test
    public void testLabel() throws SiteWhereException {
	byte[] label = getLabelForEntity(knownEntityToken(), QR_GENERATIO_ID);
	assertNotNull(label);
    }

    protected abstract byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException;

}
