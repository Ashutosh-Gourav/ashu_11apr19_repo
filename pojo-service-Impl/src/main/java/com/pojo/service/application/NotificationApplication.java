package com.pojo.service.application;

import com.pojo.service.domain.model.FcmRegistrationInfo;

/**
 * Created by gourava on 1/20/17.
 */
public interface NotificationApplication {

    void saveDeviceFcmInfo(FcmRegistrationInfo fcmRegistrationInfo);

}
