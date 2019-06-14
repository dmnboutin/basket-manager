package fr.damaketo.basketmanager.api.infrastructure.basket.player;


import fr.damaketo.basketmanager.api.domain.Player;
import fr.damaketo.basketmanager.api.domain.PlayerPosition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 *
 */
@Document("player")
public class PlayerDocument {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String leagueId;
    private Integer size;
    private Integer weight;
    private String position;
    private RatingsDocument ratings;

    public PlayerDocument() {
    }

    public PlayerDocument(final Player player, final String leagueId) {
        setFirstName(player.getFirstName());
        setLastName(player.getLastName());
        setBirthDate(player.getBirthDate());
        setPosition(player.getPosition().name());
        setSize(player.getSize());
        setWeight(player.getWeight());
        setLeagueId(leagueId);
        RatingsDocument ratingsDocument = new RatingsDocument();
        ratingsDocument.setFreeThrow(player.getRatings().getFreeThrow());
        ratingsDocument.setShortRange(player.getRatings().getShortRange());
        ratingsDocument.setMidRange(player.getRatings().getMidRange());
        ratingsDocument.setLongRange(player.getRatings().getLongRange());
        ratingsDocument.setDefense(player.getRatings().getDefense());
        ratingsDocument.setBlock(player.getRatings().getBlock());
        ratingsDocument.setSteal(player.getRatings().getSteal());
        ratingsDocument.setDefenseMindset(player.getRatings().getDefenseMindset());
        ratingsDocument.setOffenseMindset(player.getRatings().getOffenseMindset());
        ratingsDocument.setRebounds(player.getRatings().getRebounds());
        ratingsDocument.setAssists(player.getRatings().getAssists());
        ratingsDocument.setClutch(player.getRatings().getClutch());
        ratingsDocument.setStamina(player.getRatings().getStamina());
        setRatings(ratingsDocument);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public RatingsDocument getRatings() {
        return ratings;
    }

    public void setRatings(RatingsDocument ratings) {
        this.ratings = ratings;
    }

    public Player toPlayer() {
        final Player player = new Player();
        player.setId(this.id);
        player.setFirstName(this.firstName);
        player.setLastName(this.lastName);
        player.setBirthDate(this.birthDate);
        player.setPosition(PlayerPosition.valueOf(this.position));
        player.setSize(this.size);
        player.setWeight(this.weight);
        player.setRatings(this.ratings.toRatings());
        return player;
    }
}

