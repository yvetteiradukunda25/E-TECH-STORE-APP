package gencoders.e_tech_store_app.orderItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    OrderItem deleteOrderItemById(Long id);
}
