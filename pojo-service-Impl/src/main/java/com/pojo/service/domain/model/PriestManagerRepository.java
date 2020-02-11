package com.pojo.service.domain.model;

import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public interface PriestManagerRepository {

    List<RegisteredPriestDetails> getPriestManagerDetails(User user);

    void savePriestDetails(User user);

    void updatePriestDetails(User user);

    void updatePriestLastSeenLocation(int id, float lastSeenLatitude, float lastSeenLongitude);

    List<RegisteredPriestDetails> getRegisteredPriestInfo(String priestMobile,String priestEmail);



}
