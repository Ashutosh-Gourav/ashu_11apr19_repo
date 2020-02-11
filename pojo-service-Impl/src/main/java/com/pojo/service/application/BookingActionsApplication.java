package com.pojo.service.application;

import com.pojo.service.api.v1.pojo.BookingAcceptanceResponse;
import com.pojo.service.api.v1.pojo.BookingDetailsResponse;
import com.pojo.service.api.v1.pojo.NewBookingResponse;
import com.pojo.service.api.v1.pojo.PriestImageResponseObject;
import com.pojo.service.api.v1.pojo.UserBookingRequest;

import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public interface BookingActionsApplication {
    void userBookingRequest(UserBookingRequest userBookingRequest);

    PriestImageResponseObject getUserBookingPanditImage(String userBookingRequestId);

    List<BookingDetailsResponse>  getUserBookingHistory(String userId);

    List<NewBookingResponse> getNewBookings(int priestId,float lastSeenLatitude,float lastSeenLongitude);

    BookingAcceptanceResponse acceptBookingRequest(String userBookingRequestId,String priestMobile,String priestEmail);




}
