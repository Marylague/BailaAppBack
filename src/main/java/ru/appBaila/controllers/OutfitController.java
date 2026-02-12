package ru.appBaila.controllers;

import ru.appBaila.models.dto.OutfitDto;
import ru.appBaila.services.OutfitService;
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
@RequestMapping("api/outfit")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class OutfitController {
    private final OutfitService service;
    private final SecurityService securityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("@securityService.hasAdminRole")
    public OutfitDto create(@RequestBody OutfitDto outfit) {
        return service.save(outfit);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@securityService.hasAdminRole")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/entity")
    @PreAuthorize("@securityService.hasAdminRole")
    public void deleteByEntity(@RequestBody OutfitDto outfit) {
        service.deleteByEntity(outfit);
    }

    @PutMapping()
    @PreAuthorize("@securityService.hasAdminRole")
    public OutfitDto update(@RequestBody OutfitDto dto) {
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public OutfitDto getById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/entity")
    public OutfitDto getByEntity(@RequestBody OutfitDto outfit){return service.getByEntity(outfit);}
}
