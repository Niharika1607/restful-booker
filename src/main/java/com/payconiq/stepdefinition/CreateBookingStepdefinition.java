package com.payconiq.stepdefinition;

import com.payconiq.model.BookingDetailsResponse;
import com.payconiq.utils.JsonReader;
import com.payconiq.utils.ResponseHandler;
import com.payconiq.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateBookingStepdefinition {
    private TestContext context;
    private static final Logger LOG = LogManager.getLogger(CreateBookingStepdefinition.class);

    public CreateBookingStepdefinition(TestContext context) {
        this.context = context;
    }

    @When("user creates a booking")
    public void userCreatesABooking(DataTable dataTable) {
        Map<String, String> bookingData = dataTable.asMaps().get(0);
        JSONObject bookingBody = new JSONObject();
        bookingBody.put("firstname", bookingData.get("firstname"));
        bookingBody.put("lastname", bookingData.get("lastname"));
        bookingBody.put("totalprice", Integer.valueOf(bookingData.get("totalprice")));
        bookingBody.put("depositpaid", Boolean.valueOf(bookingData.get("depositpaid")));
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", (bookingData.get("checkin")));
        bookingDates.put("checkout", (bookingData.get("checkout")));
        bookingBody.put("bookingdates", bookingDates);
        bookingBody.put("additionalneeds", bookingData.get("additionalneeds"));

        context.response = context.requestSetup().body(bookingBody.toString())
                .when().post(context.session.get("endpoint").toString());

        BookingDetailsResponse response = ResponseHandler.deserializedResponse(context.response, BookingDetailsResponse.class);
        assertNotNull("Booking not created", response);
        LOG.info("Newly created booking ID: " + response.getBookingid());
        context.session.put("bookingID", response.getBookingid());
        validateBookingData(new JSONObject(bookingData), response);
    }

    private void validateBookingData(JSONObject bookingData, BookingDetailsResponse response) {
        LOG.info(bookingData);
        assertNotNull("Booking ID missing", response.getBookingid());
        assertEquals("First Name did not match", bookingData.get("firstname"), response.getBooking().firstname);
        assertEquals("Last Name did not match", bookingData.get("lastname"), response.getBooking().lastname);
        assertEquals("Total Price did not match", bookingData.get("totalprice"), response.getBooking().totalprice);
        assertEquals("Deposit Paid did not match", bookingData.get("depositpaid"), response.getBooking().depositpaid);
        assertEquals("Additional Needs did not match", bookingData.get("additionalneeds"), response.getBooking().additionalneeds);
        assertEquals("Check in Date did not match", bookingData.get("checkin"), response.getBooking().getBookingdates().checkin);
        assertEquals("Check out Date did not match", bookingData.get("checkout"), response.getBooking().getBookingdates().checkout);
    }

    @When("user creates a booking using data {string} from JSON file {string}")
    public void userCreatesABookingUsingDataFromJSONFile(String dataKey, String JSONFile) {
        context.response = context.requestSetup().body(JsonReader.getRequestBody(JSONFile, dataKey))
                .when().post(context.session.get("endpoint").toString());

        BookingDetailsResponse response = ResponseHandler.deserializedResponse(context.response, BookingDetailsResponse.class);
        assertNotNull("Booking not created", response);
        LOG.info("Newly created booking ID: " + response.getBookingid());
        context.session.put("bookingID", response.getBookingid());
    }
}
