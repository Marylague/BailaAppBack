package ru.appBaila.controllers;


import ru.appBaila.models.dto.CartDto;
import ru.appBaila.models.entitys.User;
import ru.appBaila.services.CartService;
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
@RequestMapping("api/cart")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class CartController {
    private final CartService service;
    private final SecurityService securityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("@securityService.hasAdminRole")
    public CartDto create(@RequestBody CartDto cart) {
        // checks
        User currentUser = securityService.getCurrentUserInfo();
        return service.save(cart, currentUser);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@securityService.hasAdminRole")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/entity")
    @PreAuthorize("@securityService.hasAdminRole")
    public void deleteByEntity(@RequestBody CartDto cart) {
        service.deleteByEntity(cart);
    }

    @PutMapping()
    @PreAuthorize("@securityService.hasAdminRole")
    public CartDto update(@RequestBody CartDto dto) {
        //checks
        User currentUser = securityService.getCurrentUserInfo();
        return service.save(dto, currentUser);
    }

    @GetMapping("/{id}")
    public CartDto getById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/entity")
    public CartDto getByEntity(@RequestBody CartDto cart){return service.getByEntity(cart);}
}

