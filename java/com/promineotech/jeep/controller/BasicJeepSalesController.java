package com.promineotech.jeep.controller;


import java.util.List;
import org.hibernate.validator.internal.util.logging.Log;
import org.jboss.logging.BasicLogger;
//import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.service.JeepSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicJeepSalesController implements JeepSalesController {

  @Autowired
  private JeepSalesService jeepSalesService;

  @Override
  public List<Jeep> fetchJeeps(JeepModel model, String trim) {
    BasicLogger log = null;
    //by default Spring logs by info not debug 
    log.debug("model ={}, trim ={}");
    return jeepSalesService.fetchJeeps(model, trim);

  }
}
