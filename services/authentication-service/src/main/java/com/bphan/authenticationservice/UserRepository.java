package com.bphan.authenticationservice;

import com.bphan.authenticationservice.Security.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {

    @Query(value = "SELECT * FROM Users u WHERE u.username = :username", nativeQuery = true)
    public AppUser findUserWithName(@Param("username") String username);

}