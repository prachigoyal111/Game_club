package com.jarvis.game_club.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.jarvis.game_club.modal.MemberModal;
import org.springframework.stereotype.Repository;
@Repository
public interface MemberRepository extends MongoRepository<MemberModal, String> {
    MemberModal findByPhone(String phone);
}
