package com.cg.ars.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.ars.dao.FlightDaoImpl;
import com.cg.ars.dto.FlightSchedules;
import com.cg.ars.exception.FlightException;
import com.cg.ars.service.FlightServiceImpl;

public class FlightDaoTest {

	FlightServiceImpl service;
	FlightDaoImpl dao = new FlightDaoImpl();
	
	@Before
	public void init(){
		
		dao = new FlightDaoImpl();
		service = new FlightServiceImpl();
		service.setDao(dao);
	}
	
	    @Test
	    public void testGetAllFlights() throws FlightException {
		ArrayList<FlightSchedules>list = service.getAllFlights();
		assertNotNull(list);
	    }
		
		
	
	@After
	public void destroy() {
		dao = null;
		service = null;
	}

}
