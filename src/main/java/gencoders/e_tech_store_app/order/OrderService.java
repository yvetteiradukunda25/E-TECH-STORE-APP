package gencoders.e_tech_store_app.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {

        return orderRepository.save(order);
    }

    public List<Order> findAllOrders() {

        return orderRepository.findAll();
    }
    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    public Order updateOrder(Long id, OrderDto updatedOrder) {
        Order order = orderRepository.findById(id).orElse(null);new RuntimeException("User not found");
        order.setUser_id(updatedOrder.getUser_id());
        order.setTotalAmount(updatedOrder.getTotalAmount());
        order.setShippingAddress(updatedOrder.getShippingAddress());
        order.setStatus(OrderStatus.valueOf(updatedOrder.getStatus()));
        return orderRepository.save(order);
    }

    public void deleteOrderById(long id) {
        Order order = orderRepository.findById(id).orElseThrow(null);new RuntimeException("User not found");
        orderRepository.deleteById(id);
    }
}
