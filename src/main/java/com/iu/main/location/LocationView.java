package com.iu.main.location;

import java.util.ArrayList;


public class LocationView {
	public void view(String str) {
		System.out.println(str);
	}
	public void view(LocationDTO locationdto) {
		System.out.println(locationdto.getLocation_id());
		System.out.println(locationdto.getStreet_address());
		System.out.println(locationdto.getPostal_code());
		System.out.println(locationdto.getCity());
		System.out.println(locationdto.getState_province());
		System.out.println(locationdto.getCountry_id());
		
	}
	public void view(ArrayList<LocationDTO> ar) {//모두출력
		for(LocationDTO lo:ar) {
			this.view(lo);
		}

	}
}
