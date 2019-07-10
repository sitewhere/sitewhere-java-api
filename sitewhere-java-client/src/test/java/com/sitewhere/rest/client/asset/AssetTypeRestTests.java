/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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
