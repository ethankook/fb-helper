package com.example.fbhelper.model;

import lombok.*;
import jakarta.persistence.*;
import com.example.fbhelper.enums.*;
import java.time.*;


@Entity
@Table(name = "league")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "yahoo_league_key", nullable = false)
    private String yahooLeagueKey;

    @Column(name = "scoring_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ScoringType scoring;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "season_year", nullable = false)
    private Integer seasonYear;

    @Column(name = "num_teams", nullable = false)
    private Integer numTeams;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_At", nullable = false, insertable = false, updatable = true)
    private Instant updatedAt;


}
