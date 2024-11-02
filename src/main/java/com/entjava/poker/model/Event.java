package com.entjava.poker.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name="event_player",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> players = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "winner", referencedColumnName = "id")
    private Player player;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWinnerId() {
        return id;
    }

    public void setWinnerId(Integer id) {
        this.id = id;
    }

}
