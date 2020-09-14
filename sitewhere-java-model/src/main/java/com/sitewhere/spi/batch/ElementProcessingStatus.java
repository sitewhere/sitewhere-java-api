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
package com.sitewhere.spi.batch;

/**
 * Indicates the processing status of a single {@link IBatchElement}.
 */
public enum ElementProcessingStatus {

    /** Indicates a batch element has not been processed */
    Unprocessed('U'),

    /** Indicates a batch element is currently being processed */
    Processing('P'),

    /** Indicates processing failed for the batch element */
    Failed('F'),

    /** Indicates processing succeeded for the batch element */
    Succeeded('S');

    /** Event code */
    private char code;

    private ElementProcessingStatus(char code) {
	this.code = code;
    }

    public static ElementProcessingStatus getByCode(char code) {
	for (ElementProcessingStatus value : ElementProcessingStatus.values()) {
	    if (value.getCode() == code) {
		return value;
	    }
	}
	return null;
    }

    public char getCode() {
	return code;
    }

    public void setCode(char code) {
	this.code = code;
    }
}