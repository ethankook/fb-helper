package com.example.fbhelper.repository;

import com.example.fbhelper.model.*;

import java.time.LocalDate;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StatLineRepository extends JpaRepository<StatLine, Long> {
    List<StatLine> findByPlayer(Player player);

    List<StatLine> findByGameDate(LocalDate gameDate);

    Optional<StatLine> findByPlayerAndGameDate(Player player, LocalDate gameDate);

    List<StatLine> findByPlayerAndGameDateGreaterThanEqual(Player player, LocalDate gameDate);
}
