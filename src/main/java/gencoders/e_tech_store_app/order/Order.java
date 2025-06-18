package gencoders.e_tech_store_app.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name ="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long user_id; //FK to User

    private BigDecimal totalAmount;

    private String shippingAddress;

    @Column(nullable = false)
    private LocalDateTime orderDate;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<OrderItem> orderItems;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "payment_status", nullable = false)

//    private PaymentStatus paymentStatus;


}