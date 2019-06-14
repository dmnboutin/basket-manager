package fr.damaketo.basketmanager.api.domain;

import java.time.LocalDate;

/**
 *
 */
public class Player {

    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private Integer size;
    private Integer weight;
    private PlayerPosition position;

    private Ratings ratings;

    public Player() {
    }

    public Player(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getOverall() {
        switch (this.position) {
            case POINT_GUARD: return getOverallRatings(1, 5, 2, 6, 2, 7, 7,  10, 2, 5, 10, 10);
            case SHOOTING_GUARD: return getOverallRatings(1, 3, 3, 6, 2, 7, 7, 7, 3, 5, 10, 10);
            case SHOOTING_FORWARD: return getOverallRatings(1, 5, 5, 6, 6, 8, 10, 5, 4, 4, 10, 10);
            case POWER_FORWARD: return getOverallRatings(1, 5, 10, 6, 8, 7, 4, 8, 8, 3, 10, 10);
            case CENTER: return getOverallRatings(1, 2, 10, 6, 10, 7, 1, 8, 10, 2, 10, 10);
            default: return getOverallRatings(1, 5, 5, 6, 6, 8, 10, 5, 5, 5, 10, 10);
        }
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

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    private Double getOverallRatings(int freeThrow, int assists, int rebounds, int clutch,
                                     int shortRange, int midRange, int longRange,
                                     int defense, int block, int steal,
                                     int offenseWeight, int defenseWeight) {

        double ratioOffense = this.getRatings().getOffenseMindset() / this.getRatings().getDefenseMindset();
        double ratioDefense = this.getRatings().getDefenseMindset() / this.getRatings().getOffenseMindset();

        double offenseRating = (this.getRatings().getShortRange() * shortRange
                + this.getRatings().getMidRange() * midRange
                + this.getRatings().getLongRange() * longRange) / (shortRange + midRange + longRange);

        double defensiveRating = (this.getRatings().getDefense() * defense
                + this.getRatings().getBlock() * block
                + this.getRatings().getSteal() * steal) / (defense + block + steal);

        return (this.getRatings().getFreeThrow() * freeThrow
                + this.getRatings().getAssists() * assists
                + this.getRatings().getRebounds() * rebounds
                + this.getRatings().getClutch() * clutch
                + offenseRating * (ratioOffense / (ratioDefense + ratioOffense) ) * 2 * offenseWeight
                + defensiveRating * (ratioDefense / (ratioDefense + ratioOffense) ) * 2 * defenseWeight
            ) / (freeThrow + assists + rebounds + clutch + offenseWeight + defenseWeight);
    }
}
