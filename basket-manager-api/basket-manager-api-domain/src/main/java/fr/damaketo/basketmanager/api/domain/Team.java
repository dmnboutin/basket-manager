package fr.damaketo.basketmanager.api.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 */
public class Team {

    private String id;
    private Account manager;
    private String name;
    private City city;
    private LocalDateTime creationDate;
    private List<Player> players;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getManager() {
        return manager;
    }

    public void setManager(Account manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
