package ru.appBaila.services;

import ru.appBaila.models.dto.CartDto;
import ru.appBaila.models.entitys.Cart;
import ru.appBaila.models.entitys.User;
import ru.appBaila.repositories.JPACartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartService {
    private JPACartRepository repository;

    @Autowired
    public CartService(JPACartRepository repository) {this.repository = repository;}

    public CartDto save(CartDto dto, User user) {
        return new CartDto(repository.save(new Cart(dto, user)));
    }

    // update

    public CartDto getById(long id) {
        // + проверка
        return new CartDto(repository.getOne(id));
    }

    public CartDto getByEntity(CartDto dto) {
        return getById(dto.getId());
    }

    public void deleteById(long id) {
        // проверка на существование
        repository.deleteById(id);
    }

    public void deleteByEntity(CartDto dto) {
        deleteById(dto.getId());
    }

}
