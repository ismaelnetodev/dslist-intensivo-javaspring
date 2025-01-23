package com.minhaempresa.dslist.controllers;

import com.minhaempresa.dslist.dto.GameListDTO;

import com.minhaempresa.dslist.dto.GameMinDTO;
import com.minhaempresa.dslist.dto.ReplacementDTO;
import com.minhaempresa.dslist.projections.GameMinProjection;
import com.minhaempresa.dslist.services.GameListService;
import com.minhaempresa.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> getAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getTargetIndex());
    }

}
