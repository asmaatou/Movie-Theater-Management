package com.example.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface MovieTheaterRepo extends JpaRepository {
}
