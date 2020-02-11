package com.pojo.service.application;

import com.pojo.service.domain.model.User;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public interface LoginApplication {
    String login(User user);

    String saveUserDetails(User user);

    void updateStatus(String mobileNumber, String email, boolean isUser);

    String resetUserPassword(String email,String mobileNumber,boolean isUser);

    void updateUserPassword(User user);

}
