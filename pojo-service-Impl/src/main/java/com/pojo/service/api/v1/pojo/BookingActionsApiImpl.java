package com.pojo.service.api.v1.pojo;

import com.pojo.service.application.BookingActionsApplication;
import com.pojo.service.domain.model.*;
import com.pojo.service.infrastructure.PriestImageNotFoundException;
import com.pojo.service.infrastructure.UserBookingIdNotFoundException;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class BookingActionsApiImpl implements com.pojo.service.api.v1.pojo.BookingActionsApi {
    @Resource
    private BookingActionsApplication bookingActionsApplication;


    @Override
    public void userBookingRequest(com.pojo.service.api.v1.pojo.UserBookingRequest userBookingRequest) {
        checkWebArgument(userBookingRequest != null, "userBookingRequest cannot be null");
        checkWebArgument(userBookingRequest.getBookingRequestTime() != null, "BookingRequestTime is null");
        checkWebArgument(!(userBookingRequest.getBookingRequestTime().trim().isEmpty()), "BookingRequestTime is empty");
        checkWebArgument(userBookingRequest.getPoojaBookingRequestId() != null, "BookingRequestId is null");
        checkWebArgument(!(userBookingRequest.getPoojaBookingRequestId().trim().isEmpty()), "BookingRequestId is empty");
        checkWebArgument(userBookingRequest.getPoojaAddress() != null, "poojaAddress is null");
        checkWebArgument(!(userBookingRequest.getPoojaAddress().trim().isEmpty()), "BookingRequestId is empty");
        checkWebArgument(userBookingRequest.getPoojaAddressLatitude() > 7 && userBookingRequest.getPoojaAddressLatitude() < 33, "Latitude should vary from 8-32");
        checkWebArgument((userBookingRequest.getPoojaAddressLongitude() > 69) && (userBookingRequest.getPoojaAddressLongitude() < 93), "longitude should vary from 70-92 ");
        checkWebArgument(userBookingRequest.getPoojaId() >= 0, "please provide a valid poojaId");
        checkWebArgument(userBookingRequest.getPoojaLanguage() != null, "poojaLanguage provided is null");
        checkWebArgument(!(userBookingRequest.getPoojaLanguage().trim().isEmpty()), "poojaLanguage provided is empty");
        checkWebArgument(userBookingRequest.getBookingRequestTime() != null, "Booking Request timings are null");
        checkWebArgument(userBookingRequest.getPoojaStartTime() != null, "Booking Start timings are null");
        checkWebArgument(!(userBookingRequest.getPoojaStartTime().trim().isEmpty()), "Booking Start timings is empty");
        checkWebArgument(userBookingRequest.getPrepBy() != null, "prepBy cannot be null");
        checkWebArgument(userBookingRequest.getOfferedPrice() > 0, "offredPrize is zero");

        try {
            bookingActionsApplication.userBookingRequest(userBookingRequest);

        } catch (BookingAlreadyExistException e) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        } catch (PojoException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public com.pojo.service.api.v1.pojo.PriestImageResponseObject getUserBookingPanditImage(com.pojo.service.api.v1.pojo.UserBookingRequestId userBookingRequestId) {
        checkWebArgument(userBookingRequestId != null, "Request cannot be null");
        checkWebArgument(userBookingRequestId.getUserBookingRequestId() != null, "bookingRequestId cannot be null");
        checkWebArgument(!(userBookingRequestId.getUserBookingRequestId().trim().isEmpty()), "bookingRequestId is Empty");
        String userBookingrequestId = userBookingRequestId.getUserBookingRequestId();
        com.pojo.service.api.v1.pojo.PriestImageResponseObject priestImageResponseObject;
        try {
            priestImageResponseObject = bookingActionsApplication.getUserBookingPanditImage(userBookingrequestId);

        } catch (PriestImageNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (UserBookingIdNotFoundException e) {
            throw new WebApplicationException(Response.Status.PRECONDITION_FAILED);
        }

        return priestImageResponseObject;
    }

    @Override
    public List<com.pojo.service.api.v1.pojo.BookingDetailsResponse> getUserBookingHistory(com.pojo.service.api.v1.pojo.UserId userId) {
        checkWebArgument(userId != null, "request cannot be null");
        checkWebArgument(userId.getUserId() != null, "userIdcannot be null");
        checkWebArgument(!(userId.getUserId().trim().isEmpty()), "userId is empty");
        String userUserId = userId.getUserId();
        List<com.pojo.service.api.v1.pojo.BookingDetailsResponse> bookingDetailsResponseList;
        try {
            bookingDetailsResponseList = bookingActionsApplication.getUserBookingHistory(userUserId);

        } catch (NoHistoryFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return bookingDetailsResponseList;
    }

    @Override
    public List<com.pojo.service.api.v1.pojo.NewBookingResponse> getNewBookingDetails(com.pojo.service.api.v1.pojo.NewBookingRequest newBookingRequest) {

        checkWebArgument(newBookingRequest.getLastSeenLatitude() > 7 && newBookingRequest.getLastSeenLatitude() < 33, "Latitude should vary from 8-32");
        checkWebArgument((newBookingRequest.getLastSeenLongitude() > 69) && (newBookingRequest.getLastSeenLongitude() < 93), "longitude should vary from 70-92 ");
        checkWebArgument(newBookingRequest.getPriestId() > 0, "please provide a valid poojaId");

        int priestId = newBookingRequest.getPriestId();
        float lastSeenLatitude = newBookingRequest.getLastSeenLatitude();
        float lastSeenLongitude = newBookingRequest.getLastSeenLongitude();

        List<com.pojo.service.api.v1.pojo.NewBookingResponse> newBookingResponses = bookingActionsApplication.getNewBookings(priestId, lastSeenLatitude, lastSeenLongitude);
        return newBookingResponses;
    }

    @Override
    public com.pojo.service.api.v1.pojo.BookingAcceptanceResponse userBookingAcceptance(com.pojo.service.api.v1.pojo.UserBookingRequestId bookingRequestId) {
        checkWebArgument(bookingRequestId != null, "bookingRequestId should not be null");
        checkWebArgument(bookingRequestId.getPriestMobile() != null, "priestMobile is null");
        checkWebArgument(!(bookingRequestId.getPriestMobile().trim().isEmpty()), "priestMobile cannot be empty");

        String userBookingRequestId = bookingRequestId.getUserBookingRequestId();
        String priestMobileNumber = bookingRequestId.getPriestMobile();
        String priestEmail = bookingRequestId.getPriestEmail();
        com.pojo.service.api.v1.pojo.BookingAcceptanceResponse bookingAcceptanceResponse = null;

        try {
            bookingAcceptanceResponse = bookingActionsApplication.acceptBookingRequest(userBookingRequestId, priestMobileNumber, priestEmail);

        } catch (PriestNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (UserNotFoundException e) {
            throw new WebApplicationException(Response.Status.FORBIDDEN);

        } catch (PojoException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return bookingAcceptanceResponse;
    }


    public static void checkWebArgument(boolean assertion, String message) {
        if (!assertion) {
            try {
                throw new BadRequestException();
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
