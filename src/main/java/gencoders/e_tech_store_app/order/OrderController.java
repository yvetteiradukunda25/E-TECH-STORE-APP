package gencoders.e_tech_store_app.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Api/Order")

public class OrderController {
    private final OrderService orderService;

    @PostMapping("/Api/create")
    public Order createPatient(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setUser_id(orderDto.getUser_id());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setShippingAddress(orderDto.getShippingAddress());
        order.setStatus(OrderStatus.valueOf(orderDto.getStatus()));
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> findAllPatient() {
        return orderService.findAllOrders();
    }

    @GetMapping("/api/{id}")
    public Order findOrderById(@PathVariable long id) {
        return orderService.findOrderById(id);

    }


    @PutMapping("api/update/{id}")

    public Order updateOrder(@PathVariable long id, @RequestBody OrderDto orderDto) {
        Order order = orderService.findOrderById(id);
        order.setUser_id(orderDto.getUser_id());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setShippingAddress(orderDto.getShippingAddress());
        order.setStatus(OrderStatus.valueOf(orderDto.getStatus()));
        return orderService.updateOrder(id, orderDto);
    }


    @DeleteMapping("/Api/delete/{id}")
    public void deleteOrderById(@PathVariable long id) {
        orderService.deleteOrderById(id);
    }
}
