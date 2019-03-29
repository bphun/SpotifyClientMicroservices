package com.bphan.moviecatalogservice;

import java.util.List;
import java.util.stream.Collectors;

import com.netflix.discovery.DiscoveryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating ratings = webClientBuilder.build()
        .get()
        .uri("http://movie-rating-service/ratingsdata/users/" + userId)
        .retrieve()
        .bodyToMono(UserRating.class)
        .block();

        return ratings.getRatings().stream().map(rating -> {
            Movie movie = webClientBuilder.build()
            .get()
            .uri("http://movie-info-service/movies/" + rating.getMovieId())
            .retrieve()
            .bodyToMono(Movie.class)
            .block();

            return new CatalogItem(movie.getName(), movie.getMovieDesc(), rating.getRating());
        }).collect(Collectors.toList());
    }
}