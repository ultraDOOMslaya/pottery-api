package com.maakesbe.authentication.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.maakesbe.authentication.entity.User;

/**
 * UserRepository
 * 
 * @author vladimir.stankovic
 *
 * Aug 16, 2016
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u left join fetch u.roles r where u.username=:username")
    public Optional<User> findByUsername(@Param("username") String username);
}
