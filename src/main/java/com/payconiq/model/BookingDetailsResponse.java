package com.payconiq.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class BookingDetailsResponse implements Serializable {
    public String bookingid;
    public Booking booking;
}