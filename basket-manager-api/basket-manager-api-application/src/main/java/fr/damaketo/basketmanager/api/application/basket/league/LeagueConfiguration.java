package fr.damaketo.basketmanager.api.application.basket.league;

import fr.damaketo.basketmanager.api.domain.AccountRepository;
import fr.damaketo.basketmanager.api.domain.LeagueRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class LeagueConfiguration {

    @Bean
    CreateLeague createLeague(final LeagueRepository leagueRepository, final AccountRepository accountRepository) {
        return new CreateLeague(leagueRepository, accountRepository);
    }

    @Bean
    GetLeague getLeague(final LeagueRepository leagueRepository) {
        return new GetLeague(leagueRepository);
    }

    @Bean
    UpdateLeague updateLeague(final LeagueRepository leagueRepository) {
        return new UpdateLeague(leagueRepository);
    }
}
