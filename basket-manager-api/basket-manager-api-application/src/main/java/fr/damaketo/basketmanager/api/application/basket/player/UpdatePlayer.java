
package fr.damaketo.basketmanager.api.application.basket.player;

import fr.damaketo.basketmanager.api.domain.Player;
import fr.damaketo.basketmanager.api.domain.PlayerRepository;
import reactor.core.publisher.Mono;

/**
 *
 */
public class UpdatePlayer {

    private final PlayerRepository playerRepository;

    public UpdatePlayer(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Mono<Player> proceed(final Player player) {

        return Mono.just(player);
    }
}
