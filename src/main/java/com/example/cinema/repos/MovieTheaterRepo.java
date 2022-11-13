package com.example.cinema.repos;

import com.example.cinema.entities.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface MovieTheaterRepo extends JpaRepository<MovieTheater, Integer> {
}
