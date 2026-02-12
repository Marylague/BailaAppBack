package ru.appBaila.repositories;

import ru.appBaila.models.entitys.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAOrderRepository extends JpaRepository<Order, Long> {

}
