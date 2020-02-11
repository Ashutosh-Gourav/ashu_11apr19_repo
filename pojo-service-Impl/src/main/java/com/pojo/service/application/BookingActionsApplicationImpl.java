package com.pojo.service.application;

import com.pojo.service.api.v1.pojo.BookingAcceptanceResponse;
import com.pojo.service.api.v1.pojo.BookingDetailsResponse;
import com.pojo.service.api.v1.pojo.NewBookingResponse;
import com.pojo.service.api.v1.pojo.PriestImageResponseObject;
import com.pojo.service.api.v1.pojo.UserBookingRequest;
import com.pojo.service.domain.model.*;
import com.pojo.service.infrastructure.PriestImageNotFoundException;
import org.joda.time.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.Math.abs;


public class BookingActionsApplicationImpl implements BookingActionsApplication {
    @Resource
    private BookingActionsRepository bookingActionsRepository;

    @Resource
    private PriestManagerRepository priestManagerRepository;

    @Resource
    private UserDetailsRepository userDetailsRepository;


    @Override
    public void userBookingRequest(UserBookingRequest userBookingRequest) {
        String userId = userBookingRequest.getUserId();
        float longitude = userBookingRequest.getPoojaAddressLongitude();
        float latitude = userBookingRequest.getPoojaAddressLatitude();
        int poojaId = userBookingRequest.getPoojaId();
        String bookingStartTime = userBookingRequest.getPoojaStartTime();
        String bookingRequestTime = userBookingRequest.getBookingRequestTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.S");
        try {
            java.util.Date date = formatter.parse(bookingStartTime);
            Timestamp startTimestamp = new Timestamp(date.getTime());

            List<BookingDetails> bookingDetailsList = bookingActionsRepository.getBookingDetails(userId, poojaId);
            if (bookingDetailsList.isEmpty()) {
                BookingDetails bookingDetails = new BookingDetails();
                bookingDetails.setPoojaLanguage(userBookingRequest.getPoojaLanguage());
                bookingDetails.setPoojaStartTime(startTimestamp);
                bookingDetails.setPrepBy(userBookingRequest.getPrepBy());
                bookingDetails.setPoojaId(userBookingRequest.getPoojaId());
                java.util.Date bookingRequestDate = formatter.parse(bookingRequestTime);
                Timestamp bookingRequestTimestamp = new Timestamp(bookingRequestDate.getTime());
                bookingDetails.setBookingRequestTime(bookingRequestTimestamp);
                bookingDetails.setPoojaAddress(userBookingRequest.getPoojaAddress());
                bookingDetails.setPoojaAddressLatitude(latitude);
                bookingDetails.setPoojaAddressLongitude(longitude);
                bookingDetails.setPoojaBookingRequestId(userBookingRequest.getPoojaBookingRequestId());
                bookingDetails.setPoojaBookingStatus("pending");
                bookingDetails.setUserId(userBookingRequest.getUserId());
                bookingDetails.setOfferedPrice(userBookingRequest.getOfferedPrice());
                bookingActionsRepository.saveUserBookingDetails(bookingDetails);
            } else {
                for (BookingDetails bookingDetails : bookingDetailsList) {

                    Timestamp startDateTime = bookingDetails.getPoojaStartTime();
                    java.sql.Date startDate = new java.sql.Date(startDateTime.getTime());
                    SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
                    dbFormat.applyPattern("dd/MM/yyyy");
                    String formattedStartDate = dbFormat.format(startDate);
                    System.out.println(formattedStartDate);
                    formatter.applyPattern("dd/MM/yyyy");
                    String userStartDate = formatter.format(date);
                    float userAddresslongitude = bookingDetails.getPoojaAddressLongitude();
                    float userAddressLatitude = bookingDetails.getPoojaAddressLatitude();

                    System.out.println(userStartDate);
                    if (userStartDate.equalsIgnoreCase(formattedStartDate) &&
                            !(bookingDetails.getBookingStatus().equalsIgnoreCase("cancelled") ||
                                    bookingDetails.getBookingStatus().equalsIgnoreCase("booked"))) {
                        if (abs(userAddressLatitude - userBookingRequest.getPoojaAddressLatitude()) < 1 &&
                                abs(userAddresslongitude - userBookingRequest.getPoojaAddressLongitude()) < 1) {
                            throw new BookingAlreadyExistException("Booking already exist Exception");

                        }
                    }
                }
            }
        } catch (ParseException e) {
            throw new PojoException("Internal Exception");
        }

    }

