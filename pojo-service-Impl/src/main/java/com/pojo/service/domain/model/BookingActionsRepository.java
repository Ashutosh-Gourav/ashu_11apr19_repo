package com.pojo.service.domain.model;

import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public interface BookingActionsRepository {

    List<BookingDetails> getBookingDetails(String userId,int pooja);

    void saveUserBookingDetails(BookingDetails bookingDetails);

    String getUserBookingPanditImage(String userBookingRequestId);

    List<UserBookingHistoryObject> getUserBookingHistory(String userId);

    List<NewBookingResponseObject> getNewUserBookings();

    void updateBookingStatusToExpired(NewBookingResponseObject newBookingResponseObject);

    void updateBookingDetailsWithPriestInfo(String userBookingRequestId,String priestMobile,String priestName,int id);
}
