package com.pojo.service.domain.model;

import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public interface UserDetailsRepository {

    List<RegisteredUserDetails> getUserDetails(User user);
    List<RegisteredUserDetails> getUserDetailsForStatusUpdate(User user,String status);
    List<RegisteredUserDetails> getActiveUserDetails(User user);

    void saveUserDetails(User user,String status);
    void updateUserDetails(User user);
    void updateStatus(String mobileNumber, String email,String status);
    void updateUserPassword(User user);
    void updateUserDetailsWithSameEmail(User user);
    List<RegisteredUserBookingDetails> getUserNameForBookingId(String userBookingRequestId);
}
