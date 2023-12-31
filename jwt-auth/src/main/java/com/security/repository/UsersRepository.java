package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByEmail(String email);

	boolean existsByEmail(String userName);
}
