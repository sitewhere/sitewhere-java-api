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
package com.sitewhere.rest.model.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.SiteWhereSystemException;
import com.sitewhere.spi.common.IMetadataProvider;
import com.sitewhere.spi.error.ErrorCode;
import com.sitewhere.spi.error.ErrorLevel;

/**
 * Holds arbitrary metadata associated with an entity.
 */
public class MetadataProvider implements IMetadataProvider, Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = -7708181397230364294L;

    /** Map of metadata entries */
    private Map<String, String> metadata = new HashMap<String, String>();

    /*
     * @see com.sitewhere.spi.common.IMetadataProvider#getMetadata()
     */
    @Override
    public Map<String, String> getMetadata() {
	return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
	this.metadata = metadata;
    }

    /**
     * Copy contents of one metadata provider to another.
     * 
     * @param source
     * @param target
     */
    public static void copy(IMetadataProvider source, MetadataProvider target) throws SiteWhereException {
	if (source != null) {
	    copy(source.getMetadata(), target);
	}
    }

    /**
     * Copy values from a map into a {@link MetadataProvider}.
     * 
     * @param source
     * @param target
     * @throws SiteWhereException
     */
    public static void copy(Map<String, String> source, MetadataProvider target) throws SiteWhereException {
	if (source != null) {
	    for (String key : source.keySet()) {
		if (!key.matches("^[\\w-]+$")) {
		    throw new SiteWhereSystemException(ErrorCode.InvalidMetadataFieldName, ErrorLevel.ERROR);
		}
		target.getMetadata().put(key, source.get(key));
	    }
	}
    }
}