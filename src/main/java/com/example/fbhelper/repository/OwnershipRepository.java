package com.example.fbhelper.repository;
import com.example.fbhelper.model.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnershipRepository extends JpaRepository<Ownership, Long>{

    List<Ownership> findByPlayer(Player player);

}
