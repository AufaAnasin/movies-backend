package dev.aufaasensio.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//repositories is one of the way to talk with the database
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
