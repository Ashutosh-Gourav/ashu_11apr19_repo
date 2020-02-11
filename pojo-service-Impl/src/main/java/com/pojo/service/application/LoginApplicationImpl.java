package com.pojo.service.application;

import com.pojo.service.domain.constants.StatusType;
import com.pojo.service.domain.model.*;
import com.pojo.service.domain.services.SendSms;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

public class LoginApplicationImpl implements LoginApplication {
    @Resource
    private UserDetailsRepository userDetailsRepository;

    @Resource
    private PriestDetailsRepository priestDetailsRepository;

    @Resource
    private NotificationRepository notificationRepository;

    @Override
    public String login(User user) {

        List<FcmRegistrationInfo> fcmRegistrationInfoList = notificationRepository.getRegistrationInfo(user.getDeviceId());
        FcmRegistrationInfo fcmRegistrationInfo = new FcmRegistrationInfo();
        fcmRegistrationInfo.setDeviceId(user.getDeviceId());
        fcmRegistrationInfo.setFcmRegistrationToken(user.getFcmRegistrationToken());
        if (user.isUser()) {

            List<RegisteredUserDetails> registeredUserDetailsList = userDetailsRepository.getActiveUserDetails(user);
            if (!registeredUserDetailsList.isEmpty()) {
                if (user.getPassword().equals(registeredUserDetailsList.get(0).getPassword())) {
                    int otp = generateRandomInteger();
                    SendSms sendSms = new SendSms();
                    int id = registeredUserDetailsList.get(0).getId();
                    fcmRegistrationInfo.setUser(true);
                    fcmRegistrationInfo.setPersonId(id);
                    if (fcmRegistrationInfoList.isEmpty()) {
                        notificationRepository.saveFcmRegistrationInfo(fcmRegistrationInfo);
                    } else {
                        notificationRepository.updateFcmRegistrationInfo(fcmRegistrationInfo);
                    }
//                    try {
//                        sendSms.createSoapClient(user.getMobileNumber(), id, otp);
//                    } catch (ServiceException e) {
//                        throw  new SmsSendingException("something went wrong while sending msg to user");
//                    } catch (MalformedURLException e) {
//                        throw  new SmsSendingException("something went wrong while sending msg to user");
//                    }
                    return String.valueOf(otp);
                }
                throw new PasswordMismatchException("your password doesn't match our record");

            }
            throw new UserNotFoundException("UserNotFound::::::::");

        }
        List<RegisteredPriestDetails> registeredPriestDetailsList = priestDetailsRepository.getPriestDetails(user);
        if (!registeredPriestDetailsList.isEmpty()) {
            if (user.getPassword().equals(registeredPriestDetailsList.get(0).getPriestPassword())) {
                int otp = generateRandomInteger();
                SendSms sendSms = new SendSms();
                int id = registeredPriestDetailsList.get(0).getId();
                fcmRegistrationInfo.setUser(false);
                fcmRegistrationInfo.setPersonId(id);
                if (fcmRegistrationInfoList.isEmpty()) {
                    notificationRepository.saveFcmRegistrationInfo(fcmRegistrationInfo);
                } else {
                    notificationRepository.updateFcmRegistrationInfo(fcmRegistrationInfo);
                }
//                    try {
//                        sendSms.createSoapClient(user.getMobileNumber(), id, otp);
//                    } catch (ServiceException e) {
//                        throw  new SmsSendingException("something went wrong while sending msg to user");
//                    } catch (MalformedURLException e) {
//                        throw  new SmsSendingException("something went wrong while sending msg to user");
//                    }
                return String.valueOf(otp);


            }
            throw new PasswordMismatchException("your password doesn't match our record");
        }

        throw new UserNotFoundException("priest doesnot exist in our database");

    }

