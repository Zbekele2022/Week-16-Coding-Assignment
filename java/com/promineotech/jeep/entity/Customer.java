package com.promineotech.jeep.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class Customer {
  private Long customerPK;
  private String customerId;
  private String firstName;
  private String lastName;
  private String phone;
  public Object getCustomerPK() {
    // TODO Auto-generated method stub
    return null;
  }
 
  
  }
 
