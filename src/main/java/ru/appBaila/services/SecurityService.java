package ru.appBaila.services;

import ru.appBaila.models.entitys.User;
import ru.appBaila.repositories.JPAUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("securityService")
public class SecurityService {

    private final JPAUserRepository userRepository;

    @Autowired
    public SecurityService(JPAUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean canAccessUser(Long userId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = auth.getName();

        User currentUser = userRepository.findByUsername(currentUsername).orElse(null);
        if (currentUser == null) return false;

        return currentUser.getId().equals(userId) ||
                currentUser.getRole().name().equals("ADMIN");
    }

    public User getCurrentUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = auth.getName();

        User currentUser = userRepository.findByUsername(currentUsername).orElse(null);
        return currentUser;
    }

    public boolean canModifyUser(Long userId) {
        return canAccessUser(userId);
    }

    public boolean hasAdminRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }
}

