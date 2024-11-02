package com.entjava.poker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany
    @JsonBackReference
    @JoinTable(
            name="event_player",
            joinColumns = {
                    @JoinColumn(name = "player_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "event_id", referencedColumnName = "id")
            }
    )
    private Set<Player> events = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getEvents() {
        return events;
    }

    public void setEvents(Set<Player> events) {
        this.events = events;
    }

}
