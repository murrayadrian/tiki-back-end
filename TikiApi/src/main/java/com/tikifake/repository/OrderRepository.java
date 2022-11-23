package com.tikifake.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tikifake.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
