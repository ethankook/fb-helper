package com.example.fbhelper.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;
import com.example.fbhelper.enums.*;
import org.springframework.cglib.core.Local;


@Entity
@Table(name = "sync_state")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SyncState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_synced_stats")
    private LocalDate lastSyncedStats;

    @Column(name = "last_synced_ownership")
    private LocalDate lastSyncedOwnership;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_At", nullable = false, insertable = false, updatable = true)
    private Instant updatedAt;
}
