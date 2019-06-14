package fr.damaketo.basketmanager.api.presentation;

import fr.damaketo.basketmanager.api.application.basket.league.CreateLeague;
import fr.damaketo.basketmanager.api.application.basket.league.GetLeague;
import fr.damaketo.basketmanager.api.application.basket.league.UpdateLeague;
import fr.damaketo.basketmanager.api.application.basket.team.CreateTeam;
import fr.damaketo.basketmanager.api.domain.League;
import fr.damaketo.basketmanager.api.domain.Team;
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
public class LeagueHandler {

    private CreateLeague createLeague;
    private GetLeague getLeague;
    private UpdateLeague updateLeague;
    private CreateTeam createTeam;

    public LeagueHandler(final CreateLeague createLeague,
                         final GetLeague getLeague,
                         final UpdateLeague updateLeague,
                         final CreateTeam createTeam) {
        this.createLeague = createLeague;
        this.getLeague = getLeague;
        this.updateLeague = updateLeague;
        this.createTeam = createTeam;
    }

    Mono<ServerResponse> getById(ServerRequest request) {
        Mono<League> mono = this.getLeague.byId(id(request));
        return defaultReadResponse(mono);
    }

    Mono<ServerResponse> all(ServerRequest request) {
        Flux<League> flux = request
                .bodyToFlux(League.class)
                .flatMap(toWrite -> this.getLeague.all());
        return defaultReadResponse(flux);
    }

    Mono<ServerResponse> create(ServerRequest request) {
        Flux<League> flux = request
                .bodyToFlux(League.class)
                .flatMap(toWrite -> this.createLeague.proceed(accountId(request), toWrite));
        return defaultWriteResponse(flux);
    }

    private static Mono<ServerResponse> defaultWriteResponse(Publisher<League> leagues) {
        return Mono
                .from(leagues)
                .flatMap(league -> ServerResponse
                        .created(URI.create("/leagues/" + league.getId()))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .build()
                );
    }

    private static Mono<ServerResponse> defaultWriteResponseTeam(final String leagueId, Publisher<Team> teams) {
        return Mono
                .from(teams)
                .flatMap(team -> ServerResponse
                        .created(URI.create("/leagues/" + leagueId + "/teams/" + team.getId()))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .build()
                );
    }


    private static Mono<ServerResponse> defaultReadResponse(Publisher<League> leagues) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(leagues, League.class);
    }

    private static Mono<ServerResponse> defaultReadResponseTeam(Publisher<Team> teams) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(teams, Team.class);
    }

    private static String id(ServerRequest request) {
        return request.pathVariable("id");
    }

    private static String accountId(ServerRequest request) {
        return request.headers().header("accountId").get(0);
    }

    public Mono<ServerResponse> addTeam(ServerRequest request) {
        Mono<Team> mono = request
                .bodyToMono(Team.class)
                .flatMap(teamToAdd -> this.createTeam.proceed(teamToAdd, id(request), accountId(request)));
        return defaultWriteResponseTeam(id(request), mono);
    }
}
