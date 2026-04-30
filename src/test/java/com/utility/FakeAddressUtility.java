package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	public static AddressPOJO getFakeAddress() {
		Faker faker = new Faker(Locale.US);
		faker.phoneNumber();
		AddressPOJO addressPOJO = new AddressPOJO(faker.company().name(), faker.address().streetName(),
				faker.address().buildingNumber(), faker.address().city(), "2", faker.numerify("#####"),
				faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "other", "OFFICE ADDRESS");
		return addressPOJO;
	}

}
