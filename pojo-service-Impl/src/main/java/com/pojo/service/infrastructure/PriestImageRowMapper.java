package com.pojo.service.infrastructure;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.codec.Base64;

import javax.xml.bind.DatatypeConverter;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PriestImageRowMapper implements RowMapper {
    @Override
    public String mapRow(ResultSet rs, int rowNum) throws SQLException {

        Blob b= rs.getBlob("panditImage");
        String photo64 = null ;
        if(b!=null){
            byte[] ba = b.getBytes(1, (int)b.length());
            byte[] img64 = Base64.encode(ba);
            photo64= DatatypeConverter.printBase64Binary(img64);
            return photo64;
        }


        return "No Image";
    }
}
