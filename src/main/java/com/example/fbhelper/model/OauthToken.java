package com.example.fbhelper.model;
import lombok.*;
import jakarta.persistence.*;
import java.time.*;
import com.example.fbhelper.enums.*;

@Entity
@Table(name = "oauth_token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OauthToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider", nullable = false)
    private AuthProvider provider;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "expires_at", nullable = false)
    private Integer expiresAt;

    @Column(name = "scope")
    private String scope;

    @Column(name = "token_type", nullable = false)
    private String tokenType;

    @Column(name = "raw_response", columnDefinition = "jsonb")
    private String rawResponse;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = true)
    private Instant updatedAt;
}
