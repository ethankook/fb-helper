package com.example.fbhelper.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id", nullable = false)
    private League league;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_team", nullable = false)
    private Boolean userTeam;

    @Column(name = "yahoo_team_key", nullable = false)
    private String yahooTeamKey;

    @Column(name = "punt_categories")
    private String puntCategories;

    @Column(name = "win_categories")
    private String winCategories;

    @Column(name = "createdAt", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updatedAt", nullable = false, insertable = false, updatable = true)
    private Instant updatedAt;

}
