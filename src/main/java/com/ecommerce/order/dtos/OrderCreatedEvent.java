package com.ecommerce.order.dtos;


import com.ecommerce.order.models.OrderStatus;
import lombok.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter@Setter@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {


    private Long orderId;
    private String userId;
    private OrderStatus status;
    private List<OrderItemDTO> items;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;

}
