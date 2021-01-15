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
package com.sitewhere.rest.model.device.event;

import java.util.Map;
import java.util.UUID;

import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.device.event.IDeviceEventContext;

/**
 * Model object for device event context information. This information augments
 * the existing event information to provide extra context for processing
 * operations.
 */
public class DeviceEventContext implements IDeviceEventContext {

    /** Event originator */
    private String originator;

    /** Event source id */
    private String sourceId;

    /** Device token */
    private String deviceToken;

    /** Device id */
    private UUID deviceId;

    /** Device type id */
    private UUID deviceTypeId;

    /** Parent device id */
    private UUID parentDeviceId;

    /** Device status */
    private String deviceStatus;

    /** Device metadata */
    private Map<String, String> deviceMetadata;

    /** Device assignment id */
    private UUID deviceAssignmentId;

    /** Customer id */
    private UUID customerId;

    /** Area id */
    private UUID areaId;

    /** Asset id */
    private UUID assetId;

    /** Device assignment status */
    private DeviceAssignmentStatus deviceAssignmentStatus;

    /** Device assignment metadata */
    private Map<String, String> deviceAssignmentMetadata;

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getOriginator()
     */
    @Override
    public String getOriginator() {
	return originator;
    }

    public void setOriginator(String originator) {
	this.originator = originator;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getSourceId()
     */
    @Override
    public String getSourceId() {
	return sourceId;
    }

    public void setSourceId(String sourceId) {
	this.sourceId = sourceId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getDeviceToken()
     */
    @Override
    public String getDeviceToken() {
	return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
	this.deviceToken = deviceToken;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getDeviceId()
     */
    @Override
    public UUID getDeviceId() {
	return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
	this.deviceId = deviceId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getDeviceTypeId()
     */
    @Override
    public UUID getDeviceTypeId() {
	return deviceTypeId;
    }

    public void setDeviceTypeId(UUID deviceTypeId) {
	this.deviceTypeId = deviceTypeId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getParentDeviceId()
     */
    @Override
    public UUID getParentDeviceId() {
	return parentDeviceId;
    }

    public void setParentDeviceId(UUID parentDeviceId) {
	this.parentDeviceId = parentDeviceId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getDeviceStatus()
     */
    @Override
    public String getDeviceStatus() {
	return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
	this.deviceStatus = deviceStatus;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getDeviceMetadata()
     */
    @Override
    public Map<String, String> getDeviceMetadata() {
	return deviceMetadata;
    }

    public void setDeviceMetadata(Map<String, String> deviceMetadata) {
	this.deviceMetadata = deviceMetadata;
    }

    /*
     * @see
     * com.sitewhere.spi.device.event.IDeviceEventContext#getDeviceAssignmentId()
     */
    @Override
    public UUID getDeviceAssignmentId() {
	return deviceAssignmentId;
    }

    public void setDeviceAssignmentId(UUID deviceAssignmentId) {
	this.deviceAssignmentId = deviceAssignmentId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getCustomerId()
     */
    @Override
    public UUID getCustomerId() {
	return customerId;
    }

    public void setCustomerId(UUID customerId) {
	this.customerId = customerId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getAreaId()
     */
    @Override
    public UUID getAreaId() {
	return areaId;
    }

    public void setAreaId(UUID areaId) {
	this.areaId = areaId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#getAssetId()
     */
    @Override
    public UUID getAssetId() {
	return assetId;
    }

    public void setAssetId(UUID assetId) {
	this.assetId = assetId;
    }

    /*
     * @see
     * com.sitewhere.spi.device.event.IDeviceEventContext#getDeviceAssignmentStatus(
     * )
     */
    @Override
    public DeviceAssignmentStatus getDeviceAssignmentStatus() {
	return deviceAssignmentStatus;
    }

    public void setDeviceAssignmentStatus(DeviceAssignmentStatus deviceAssignmentStatus) {
	this.deviceAssignmentStatus = deviceAssignmentStatus;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventContext#
     * getDeviceAssignmentMetadata()
     */
    @Override
    public Map<String, String> getDeviceAssignmentMetadata() {
	return deviceAssignmentMetadata;
    }

    public void setDeviceAssignmentMetadata(Map<String, String> deviceAssignmentMetadata) {
	this.deviceAssignmentMetadata = deviceAssignmentMetadata;
    }
}