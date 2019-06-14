
package fr.damaketo.basketmanager.api.application.basket.team;

import fr.damaketo.basketmanager.api.domain.*;
import reactor.core.publisher.Mono;

/**
 *
 */
public class CreateTeam {

    private final LeagueRepository leagueRepository;
    private final AccountRepository accountRepository;

    public CreateTeam(LeagueRepository leagueRepository, AccountRepository accountRepository) {
        this.leagueRepository = leagueRepository;
        this.accountRepository = accountRepository;
    }

    public Mono<Team> proceed(final Team team, final String leagueId, final String accountId) {
        return accountRepository.getById(accountId)
                .flatMap(account -> leagueRepository.createTeam(team, leagueId, account));
    }
}
