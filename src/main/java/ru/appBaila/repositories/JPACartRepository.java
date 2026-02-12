package ru.appBaila.repositories;

import ru.appBaila.models.entitys.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPACartRepository extends JpaRepository<Cart, Long> {
}
