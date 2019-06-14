package fr.damaketo.basketmanager.api.infrastructure.account;

import fr.damaketo.basketmanager.api.domain.Account;
import fr.damaketo.basketmanager.api.domain.AccountRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
public class AccountDefaultRepository implements AccountRepository {

    private AccountMongoRepository accountMongoRepository;

    public AccountDefaultRepository(AccountMongoRepository accountMongoRepository) {
        this.accountMongoRepository = accountMongoRepository;
    }

    public Mono<Account> create(String login) {
        final AccountDocument account = new AccountDocument();
        account.setLogin(login);
        return accountMongoRepository.save(account)
            .map(AccountDocument::toAccount)
                .doOnError(throwable -> Mono.error(new Exception()));
    }

    public Mono<Account> getById(String id) {
        return accountMongoRepository.findById(id)
                .map(AccountDocument::toAccount);
    }

    public Flux<Account> getAll() {
        return accountMongoRepository.findAll().map(AccountDocument::toAccount);
    }
}
