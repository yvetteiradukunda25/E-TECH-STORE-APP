package gencoders.e_tech_store_app.order;

import gencoders.e_tech_store_app.payment.PaymentStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Api/Orders")  // Base path
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@Valid @RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setStatus(OrderStatus.valueOf(orderDto.getStatus()));
        order.setShippingAddress(orderDto.getShippingAddress());
        order.setPaymentStatus(PaymentStatus.valueOf(orderDto.getPaymentStatus().toUpperCase()));

        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable long id) {
        return orderService.findOrderById(id);
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable long id, @RequestBody OrderDto orderDto) {
        Order order = orderService.findOrderById(id);
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setShippingAddress(orderDto.getShippingAddress());
        order.setStatus(OrderStatus.valueOf(orderDto.getStatus()));

        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderById(@PathVariable long id) {
        orderService.deleteOrderById(id);
    }
}
