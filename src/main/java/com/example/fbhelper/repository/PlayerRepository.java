package com.example.fbhelper.repository;

import com.example.fbhelper.enums.Position;
import com.example.fbhelper.model.*;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByYahooPlayerId(String yahooPlayerId);

    List<Player> findByNbaTeam(String nbaTeam);

    List<Player> findByPositions(Position position);

    List<Player> findByFullNameContainingIgnoreCase(String name);
}
