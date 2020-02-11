package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.PojoException;
import com.pojo.service.domain.model.PriestManagerRepository;
import com.pojo.service.domain.model.RegisteredPriestDetails;
import com.pojo.service.domain.model.User;
import com.pojo.service.infrastructure.sql.KeyHolderFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PriestManagerRepositoryImpl implements PriestManagerRepository {

    @Resource
    private KeyHolderFactory keyHolderFactory;

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Resource
    private RowMapper<RegisteredPriestDetails> priestDetailsRowMapper;

    private static final String SELECT_PRIEST_DETAILS="select * from g4o_priest where phoneNumber =:phoneNumber";

    private static final String SELECT_ACTIVE_AND_VERIFIED_PRIEST ="select * from g4o_priest where phoneNumber =:phoneNumber and priestEmail = :email and status = 'active' and isVerified = 1";

    private static final String INSERT_PRIEST_DETAILS="insert into g4o_priest ( name,phoneNumber,address,registeredLatitude,registeredLongitude,status,priestEmail) values" +
            "(:name,:phoneNumber,:address,:registeredLatitude,:registeredLongitude,'pending',:priestEmail)";
    private static final String UPDATE_PRIEST_RECORD="update g4o_priest SET name= :name,phoneNumber=:phoneNumber, address=:address,registeredLatitude=:registeredLatitude,registeredLongitude=:registeredLongitude," +
            "priestEmail=:priestEmail where phoneNumber=:phoneNumber";

    private static final String UPDATE_PRIEST_LAST_SEEN_LOCATION = "update  g4o_priest SET lastSeenLatitude = :lastSeenLatitude ,lastSeenLongitude=:lastSeenLongitude where phoneNumber =:id and status =''active' and isVerified ='true'";
    @Override
    public List<RegisteredPriestDetails> getPriestManagerDetails(User user) {
        List<RegisteredPriestDetails> registeredPriestDetailsList=namedParameterJdbcTemplate.query(SELECT_PRIEST_DETAILS,new MapSqlParameterSource("phoneNumber",user.getMobileNumber()),priestDetailsRowMapper);
        return registeredPriestDetailsList;
    }

    @Override
    public void savePriestDetails(User user) {
        KeyHolder keyHolder = keyHolderFactory.create();

        namedParameterJdbcTemplate.update(INSERT_PRIEST_DETAILS,createInsertSource(user),keyHolder);
    }
    @Override
    public void updatePriestDetails(User user) {
        namedParameterJdbcTemplate.update(UPDATE_PRIEST_RECORD,createInsertSource(user));
    }

    @Override
    public void updatePriestLastSeenLocation(int id, float lastSeenLatitude, float lastSeenLongitude) {
        namedParameterJdbcTemplate.update(UPDATE_PRIEST_LAST_SEEN_LOCATION,updateSQLSource(id, lastSeenLatitude, lastSeenLongitude));
    }

    @Override
    public List<RegisteredPriestDetails> getRegisteredPriestInfo(String priestMobile, String priestEmail) {
        List<RegisteredPriestDetails> registeredPriestDetails = null;

        try{
            registeredPriestDetails = namedParameterJdbcTemplate.query(SELECT_ACTIVE_AND_VERIFIED_PRIEST,createActivePriestSource(priestEmail,priestMobile),priestDetailsRowMapper);
        }catch (Exception e){
          throw new PojoException(" Some db Error occured:::::");
        }
        return registeredPriestDetails;
    }

    private SqlParameterSource createActivePriestSource(String priestEmail, String priestMobile) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("email",priestEmail);
        source.addValue("phoneNumber",priestMobile);
        return source;
    }

    private SqlParameterSource updateSQLSource(int id, float lastSeenLatitude, float lastSeenLongitude) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id",id);
        source.addValue("lastSeenLatitude",lastSeenLatitude);
        source.addValue("lastSeenLongitude",lastSeenLongitude);
        return source;
    }

    private SqlParameterSource createInsertSource(User user) {

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("priestEmail",user.getEmail());
        sqlParameterSource.addValue("name",user.getName());
        sqlParameterSource.addValue("phoneNumber",user.getMobileNumber());
        sqlParameterSource.addValue("address",user.getRegisteredAddress());
//        sqlParameterSource.addValue("deviceId",user.getDeviceId());
        sqlParameterSource.addValue("registeredLatitude",user.getRegisteredLatitude());
        sqlParameterSource.addValue("registeredLongitude",user.getRegisteredLongitude());
        return sqlParameterSource;
    }


}
