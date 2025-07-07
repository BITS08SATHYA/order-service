package com.ecommerce.order.dtos;

import lombok.*;

import java.math.BigDecimal;

/**
 * DTO for {@link com.app.ecom.model.OrderItem}
 */

@Getter
@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO  {
    private Long id;
    private String productId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;
}