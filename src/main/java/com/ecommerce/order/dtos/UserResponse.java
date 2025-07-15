package com.ecommerce.order.dtos;

import lombok.*;

@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role = UserRole.CUSTOMER;
    private AddressDTO address;
}
