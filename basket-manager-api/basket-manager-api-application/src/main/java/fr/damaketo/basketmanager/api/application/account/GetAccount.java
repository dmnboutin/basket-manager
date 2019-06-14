
package fr.damaketo.basketmanager.api.application.account;

import fr.damaketo.basketmanager.api.domain.Account;
import fr.damaketo.basketmanager.api.domain.AccountRepository;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 *
 */
public class GetAccount {

    private final AccountRepository accountRepository;

    public GetAccount(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Mono<Account> byId(final String email) {
        return accountRepository.getById(email);
    }

    public Flux<Account> all() {
        return accountRepository.getAll();

    }
}
