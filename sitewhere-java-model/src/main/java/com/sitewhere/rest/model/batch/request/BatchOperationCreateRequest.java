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
package com.sitewhere.rest.model.batch.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.batch.request.IBatchOperationCreateRequest;

/**
 * Holds information needed to create a batch operation.
 */
@JsonInclude(Include.NON_NULL)
public class BatchOperationCreateRequest extends PersistentEntityCreateRequest implements IBatchOperationCreateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = 276630436113821199L;

    /** Operation type requested */
    private String operationType;

    /** Operation parameters */
    private Map<String, String> parameters = new HashMap<String, String>();

    /** List of tokens for affected devices */
    private List<String> deviceTokens = new ArrayList<>();

    /*
     * @see
     * com.sitewhere.spi.batch.request.IBatchOperationCreateRequest#getOperationType
     * ()
     */
    @Override
    public String getOperationType() {
	return operationType;
    }

    public void setOperationType(String operationType) {
	this.operationType = operationType;
    }

    /*
     * @see
     * com.sitewhere.spi.batch.request.IBatchOperationCreateRequest#getParameters()
     */
    @Override
    public Map<String, String> getParameters() {
	return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
	this.parameters = parameters;
    }

    /*
     * @see
     * com.sitewhere.spi.batch.request.IBatchOperationCreateRequest#getDeviceTokens(
     * )
     */
    @Override
    public List<String> getDeviceTokens() {
	return deviceTokens;
    }

    public void setDeviceTokens(List<String> deviceTokens) {
	this.deviceTokens = deviceTokens;
    }
}