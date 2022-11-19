package com.example.cinema.repos;

import com.example.cinema.entities.MovieTheater;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.DefaultParameters;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface MovieTheaterRepo extends JpaRepository<MovieTheater, Integer> {
    @Query("select m from MovieTheater m where m.name  like :kw")
    List<MovieTheater> searchMovieTheater(@Param("kw")  String keyword);

}
