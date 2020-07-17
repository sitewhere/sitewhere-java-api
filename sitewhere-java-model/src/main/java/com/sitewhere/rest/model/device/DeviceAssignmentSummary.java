/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device;

import java.util.Date;
import java.util.UUID;

import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.device.IDeviceAssignmentSummary;

/**
 * Summarizes device and directly related entities such as device type and
 * assignments.
 */
public class DeviceAssignmentSummary extends PersistentEntity implements IDeviceAssignmentSummary {

    /** Serial version UID */
    private static final long serialVersionUID = -6857027037347179506L;

    /** Id of assigned customer */
    private UUID customerId;

    /** Customer name */
    private String customerName;

    /** Customer image url */
    private String customerImageUrl;

    /** Id of assigned area */
    private UUID areaId;

    /** Area name */
    private String areaName;

    /** Area image url */
    private String areaImageUrl;

    /** Id of assigned asset */
    private UUID assetId;

    /** Asset name */
    private String assetName;

    /** Asset image url */
    private String assetImageUrl;

    /** Assignment status */
    private DeviceAssignmentStatus status;

    /** Assignment start date */
    private Date activeDate;

    /** Assignment end date */
    private Date releasedDate;

    @Override
    public UUID getCustomerId() {
	return customerId;
    }

    public void setCustomerId(UUID customerId) {
	this.customerId = customerId;
    }

    @Override
    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }

    @Override
    public String getCustomerImageUrl() {
	return customerImageUrl;
    }

    public void setCustomerImageUrl(String customerImageUrl) {
	this.customerImageUrl = customerImageUrl;
    }

    @Override
    public UUID getAreaId() {
	return areaId;
    }

    public void setAreaId(UUID areaId) {
	this.areaId = areaId;
    }

    @Override
    public String getAreaName() {
	return areaName;
    }

    public void setAreaName(String areaName) {
	this.areaName = areaName;
    }

    @Override
    public String getAreaImageUrl() {
	return areaImageUrl;
    }

    public void setAreaImageUrl(String areaImageUrl) {
	this.areaImageUrl = areaImageUrl;
    }

    @Override
    public UUID getAssetId() {
	return assetId;
    }

    public void setAssetId(UUID assetId) {
	this.assetId = assetId;
    }

    @Override
    public String getAssetName() {
	return assetName;
    }

    public void setAssetName(String assetName) {
	this.assetName = assetName;
    }

    @Override
    public String getAssetImageUrl() {
	return assetImageUrl;
    }

    public void setAssetImageUrl(String assetImageUrl) {
	this.assetImageUrl = assetImageUrl;
    }

    @Override
    public DeviceAssignmentStatus getStatus() {
	return status;
    }

    public void setStatus(DeviceAssignmentStatus status) {
	this.status = status;
    }

    @Override
    public Date getActiveDate() {
	return activeDate;
    }

    public void setActiveDate(Date activeDate) {
	this.activeDate = activeDate;
    }

    @Override
    public Date getReleasedDate() {
	return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
	this.releasedDate = releasedDate;
    }
}
