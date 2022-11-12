package com.promineotech.jeep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Option;

public interface JeepSalesDao {

  List<Jeep> fetchJeeps(JeepModel model, String trim);

  /**
   *
   */
  Optional<Jeep> fetchModel(JeepModel model, String trim, int doors);
  /**
   *
   */
  Optional<Customer> fetchCustomer(String customerId);

  /**
   *
   */
  List<Option> fetchOptions(List<String> optionIds);


  Jeep mapRow(ResultSet rs, int rowNum) throws SQLException;
}
