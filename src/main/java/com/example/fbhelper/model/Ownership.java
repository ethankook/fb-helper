package com.example.fbhelper.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.*;
import com.example.fbhelper.enums.*;


@Entity
@Table(
        name = "ownership",
        uniqueConstraints = @UniqueConstraint(columnNames = {"player_id", "snapshot_date"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Ownership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "snapshot_date", nullable = false)
    private LocalDate snapshotDate;

    @Column(name = "percent_owned", nullable = false)
    private BigDecimal percentOwned;

    @Column(name = "percent_started")
    private BigDecimal percentStarted;

    @Column(name = "raw_json", columnDefinition = "jsonb")
    private String rawJson;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_At", nullable = false, insertable = false, updatable = true)
    private Instant updatedAt;


}
