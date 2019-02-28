package com.geodetails.application.model;

public class ResultsModel {
	private String muid;

	private String[] formattedAddressLines;

	private String country;

	private DisplayMapRegionModel displayMapRegion;

	private String countryCode;

	private String timezone;

	private CenterModel center;

	private String name;

	private String geocodeAccuracy;

	public String getMuid() {
		return muid;
	}

	public void setMuid(String muid) {
		this.muid = muid;
	}

	public String[] getFormattedAddressLines() {
		return formattedAddressLines;
	}

	public void setFormattedAddressLines(String[] formattedAddressLines) {
		this.formattedAddressLines = formattedAddressLines;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public DisplayMapRegionModel getDisplayMapRegion() {
		return displayMapRegion;
	}

	public void setDisplayMapRegion(DisplayMapRegionModel displayMapRegion) {
		this.displayMapRegion = displayMapRegion;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public CenterModel getCenter() {
		return center;
	}

	public void setCenter(CenterModel center) {
		this.center = center;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGeocodeAccuracy() {
		return geocodeAccuracy;
	}

	public void setGeocodeAccuracy(String geocodeAccuracy) {
		this.geocodeAccuracy = geocodeAccuracy;
	}

	@Override
	public String toString() {
		return "ClassPojo [muid = " + muid + ", formattedAddressLines = " + formattedAddressLines + ", country = "
				+ country + ", displayMapRegion = " + displayMapRegion + ", countryCode = " + countryCode
				+ ", timezone = " + timezone + ", center = " + center + ", name = " + name + ", geocodeAccuracy = "
				+ geocodeAccuracy + "]";
	}

}
