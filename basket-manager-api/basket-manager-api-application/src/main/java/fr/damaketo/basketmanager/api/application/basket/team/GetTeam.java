
package fr.damaketo.basketmanager.api.application.basket.team;

import fr.damaketo.basketmanager.api.domain.LeagueRepository;
import fr.damaketo.basketmanager.api.domain.Player;
import fr.damaketo.basketmanager.api.domain.PlayerRepository;
import fr.damaketo.basketmanager.api.domain.Team;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
public class GetTeam {

    private final LeagueRepository leagueRepository;

    public GetTeam(final LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public Mono<Team> byId(final String id) {
        return null;//leagueRepository.getById(id);
    }
}