    @Override
    public String saveUserDetails(User user) {
        List<FcmRegistrationInfo> fcmRegistrationInfoList = notificationRepository.getRegistrationInfo(user.getDeviceId());
        List<RegisteredUserDetails> registeredUserDetailsList = userDetailsRepository.getUserDetails(user);
        int generatedOtp = generateRandomInteger();
        String status = StatusType.INACTIVE.get();
        FcmRegistrationInfo fcmRegistrationInfo = new FcmRegistrationInfo();
        fcmRegistrationInfo.setDeviceId(user.getDeviceId());
        fcmRegistrationInfo.setFcmRegistrationToken(user.getFcmRegistrationToken());
        fcmRegistrationInfo.setUser(true);
        if (registeredUserDetailsList.isEmpty()) {
            userDetailsRepository.saveUserDetails(user, status);
            List<RegisteredUserDetails> nowSavedRegisteredUserDetailsList = userDetailsRepository.getUserDetailsForStatusUpdate(user, status);
            int id = nowSavedRegisteredUserDetailsList.get(0).getId();
            SendSms sendSms = new SendSms();
            fcmRegistrationInfo.setPersonId(id);
            if (fcmRegistrationInfoList.isEmpty()) {
                notificationRepository.saveFcmRegistrationInfo(fcmRegistrationInfo);
            } else {
                notificationRepository.updateFcmRegistrationInfo(fcmRegistrationInfo);
            }
            try {
//                sendSms.createSoapClient(user.getMobileNumber(), id, generatedOtp);
                return String.valueOf(generatedOtp);
            } catch (Exception e) {
                throw new SmsSendingException("there is some problem while sending sms");
            }

        } else {
            for (RegisteredUserDetails registeredUserDetails : registeredUserDetailsList) {
                if (registeredUserDetails.getEmail().equals(user.getEmail())) {
                    if (registeredUserDetails.getStatus().equals(StatusType.ACTIVE.get())) {
                        fcmRegistrationInfo.setPersonId(registeredUserDetails.getId());
                        if (fcmRegistrationInfoList.isEmpty()) {
                            notificationRepository.saveFcmRegistrationInfo(fcmRegistrationInfo);
                        } else {
                            notificationRepository.updateFcmRegistrationInfo(fcmRegistrationInfo);
                        }
                        throw new UserAlreadyExistException("user Already exist in our database");
                    }
                    userDetailsRepository.updateUserDetailsWithSameEmail(user);
                    int id = registeredUserDetails.getId();
                    fcmRegistrationInfo.setPersonId(id);
                    if (fcmRegistrationInfoList.isEmpty()) {
                        notificationRepository.saveFcmRegistrationInfo(fcmRegistrationInfo);
                    } else {
                        notificationRepository.updateFcmRegistrationInfo(fcmRegistrationInfo);
                    }
                    try {
//                    sendSms.createSoapClient(user.getMobileNumber(), id, generatedOtp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return String.valueOf(generatedOtp);

                }
            }
            userDetailsRepository.saveUserDetails(user, status);
            List<RegisteredUserDetails> nowRegisteredUserDetailsList = userDetailsRepository.getUserDetailsForStatusUpdate(user, status);
            int id = nowRegisteredUserDetailsList.get(0).getId();
            fcmRegistrationInfo.setPersonId(id);
            if (fcmRegistrationInfoList.isEmpty()) {
                notificationRepository.saveFcmRegistrationInfo(fcmRegistrationInfo);
            } else {
                notificationRepository.updateFcmRegistrationInfo(fcmRegistrationInfo);
            }
            try {
//            sendSms.createSoapClient(user.getMobileNumber(), id, generatedOtp);
                return String.valueOf(generatedOtp);
            } catch (Exception e) {
                throw new SmsSendingException("Error while sending sms");

            }

        }
    }

    @Override
    public void updateStatus(String mobileNumber, String email, boolean isUser) {
        User user = new User();
        user.setMobileNumber(mobileNumber);
        user.setEmail(email);
        if (isUser) {
            List<RegisteredUserDetails> userDetails = userDetailsRepository.getUserDetailsForStatusUpdate(user,StatusType.INACTIVE.get());
            if (userDetails.isEmpty()) {
                throw new UserNotFoundException("user does't exist in our db");
            } else {
                List<RegisteredUserDetails> alreadyPresentUsersForSamePhnNumber = userDetailsRepository.getUserDetails(user);
                for (RegisteredUserDetails registeredUserDetails : alreadyPresentUsersForSamePhnNumber) {
                    if (!(registeredUserDetails.getEmail().equalsIgnoreCase(email))) {
                        userDetailsRepository.updateStatus(mobileNumber, registeredUserDetails.getEmail(), StatusType.BLOCKED.get());
                    } else {
                        userDetailsRepository.updateStatus(mobileNumber, email, StatusType.ACTIVE.get());
                    }
                }
            }
        } else {
            List<RegisteredPriestDetails> registeredPriestDetailsList = priestDetailsRepository.getPriestDeatilsAfterOTPConfirmation(user);
            if (registeredPriestDetailsList.isEmpty()) {
                throw new UserNotFoundException("priest does't exist in our db");

            } else {
                List<RegisteredPriestDetails> alreadyRegisteredPriestDetailsList = priestDetailsRepository.getPriestDeatilsAfterOTPConfirmation(user);
                for (RegisteredPriestDetails registeredPriestDetails : alreadyRegisteredPriestDetailsList) {
                    if (!(registeredPriestDetails.getPriestEmail().equalsIgnoreCase(email))) {
                        priestDetailsRepository.updateStatusofPriestAsActive(mobileNumber, email, StatusType.BLOCKED.get());
                    } else {
                        priestDetailsRepository.updateStatusofPriestAsActive(mobileNumber, email, StatusType.ACTIVE.get());
                    }

                }

            }
        }

    }

    @Override
    public String resetUserPassword(String email, String mobileNumber, boolean isUser) {
        User user = new User();
        user.setMobileNumber(mobileNumber);
        if (isUser) {
            List<RegisteredUserDetails> registeredUserDetailsList = userDetailsRepository.getActiveUserDetails(user);
            if (!registeredUserDetailsList.isEmpty()) {
                int flag = 0;
                for (RegisteredUserDetails registeredUserDetails : registeredUserDetailsList) {
                    if (registeredUserDetails.getEmail().equalsIgnoreCase(email)) {
                        int generatedOtp = generateRandomInteger();
//                SendSms sendSms = new SendSms();
//                try {
//                    sendSms.createSoapClient(mobileNumber,registeredUserDetailsList.get(0).getId(),generatedOtp);
//                } catch (Exception e) {
//                    throw new SmsSendingException("some service exception");
//                }
                        flag = 1;
                        return String.valueOf(generatedOtp);
                    }
                }
                if (flag == 0) {
                    throw new EmailIdMisMatchException("EmailId doesnot match");
                }

            }
            throw new UserNotFoundException("userId doesn't exist in db");
        }
        List<RegisteredPriestDetails> registeredPriestDetailsList = priestDetailsRepository.getPriestDetails(user);
        if (!registeredPriestDetailsList.isEmpty()) {
            int flag = 0;
            for (RegisteredPriestDetails registeredPriestDetails : registeredPriestDetailsList) {
                if (registeredPriestDetailsList.get(0).getPriestEmail().equalsIgnoreCase(user.getEmail())) {
                    int generatedOtp = generateRandomInteger();
//                SendSms sendSms = new SendSms();
//                try {
//                    sendSms.createSoapClient(mobileNumber,registeredPriestDetailsList.get(0).getId(),generatedOtp);
//                } catch (Exception e) {
//                    throw new SmsSendingException("some service exception");
//                }
                    flag = 1;
                    return String.valueOf(generatedOtp);
                }
            }
            if (flag == 0) {
                throw new EmailIdMisMatchException("EmailId doesnot match");
            }

        }
        throw new PriestNotFoundException("priest doesn't exist in db");

    }

    @Override
    public void updateUserPassword(User user) {
        if (user.isUser()) {
            List<RegisteredUserDetails> registeredUserDetailsList = userDetailsRepository.getActiveUserDetails(user);
            if (!registeredUserDetailsList.isEmpty()) {
                int flag = 0;
                for (RegisteredUserDetails registeredUserDetails : registeredUserDetailsList) {

                    if (registeredUserDetails.getEmail().equals(user.getEmail())) {
                        userDetailsRepository.updateUserPassword(user);
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    throw new EmailIdMisMatchException("EmailId doesn't match ");
                }

            } else throw new UserNotFoundException("userId doesn't exist in db");
        } else {
            List<RegisteredPriestDetails> registeredPriestDetailsList = priestDetailsRepository.getPriestDetails(user);
            if (!registeredPriestDetailsList.isEmpty()) {
                int flag = 0;
                for (RegisteredPriestDetails registeredPriestDetails : registeredPriestDetailsList) {
                    if (registeredPriestDetails.getPriestEmail().equals(user.getEmail())) {
                        priestDetailsRepository.updatePriestPassword(user);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    throw new EmailIdMisMatchException("EmailId doesn't match ");
                }

            } else throw new PriestNotFoundException("priest doesn't exist in db");
        }
    }

    private int generateRandomInteger() {

        Random randomGenerator = new Random();
        int randomInt = 0;
        randomInt = randomGenerator.nextInt(89999) + 100000;
        return randomInt;
    }
}
