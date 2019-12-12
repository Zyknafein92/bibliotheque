package com.bibliotheque.usermicroservice.service.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Data
@Getter
@Setter
public class UserDTO {

  //  @NotNull
  // @Valid
  // @Size(min=5, max=50, message = "First name should not have value outside 5-50")
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String phone;
    private String email;
    private String address;
    private String postalCode;
    private String city;

}
