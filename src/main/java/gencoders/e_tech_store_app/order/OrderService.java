package gencoders.e_tech_store_app.order;

import gencoders.e_tech_store_app.payment.PaymentStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDto dto) {
    Order order = new Order();
    order.setTotalAmount(dto.getTotalAmount());
    order.setShippingAddress(dto.getShippingAddress());
    order.setStatus(OrderStatus.valueOf(dto.getStatus().toUpperCase()));
    order.setPaymentStatus(PaymentStatus.valueOf(dto.getPaymentStatus().toUpperCase()));
        return orderRepository.save(order);
    }

    public List<Order> findAllOrders() {

        return orderRepository.findAll();
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order ID " + id + " not found"));
    }


    public Order updateOrder(Long id, OrderDto dto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order ID " + id + " not found"));

        order.setTotalAmount(dto.getTotalAmount());
        order.setShippingAddress(dto.getShippingAddress());
        order.setStatus(OrderStatus.valueOf(dto.getStatus().toUpperCase()));
        order.setPaymentStatus(PaymentStatus.valueOf(dto.getPaymentStatus().toUpperCase()));


        return orderRepository.save(order);
    }


    public void deleteOrderById(long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order ID " + id + " not found"));

        orderRepository.delete(order);
    }

}
