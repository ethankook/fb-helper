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
    private Integer season_year;

    @Column(name = "num_teams", nullable = false)
    private Integer num_teams;

    @Column(name = "createdAt", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updatedAt", nullable = false, insertable = false, updatable = true)
    private Instant updatedAt;


}
