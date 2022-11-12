package com.promineotech.jeep.entity;

import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class Order {
  private Long orderPK;
  private Customer customer;
  private Jeep model;
  private JeepModel modelId;
  private JeepModel NumDoors;
  private JeepModel trimLevels;
  private Color colorId;
  private Engine engineId;
  private Tire tireId;
  private List<Option> options;
  private BigDecimal price;
  public Object getCustomer() {
    // TODO Auto-generated method stub
    return null;
  }
  public static Object builder() {
    // TODO Auto-generated method stub
    return null;
  }
  
 
}