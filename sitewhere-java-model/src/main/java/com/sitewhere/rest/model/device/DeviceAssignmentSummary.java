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

    /** Id of associated device */
    private UUID deviceId;

    /** Token of associated device */
    private String deviceToken;

    /** Type id of associated device */
    private UUID deviceTypeId;

    /** Device type name */
    private String deviceTypeName;

    /** Device type image url */
    private String deviceTypeImageUrl;

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

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getDeviceId()
     */
    @Override
    public UUID getDeviceId() {
	return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
	this.deviceId = deviceId;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getDeviceToken()
     */
    @Override
    public String getDeviceToken() {
	return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
	this.deviceToken = deviceToken;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getDeviceTypeId()
     */
    @Override
    public UUID getDeviceTypeId() {
	return deviceTypeId;
    }

    public void setDeviceTypeId(UUID deviceTypeId) {
	this.deviceTypeId = deviceTypeId;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getDeviceTypeName()
     */
    @Override
    public String getDeviceTypeName() {
	return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
	this.deviceTypeName = deviceTypeName;
    }

    /*
     * @see
     * com.sitewhere.spi.device.IDeviceAssignmentSummary#getDeviceTypeImageUrl()
     */
    @Override
    public String getDeviceTypeImageUrl() {
	return deviceTypeImageUrl;
    }

    public void setDeviceTypeImageUrl(String deviceTypeImageUrl) {
	this.deviceTypeImageUrl = deviceTypeImageUrl;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getCustomerId()
     */
    @Override
    public UUID getCustomerId() {
	return customerId;
    }

    public void setCustomerId(UUID customerId) {
	this.customerId = customerId;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getCustomerName()
     */
    @Override
    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getCustomerImageUrl()
     */
    @Override
    public String getCustomerImageUrl() {
	return customerImageUrl;
    }

    public void setCustomerImageUrl(String customerImageUrl) {
	this.customerImageUrl = customerImageUrl;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getAreaId()
     */
    @Override
    public UUID getAreaId() {
	return areaId;
    }

    public void setAreaId(UUID areaId) {
	this.areaId = areaId;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getAreaName()
     */
    @Override
    public String getAreaName() {
	return areaName;
    }

    public void setAreaName(String areaName) {
	this.areaName = areaName;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getAreaImageUrl()
     */
    @Override
    public String getAreaImageUrl() {
	return areaImageUrl;
    }

    public void setAreaImageUrl(String areaImageUrl) {
	this.areaImageUrl = areaImageUrl;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getAssetId()
     */
    @Override
    public UUID getAssetId() {
	return assetId;
    }

    public void setAssetId(UUID assetId) {
	this.assetId = assetId;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getAssetName()
     */
    @Override
    public String getAssetName() {
	return assetName;
    }

    public void setAssetName(String assetName) {
	this.assetName = assetName;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getAssetImageUrl()
     */
    @Override
    public String getAssetImageUrl() {
	return assetImageUrl;
    }

    public void setAssetImageUrl(String assetImageUrl) {
	this.assetImageUrl = assetImageUrl;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getStatus()
     */
    @Override
    public DeviceAssignmentStatus getStatus() {
	return status;
    }

    public void setStatus(DeviceAssignmentStatus status) {
	this.status = status;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getActiveDate()
     */
    @Override
    public Date getActiveDate() {
	return activeDate;
    }

    public void setActiveDate(Date activeDate) {
	this.activeDate = activeDate;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceAssignmentSummary#getReleasedDate()
     */
    @Override
    public Date getReleasedDate() {
	return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
	this.releasedDate = releasedDate;
    }
}
