package com.promineotech.jeep.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.jboss.logging.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Option;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Service
@RestController
public class DefaultJeepSalesDao implements JeepSalesDao {
  /**
   * @param option
   * @param orderPK
   * @return
   */

@Autowired
private NamedParameterJdbcTemplate jdbcTemplate;

@Override
public List<Jeep> fetchJeeps(JeepModel model, String trim) {
  
  BasicLogger log = null;
  log.debug("DAO:model ={}, trim ={}", model, trim);
 
  // formatter: Off
  String sql = ""
      + " SELECT * "
      + " FROM models"
      + " WHERE model_id = : model_id AND trim_level = :trim_level";
  // formatter : On
  
  Map<String,Object> params = new HashMap<>();
  params.put("model_id", model.toString());
  params.put("trim_level", trim);

 return jdbcTemplate.query(sql, params, new RowMapper<>() {

    @Override
 public Jeep mapRow(ResultSet rs, int rowNum) throws SQLException {
      // formatter: Off
 return Jeep.builder()
      .basePrice(new BigDecimal(rs.getString("base_price")))
       .modelId(JeepModel.valueOf(rs.getString("model_id")))
       .modelPk(rs.getLong("model_pk"))
       .numDoors(rs.getInt("num_doors"))
       .trimLevel(rs.getString("trim_level"))
        .wheelSize(rs.getInt("wheel_size"))
         .build();
      
   //formatter:On  
         

    
 
 }
 }






  








@Override
public Optional<Jeep> fetchModel(JeepModel model, String trim, int doors) {
  // TODO Auto-generated method stub
  return Optional.empty();
}

@Override
public Optional<Customer> fetchCustomer(String customerId) {
  // TODO Auto-generated method stub
  return Optional.empty();
}

@Override
public List<Option> fetchOptions(List<String> optionIds) {
  // TODO Auto-generated method stub
  return null;
}

@Override
public Jeep mapRow(ResultSet rs, int rowNum) throws SQLException {
  // TODO Auto-generated method stub
  return null;
}