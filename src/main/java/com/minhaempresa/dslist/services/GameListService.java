package com.minhaempresa.dslist.services;

import com.minhaempresa.dslist.dto.GameListDTO;
import com.minhaempresa.dslist.entities.GameList;
import com.minhaempresa.dslist.projections.GameMinProjection;
import com.minhaempresa.dslist.repositories.GameListRepository;
import com.minhaempresa.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int targetIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(targetIndex, obj);

        int min = sourceIndex < targetIndex ? sourceIndex : targetIndex;
        int max = sourceIndex < targetIndex ? targetIndex : sourceIndex;

        for (int i = min; i < max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
