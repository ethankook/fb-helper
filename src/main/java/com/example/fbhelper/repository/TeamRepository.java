package com.example.fbhelper.repository;
import com.example.fbhelper.model.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long>{

    List<Team> findByLeague(League league);

    Optional<Team> findByYahooTeamKey(String yahooTeamKey);

    List<Team> findByUserTeam(Boolean userTeam);

    Optional<Team> findByLeagueAndYahooTeamKey(League league, String yahooTeamKey);
}
