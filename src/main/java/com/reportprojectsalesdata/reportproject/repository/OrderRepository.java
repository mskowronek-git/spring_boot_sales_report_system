package com.reportprojectsalesdata.reportproject.repository;

import com.reportprojectsalesdata.reportproject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderTrackingNumber(String orderTrakckingNumber);
}
