package ru.appBaila.controllers;

import ru.appBaila.models.dto.UserDto;
import ru.appBaila.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    @PreAuthorize("@securityService.canAccessUser(#id)")
    public UserDto getById(@PathVariable long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@securityService.canModifyUser(#id)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/entity")
    @PreAuthorize("@securityService.canModifyUser(#user.id)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByEntity(@RequestBody UserDto user) {
        service.deleteByEntity(user);
    }
}