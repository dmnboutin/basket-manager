
package fr.damaketo.basketmanager.api.infrastructure;

import fr.damaketo.basketmanager.api.infrastructure.account.AccountDefaultRepository;
import fr.damaketo.basketmanager.api.infrastructure.account.AccountMongoRepository;
import fr.damaketo.basketmanager.api.infrastructure.basket.league.LeagueDefaultRepository;
import fr.damaketo.basketmanager.api.infrastructure.basket.league.LeagueMongoRepository;
import fr.damaketo.basketmanager.api.infrastructure.basket.player.PlayerDefaultRepository;
import fr.damaketo.basketmanager.api.infrastructure.basket.player.PlayerMongoRepository;
import fr.damaketo.basketmanager.api.infrastructure.basket.team.TeamMongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class InfrastructureConfiguration {

    @Bean
    AccountDefaultRepository accountDefaultRepository(final AccountMongoRepository accountMongoRepository) {
        return new AccountDefaultRepository(accountMongoRepository);
    }

    @Bean
    PlayerDefaultRepository playerDefaultRepository(final PlayerMongoRepository playerMongoRepository) {
        return new PlayerDefaultRepository(playerMongoRepository);
    }

    @Bean
    LeagueDefaultRepository leagueDefaultRepository(final LeagueMongoRepository leagueMongoRepository, final TeamMongoRepository teamMongoRepository) {
        return new LeagueDefaultRepository(leagueMongoRepository, teamMongoRepository);
    }
}
