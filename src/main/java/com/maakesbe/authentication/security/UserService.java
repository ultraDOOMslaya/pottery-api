package com.maakesbe.authentication.security;

import java.util.Optional;

import com.maakesbe.authentication.entity.User;

/**
 * 
 * @author vladimir.stankovic
 *
 * Aug 17, 2016
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
}
