/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.marshaling;

import com.sitewhere.rest.model.asset.marshaling.MarshaledAsset;
import com.sitewhere.rest.model.device.DeviceAssignment;

/**
 * Extends {@link DeviceAssignment} to support fields that can be included on
 * REST calls.
 */
public class MarshaledDeviceAssignment extends DeviceAssignment {

    /** Serial version UID */
    private static final long serialVersionUID = -6149550465354186892L;

    /** Device being assigned */
    private MarshaledDevice device;

    /** Assigned customer */
    private MarshaledCustomer customer;

    /** Assigned area */
    private MarshaledArea area;

    /** Associated asset */
    private MarshaledAsset asset;

    /** Customer name */
    private String customerName;

    /** Customer image url */
    private String customerImageUrl;

    /** Area name */
    private String areaName;

    /** Area image url */
    private String areaImageUrl;

    /** Associated asset name */
    private String assetName;

    /** Associated asset image */
    private String assetImageUrl;

    public MarshaledDevice getDevice() {
	return device;
    }

    public void setDevice(MarshaledDevice device) {
	this.device = device;
    }

    public MarshaledCustomer getCustomer() {
	return customer;
    }

    public void setCustomer(MarshaledCustomer customer) {
	this.customer = customer;
    }

    public MarshaledArea getArea() {
	return area;
    }

    public void setArea(MarshaledArea area) {
	this.area = area;
    }

    public MarshaledAsset getAsset() {
	return asset;
    }

    public void setAsset(MarshaledAsset asset) {
	this.asset = asset;
    }

    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }

    public String getCustomerImageUrl() {
	return customerImageUrl;
    }

    public void setCustomerImageUrl(String customerImageUrl) {
	this.customerImageUrl = customerImageUrl;
    }

    public String getAreaName() {
	return areaName;
    }

    public void setAreaName(String areaName) {
	this.areaName = areaName;
    }

    public String getAreaImageUrl() {
	return areaImageUrl;
    }

    public void setAreaImageUrl(String areaImageUrl) {
	this.areaImageUrl = areaImageUrl;
    }

    public String getAssetName() {
	return assetName;
    }

    public void setAssetName(String assetName) {
	this.assetName = assetName;
    }

    public String getAssetImageUrl() {
	return assetImageUrl;
    }

    public void setAssetImageUrl(String assetImageUrl) {
	this.assetImageUrl = assetImageUrl;
    }
}