package ru.appBaila.controllers;

import ru.appBaila.models.dto.OrderDto;
import ru.appBaila.models.entitys.User;
import ru.appBaila.services.OrderService;
import ru.appBaila.services.SecurityService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class OrderController {
    private final OrderService service;
    private final SecurityService securityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("@securityService.hasAdminRole")
    public OrderDto create(@RequestBody OrderDto order) {
        User currentUser = securityService.getCurrentUserInfo();
        return service.save(order, currentUser);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@securityService.hasAdminRole")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/entity")
    @PreAuthorize("@securityService.hasAdminRole")
    public void deleteByEntity(@RequestBody OrderDto order) {
        service.deleteByEntity(order);
    }

    @PutMapping()
    @PreAuthorize("@securityService.hasAdminRole")
    public OrderDto update(@RequestBody OrderDto dto) {
        User currentUser = securityService.getCurrentUserInfo();
        return service.save(dto, currentUser);
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/entity")
    public OrderDto getByEntity(@RequestBody OrderDto order){return service.getByEntity(order);}
}