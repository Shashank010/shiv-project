package com.cg.ars.service;

import com.cg.ars.dto.BookingInfo;
import com.cg.ars.exception.FlightException;



public interface BookingService {
	
	int addBookingDetails(BookingInfo book) throws FlightException;
	
	boolean validateEmail(String email);
	boolean validateNumberPass(int no_of_pass);
	boolean validateScity(String src_city);
	boolean validateDcity(String dest_city);
	boolean validateClass(String class_type);
	boolean validateFare(int t_fare);
	boolean validateSeat(int seat_no);
	
	
	
	

}
