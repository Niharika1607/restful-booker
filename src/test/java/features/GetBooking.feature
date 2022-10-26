@Read @GetBooking
Feature: To Get all the booking ids and some specified bookings
  Background:
   * def bookingId = 57
  Scenario: Get all the booking ids

    Given url baseUrl
    And header Accept = 'application/json'
    When method GET
    Then status 200

  Scenario: Get all details of specific booking id

    #Given url baseUrl + bookingId
    Given url baseUrl + bookingId
    And header Accept = 'application/json'
    When method GET
    Then status 200
