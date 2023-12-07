package com.app.purna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