    @Override
    public PriestImageResponseObject getUserBookingPanditImage(String userBookingRequestId) {
        String image = bookingActionsRepository.getUserBookingPanditImage(userBookingRequestId);
        if (image.equalsIgnoreCase("No Image")) {
            throw new PriestImageNotFoundException("No priest Image in our Db");
        }
        PriestImageResponseObject priestImageResponseObject = new PriestImageResponseObject();
        priestImageResponseObject.setPriestImage(image);
        return priestImageResponseObject;
    }

    @Override
    public List<BookingDetailsResponse> getUserBookingHistory(String userId) {
        List<UserBookingHistoryObject> userBookingHistoryObjectList = bookingActionsRepository.getUserBookingHistory(userId);
        List<BookingDetailsResponse> bookingDetailsResponses = new ArrayList<>();
        if (!userBookingHistoryObjectList.isEmpty()) {
            for (UserBookingHistoryObject userBookingHistoryObject : userBookingHistoryObjectList) {
                BookingDetailsResponse bookingDetailsResponse = new BookingDetailsResponse();
                bookingDetailsResponse.setPanditPhone(userBookingHistoryObject.getPanditPhone());
                bookingDetailsResponse.setPoojaAddressLatitude(userBookingHistoryObject.getPoojaAddressLatitude());
                bookingDetailsResponse.setPoojaAddressLongitude(userBookingHistoryObject.getPoojaAddressLongitude());
                bookingDetailsResponse.setPoojaAddress(userBookingHistoryObject.getPoojaAddress());
                bookingDetailsResponse.setPanditName(userBookingHistoryObject.getPanditName());
                bookingDetailsResponse.setPoojaBookingRequestId(userBookingHistoryObject.getPoojaBookingRequestId());
                Timestamp poojaStartTimestamp = userBookingHistoryObject.getPoojaStartTime();
                Timestamp bookingRequestTime = userBookingHistoryObject.getBookingRequestTime();
                SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.sql.Date poojaStartDateTime = new java.sql.Date(poojaStartTimestamp.getTime());
                java.sql.Date bookingRequestDateTime = new java.sql.Date(bookingRequestTime.getTime());
                dbFormat.applyPattern("dd/MM/yyyy HH:mm:ss");
                String userStartDate = dbFormat.format(poojaStartDateTime);
                String userBookingRequestTime = dbFormat.format(bookingRequestDateTime);
                bookingDetailsResponse.setBookingRequestTime(userBookingRequestTime);
                bookingDetailsResponse.setPoojaStartTime(userStartDate);
                bookingDetailsResponse.setPoojaBookingStatus(userBookingHistoryObject.getPoojaBookingStatus());
                bookingDetailsResponse.setPoojaLanguage(userBookingHistoryObject.getPoojaLanguage());
                bookingDetailsResponse.setPoojaId(userBookingHistoryObject.getPoojaId());
                bookingDetailsResponse.setBookingId(userBookingHistoryObject.getId());
                bookingDetailsResponse.setPrepBy(userBookingHistoryObject.getPrepBy());
                bookingDetailsResponse.setUserId(userBookingHistoryObject.getUserId());
                bookingDetailsResponse.setOfferedPrice(userBookingHistoryObject.getOfferedPrice());
                bookingDetailsResponses.add(bookingDetailsResponse);


            }
            return bookingDetailsResponses;


        }
        throw new NoHistoryFoundException("This are no records present in our database ");
    }

