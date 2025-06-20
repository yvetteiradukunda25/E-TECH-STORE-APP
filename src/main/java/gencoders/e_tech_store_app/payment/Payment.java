package gencoders.e_tech_store_app.payment;

import gencoders.e_tech_store_app.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    // Relationship to Order
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Enum for payment method
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    // Amount paid
    @Column(nullable = false)
    private BigDecimal amount;

    // Date and time of payment
    @Column(nullable = false)
    private LocalDateTime paymentDate;

    // Status of the payment
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;
}

