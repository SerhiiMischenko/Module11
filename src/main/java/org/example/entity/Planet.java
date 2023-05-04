package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Planet implements Serializable {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "startPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> startingTickets = new HashSet<>();

    @OneToMany(mappedBy = "endPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> endingTickets = new HashSet<>();

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name;
    }
}
