package com.example.fbhelper.repository;

import com.example.fbhelper.model.OauthToken;
import com.example.fbhelper.enums.AuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OauthTokenRepository extends JpaRepository<OauthToken, Long> {
    Optional<OauthToken> findByProvider(AuthProvider oauthProvider);

    boolean existsByProvider(AuthProvider oauthProvider);
}
