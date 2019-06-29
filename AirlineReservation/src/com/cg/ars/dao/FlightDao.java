package com.cg.ars.dao;

import java.util.ArrayList;

import com.cg.ars.dto.FlightSchedules;
import com.cg.ars.exception.FlightException;

public interface FlightDao {

	 FlightSchedules getFlightbyNo(int flightno) throws FlightException;
		
		ArrayList<FlightSchedules>getAllFlights() throws FlightException;
}
