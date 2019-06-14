
package fr.damaketo.basketmanager.api.application.basket.player;

import fr.damaketo.basketmanager.api.domain.Player;
import fr.damaketo.basketmanager.api.domain.PlayerRepository;
import reactor.core.publisher.Mono;

/**
 *
 */
public class CreatePlayer {

    private final PlayerRepository playerRepository;

    public CreatePlayer(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Mono<Player> proceed(final Player player, final String leagueId) {
        return playerRepository.create(player, leagueId);
    }
}
