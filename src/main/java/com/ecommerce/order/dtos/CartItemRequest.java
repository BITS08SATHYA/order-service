package com.ecommerce.order.dtos;


import lombok.*;

@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItemRequest {

    private String productId;
    private Integer quantity;

}
