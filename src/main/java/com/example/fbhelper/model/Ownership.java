package com.example.fbhelper.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;
import com.example.fbhelper.enums.*;


@Entity
@Table(name = "ownership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Ownership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "player_id", nullable = false)
    private Player player;







}
