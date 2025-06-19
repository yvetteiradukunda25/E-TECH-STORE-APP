package gencoders.e_tech_store_app.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private BigDecimal totalAmount;
    private String shippingAddress;
    private String status;
    private String paymentStatus;

}