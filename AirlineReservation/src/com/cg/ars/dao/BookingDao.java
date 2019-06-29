package com.cg.ars.dao;

import com.cg.ars.dto.BookingInfo;
import com.cg.ars.exception.FlightException;

public interface BookingDao {

	int addBookingDetails(BookingInfo book) throws FlightException;
}
