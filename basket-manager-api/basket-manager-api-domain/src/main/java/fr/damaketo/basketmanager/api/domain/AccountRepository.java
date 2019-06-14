
package fr.damaketo.basketmanager.api.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
public interface AccountRepository {

    Mono<Account> create(final String login);

    Mono<Account> getById(final String id);

    Flux<Account> getAll();
}
