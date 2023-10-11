package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.Roles;


@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

	Optional<Roles> findByUserId(Long userId);
}
