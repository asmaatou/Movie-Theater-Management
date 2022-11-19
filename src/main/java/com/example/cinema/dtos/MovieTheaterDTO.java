package com.example.cinema.dtos;
import com.example.cinema.enums.Status;
import com.example.cinema.enums.Type;
import lombok.Data;

@Data
public class MovieTheaterDTO {
    private String name;
    private String address;
    private Status status;
    private Type type;
}
