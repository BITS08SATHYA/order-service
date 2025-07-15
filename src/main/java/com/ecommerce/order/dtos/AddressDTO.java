package com.ecommerce.order.dtos;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.app.ecom.model.Address}
 */
@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO implements Serializable {
    Long id;
    String street;
    String city;
    String state;
    String country;
    String zipcode;
}
