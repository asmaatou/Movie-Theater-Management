package com.example.cinema.ws;

import com.example.cinema.entities.MovieTheater;
import com.example.cinema.repos.MovieTheaterRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json",path = "/api")
public class MovieTheaterRESTController {
    MovieTheaterRepo movieTheaterRepo;

    public MovieTheaterRESTController(MovieTheaterRepo movieTheaterRepo) {
        this.movieTheaterRepo = movieTheaterRepo;
    }
    @GetMapping("/movietheater/{id}")
    public MovieTheater getMovieTheater(@PathVariable  Integer id){
        return movieTheaterRepo.findById(id).get();
    }
    @GetMapping("/movietheater")
    public List<MovieTheater> getMovieTheater(){
        return movieTheaterRepo.findAll();
    }
    @PostMapping("/add")
    public MovieTheater addMovieTheatre(@RequestBody MovieTheater movieTheater){
        return movieTheaterRepo.save(movieTheater);
    }
    @PutMapping("/edit/{id}")
    public MovieTheater editMovieTheatre(@PathVariable Integer id,MovieTheater movieTheater){
        MovieTheater movieT = movieTheaterRepo.findById(id).get();
        if(movieT != null){
            movieT.setName(movieTheater.getName());
            movieT.setAddress(movieTheater.getAddress());
            movieT.setCreationDate(movieTheater.getCreationDate());
            movieT.setChairsNumber(movieTheater.getChairsNumber());
            movieT.setStatus(movieTheater.getStatus());
            movieT.setType(movieTheater.getType());
            return movieTheaterRepo.save(movieT);
        }
        return  null;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMovieTheatre(@PathVariable Integer id){
        movieTheaterRepo.deleteById(id);
    }

}
