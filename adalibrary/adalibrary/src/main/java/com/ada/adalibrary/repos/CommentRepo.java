package com.ada.adalibrary.repos;

import com.ada.adalibrary.domain.CommentEntity;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends MongoRepository<CommentEntity, String > {

    Optional<List<CommentEntity>> findAllByBookExtid(int id);
}
