/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.MetadataProvider;
import com.sitewhere.spi.search.ITreeNode;

/**
 * Model object for a node in a tree which can point to an external entity.
 */
@JsonInclude(Include.NON_NULL)
public class TreeNode extends MetadataProvider implements ITreeNode {

    /** Serial version UID */
    private static final long serialVersionUID = 6713974105602371474L;

    /** Token for node entity */
    private String token;

    /** Node name */
    private String name;

    /** Node icon */
    private String icon;

    /** Node children */
    private List<ITreeNode> children;

    /*
     * @see com.sitewhere.spi.search.ITreeNode#getToken()
     */
    @Override
    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    /*
     * @see com.sitewhere.spi.search.ITreeNode#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.search.ITreeNode#getIcon()
     */
    @Override
    public String getIcon() {
	return icon;
    }

    public void setIcon(String icon) {
	this.icon = icon;
    }

    /*
     * @see com.sitewhere.spi.search.ITreeNode#getChildren()
     */
    @Override
    public List<ITreeNode> getChildren() {
	return children;
    }

    public void setChildren(List<ITreeNode> children) {
	this.children = children;
    }
}
