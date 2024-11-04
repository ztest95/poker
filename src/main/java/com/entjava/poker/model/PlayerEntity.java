package com.entjava.poker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player")
public class PlayerEntity {

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
    private Set<PlayerEntity> events = new HashSet<>();

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

    public Set<PlayerEntity> getEvents() {
        return events;
    }

    public void setEvents(Set<PlayerEntity> events) {
        this.events = events;
    }

}
