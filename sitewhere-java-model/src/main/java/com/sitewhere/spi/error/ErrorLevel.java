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
package com.sitewhere.spi.error;

/**
 * Indicates severity of an error.
 */
public enum ErrorLevel {

    INFO('I'), WARNING('W'), ERROR('E'), CRITICAL('C');

    /** Type indicator */
    private char type;

    private ErrorLevel(char type) {
	this.type = type;
    }

    /**
     * Get the area type.
     * 
     * @return
     */
    public char getType() {
	return type;
    }

    /**
     * Get ErrorLevel from type indicator.
     * 
     * @param type
     * @return
     */
    public static ErrorLevel fromType(char type) {
	for (ErrorLevel level : ErrorLevel.values()) {
	    if (level.getType() == type) {
		return level;
	    }
	}
	throw new RuntimeException("Unknown ErrorLevel type: " + type);
    }
}