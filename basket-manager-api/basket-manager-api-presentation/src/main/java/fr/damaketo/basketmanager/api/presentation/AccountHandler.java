package fr.damaketo.basketmanager.api.presentation;

import fr.damaketo.basketmanager.api.application.account.CreateAccount;
import fr.damaketo.basketmanager.api.application.account.GetAccount;
import fr.damaketo.basketmanager.api.application.account.UpdateAccount;
import fr.damaketo.basketmanager.api.domain.Account;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 *
 */
@Component
public class AccountHandler {

    private CreateAccount createAccount;
    private GetAccount getAccount;
    private UpdateAccount updateAccount;

    public AccountHandler(final CreateAccount createAccount,
                          final GetAccount getAccount,
                          final UpdateAccount updateAccount) {
        this.createAccount = createAccount;
        this.getAccount = getAccount;
        this.updateAccount = updateAccount;
    }

    Mono<ServerResponse> getById(ServerRequest request) {
        Mono<Account> mono = this.getAccount.byId(id(request));
        return defaultReadResponse(mono);
    }

    Mono<ServerResponse> all(ServerRequest request) {
        Flux<Account> flux = request
                .bodyToFlux(Account.class)
                .flatMap(toWrite -> this.getAccount.all());
        return defaultReadResponse(flux);
    }

    Mono<ServerResponse> create(ServerRequest request) {
        Flux<Account> flux = request
                .bodyToFlux(Account.class)
                .flatMap(toWrite -> this.createAccount.proceed(toWrite));
        return defaultWriteResponse(flux);
    }

    private static Mono<ServerResponse> defaultWriteResponse(Publisher<Account> accounts) {
        return Mono
                .from(accounts)
                .flatMap(account -> ServerResponse
                        .created(URI.create("/accounts/" + account.getId()))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .build()
                );
    }


    private static Mono<ServerResponse> defaultReadResponse(Publisher<Account> accounts) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(accounts, Account.class);
    }

    private static String id(ServerRequest r) {
        return r.pathVariable("id");
    }
}
