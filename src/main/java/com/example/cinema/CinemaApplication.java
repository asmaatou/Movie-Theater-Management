package com.example.cinema;

import com.example.cinema.entities.MovieTheater;
import com.example.cinema.enums.Status;
import com.example.cinema.enums.Type;
import com.example.cinema.repos.MovieTheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

    @Autowired
    MovieTheaterRepo movieTheaterRepo;
    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=1;i<5;i++){
            movieTheaterRepo.save(
                    new MovieTheater(null,"Movie Theater "+i,"Address_"+i,new Date(), new Random().nextInt(51)+50,
                            (i%2 == 0) ? Status.Closed : Status.Open,
                            (i%2 == 0) ? Type.Standard : Type.VR)
            );
        }

    }
}
