package gencoders.e_tech_store_app.order;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Api/Orders")  // Base path
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public Order create(@RequestBody OrderDto dto) {
        return orderService.createOrder(dto);
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
    public Order update(@PathVariable Long id, @RequestBody OrderDto dto) {
        return orderService.updateOrder(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteOrderById(@PathVariable long id) {
        orderService.deleteOrderById(id);
    }
}
