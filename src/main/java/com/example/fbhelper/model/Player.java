package com.example.fbhelper.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity
@Table(name = "player")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "yahoo_player_id", nullable= false)
    private String yahooPlayerId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "first_name", nullable= false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nba_team")
    private String nbaTeam;

    @Column(name = "positions", nullable= false)
    private String positions;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, updatable = true)
    private Instant updatedAt;
}
