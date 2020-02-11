package com.pojo.service.api.v1.pojo;

import com.pojo.service.application.PoojaDetailsApplication;
import com.pojo.service.domain.model.PoojaDetails;
import com.pojo.service.domain.model.PoojaItems;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PoojaDetailsApiImpl implements com.pojo.service.api.v1.pojo.PoojaDetailsApi {

    @Resource
    private PoojaDetailsApplication poojaDetailsApplication;

    @Override
    public List<com.pojo.service.api.v1.pojo.PoojaDetailsResponse>  getpoojaDetails() {

        List<PoojaDetails> poojaDetailsList = poojaDetailsApplication.getPoojaDetails();
        List<com.pojo.service.api.v1.pojo.PoojaDetailsResponse> poojaDetailsResponseList = new ArrayList<>();
        List<PoojaItems> poojaItemsList;

        for (PoojaDetails poojaDetails : poojaDetailsList) {
            com.pojo.service.api.v1.pojo.PoojaDetailsResponse poojaDetailsResponse = new com.pojo.service.api.v1.pojo.PoojaDetailsResponse();
            poojaDetailsResponse.setName(poojaDetails.getName());
            poojaDetailsResponse.setProcedure(poojaDetails.getProcedure());
            poojaDetailsResponse.setImportance(poojaDetails.getImportance());
            poojaDetailsResponse.setAvgDuration(poojaDetails.getAvgDuration());
            poojaDetailsResponse.setCost(poojaDetails.getCost());
            poojaDetailsResponse.setId(poojaDetails.getId());
            poojaItemsList = poojaDetails.getPoojaItems();
            List<com.pojo.service.api.v1.pojo.PoojaItemInResponse> poojaItemInResponseList = new ArrayList<>();
            for (PoojaItems poojaItem : poojaItemsList) {
                com.pojo.service.api.v1.pojo.PoojaItemInResponse poojaItemInResponse = new com.pojo.service.api.v1.pojo.PoojaItemInResponse();
                poojaItemInResponse.setName(poojaItem.getName());
                poojaItemInResponse.setQuantity(poojaItem.getQuantity());
                poojaItemInResponseList.add(poojaItemInResponse);
                poojaDetailsResponse.setPoojaItems(poojaItemInResponseList);

            }
            poojaDetailsResponseList.add(poojaDetailsResponse);
        }
        return poojaDetailsResponseList;
    }
}
