package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Ticket implements Serializable {

    public Ticket(Client client, Planet startPlanet, Planet endPlanet) {
        this.client = client;
        this.startPlanet = startPlanet;
        this.endPlanet = endPlanet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet startPlanet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet endPlanet;

    public Ticket() {

    }

    @Override
    public String toString() {
        return "id = " + id + ", client id = " + client.getId() + ", start planet = " + startPlanet.getName() +
                ", end planet = " + endPlanet.getName();
    }
}
