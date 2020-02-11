package com.pojo.service.domain.model;

import java.util.List;

public interface NotificationRepository {

    void saveFcmRegistrationInfo(FcmRegistrationInfo fcmRegistrationInfo);

    List<FcmRegistrationInfo> getRegistrationInfo(String deviceId);

    void updateFcmRegistrationInfo(FcmRegistrationInfo fcmRegistrationInfo);


}
