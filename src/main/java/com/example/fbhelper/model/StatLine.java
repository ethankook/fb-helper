package com.example.fbhelper.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.*;
import com.example.fbhelper.enums.*;


@Entity
@Table(
        name = "stat_line",
        uniqueConstraints = @UniqueConstraint(columnNames = {"player_id", "game_date"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StatLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "game_date", nullable = false)
    private LocalDate gameDate;


    @Column(name = "pts")
    private BigDecimal pts;

    @Column(name = "reb")
    private BigDecimal reb;

    @Column(name = "ast")
    private BigDecimal ast;

    @Column(name = "stl")
    private BigDecimal stl;

    @Column(name = "blk")
    private BigDecimal blk;

    @Column(name = "threes")
    private BigDecimal threes;

    @Column(name = "tov")
    private BigDecimal tov;

    @Column(name = "fgm")
    private BigDecimal fgm;

    @Column(name = "fga")
    private BigDecimal fga;

    @Column(name = "ftm")
    private BigDecimal ftm;

    @Column(name = "fta")
    private BigDecimal fta;

    @Column(name = "minutes")
    private BigDecimal minutes;

    @Column(name = "raw_json", columnDefinition = "jsonb")
    private String rawJson;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

}
