package com.example.fbhelper.repository;

import com.example.fbhelper.enums.ScoringType;
import com.example.fbhelper.model.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> {

    Optional<League> findByYahooLeagueKey(String yahooLeagueKey);

    List<League> findByScoring(ScoringType scoringType);

    List<League> findBySeasonYear(Integer seasonYear);
}
