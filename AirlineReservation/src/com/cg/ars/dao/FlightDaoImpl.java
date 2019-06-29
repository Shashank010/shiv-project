package com.cg.ars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cg.ars.dto.FlightSchedules;
import com.cg.ars.exception.FlightException;
import com.cg.ars.util.DBUtil;
import com.cg.logger.MyLogger;

public class FlightDaoImpl implements FlightDao{

	Connection con;
	Logger logger;
	
	public FlightDaoImpl()
	{
		con = DBUtil.getConnect();
		logger = MyLogger.getLogger();
	}

	
	/*public int getFlightbyNo() throws FlightException
	{
		logger.info("In getFlightbyNo");
		int flightNo = 0;
		String qry = "select f from flightinfo f where id=?"; 
		try{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next())
			{
				flightNo= rs.getInt(1);
				logger.info("Got Flight with flight no "+flightNo);
				
			}
		}
		catch(SQLException e)
		{
		
			logger.error("error "+e.getMessage());
			throw new FlightException(e.getMessage());
			
		}
		logger.info("Completed getFlightbyNo");
		return flightNo;
	}*/


	@Override
	public FlightSchedules getFlightbyNo(int flightno) throws FlightException {
		
		
		FlightSchedules flight = null;
		String qry = "select * from FLIGHTINFO where FLIGHTNO=?"; //**********
		try
		{
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, flightno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				
				int flightNo = rs.getInt(1);
				String airline = rs.getString(2);
				String dep_city = rs.getString(3);
				String arr_city = rs.getString(4);
				/*LocalDate dep_date = rs.getString(5);
				LocalDate arr_date = rs.getString(6);*/
				
				java.sql.Date date = rs.getDate(5);
				java.time.LocalDate dep_date = date.toLocalDate();
				
				java.sql.Date date1 = rs.getDate(6);
				java.time.LocalDate arr_date = date1.toLocalDate();
			
				int fseats = rs.getInt(7);
				double fseatsfare=rs.getDouble(8);
				
				flight =new FlightSchedules(flightno, airline, dep_city,
						arr_city, dep_date, arr_date, fseats, fseatsfare);
				
			}
			else
				throw new FlightException("Flight with flightNo "+flightno+" not found");
			
		}
		catch(SQLException e)
		{
			throw new FlightException(e.getMessage());
		}
		return flight;
	
	}


	@Override
	public ArrayList<FlightSchedules> getAllFlights() throws FlightException {
		
		
		ArrayList<FlightSchedules>list=new ArrayList<FlightSchedules>();
		String qry = "select * from Flightinfo"; //*************
		
		try{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while(rs.next())
			{
				
				int flightNo = rs.getInt(1);
				String airline = rs.getString(2);
				String dep_city = rs.getString(3);
				String arr_city = rs.getString(4);
				
				java.sql.Date date = rs.getDate(5);
				java.time.LocalDate dep_date = date.toLocalDate();
				
				java.sql.Date date1 = rs.getDate(6);
				java.time.LocalDate arr_date = date1.toLocalDate();
				int fseats = rs.getInt(7);
				double fseatsfare=rs.getDouble(8);
				
				FlightSchedules flight =new FlightSchedules(flightNo, airline, dep_city,
						arr_city, dep_date, arr_date, fseats, fseatsfare);
				list.add(flight);
			}
		}		
			catch(SQLException e)
			{
				throw new FlightException(e.getMessage());
			}
				
		return list;
		
	}
}
