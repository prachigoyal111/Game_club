package com.jarvis.game_club.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.jarvis.game_club.modal.GameModel;
import org.springframework.stereotype.Repository;
@Repository
public interface GameRepository extends MongoRepository<GameModel, String> {

}