package com.payconiq.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class BookingDates implements Serializable {
    public String checkin;
    public String checkout;

}