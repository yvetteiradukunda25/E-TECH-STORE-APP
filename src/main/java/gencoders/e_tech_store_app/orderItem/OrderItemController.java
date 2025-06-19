package gencoders.e_tech_store_app.orderItem;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Api/OrderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping("/Api/create")
    public OrderItem createOrderItem(@RequestBody OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice_at_purchase(orderItemDto.getPrice_at_purchase());
        return orderItemService.createOrderItem(orderItemDto);
    }

    @GetMapping("/Api/Get All OrderItems")
    public List<OrderItem> findAllOrderItems() {
        return orderItemService.findAllOrderItems();
    }

    @GetMapping("/api/{id}")
    public OrderItem findOrderItemById(@PathVariable long id) {
        return orderItemService.findOrderItemById(id);

    }


    @PutMapping("api/update/{id}")

    public OrderItem updateOrderItem(@PathVariable long id, @RequestBody OrderItemDto orderItemDto) {
        OrderItem orderItem = orderItemService.findOrderItemById(id);
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice_at_purchase(orderItemDto.getPrice_at_purchase());

        return orderItemService.updateOrderItem(id, orderItemDto);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteOrderById(@PathVariable long id) {
        orderItemService.deleteOrderItemById(id);
    }
}

