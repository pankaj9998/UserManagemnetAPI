package com.example.user.repository;


import com.example.user.entity.User;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE " +
            "(?1 IS NULL OR u.username LIKE %?1%) AND " +
            "(?2 IS NULL OR u.address.pinCode = ?2) AND " +
            "(u.registrationDate BETWEEN ?3 AND ?4)")
    Page<User> search(String name, String pinCode, LocalDateTime start, LocalDateTime end, Pageable pageable);
}