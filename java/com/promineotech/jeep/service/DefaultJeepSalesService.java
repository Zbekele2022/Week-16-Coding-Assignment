package com.promineotech.jeep.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
//import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.dao.JeepSalesDao;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import lombok.extern.slf4j.Slf4j;

@Service
@RestController
@Slf4j
public class DefaultJeepSalesService  implements JeepSalesService {

@Autowired
private JeepSalesDao jeepSalesDao;


@Transactional(readOnly = true) 
@Override
public List<Jeep> fetchJeeps(JeepModel model,String trim) {
log.info("The fetchjeeps method was called with model = {} and trim = {}", model,trim);

List<Jeep> jeeps = jeepSalesDao.fetchJeeps(model, trim);
Collections.sort(jeeps);
 if(jeeps.isEmpty()) {
  String msg= String.format("No Jeeps found with model=%s and trim =%s", 
  model,trim);
  
  throw new NoSuchElementException(msg);
}
return jeeps;

}
  
}
