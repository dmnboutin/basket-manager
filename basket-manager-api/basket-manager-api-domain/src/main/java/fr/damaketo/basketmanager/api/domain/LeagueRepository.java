
package fr.damaketo.basketmanager.api.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
public interface LeagueRepository {

    Mono<League> create(final League login);

    Mono<League> getById(final String id);

    Flux<League> getAll();

    Mono<Team> createTeam(final Team team, final String leagueId, final Account manager);
}
