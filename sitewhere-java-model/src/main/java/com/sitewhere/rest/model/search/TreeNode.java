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
    private List<TreeNode> children;

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
    public List<TreeNode> getChildren() {
	return children;
    }

    public void setChildren(List<TreeNode> children) {
	this.children = children;
    }
}
