package com.cg.ars.test;


import static org.junit.Assert.assertNotSame;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.ars.dao.BookingDaoImpl;
import com.cg.ars.dto.BookingInfo;
import com.cg.ars.exception.FlightException;
import com.cg.ars.service.BookingServiceImpl;


public class BookingDaoTest {

	BookingServiceImpl service;
	BookingDaoImpl dao = new BookingDaoImpl();
	
	@Before
	public void init(){
		
		dao = new BookingDaoImpl();
		service = new BookingServiceImpl();
		service.setDao(dao);
	}
	
	    
		
		@Test
		public void testAddBookingDetails() throws FlightException
		{
			BookingInfo book = new BookingInfo();
			
			book.setId(1);
			book.setEmail("shivamshrvstv@gmail.com");
			book.setNo_of_pass(2);
			book.setClass_type("A");
			book.setT_fare(4500);
			book.setSeat_no(2);
			book.setSrc_city("Mumbai");
			book.setDest_city("Hyderabad");	
			
					
			
			int id = service.addBookingDetails(book);
			assertNotSame(id,0);
		}
	

	
		
	
	@After
	public void destroy() {
		dao = null;
		service = null;
	}

}
