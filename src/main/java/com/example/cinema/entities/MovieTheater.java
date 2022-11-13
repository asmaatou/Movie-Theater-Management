package com.example.cinema.entities;

import com.example.cinema.enums.Status;
import com.example.cinema.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class MovieTheater {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 50,nullable = false)
    private String name;
    @Column(length = 100,nullable = false)
    private String address;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private int chairsNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Type type;
}
