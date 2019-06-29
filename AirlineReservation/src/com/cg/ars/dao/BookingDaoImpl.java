package com.cg.ars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.apache.log4j.Logger;

import com.cg.ars.dto.BookingInfo;
import com.cg.ars.exception.FlightException;
import com.cg.ars.util.DBUtil;
import com.cg.logger.MyLogger;


public class BookingDaoImpl implements BookingDao{

	Connection con;
	Logger logger;
	
	public BookingDaoImpl()
	{
		con = DBUtil.getConnect();
		logger = MyLogger.getLogger();
	}
	
	public int getId() throws FlightException
	{
		logger.info("In getId");
		int id = 0;
		String qry = "select bookid_seq.currval from dual"; 
		try{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next())
			{
				id= rs.getInt(1);
				logger.info("Got Booking with id "+id);
				
			}
		}
		catch(SQLException e)
		{
		
			logger.error("error "+e.getMessage());
			throw new FlightException(e.getMessage());
			
		}
		logger.info("Completed getId");
		return id;
	}

	@Override
	public int addBookingDetails(BookingInfo book) throws FlightException {
		
		logger.info("in add booking details");
		logger.info("booking details:: "+book);
		int id=0;
		String qry = "insert into BOOKINGINFO values(bookid_seq.nextval,?,?,?,?,?,?,?)"; 
		
		String email = book.getEmail();
		int passno = book.getNo_of_pass();
		String ctype = book.getClass_type();
		int total = book.getT_fare();
		int sno = book.getSeat_no();
		String scity = book.getSrc_city();
		String dcity = book.getDest_city();
		/*LocalDate bDate = stu.getbDate();
		
		java.sql.Date date = java.sql.Date.valueOf(bDate);*/
		
		try{
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setString(1, email);
			pstmt.setInt(2, passno);
			pstmt.setString(3, ctype);
			pstmt.setInt(4, total);
			pstmt.setInt(5, sno);
			pstmt.setString(6, scity);
			pstmt.setString(7, dcity);
			/*pstmt.setDate(3,date);*/
			
			int row = pstmt.executeUpdate();
			if(row>0)
			{
				id = getId();
				logger.info("booked successfully and booking id is ::"+id);
				
			}
			else
				throw new FlightException("unable to insert"+book);
			
		}
		catch(SQLException e)
		{
			logger.error("error in insert = "+e.getMessage());
			throw new FlightException(e.getMessage());
		}
		return id;
	}
}
