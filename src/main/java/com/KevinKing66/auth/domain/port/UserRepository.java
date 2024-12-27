package com.KevinKing66.auth.domain.port;

import com.KevinKing66.auth.domain.User;

/**
 *
 * @author kevin
 */
public interface UserRepository {
    User findByEmail(String email);
}
