package com.cg.ars.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.ars.dao.FlightDao;
import com.cg.ars.dao.FlightDaoImpl;
import com.cg.ars.dto.FlightSchedules;
import com.cg.ars.exception.FlightException;


public class FlightServiceImpl implements FlightService{
	
	FlightDao dao;
	public void setDao(FlightDao dao){
		this.dao = dao;
	}
	
	public FlightServiceImpl()
	{
		dao = new FlightDaoImpl();
	}

	@Override
	public FlightSchedules getFlightbyNo(int flightno) throws FlightException {
		
		return dao.getFlightbyNo(flightno);
	}

	@Override
	public ArrayList<FlightSchedules> getAllFlights() throws FlightException {
		
		return dao.getAllFlights();
	}

	@Override
	public boolean validateAirline(String airline) {
		String pattern = "[A-z]{1}[a-z]{2,}";
		if(Pattern.matches(pattern,airline))
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean validateDepCity(String dep_city) {
		String pattern = "[A-z]{1}[a-z]{2,}";
		if(Pattern.matches(pattern,dep_city))
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean validateArrCity(String arr_city) {
		String pattern = "[A-z]{1}[a-z]{2,}";
		if(Pattern.matches(pattern,arr_city))
		{
			return true;
		}
		else
			return false;
	}


	@Override
	public boolean validateFirstSeats(int fseats) {
		String pattern = "[0-9]{3}";
		String fs = ""+fseats;
		if(Pattern.matches(pattern,fs))
		{
			return true;
		}
		else 
			return false;
	}

}
