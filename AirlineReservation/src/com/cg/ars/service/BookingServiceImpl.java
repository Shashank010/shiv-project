package com.cg.ars.service;

import java.util.regex.Pattern;

import com.cg.ars.dao.BookingDao;
import com.cg.ars.dao.BookingDaoImpl;
import com.cg.ars.dao.FlightDao;
import com.cg.ars.dao.FlightDaoImpl;
import com.cg.ars.dto.BookingInfo;
import com.cg.ars.exception.FlightException;

public class BookingServiceImpl implements BookingService {

	BookingDao dao;

	public void setDao(BookingDao dao) {
		this.dao = dao;
	}

	public BookingServiceImpl() {
		dao = new BookingDaoImpl();
	}

	@Override
	public int addBookingDetails(BookingInfo book) throws FlightException {

		return dao.addBookingDetails(book);
	}

	@Override
	public boolean validateEmail(String email) {
		String pattern = "^(.+)@(.+)$";
		if(Pattern.matches(pattern,email))
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean validateNumberPass(int no_of_pass) {
		String pattern = "[0-9]{1,2}";
		String fs = ""+no_of_pass;
		if(Pattern.matches(pattern,fs))
		{
			return true;
		}
		else 
			return false;
	}

	@Override
	public boolean validateScity(String src_city) {
		String pattern = "[A-Z]{1}[a-z]{3,}";
		if(Pattern.matches(pattern,src_city))
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean validateDcity(String dest_city) {
		String pattern = "[A-Z]{1}[a-z]{3,}";
		if(Pattern.matches(pattern,dest_city))
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean validateClass(String class_type) {
		String pattern = "[A-Z]{1}[a-z]{1,}";
		if(Pattern.matches(pattern,class_type))
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean validateFare(int t_fare) {
		String pattern = "[0-9]{3,}";
		String fs = ""+t_fare;
		if(Pattern.matches(pattern,fs))
		{
			return true;
		}
		else 
			return false;
	   
	}

	@Override
	public boolean validateSeat(int seat_no) {
		String pattern = "[0-9]{1,}";
		String fs = ""+seat_no;
		if(Pattern.matches(pattern,fs))
		{
			return true;
		}
		else 
			return false;
	}
}
