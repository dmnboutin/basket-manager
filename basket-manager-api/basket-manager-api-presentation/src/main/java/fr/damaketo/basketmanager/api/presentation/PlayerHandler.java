package fr.damaketo.basketmanager.api.presentation;

import fr.damaketo.basketmanager.api.application.basket.player.CreatePlayer;
import fr.damaketo.basketmanager.api.application.basket.player.GetPlayer;
import fr.damaketo.basketmanager.api.application.basket.player.UpdatePlayer;
import fr.damaketo.basketmanager.api.domain.Player;
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
public class PlayerHandler {

    private CreatePlayer createPlayer;
    private GetPlayer getPlayer;
    private UpdatePlayer updatePlayer;

    public PlayerHandler(CreatePlayer createPlayer, GetPlayer getPlayer, UpdatePlayer updatePlayer) {
        this.createPlayer = createPlayer;
        this.getPlayer = getPlayer;
        this.updatePlayer = updatePlayer;
    }

    Mono<ServerResponse> getById(ServerRequest request) {
        Mono<Player> mono = this.getPlayer.byId(id(request));
        return defaultReadResponse(mono);
    }

    Mono<ServerResponse> all(ServerRequest request) {
        Flux<Player> flux = request
                .bodyToFlux(Player.class)
                .flatMap(toWrite -> this.getPlayer.all());
        return defaultReadResponse(flux);
    }

    Mono<ServerResponse> create(ServerRequest request) {
        Flux<Player> flux = request
                .bodyToFlux(Player.class)
                .flatMap(player -> this.createPlayer.proceed(player, leagueId(request)));
        return defaultWriteResponse(flux);
    }

    public Mono<ServerResponse> getByLeagueId(ServerRequest request) {
        return defaultReadResponse(this.getPlayer.byLeagueId(leagueId(request)));
    }

    private static Mono<ServerResponse> defaultWriteResponse(Publisher<Player> players) {
        return Mono
                .from(players)
                .flatMap(player -> ServerResponse
                        .created(URI.create("/players/" + player.getId()))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .build()
                );
    }


    private static Mono<ServerResponse> defaultReadResponse(Publisher<Player> players) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(players, Player.class);
    }

    private static String id(ServerRequest r) {
        return r.pathVariable("id");
    }

    private static String leagueId(ServerRequest r) {
        return r.pathVariable("leagueId");
    }

}
