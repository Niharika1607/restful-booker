# Restful-booker Testing

## **Overview:**
In this Project below APIs have been automated from [Restful-booker](https://restful-booker.herokuapp.com/apidoc/index.html).

CREATE - http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-CreateBooking
READ   - http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBookings
UPDATE - http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-UpdateBooking
DELETE - http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-DeleteBooking

### **Some of the key features of this framework:**

1. It generates Extent report with all the step details. Report will be generated both HTML & PDF file format.
2. Generates execution logs, with detailed request and response details.
3. Feature file has examples of reading request details from Scenario and json file
4. This also has an example to validate response body using json schema and java pojo classes.
5. Test execution can be triggered form command line. 
6. Easy integration to CI/CD pipeline.


## **Running Test:**

Open the command prompt and navigate to the folder in which pom.xml file is present.
Run the below Maven command.

    mvn clean test


Once the execution completes report & log will be generated in below folder.

**Report:** 		*target/report*<br>
**Log:** 		*target/logs*