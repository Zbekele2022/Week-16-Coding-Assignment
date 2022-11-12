package com.promineotech.jeep.entity;

import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import lombok.Data;
import lombok.NonNull;

@Data
public class OrderRequest {
  @NotNull
  @Length(max = 30)
  @Pattern(regexp ="[A-Z_]*")
  private String customer;
  
  @NotNull
  private JeepModel model;
  
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp ="[\\W\\S]*")
  private String trim;
  
  @Positive
  @Min(2)
  @Max(4)
  private int doors;
  
  @NonNull
  @Length(max = 30)
  @Pattern(regexp ="[\\W\\S]*")
  private String color;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp ="[\\W\\S]*")
  private String engine;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp ="[\\W\\S]*")
  private String tire;
  
  public String getCustomer() {
    // TODO Auto-generated method stub
    return null;
  }
  public String getTrim() {
    // TODO Auto-generated method stub
    return null;
  }
  public JeepModel getModel() {
    // TODO Auto-generated method stub
    return null;
  }
  public int getNumDoors() {
    // TODO Auto-generated method stub
    return 0;
  }
 public String getColor() {
    // TODO Auto-generated method stub
    return null;
  }
  public String getEngine() {
    // TODO Auto-generated method stub
    return null;
  }
  public String getTire() {
    // TODO Auto-generated method stub
    return null;
  }
  public List<String> getOptions() {
    // TODO Auto-generated method stub
    return null;
  }
 
 
 
 
  
 
 
 

}