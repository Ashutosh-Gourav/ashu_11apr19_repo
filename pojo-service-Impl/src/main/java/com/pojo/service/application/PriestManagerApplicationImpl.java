package com.pojo.service.application;

import com.pojo.service.domain.model.*;
import com.pojo.service.domain.services.SendSms;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PriestManagerApplicationImpl implements PriestManagerApplication {


    @Resource
    private PriestManagerRepository priestManagerRepository;

    @Resource
    private NotificationRepository notificationRepository;

    @Override
    public String saveUserDetails(User user) {
        List<FcmRegistrationInfo> fcmRegistrationInfoList= notificationRepository.getRegistrationInfo(user.getDeviceId());
        List<RegisteredPriestDetails> registeredPriestDetailsList = priestManagerRepository.getPriestManagerDetails(user);
        FcmRegistrationInfo fcmRegistrationInfo = new FcmRegistrationInfo();
        fcmRegistrationInfo.setDeviceId(user.getDeviceId());
        fcmRegistrationInfo.setFcmRegistrationToken(user.getFcmRegistrationToken());
        fcmRegistrationInfo.setUser(user.isUser());
        int generatedOtp = generateRandomInteger();
        SendSms sendSms = new SendSms();
        if(registeredPriestDetailsList.isEmpty()){

            priestManagerRepository.savePriestDetails(user);
            List<RegisteredPriestDetails> registeredPriestDetailses = priestManagerRepository.getPriestManagerDetails(user);
            int id= registeredPriestDetailses.get(0).getId();
            fcmRegistrationInfo.setPersonId(id);
            if(fcmRegistrationInfoList.isEmpty()){

            notificationRepository.saveFcmRegistrationInfo(fcmRegistrationInfo);
            }else {
                notificationRepository.updateFcmRegistrationInfo(fcmRegistrationInfo);
            }
            try {
//                sendSms.createSoapClient(user.getMobileNumber(), id, generatedOtp);
                return String.valueOf(generatedOtp);
            } catch (Exception e) {
                throw new SmsSendingException("Error while sending sms");

            }
        }
        for(RegisteredPriestDetails registeredPriestDetails :registeredPriestDetailsList){
            if(registeredPriestDetails.getStatus().equalsIgnoreCase("active")){
                throw new UserAlreadyExistException("Priest already Exist in our records with status active");
            }
            priestManagerRepository.updatePriestDetails(user);
            int id= registeredPriestDetails.getId();
            fcmRegistrationInfo.setId(id);
            if(fcmRegistrationInfoList.isEmpty()){
                notificationRepository.saveFcmRegistrationInfo(fcmRegistrationInfo);
            }else {
                notificationRepository.updateFcmRegistrationInfo(fcmRegistrationInfo);
            }
            try {
//                sendSms.createSoapClient(user.getMobileNumber(), id, generatedOtp);
                return String.valueOf(generatedOtp);
            } catch (Exception e) {
                throw new SmsSendingException("Error while sending sms");

            }
        }

        throw new PojoException("Some Internal Error occured");
    }

    private int generateRandomInteger() {

        Random randomGenerator = new Random();
        int randomInt = 0;
        randomInt = randomGenerator.nextInt(89999) + 100000;
        return randomInt;
    }
}
