package com.jarvis.game_club.controller;
import java.util.Optional;
import java.util.List;

import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.game_club.exceptions.IdNotPresentException;
import com.jarvis.game_club.modal.GameModel;
import com.jarvis.game_club.repository.GameRepository;
import com.jarvis.game_club.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;
    @PostMapping
    public ResponseEntity<GameModel> create(@RequestBody GameModel game) {
        GameModel savedGame = service.create(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }


    @GetMapping
    public ResponseEntity<List<GameModel>> findAll() {
        List<GameModel> games = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GameModel> findById(@PathVariable String id) throws IdNotPresentException {
        GameModel game = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(game);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<GameModel> update(@PathVariable String id, @RequestBody GameModel updatedGame) throws IdNotPresentException {
        GameModel updatedGameModel = service.updateGame(id, updatedGame);
        return ResponseEntity.status(HttpStatus.OK).body(updatedGameModel);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable String id) throws IdNotPresentException {
        service.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}