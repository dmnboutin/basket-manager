package fr.damaketo.basketmanager.api.application.basket.team;

import fr.damaketo.basketmanager.api.domain.AccountRepository;
import fr.damaketo.basketmanager.api.domain.LeagueRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class TeamConfiguration {

    @Bean
    CreateTeam CreateTeam(final LeagueRepository leagueRepository, final AccountRepository accountRepository) {
        return new CreateTeam(leagueRepository, accountRepository);
    }

    @Bean
    GetTeam getTeam(final LeagueRepository leagueRepository) {
        return new GetTeam(leagueRepository);
    }
}
