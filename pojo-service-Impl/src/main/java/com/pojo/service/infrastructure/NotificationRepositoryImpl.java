package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.FcmRegistrationInfo;
import com.pojo.service.domain.model.NotificationRepository;
import com.pojo.service.domain.model.PojoException;
import com.pojo.service.infrastructure.sql.KeyHolderFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gourava on 1/20/17.
 */
public class NotificationRepositoryImpl implements NotificationRepository {

    @Resource
    private KeyHolderFactory keyHolderFactory;

    @Resource
    private NamedParameterJdbcOperations namedParameterJdbcTemplate;

    @Resource
    private RowMapper<FcmRegistrationInfo> fcmRegistrationInfoRowMapper;

    private static final String INSERT_FCM_REGISTRATION_DETAILS = "insert into fcmRegistrationTable(fcmRegistrationToken,deviceId,personId,isUser) values (:fcmRegistrationToken,:deviceId,:personId,:isUser)";
    private static final String SELECT_FCM_REGISTRATION_INFO="select * from fcmRegistrationTable where deviceId=:deviceId";
    private static final String UPDATE_FCM_REGISTRATION_INFO="update fcmRegistrationTable SET fcmRegistrationToken = :fcmRegistrationToken,deviceId = :deviceId, personId =:personId,isUser =:isUser where deviceId =:deviceId ";


    @Override
    public void saveFcmRegistrationInfo(FcmRegistrationInfo fcmRegistrationInfo) {
        KeyHolder keyHolder = keyHolderFactory.create();
        try{
            namedParameterJdbcTemplate.update(INSERT_FCM_REGISTRATION_DETAILS,createInsertSource(fcmRegistrationInfo),keyHolder);
        }catch (Exception e){
            throw  new PojoException("DB insertion error",e.getCause());
        }
    }

    @Override
    public List<FcmRegistrationInfo> getRegistrationInfo(String deviceId) {

        List<FcmRegistrationInfo> registrationInfo = namedParameterJdbcTemplate.query(SELECT_FCM_REGISTRATION_INFO,new MapSqlParameterSource("deviceId",deviceId),fcmRegistrationInfoRowMapper);
        return registrationInfo;
    }

    @Override
    public void updateFcmRegistrationInfo(FcmRegistrationInfo fcmRegistrationInfo) {
        try{
            namedParameterJdbcTemplate.update(UPDATE_FCM_REGISTRATION_INFO,createInsertSource(fcmRegistrationInfo));

        }catch (Exception e){
            throw new PojoException("DB update error",e.getCause());
        }
    }


    private SqlParameterSource createInsertSource(FcmRegistrationInfo fcmRegistrationInfo) {

        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("fcmRegistrationToken", fcmRegistrationInfo.getFcmRegistrationToken());
        source.addValue("deviceId",fcmRegistrationInfo.getDeviceId());
        source.addValue("personId",fcmRegistrationInfo.getPersonId());
        source.addValue("isUser",fcmRegistrationInfo.isUser());
        return source;
    }

}
