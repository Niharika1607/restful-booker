package com.payconiq.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDetailsRequest implements Serializable {
    public String firstname;
    public String lastname;
    public String totalprice;
    public String depositpaid;
    public BookingDates bookingdates;
    public String additionalneeds;
}