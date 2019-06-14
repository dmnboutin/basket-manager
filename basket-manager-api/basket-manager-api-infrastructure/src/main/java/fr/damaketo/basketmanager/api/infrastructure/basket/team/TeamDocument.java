package fr.damaketo.basketmanager.api.infrastructure.basket.team;

import fr.damaketo.basketmanager.api.domain.City;
import fr.damaketo.basketmanager.api.domain.Team;
import fr.damaketo.basketmanager.api.infrastructure.account.AccountDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 */
@Document("team")
public class TeamDocument {

    @Id
    private String id;
    private String name;
    private String city;
    private LocalDateTime creationDate;
    private AccountDocument manager;

    public TeamDocument() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public AccountDocument getManager() {
        return manager;
    }

    public void setManager(AccountDocument manager) {
        this.manager = manager;
    }

    public Team toTeam() {
        final Team team = new Team();
        team.setId(this.id);
        team.setCity(new City(this.city));
        team.setName(this.name);
        team.setManager(this.manager.toAccount());
        team.setCreationDate(this.creationDate);
        return team;
    }
}


