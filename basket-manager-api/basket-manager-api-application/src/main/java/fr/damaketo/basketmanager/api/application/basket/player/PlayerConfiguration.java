
package fr.damaketo.basketmanager.api.application.basket.player;

import fr.damaketo.basketmanager.api.domain.PlayerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class PlayerConfiguration {

    @Bean
    CreatePlayer createPlayer(final PlayerRepository playerRepository) {
        return new CreatePlayer(playerRepository);
    }

    @Bean
    GetPlayer getPlayer(final PlayerRepository playerRepository) {
        return new GetPlayer(playerRepository);
    }

    @Bean
    UpdatePlayer updatePlayer(final PlayerRepository playerRepository) {
        return new UpdatePlayer(playerRepository);
    }
}
