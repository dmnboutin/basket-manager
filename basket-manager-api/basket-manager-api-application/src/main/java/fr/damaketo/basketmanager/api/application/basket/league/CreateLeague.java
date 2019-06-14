
package fr.damaketo.basketmanager.api.application.basket.league;

import fr.damaketo.basketmanager.api.domain.AccountRepository;
import fr.damaketo.basketmanager.api.domain.League;
import fr.damaketo.basketmanager.api.domain.LeagueRepository;
import reactor.core.publisher.Mono;

/**
 *
 */
public class CreateLeague {

    private final LeagueRepository leagueRepository;
    private final AccountRepository accountRepository;

    public CreateLeague(LeagueRepository leagueRepository, AccountRepository accountRepository) {
        this.leagueRepository = leagueRepository;
        this.accountRepository = accountRepository;
    }

    public Mono<League> proceed(final String accountId, final League league) {
        return accountRepository.getById(accountId)
                .map(account -> {
                    league.setAdministrator(account);
                    return league;
                })
                .flatMap(leagueRepository::create);
    }
}
