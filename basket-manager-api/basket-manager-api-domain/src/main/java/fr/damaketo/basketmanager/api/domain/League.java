
package fr.damaketo.basketmanager.api.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 */
public class League {

    private String id;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private Account administrator;
    private Integer numberOfTeam;
    private LeagueStatus status;
    private List<Team> teams;
    private List<Player> players;
    private List<Season> seasons;


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

    public Account getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Account administrator) {
        this.administrator = administrator;
    }

    public Integer getNumberOfTeam() {
        return numberOfTeam;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public void setNumberOfTeam(Integer numberOfTeam) {
        this.numberOfTeam = numberOfTeam;
    }

    public LeagueStatus getStatus() {
        return status;
    }

    public void setStatus(LeagueStatus status) {
        this.status = status;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
