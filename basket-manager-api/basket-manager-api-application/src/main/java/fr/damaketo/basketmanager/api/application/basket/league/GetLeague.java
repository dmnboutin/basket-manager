
package fr.damaketo.basketmanager.api.application.basket.league;

import fr.damaketo.basketmanager.api.domain.League;
import fr.damaketo.basketmanager.api.domain.LeagueRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
public class GetLeague {

    private final LeagueRepository leagueRepository;

    public GetLeague(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public Mono<League> byId(final String email) {
        return leagueRepository.getById(email);
    }

    public Flux<League> all() {
        return leagueRepository.getAll();

    }
}
