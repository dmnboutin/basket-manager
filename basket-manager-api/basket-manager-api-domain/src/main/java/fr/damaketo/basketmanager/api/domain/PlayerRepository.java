
package fr.damaketo.basketmanager.api.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
public interface PlayerRepository {

    Mono<Player> create(final Player player, final String leagueId);

    Mono<Player> getById(final String id);

    Flux<Player> getAll();

    Flux<Player> getByLeagueId(final String leagueId);
}