    @Override
    public List<NewBookingResponse> getNewBookings(int priestId, float lastSeenLatitude, float lastSeenLongitude) {

        priestManagerRepository.updatePriestLastSeenLocation(priestId, lastSeenLatitude, lastSeenLongitude);

        List<NewBookingResponseObject> newBookingResponseObjectList = bookingActionsRepository.getNewUserBookings();
        List<NewBookingResponse> newBookingResponses = new ArrayList<>();
        for (NewBookingResponseObject newBookingResponseObject : newBookingResponseObjectList) {
            Timestamp timestamp = newBookingResponseObject.getPoojaStartTime();
            SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date poojaStartDateTime = new java.sql.Date(timestamp.getTime());
            dbFormat.applyPattern("dd/MM/yyyy HH:mm:ss");

            String startTime = dbFormat.format(poojaStartDateTime);
            if (timeDifference(startTime, newBookingResponseObject.getPrepBy())) {
                NewBookingResponse newBookingResponse = new NewBookingResponse();
                newBookingResponse.setPoojalanguage(newBookingResponseObject.getPoojalanguage());
                newBookingResponse.setUserMobileNumber(newBookingResponseObject.getUserMobileNumber());
                newBookingResponse.setPoojaAddress(newBookingResponseObject.getPoojaAddress());
                newBookingResponse.setUserFullName(newBookingResponseObject.getUserFullName());
                newBookingResponse.setPrepBy(newBookingResponseObject.getPrepBy());
                newBookingResponse.setPoojaAddressLatitude(newBookingResponseObject.getPoojaAddressLatitude());
                newBookingResponse.setPoojaAddressLongitude(newBookingResponseObject.getPoojaAddressLongitude());
                newBookingResponse.setPoojaid(newBookingResponseObject.getPoojaid());
                newBookingResponse.setPoojaStartTime(startTime);
                newBookingResponse.setStatus(newBookingResponseObject.getStatus());
                newBookingResponses.add(newBookingResponse);
            } else {
                bookingActionsRepository.updateBookingStatusToExpired(newBookingResponseObject);
            }
        }

        return newBookingResponses;
    }

    @Override
    public BookingAcceptanceResponse acceptBookingRequest(String userBookingRequestId, String priestMobile, String priestEmail) {
        List<RegisteredPriestDetails> registeredPriestDetails = priestManagerRepository.getRegisteredPriestInfo(priestMobile, priestEmail);
        if (registeredPriestDetails.isEmpty()) {
            throw new PriestNotFoundException("Priest is not registered with us");
        }
        String priestName = registeredPriestDetails.get(0).getName();
        int id = registeredPriestDetails.get(0).getId();

        bookingActionsRepository.updateBookingDetailsWithPriestInfo(userBookingRequestId, priestMobile, priestName, id);
        List<RegisteredUserBookingDetails> registeredUserBookingDetailses = userDetailsRepository.getUserNameForBookingId(userBookingRequestId);

        if (registeredUserBookingDetailses.isEmpty()) {
            throw new UserNotFoundException("user doesnot exist");
        }

        BookingAcceptanceResponse bookingAcceptanceResponse = new BookingAcceptanceResponse();

        bookingAcceptanceResponse.setUserName(registeredUserBookingDetailses.get(0).getUserName());
        bookingAcceptanceResponse.setBookingId(id);
        bookingAcceptanceResponse.setPrepBy(registeredUserBookingDetailses.get(0).getPrepBy());
        bookingAcceptanceResponse.setOfferedPrice(registeredUserBookingDetailses.get(0).getOfferedPrice());
        bookingAcceptanceResponse.setPoojaAddressLatitude(registeredUserBookingDetailses.get(0).getPoojaLatitude());
        bookingAcceptanceResponse.setPoojaAddress(registeredUserBookingDetailses.get(0).getPoojaAddress());
        bookingAcceptanceResponse.setOfferedPrice(registeredUserBookingDetailses.get(0).getOfferedPrice());
        bookingAcceptanceResponse.setPoojaId(registeredUserBookingDetailses.get(0).getPoojaId());
        bookingAcceptanceResponse.setPoojaBookingRequestId(userBookingRequestId);
        bookingAcceptanceResponse.setPoojaLanguage(registeredUserBookingDetailses.get(0).getLang());


        return bookingAcceptanceResponse;
    }

    private boolean timeDifference(String startTime, String prepBy) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));
        String currentTime = sdf.format(cal.getTime());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(currentTime);
            d2 = format.parse(startTime);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);

//            System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
//            System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
//            System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
//            System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");

            if (prepBy.equalsIgnoreCase("user")) {
                if (Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 > 30) {
                    return true;
                }


            }
            if (Hours.hoursBetween(dt1, dt2).getHours() % 24 > 2) {
                return true;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}