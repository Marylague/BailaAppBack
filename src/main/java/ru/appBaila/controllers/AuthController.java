package ru.appBaila.controllers;

import ru.appBaila.models.dto.AuthResponse;
import ru.appBaila.models.dto.LoginRequest;
import ru.appBaila.models.dto.RegisterRequest;
import ru.appBaila.models.dto.UserDto;
import ru.appBaila.services.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)


    public AuthResponse register(@Valid @RequestBody RegisterRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        AuthResponse response = authService.register(request);
        saveSession(servletRequest, servletResponse);
        return response;
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        AuthResponse response = authService.login(request);
        saveSession(servletRequest, servletResponse);
        return response;
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpServletRequest request) {
        // Очищаем контекст и инвалидируем сессию
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
    }

    @GetMapping("/me")
    public UserDto getCurrentUser() {
        return authService.getCurrentUser();
    }

    // Вспомогательный метод для сохранения сессии
    private void saveSession(HttpServletRequest request, HttpServletResponse response) {
        SecurityContext context = SecurityContextHolder.getContext();
        securityContextRepository.saveContext(context, request, response);
    }
}