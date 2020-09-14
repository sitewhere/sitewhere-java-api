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
package com.sitewhere.rest.client.asset;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.asset.AssetType;
import com.sitewhere.rest.model.asset.request.AssetTypeCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.asset.AssetTypeSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class AssetTypeRestTests extends AbstractWithLabelCRUDRestTest<AssetType, AssetTypeCreateRequest> {

    private static final String name = "someAssetType";

    @Override
    protected String knownEntityToken() {
	return "cat320EL";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected AssetTypeCreateRequest buildCreateRequest(String token) {
	AssetTypeCreateRequest.Builder builder = new AssetTypeCreateRequest.Builder(token, name);
	builder.withDescription("Some assert type description");
	return builder.build();
    }

    @Override
    protected AssetType createEntity(AssetTypeCreateRequest createRequest) throws SiteWhereException {
	return getClient().createAssetType(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected AssetType findEntityByToken(String token) throws SiteWhereException {
	return getClient().getAssetTypeByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected AssetTypeCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	AssetTypeCreateRequest.Builder builder = new AssetTypeCreateRequest.Builder(token, name);
	builder.withDescription("Some updated assert type description");
	return builder.build();
    }

    @Override
    protected AssetType updateEntity(String token, AssetTypeCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateAssetType(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected AssetType deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteAssetType(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<AssetType> listEntities() throws SiteWhereException {
	AssetTypeSearchCriteria searchCriteria = new AssetTypeSearchCriteria(1, 1);
	return getClient().listAssetTypes(getTenatAuthentication(), searchCriteria);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForAssetType(getTenatAuthentication(), token, generatorId);
    }

}
