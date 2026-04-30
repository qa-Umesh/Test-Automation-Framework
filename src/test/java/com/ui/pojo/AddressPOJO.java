package com.ui.pojo;

public class AddressPOJO {
	private String company;
	private String addressLine1;
	private String address2Line;
	private String city;
	private String state;
	private String postCode;
	private String homePhone;
	private String mobileNo;
	private String otherInformation;
	private String addressAlias;

	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", address2Line=" + address2Line
				+ ", city=" + city + ", postCode=" + postCode + ", homePhone=" + homePhone + ", mobileNo=" + mobileNo
				+ ", otherInformation=" + otherInformation + ", addressAlias=" + addressAlias + ", state=" + state
				+ "]";
	}

	public AddressPOJO(String company, String addressLine1, String address2Line, String city, String state,
			String postCode, String homePhone, String mobileNo, String otherInformation, String addressAlias) {
		this.company = company;
		this.addressLine1 = addressLine1;
		this.address2Line = address2Line;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.homePhone = homePhone;
		this.mobileNo = mobileNo;
		this.otherInformation = otherInformation;
		this.addressAlias = addressAlias;

	}

	public String getCompany() {
		return company;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddress2Line() {
		return address2Line;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

}
