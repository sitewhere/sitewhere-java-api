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
