package com.pojo.service.application;

import com.pojo.service.domain.model.FcmRegistrationInfo;
import com.pojo.service.domain.model.NotificationRepository;

import javax.annotation.Resource;

/**
 * Created by gourava on 1/20/17.
 */
public class NotificationApplicationImpl implements NotificationApplication {

    @Resource
    private NotificationRepository notificationRepository;

    @Override
    public void saveDeviceFcmInfo(FcmRegistrationInfo fcmRegistrationInfo) {

        notificationRepository.saveFcmRegistrationInfo(fcmRegistrationInfo);

    }
}
