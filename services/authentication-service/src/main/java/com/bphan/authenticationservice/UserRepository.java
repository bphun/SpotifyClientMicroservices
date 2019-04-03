package com.bphan.authenticationservice;

import java.util.List;

import javax.transaction.Transactional;

import com.bphan.authenticationservice.Security.AppUser;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser, String> {

    @Query(value = "SELECT * FROM Users u WHERE u.username = :username", nativeQuery = true)
    public List<AppUser> findUserWithName(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = "INSERT IGNORE INTO Users(id, username, password_hash, user_role) VALUES(:id, :username, :password, 'USER')", nativeQuery = true)
    public void addUserWithCredentialsIfNotExist(@Param("id") String id, @Param("username") String username, @Param("password") String password);

}