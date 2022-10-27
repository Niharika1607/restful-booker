package com.payconiq.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Booking implements Serializable {
	public String firstname;
	public String lastname;
	public String totalprice;
	public String depositpaid;
	public BookingDates bookingdates;
	public String additionalneeds;
}