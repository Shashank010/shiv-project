package com.cg.ars.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.ars.dto.FlightSchedules;
import com.cg.ars.exception.FlightException;


public interface FlightService {

    FlightSchedules getFlightbyNo(int flightno) throws FlightException;
	
	ArrayList<FlightSchedules>getAllFlights() throws FlightException;
	
	public boolean validateAirline(String airline);
	public boolean validateDepCity(String dep_city);
	public boolean validateArrCity(String arr_city);
/*	public boolean validateDepDate(LocalDate dep_date);
	public boolean validateArrDate(LocalDate arr_date);*/
	
	public boolean validateFirstSeats(int fseats);
	
}
