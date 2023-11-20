package com.example.rest_playground.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Data
@Entity
@Table(name = "client_table")
public class Client {
    @Id
    @Column(name = "id_client")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer ID;
    @Column(name = "name_client")
    private String name;
    @Column(name = "email_client")
    private String email;
    @Column(name = "pNumber_client")
    private Integer p_number;

}
