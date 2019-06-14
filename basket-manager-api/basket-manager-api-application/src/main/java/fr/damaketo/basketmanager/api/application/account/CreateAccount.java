
package fr.damaketo.basketmanager.api.application.account;

import fr.damaketo.basketmanager.api.domain.Account;
import fr.damaketo.basketmanager.api.domain.AccountRepository;
import reactor.core.publisher.Mono;

/**
 *
 */
public class CreateAccount {

    private final AccountRepository accountRepository;

    public CreateAccount(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Mono<Account> proceed(final Account account) {

        return accountRepository.create(account.getLogin());
    }
}
