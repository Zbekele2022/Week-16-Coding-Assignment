package com.promineotech.jeep.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Option {
  private Long optionPK;
  private String optionId;
  private OptionType category;
  private String manufacturer;
  private String name;
  private BigDecimal price;
  public BigDecimal getOption() {
    // TODO Auto-generated method stub
    return null;
  }
  public Object getOptionPK() {
    // TODO Auto-generated method stub
    return null;
  }
  public static Object builder() {
    // TODO Auto-generated method stub
    return null;
  }
 
 
}