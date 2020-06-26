/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search;

import java.util.List;

import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Node in a tree structure.
 */
public interface ITreeNode extends IMetadataProvider {

    /**
     * Get token for item corresponding to tree node.
     * 
     * @return
     */
    String getToken();

    /**
     * Get node name.
     * 
     * @return
     */
    String getName();

    /**
     * Get node icon.
     * 
     * @return
     */
    String getIcon();

    /**
     * Get node children.
     * 
     * @return
     */
    List<? extends ITreeNode> getChildren();
}
