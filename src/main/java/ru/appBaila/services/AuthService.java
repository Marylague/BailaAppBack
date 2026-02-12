package ru.appBaila.services;

import ru.appBaila.exceptions.InvalidCredentialsException;
import ru.appBaila.exceptions.UserAlreadyExistsException;
import ru.appBaila.exceptions.UserNotFoundException;
import ru.appBaila.models.dto.AuthResponse;
import ru.appBaila.models.dto.CartDto;
import ru.appBaila.models.dto.LoginRequest;
import ru.appBaila.models.dto.RegisterRequest;
import ru.appBaila.models.dto.UserDto;
import ru.appBaila.models.entitys.Cart;
import ru.appBaila.models.entitys.User;
import ru.appBaila.repositories.JPAUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {

    private final JPAUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final CartService cartService;
    private final UserService userService;

    @Autowired
    public AuthService(
            JPAUserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            CartService cartService,
            UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.cartService = cartService;
        this.userService = userService;
    }

    public AuthResponse register(RegisterRequest request) {
        if (userService.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("Username already taken");
        }

        if (userService.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email already registered");
        }

        UserDto createdUser = userService.createUser(request);

        User user = userRepository.findById(createdUser.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Cart cart = new Cart(user);
        cartService.save(new CartDto(cart), user);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new AuthResponse(
                createdUser.getId(),
                createdUser.getUsername(),
                createdUser.getEmail(),
                createdUser.getRole()
        );
    }

    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDto user = userService.getByUsername(request.getUsername());

        return new AuthResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }

    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new InvalidCredentialsException("No authenticated user");
        }

        String username = authentication.getName();
        return userService.getByUsername(username);
    }
}