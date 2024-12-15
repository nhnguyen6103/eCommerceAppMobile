package javaproject.server.repositories;

import javaproject.server.entities.Order;
import javaproject.server.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem,String> {
    List<OrderItem> findOrderItemsByOrder(Order order);
    void deleteByOrder (Order order);
}
