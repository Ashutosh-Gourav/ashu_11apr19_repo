package com.pojo.service.application;


import com.pojo.service.domain.model.PoojaDetails;
import com.pojo.service.domain.model.PoojaDetailsRepository;

import javax.annotation.Resource;
import java.util.List;

public class PoojaDetailsApplicationImpl implements PoojaDetailsApplication {

    @Resource
    private PoojaDetailsRepository poojaDetailsRepository;
    @Override
    public List<PoojaDetails> getPoojaDetails() {
        List<PoojaDetails>  poojaDetailsList = poojaDetailsRepository.getAllPoojaDetails();

        return poojaDetailsList;
    }
}
