package com.geodetails.application.model;

public class DisplayMapRegionModel {
	private String southLat;

	private String northLat;

	private String eastLng;

	private String westLng;

	public String getSouthLat() {
		return southLat;
	}

	public void setSouthLat(String southLat) {
		this.southLat = southLat;
	}

	public String getNorthLat() {
		return northLat;
	}

	public void setNorthLat(String northLat) {
		this.northLat = northLat;
	}

	public String getEastLng() {
		return eastLng;
	}

	public void setEastLng(String eastLng) {
		this.eastLng = eastLng;
	}

	public String getWestLng() {
		return westLng;
	}

	public void setWestLng(String westLng) {
		this.westLng = westLng;
	}

	@Override
	public String toString() {
		return "ClassPojo [southLat = " + southLat + ", northLat = " + northLat + ", eastLng = " + eastLng
				+ ", westLng = " + westLng + "]";
	}
}
