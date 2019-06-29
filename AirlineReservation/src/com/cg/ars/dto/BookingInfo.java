package com.cg.ars.dto;

public class BookingInfo {

	public BookingInfo(int id, String email, int no_of_pass, String class_type,
			int t_fare, int seat_no, String src_city, String dest_city) {
		super();
		this.id = id;
		this.email = email;
		this.no_of_pass = no_of_pass;
		this.class_type = class_type;
		this.t_fare = t_fare;
		this.seat_no = seat_no;
		this.src_city = src_city;
		this.dest_city = dest_city;
	}
	private int id;
	private String email;
	private int no_of_pass;
	private String class_type;
	private int t_fare;
	private int seat_no;
	private String src_city;
	private String dest_city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNo_of_pass() {
		return no_of_pass;
	}
	public void setNo_of_pass(int no_of_pass) {
		this.no_of_pass = no_of_pass;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	public int getT_fare() {
		return t_fare;
	}
	public void setT_fare(int t_fare) {
		this.t_fare = t_fare;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public String getSrc_city() {
		return src_city;
	}
	public void setSrc_city(String src_city) {
		this.src_city = src_city;
	}
	public String getDest_city() {
		return dest_city;
	}
	public void setDest_city(String dest_city) {
		this.dest_city = dest_city;
	}
	@Override
	public String toString() {
		return "BookingInfo [id=" + id + ", email=" + email + ", no_of_pass="
				+ no_of_pass + ", class_type=" + class_type + ", t_fare="
				+ t_fare + ", seat_no=" + seat_no + ", src_city=" + src_city
				+ ", dest_city=" + dest_city + "]";
	}
	
	public BookingInfo() {}
	
}
