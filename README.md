# Restful-booker Testing

## **Overview:**
In this Project below APIs have been automated from [Restful-booker](https://restful-booker.herokuapp.com/apidoc/index.html).

**CREATE** - http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-CreateBooking

**READ**   - http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBookings

**UPDATE** - http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-UpdateBooking

**DELETE** - http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-DeleteBooking

### **Test Scenarios Automated in Framework**

1. To verify createBooking API Using data table and using Json.
2. To verify GetBookingIds API
3. To verify GetBooking API to get details for first booking id retrieved from GetBookingIds
4. To verify GetBooking API to get details for the range of checkin and checkout dates.
5. To verify GetBooking API to get details for the FirstName and LastName of the first booking id retrieved from GetBookingIds
6. To verify PartialUpdateBooking API to update FirstName and LastName
7. To verify DeleteBooking API for the first booking id retrieved from GetBookingIds.
8. To verify end to end scenario for CRUD, where a booking is created then updated and finally deleted by API.

## **Running Test:**

Open the command prompt and navigate to the folder in which pom.xml file is present.
Run the below Maven command.

    mvn clean test


Once the execution completes report & log will be generated in below folder.

**Report:** 		*target/report*<br>
**Log:** 		*target/logs*