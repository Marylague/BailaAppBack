package ru.appBaila.services;

import ru.appBaila.exceptions.OrderNotFoundException;
import ru.appBaila.models.dto.OrderDto;
import ru.appBaila.models.entitys.Order;
import ru.appBaila.models.entitys.User;
import ru.appBaila.repositories.JPAOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private final JPAOrderRepository repository;

    @Autowired
    public OrderService(JPAOrderRepository repository) {this.repository = repository;}

    public OrderDto save(OrderDto dto, User user) {
        return new OrderDto(repository.save(new Order(dto, user)));
    }

    public OrderDto getById(long id) {
        Optional<Order> toFind = repository.findById(id);
        if (toFind.isPresent()) {
            Order order = toFind.get();
            return new OrderDto(order);
        }
        throw new OrderNotFoundException("order with id " + id + "didn't exist");
    }

    public OrderDto getByEntity(OrderDto dto) {
        return getById(dto.getId());
    }

    public void deleteById(long id) {
        Optional<Order> toFind = repository.findById(id);
        if (toFind.isPresent()) {
            repository.deleteById(id);
            return;
        }
        throw new OrderNotFoundException("order with id " + id + "didn't exist");
    }

    public void deleteByEntity(OrderDto dto) {
        deleteById(dto.getId());
    }
}
