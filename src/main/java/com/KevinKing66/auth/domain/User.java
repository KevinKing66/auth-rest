package com.KevinKing66.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author kevin
 */
@Data
@Builder
@Entity
public class User {
    @Id
    private String email;
    private String password;
}
