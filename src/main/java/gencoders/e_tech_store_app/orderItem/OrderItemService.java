package gencoders.e_tech_store_app.orderItem;


import gencoders.e_tech_store_app.product.Product;
import gencoders.e_tech_store_app.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;



import gencoders.e_tech_store_app.order.Order;
import gencoders.e_tech_store_app.order.OrderRepository;


@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemService(OrderItemRepository orderItemRepository,
                            OrderRepository orderRepository,
                            ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderItem createOrderItem(OrderItemDto dto) {

        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));


        OrderItem item = new OrderItem();
        item.setQuantity(dto.getQuantity());
        item.setPrice_at_purchase(dto.getPrice_at_purchase());
        item.setOrder(order);

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        item.setProduct(product); // 👈 Sets product_id foreign key

        return orderItemRepository.save(item);
    }

    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem findOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public OrderItem updateOrderItem(Long id, OrderItemDto dto) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        orderItem.setQuantity(dto.getQuantity());
        orderItem.setPrice_at_purchase(dto.getPrice_at_purchase());

        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItemById(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new RuntimeException("OrderItem not found");
        }
        orderItemRepository.deleteById(id);
    }
}
