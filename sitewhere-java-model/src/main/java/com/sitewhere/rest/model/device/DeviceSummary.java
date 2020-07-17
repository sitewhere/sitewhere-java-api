/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device;

import java.util.List;
import java.util.UUID;

import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.device.IDeviceAssignmentSummary;
import com.sitewhere.spi.device.IDeviceSummary;

/**
 * Device summary information including device type details and device
 * assignment summaries.
 */
public class DeviceSummary extends PersistentEntity implements IDeviceSummary {

    /** Serial version UID */
    private static final long serialVersionUID = -4556277285202746345L;

    /** Device type id */
    private UUID deviceTypeId;

    /** Device type name */
    private String deviceTypeName;

    /** Device type image url */
    private String deviceTypeImageUrl;

    /** Parent device id (if nested) */
    private UUID parentDeviceId;

    /** Comments */
    private String comments;

    /** Status indicator */
    private String status;

    /** Device assignment summaries */
    private List<IDeviceAssignmentSummary> deviceAssignmentSummaries;

    @Override
    public UUID getDeviceTypeId() {
	return deviceTypeId;
    }

    public void setDeviceTypeId(UUID deviceTypeId) {
	this.deviceTypeId = deviceTypeId;
    }

    @Override
    public String getDeviceTypeName() {
	return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
	this.deviceTypeName = deviceTypeName;
    }

    @Override
    public String getDeviceTypeImageUrl() {
	return deviceTypeImageUrl;
    }

    public void setDeviceTypeImageUrl(String deviceTypeImageUrl) {
	this.deviceTypeImageUrl = deviceTypeImageUrl;
    }

    @Override
    public UUID getParentDeviceId() {
	return parentDeviceId;
    }

    public void setParentDeviceId(UUID parentDeviceId) {
	this.parentDeviceId = parentDeviceId;
    }

    @Override
    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }

    @Override
    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    @Override
    public List<IDeviceAssignmentSummary> getDeviceAssignmentSummaries() {
	return deviceAssignmentSummaries;
    }

    public void setDeviceAssignmentSummaries(List<IDeviceAssignmentSummary> deviceAssignmentSummaries) {
	this.deviceAssignmentSummaries = deviceAssignmentSummaries;
    }
}
