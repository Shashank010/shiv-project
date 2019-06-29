package com.cg.ars.pl;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.ars.dto.BookingInfo;
import com.cg.ars.dto.FlightSchedules;
import com.cg.ars.exception.FlightException;
import com.cg.ars.service.BookingService;
import com.cg.ars.service.BookingServiceImpl;
import com.cg.ars.service.FlightService;
import com.cg.ars.service.FlightServiceImpl;


public class MainClass {

	static FlightService service = new FlightServiceImpl();
	
	
	static BookingService service1 = new BookingServiceImpl();
	
	public static void main(String[] args) {
		
		int choice=0;
		try(Scanner sc = new Scanner(System.in))
		{
			do
			{
				System.out.println("1-Get flight details");
				System.out.println("2-Search flight by Id");
				System.out.println("3-Book your flight");
				System.out.println("0-Exit");
				System.out.println("Enter your choice::");
				choice = sc.nextInt();
				switch(choice)
				{
				    case 1 : 
				    	try
				    	{
				    	  ArrayList<FlightSchedules>list = service.getAllFlights();
						for(FlightSchedules obj : list)
						{
							System.out.println(obj);
						}
						}
						catch(FlightException e)
						{
							System.out.println(e.getMessage());
						}
						break;
					
					case 2 : System.out.println("Enter id to search flight::");
					int flightno = sc.nextInt();
					try
					{
						FlightSchedules ref = service.getFlightbyNo(flightno);
						System.out.println(ref);
					}
					catch(FlightException e)
					{
						System.out.println(e.getMessage());
					}
					break;
					
					case 3 : 
						BookingInfo book = acceptBookingDetails(); 
						if(book!=null)
					{	
						try
						{
							int id = service1.addBookingDetails(book);
							System.out.println("seat booked and booking id = "+id);
						}
						catch(FlightException e)
						{
							System.out.println(e.getMessage());
						}
					}
						break;
					
					case 0 :
						continue;
				}//switch
				System.out.println("do you want to continue 1-yes   0-No");
				choice = sc.nextInt();
			}while(choice!=0);
		}
		
	}//try
		

	
	public static BookingInfo acceptBookingDetails()
	{
		BookingInfo book = null;
		Scanner sc = new Scanner(System.in);
		while(true)
		{//
			System.out.println("Enter email::");
			String email = sc.next();
			if(!service1.validateEmail(email))
			{
				continue;
			}
			else
			{//
				while(true)
				{//
					System.out.println("no of passengers::");
					int no_of_pass = sc.nextInt();
					if(!service1.validateNumberPass(no_of_pass))
					{
						continue;
					}
					else
					{//
						while(true)
						{//
							System.out.println("Enter class type::");
							String class_type = sc.next();
							if(!service1.validateClass(class_type))
							{
								continue;
							}
							else
							{//
								while(true)
								{//
									System.out.println("Enter calculated total fare::");
									int t_fare = sc.nextInt();
									if(!service1.validateFare(t_fare))
									{
										continue;
									}
									else
									{//
										while(true)
										{//
											System.out.println("Enter seat number::");
											int seat_no = sc.nextInt();
											if(!service1.validateSeat(seat_no))
											{
												continue;
											}
											else
											{//
												while(true)
												{//
													System.out.println("Enter source city ::");
													String src_city = sc.next();
													if(!service1.validateScity(src_city))
													{
														continue;
													}
													else
													{//
														while(true)
														{//
															System.out.println("Enter destination city ::");
															String dest_city = sc.next();
															if(!service1.validateDcity(dest_city))
															{
																continue;
															}
															else
															{//
																if(dest_city!=null)
																{//
																	book = new BookingInfo();
																	book.setEmail(email);
																	book.setNo_of_pass(no_of_pass);
																	book.setClass_type(class_type);
																	book.setT_fare(t_fare);
																	book.setSeat_no(seat_no);
																	book.setSrc_city(src_city);
																	book.setDest_city(dest_city);
																	return book;
																}//
																break;	
															}//
														}//
													}//
												}//
											}//
										}//
									}//
								}//
							}//
						}//
					}//
				}//
			}//
		
		}//
	}//
}
						
													
											
					
