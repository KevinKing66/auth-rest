package com.KevinKing66.auth.adapter.persistence;

import com.KevinKing66.auth.domain.User;
import com.KevinKing66.auth.domain.port.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kevin
 */
@Repository
public interface JpaUserRepository extends JpaRepository<User, String>, UserRepository{
    @Override
    User findByEmail(String email);
}
