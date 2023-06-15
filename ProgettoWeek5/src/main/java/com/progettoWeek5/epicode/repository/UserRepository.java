package com.progettoWeek5.epicode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progettoWeek5.epicode.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

