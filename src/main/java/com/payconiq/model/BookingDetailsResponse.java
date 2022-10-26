package com.payconiq.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDetailsResponse implements Serializable {
    public String bookingid;
    public Booking booking;
}