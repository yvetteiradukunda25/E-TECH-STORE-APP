package gencoders.e_tech_store_app.orderItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private int quantity;
    private BigDecimal price_at_purchase;
    private Long orderId;
    private Long productId;
}
