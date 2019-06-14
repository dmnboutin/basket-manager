
package fr.damaketo.basketmanager.api.application.basket.league;

import fr.damaketo.basketmanager.api.domain.League;
import fr.damaketo.basketmanager.api.domain.LeagueRepository;
import reactor.core.publisher.Mono;

/**
 *
 */
public class UpdateLeague {

    private final LeagueRepository leagueRepository;

    public UpdateLeague(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public Mono<League> proceed(final League league) {

        return Mono.just(league);
    }
}
