package ru.appBaila.services;

import ru.appBaila.exceptions.UserNotFoundException;
import ru.appBaila.models.dto.RegisterRequest;
import ru.appBaila.models.dto.UserDto;
import ru.appBaila.models.entitys.User;
import ru.appBaila.repositories.JPAUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final JPAUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(JPAUserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto update(UserDto dto) {
        User existingUser = repository.findById(dto.getId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + dto.getId() + " didn't exist"));

        existingUser.setUsername(dto.getUsername());
        existingUser.setEmail(dto.getEmail());
        existingUser.setRole(dto.getRole());

        return new UserDto(repository.save(existingUser));
    }
    public UserDto createUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        return new UserDto(repository.save(user));
    }

    public UserDto getById(long id) {
        Optional<User> toFind = repository.findById(id);
        if (toFind.isPresent()) {
            return new UserDto(toFind.get());
        }
        throw new UserNotFoundException("User with id " + id + " didn't exist");
    }

    public UserDto getByUsername(String username) {
        Optional<User> toFind = repository.findByUsername(username);
        if (toFind.isPresent()) {
            return new UserDto(toFind.get());
        }
        throw new UserNotFoundException("User with username " + username + " didn't exist");
    }

    public UserDto getByEntity(UserDto dto) {
        return getById(dto.getId());
    }

    public void deleteById(long id) {
        Optional<User> toFind = repository.findById(id);
        if (toFind.isPresent()) {
            repository.deleteById(id);
            return;
        }
        throw new UserNotFoundException("User with id " + id + " didn't exist");
    }

    public void deleteByEntity(UserDto dto) {
        deleteById(dto.getId());
    }

    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}