package fr.damaketo.basketmanager.api.infrastructure.basket.league;

import fr.damaketo.basketmanager.api.domain.Account;
import fr.damaketo.basketmanager.api.domain.Team;
import fr.damaketo.basketmanager.api.infrastructure.account.AccountDocument;
import fr.damaketo.basketmanager.api.infrastructure.basket.team.TeamDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 */
@Document("league")
public class LeagueDocument {

    @Id
    private String id;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    private AccountDocument administrator;
    private int numberOfTeam;
    private String status;
    private List<TeamDocument> teams;

    public LeagueDocument() {
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public AccountDocument getAdministrator() {
        return administrator;
    }

    public void setAdministrator(AccountDocument administrator) {
        this.administrator = administrator;
    }

    public int getNumberOfTeam() {
        return numberOfTeam;
    }

    public void setNumberOfTeam(int numberOfTeam) {
        this.numberOfTeam = numberOfTeam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TeamDocument> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDocument> teams) {
        this.teams = teams;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}

