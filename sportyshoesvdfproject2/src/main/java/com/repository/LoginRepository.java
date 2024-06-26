package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	Login findByUsernameAndPassword(String username, String password);
	Login findByUsername(String username);
	//Login findByEmail(String emailId);
	//Login findByResetPassword(String resetPassword);
	@Modifying
	@Query("update Login log set log.password = :password where log.id = :id")
	void changePassword(@Param(value="password") String password, @Param(value = "id") Long id);
	
	@Query("select l from Login l where l.username = :username")
	public Optional<Login> findUserByName(@Param("username") String username);
	
}