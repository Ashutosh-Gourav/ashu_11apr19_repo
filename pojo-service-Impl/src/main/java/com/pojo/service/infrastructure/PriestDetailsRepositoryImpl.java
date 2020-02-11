package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.PojoException;
import com.pojo.service.domain.model.PriestDetailsRepository;
import com.pojo.service.domain.model.RegisteredPriestDetails;
import com.pojo.service.domain.model.User;
import com.pojo.service.infrastructure.sql.KeyHolderFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PriestDetailsRepositoryImpl implements PriestDetailsRepository {
    @Resource
    private NamedParameterJdbcOperations namedParameterJdbcTemplate;

    @Resource
    private KeyHolderFactory keyHolderFactory;

    @Resource
    private RowMapper<RegisteredPriestDetails> priestDetailsRowMapper;


    private static final String SELECT_ACTIVE_PRIETDETAILS="select * from  g4o_priest where phoneNumber =:mobileNumber and status=:status and isVerified=1";
    private static final String SELECT_ACTIVE_PRIETDETAILS_AFTER_OTP_CONFIRMATION ="select * from  g4o_priest where phoneNumber =:mobileNumber and status='pending' and priestEmail =:email";
    private static final String UPDATE_PRIEST_STATUS_AFTER_OTP_CONFIRMATION="update g4o_priest SET status =:status where phoneNumber=:phoneNumber and email =:email";
    private static final String UPDATE_PASSWORD_PRIEST="UPDATE g4o_priest SET priestPassword=:password where phoneNumber =:mobileNumber and priestEmail = :email and status = :status";

    @Override
    public List<RegisteredPriestDetails> getPriestDetails(User user) {
        List<RegisteredPriestDetails> registeredUserDetailsList =namedParameterJdbcTemplate.query(SELECT_ACTIVE_PRIETDETAILS,insertStatussource(user.getMobileNumber()),priestDetailsRowMapper);
        return registeredUserDetailsList;
    }

    @Override
    public List<RegisteredPriestDetails> getPriestDeatilsAfterOTPConfirmation(User user) {
        List<RegisteredPriestDetails> registeredUserDetailsList =namedParameterJdbcTemplate.query(SELECT_ACTIVE_PRIETDETAILS_AFTER_OTP_CONFIRMATION,selectActiveandVefifiedPriestsource(user.getMobileNumber(), user.getEmail()),priestDetailsRowMapper);
        return registeredUserDetailsList;

    }

    @Override
    public void updateStatusofPriestAsActive(String mobileNumber, String email,String status) {
        namedParameterJdbcTemplate.update(UPDATE_PRIEST_STATUS_AFTER_OTP_CONFIRMATION,createUpdateSourceAfterOtpConfirmation(mobileNumber,email,status));
    }

    @Override
    public void updatePriestPassword(User user) {
        try{
            namedParameterJdbcTemplate.update(UPDATE_PASSWORD_PRIEST,createUpdateSourceAfterOtpConfirmation(user.getMobileNumber(),user.getEmail(),user.getPassword()));

        }catch (Exception e){
            throw new PojoException("Some DB update error occoured",e.getCause());
        }

    }

    private SqlParameterSource createUpdateSourceAfterOtpConfirmation(String mobileNumber, String email,String status) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("phoneNumber",mobileNumber);
        source.addValue("email",email);
        source.addValue("status",status);
        return source;
    }

    private SqlParameterSource createUpdateSourceAfterPasswordChange(String mobileNumber, String email,String password) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("phoneNumber",mobileNumber);
        source.addValue("email",email);
        source.addValue("password",password);

        source.addValue("status","active");
        return source;
    }
    private SqlParameterSource selectActiveandVefifiedPriestsource(String mobileNumber, String email) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("mobileNumber",mobileNumber);
        source.addValue("email",email);
        return source;
    }

    private SqlParameterSource insertStatussource(String mobileNumber) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("status","active");
        source.addValue("mobileNumber",mobileNumber);
        return source;

    }

}
