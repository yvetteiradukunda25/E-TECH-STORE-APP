package gencoders.e_tech_store_app.orderItem;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private long order_id; //	FK to orders
    private long product_id; //	FK to products
    private int quantity;
    private BigDecimal price_at_purchase;
}
