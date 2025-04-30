package com.example.gestiontaches.security;

import com.example.gestiontaches.model.User;
import com.example.gestiontaches.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User utilisateur = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email non trouvé : " + email));

        return new org.springframework.security.core.userdetails.User(
                utilisateur.getEmail(),
                utilisateur.getPassword(),
                java.util.Collections.emptyList()
        );
    }
}
