package com.example.fbhelper.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;
import com.example.fbhelper.enums.*;
import java.util.Set;

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

    @ElementCollection(targetClass = Position.class)
    @CollectionTable(
            name = "player_position",
            joinColumns = @JoinColumn(name = "player_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "position", nullable = false)
    private Set<Position> positions;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, updatable = true)
    private Instant updatedAt;
}
