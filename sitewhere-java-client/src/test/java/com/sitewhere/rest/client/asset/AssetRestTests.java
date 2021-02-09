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
package com.sitewhere.rest.client.asset;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.asset.Asset;
import com.sitewhere.rest.model.asset.request.AssetCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.asset.AssetSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class AssetRestTests extends AbstractWithLabelCRUDRestTest<Asset, AssetCreateRequest> {

    private static final String assetType = "cat320EL";

    private static final String name = "someAsset";

    @Override
    protected String knownEntityToken() {
	return "derek.adams@sitewhere.com";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected AssetCreateRequest buildCreateRequest(String token) {
	AssetCreateRequest.Builder builder = new AssetCreateRequest.Builder(token, assetType, name);
	return builder.build();
    }

    @Override
    protected Asset createEntity(AssetCreateRequest createRequest) throws SiteWhereException {
	return getClient().createAsset(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected Asset findEntityByToken(String token) throws SiteWhereException {
	return getClient().getAssetByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected AssetCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	AssetCreateRequest.Builder builder = new AssetCreateRequest.Builder(token, assetType, name);
	return builder.build();
    }

    @Override
    protected Asset updateEntity(String token, AssetCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateAsset(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected Asset deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteAsset(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<Asset> listEntities() throws SiteWhereException {
	AssetSearchCriteria searchCriteria = new AssetSearchCriteria(1, 1);
	return getClient().listAssets(getTenatAuthentication(), searchCriteria);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForAsset(getTenatAuthentication(), token, generatorId);
    }

}
