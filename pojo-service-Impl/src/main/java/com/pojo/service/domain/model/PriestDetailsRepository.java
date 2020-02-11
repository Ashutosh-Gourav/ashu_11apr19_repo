package com.pojo.service.domain.model;

import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public interface PriestDetailsRepository {

    List<RegisteredPriestDetails> getPriestDetails(User user);

    List<RegisteredPriestDetails> getPriestDeatilsAfterOTPConfirmation(User user);


    void updateStatusofPriestAsActive(String mobileNumber, String email,String status);

    void updatePriestPassword(User user);
}
