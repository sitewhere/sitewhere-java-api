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
package com.sitewhere.spi.device.command;

/**
 * Indicates parameter datatype. These are the same datatypes used in
 * <a href="https://developers.google.com/protocol-buffers/docs/proto">Google
 * Protocol Buffers</a>.
 */
public enum ParameterType {

    Double,

    Float,

    Int32,

    Int64,

    UInt32,

    UInt64,

    SInt32,

    SInt64,

    Fixed32,

    Fixed64,

    SFixed32,

    SFixed64,

    Bool,

    String,

    Bytes;
}