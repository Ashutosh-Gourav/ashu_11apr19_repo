package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.PoojaDetails;
import com.pojo.service.domain.model.PoojaItems;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PoojaDetailsRowMapper implements RowMapper {
    @Override
    public PoojaDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        PoojaDetails poojaDetails = new PoojaDetails();
        poojaDetails.setId(rs.getInt("id"));
        poojaDetails.setName(rs.getString("name"));
        poojaDetails.setProcedure(rs.getString("procedure"));
        poojaDetails.setImportance(rs.getString("importance"));
        poojaDetails.setCost(rs.getFloat("cost"));
        poojaDetails.setAvgDuration(rs.getString("avgDuration"));
        String poojaItemsAsString = rs.getString("poojaItems");
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<PoojaItems> poojaItemsList = mapper.readValue(poojaItemsAsString, mapper.getTypeFactory().constructCollectionType(List.class, PoojaItems.class));
            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            poojaDetails.setPoojaItems(poojaItemsList);
        }
        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        return poojaDetails;

    }
}
