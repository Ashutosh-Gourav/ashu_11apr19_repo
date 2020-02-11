package com.pojo.service.domain.services;


import com.pojo.service.domain.services.sendsms.wsdl.clients.APILocator;
import com.pojo.service.domain.services.sendsms.wsdl.clients.APISoap_PortType;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SendSms {


    public void createSoapClient(String number,int customerId,int otp) throws ServiceException, MalformedURLException {
        APILocator apiLocator = new APILocator();
//        APILocator apiLocator = new APILocator();

        APISoap_PortType api = null;
        URL remoteServiceURL = new URL(" http://www.mymobileapi.com/api5/api.asmx");
        api = apiLocator.getAPISoap(remoteServiceURL);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            sb.append("<senddata>");
            sb.append("<settings>");
            sb.append("<live>"+true+"</live>");
            sb.append("<return_credits>"+true+"</return_credits>");
            sb.append("<return_msgs_credits_used>"+true+"</return_msgs_credits_used>");
            sb.append("<return_msgs_success_count>"+true+"</return_msgs_success_count>");
            sb.append("<return_msgs_failed_count>"+true+"</return_msgs_failed_count>");
            sb.append("<return_entries_success_status>"+true+"</return_entries_success_status>");
            sb.append("<return_entries_failed_status>" + true + "</return_entries_failed_status>");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            sb.append("<default_date>"+sdf.format(System.currentTimeMillis())+"</default_date>");
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
            sb.append("<default_curtime>"+sdf1.format(cal.getTime()) +"</default_curtime>");
            sb.append("<default_time>"+12+":"+30+"</default_time>");
            sb.append("<default_data1>Pooja Pandit Default Message</default_data1>");
            sb.append("<default_flash>"+false+"</default_flash>");
            sb.append("<default_type>SMS</default_type>");
            sb.append("<default_costcentre>NA</default_costcentre>");
            sb.append("<default_validityperiod>0</default_validityperiod>");
            sb.append("</settings>");
            sb.append("<entries>");
            sb.append("<numto>"+"91"+number+"</numto>");
            sb.append("<customerid>"+customerId+"</customerid>");
            sb.append("<senderid></senderid>");
            sb.append("<time>"+sdf1.format(cal.getTime())+"</time>");
            sb.append("<data1>"+otp+"</data1>");
            sb.append("<type>SMS</type>");
            sb.append("<costcentre>NA</costcentre>");
            sb.append("<validityperiod>0</validityperiod>");
            sb.append("</entries>");
            sb.append("</senddata>");
            String result =  api.send_STR_STR("vidhivirmani_IND","vidhi1234", String.valueOf(sb));
            System.out.println("result"+ result);
        } catch (Exception e) {
            throw new  RuntimeException();
            }

        System.out.println(remoteServiceURL);
    }
//    public static void main(String[] args) throws MalformedURLException, ServiceException {
////        SendSms sendSms = new SendSms();
//        String number = "9108679358";
//        System.out.println("91"+number);
////        sendSms.createSoapClient("919108679358",123455,1111);
//    }

}