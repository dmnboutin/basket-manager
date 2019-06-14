
package fr.damaketo.basketmanager.api.application.basket.player;

import fr.damaketo.basketmanager.api.domain.Player;
import fr.damaketo.basketmanager.api.domain.PlayerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
public class GetPlayer {

    private final PlayerRepository playerRepository;

    public GetPlayer(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Mono<Player> byId(final String id) {
        return playerRepository.getById(id);
    }

    public Flux<Player> byLeagueId(final String leagueId) {
        return playerRepository.getByLeagueId(leagueId);
    }

    public Flux<Player> all() {
        return playerRepository.getAll();

    }
}
