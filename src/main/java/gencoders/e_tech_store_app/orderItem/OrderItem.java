package gencoders.e_tech_store_app.orderItem;


import gencoders.e_tech_store_app.order.Order;
import gencoders.e_tech_store_app.product.Product;
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

    private int quantity;

    private BigDecimal price_at_purchase;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
}
