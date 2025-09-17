package com.jarvis.game_club.controller;
import java.util.Optional;
import java.util.List;
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
import com.jarvis.game_club.modal.GameModel;
import com.jarvis.game_club.repository.GameRepository;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping
    public GameModel addGameModel(@RequestBody GameModel game) {
        game.setId(null);
        return gameRepository.save(game);
    }

    @PostMapping("/test")
    public GameModel test(@RequestBody GameModel game) {
        return game;
    }

    @GetMapping
    public List<GameModel> getAll() {
        return gameRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public GameModel findById(@PathVariable String id) {
        return gameRepository.findById(id).orElse(null);
    }

    @PutMapping(path = "/{id}")
    public GameModel update(@PathVariable String id, @RequestBody GameModel updatedGame) {
        GameModel oldgame = gameRepository.findById(id).get();
        oldgame.setName(updatedGame.getName());
        oldgame.setDescription(updatedGame.getDescription());
        oldgame.setPrice(updatedGame.getPrice());
        GameModel savedGame = gameRepository.save(oldgame);
        return savedGame;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        gameRepository.deleteById(id);
    }
}