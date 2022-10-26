@bookerAPI @updateBooking
Feature: To update a booking in restful-booker

  Background: create an auth token
    Given user has access to endpoint "/auth"
    When user creates a auth token with credential "admin" & "password123"
    Then user should get the response code 200

  @updateBookingDataTable
  Scenario Outline: To update a booking using cucumber Data Table
    Given user has access to endpoint "/booking"
    When user makes a request to view booking IDs
    And user updates the details of a booking
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Then user should get the response code 200
    And user validates the response with JSON schema "bookingDetailsSchema.json"

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Niharika  | Shukla   | 10000      | true        | 2021-05-15 | 2021-06-11 | Breakfast       |
      | Abhi      | Shukla   | 2006       | false       | 2021-06-01 | 2021-07-10 | Dinner          |

  @updateBookingFromJSON
  Scenario Outline: To update a booking using JSON data
    Given user has access to endpoint "/booking"
    When user makes a request to view booking IDs
    And user updates the booking details using data "<dataKey>" from JSON file "<JSONFile>"
    Then user should get the response code 200
    And user validates the response with JSON schema "bookingDetailsSchema.json"

    Examples:
      | dataKey        | JSONFile         |
      | updateBooking1 | bookingBody.json |
      | updateBooking2 | bookingBody.json |

  @partialUpdateBooking
  Scenario: To partially update a booking
    Given user has access to endpoint "/booking"
    When user makes a request to view booking IDs
    And user makes a request to update first name "Niharika" & Last name "Shukla"
    Then user should get the response code 200
    And user validates the response with JSON schema "bookingDetailsSchema.json"