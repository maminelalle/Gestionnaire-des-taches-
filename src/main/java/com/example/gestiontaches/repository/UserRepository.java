// --- UserRepository.java ---
package com.example.gestiontaches.repository;

import com.example.gestiontaches.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
