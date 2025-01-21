package com.minhaempresa.dslist.repositories;

import com.minhaempresa.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
