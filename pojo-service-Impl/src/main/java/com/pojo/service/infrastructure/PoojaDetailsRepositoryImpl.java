package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.PoojaDetails;
import com.pojo.service.domain.model.PoojaDetailsRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PoojaDetailsRepositoryImpl implements PoojaDetailsRepository {

    @Resource
    private NamedParameterJdbcOperations namedParameterJdbcTemplate;

    @Resource
    private RowMapper<PoojaDetails> poojaDetailsRowMapper;

    private static final String SELECT_POOJADETAILS ="select * from g4o_poojaDetails";

    @Override
    public List<PoojaDetails> getAllPoojaDetails() {

        List<PoojaDetails> poojaDetailsList;
        poojaDetailsList =namedParameterJdbcTemplate.query(SELECT_POOJADETAILS,poojaDetailsRowMapper);
        return poojaDetailsList;
    }
}
