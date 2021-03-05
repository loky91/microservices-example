package io.javabrains.moviedataservice.resources;

import io.javabrains.moviedataservice.models.Ratings;
import io.javabrains.moviedataservice.models.UsersRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsData")
public class RatingsResource {
@RequestMapping("/{movieId}")
    public Ratings getRating(@PathVariable("movieId") String movieId){
return new Ratings(movieId,4);
    }


    @RequestMapping("/users/{userId}")
    public UsersRating getUserRating(@PathVariable("userId") String userId){
List<Ratings> ratings= Arrays.asList(
  new Ratings("1234",4),
  new Ratings("5678",3)
);
        UsersRating userRating=new UsersRating();
        userRating.setUserRating(ratings);
return userRating;
    }
}
