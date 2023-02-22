package dev.aufaasensio.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    // we want to find the movie that related to imdb
    public Review createReview(String reviewBody, String imdbId) {
        //create a new review
        Review review = reviewRepository.insert(new Review(reviewBody));

        //associate to the movies db
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId)).apply(new Update().push( "reviewIds")
                .value(review)).first();

        return review;
    }
}
