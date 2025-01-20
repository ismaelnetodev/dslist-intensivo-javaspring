package com.minhaempresa.dslist.repositories;

import com.minhaempresa.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
