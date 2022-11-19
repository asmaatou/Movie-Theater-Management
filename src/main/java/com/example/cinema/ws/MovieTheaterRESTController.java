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
    @PostMapping("/create")
    public MovieTheater addMovieTheatre(@RequestBody MovieTheater movieTheater){
        return movieTheaterRepo.save(movieTheater);
    }
    @PutMapping("/update/{id}")
    public MovieTheater editMovieTheatre(@PathVariable Integer id,@RequestBody MovieTheater mt){
        MovieTheater movieTheater = movieTheaterRepo.findById(id).get();
        if (movieTheater != null){
            movieTheater.setName(mt.getName());
            movieTheater.setAddress(mt.getAddress());
            movieTheater.setCreationDate(mt.getCreationDate());
            movieTheater.setChairsNumber(mt.getChairsNumber());
            movieTheater.setStatus(mt.getStatus());
            movieTheater.setType(mt.getType());
            return movieTheaterRepo.save(movieTheater);
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMovieTheatre(@PathVariable Integer id){
        movieTheaterRepo.deleteById(id);
    }

    @GetMapping("/movietheater/search")
    public List<MovieTheater> searchMovieTheater(@RequestParam(name = "keyword",defaultValue = "")String keyword){
        return movieTheaterRepo.searchMovieTheater("%"+keyword+"%");
    }

}
