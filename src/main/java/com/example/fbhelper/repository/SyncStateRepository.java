package com.example.fbhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fbhelper.model.SyncState;

import java.util.Optional;

public interface SyncStateRepository extends JpaRepository<SyncState, Long> {

    Optional<SyncState> findTopByOrderByIdDesc();
}
