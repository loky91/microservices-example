package io.javabrains.moviecatalogservice.resource;

import io.javabrains.moviecatalogservice.resource.models.CatalogItem;
import io.javabrains.moviecatalogservice.resource.models.Movie;
import io.javabrains.moviecatalogservice.resource.models.Ratings;
import io.javabrains.moviecatalogservice.resource.models.UsersRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
@Autowired
private RestTemplate restTemplate;
@Autowired
private WebClient.Builder webClientBuilder;
@RequestMapping("/{userId}")
public List<CatalogItem> getCatalog(@PathVariable String userId){
    /*List<Ratings> ratings= Arrays.asList(
            new Ratings("1234",4),
            new Ratings("5678",3)
    );*/

    UsersRating ratings=restTemplate.getForObject("http://MOVIE-DATA-SERVICE/ratingsData/users/"+userId, UsersRating.class);
return ratings.getUserRating().stream().map(rating->{
  Movie movie=restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId(),Movie.class);
  /*Movie movie=webClientBuilder.build()
          .get()
          .uri("http://localhost:8082/movies/"+rating.getMovieId())
          .retrieve()
          .bodyToMono(Movie.class)
          .block();*/



    return new CatalogItem(movie.getName(),"Test",rating.getRating());
})
.collect(Collectors.toList());
    }


}
