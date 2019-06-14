
package fr.damaketo.basketmanager.api.presentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

/**
 *
 */
@Configuration
public class BasketManagerEndpointConfiguration {
    /*@Bean
    AccountHandler accountHandler(final CreateAccount createAccount,
                                  final UpdateAccount updateAccount,
                                  final GetAccount getAccount) {
        return new AccountHandler(createAccount, getAccount, updateAccount);
    }*/

    @Bean
    RouterFunction<ServerResponse> routes(final AccountHandler accountHandler,
                                          final PlayerHandler playerHandler,
                                          final LeagueHandler leagueHandler) {
        return RouterFunctions.route(i(RequestPredicates.GET("/accounts")), accountHandler::all)
                .andRoute(i(RequestPredicates.GET("/accounts/{id}")), accountHandler::getById)
                .andRoute(i(RequestPredicates.POST("/accounts")), accountHandler::create)
                .andRoute(i(RequestPredicates.GET("/leagues")), leagueHandler::all)
                .andRoute(i(RequestPredicates.GET("/leagues/{id}")), leagueHandler::getById)
                .andRoute(i(RequestPredicates.GET("/leagues/{leagueId}/players")), playerHandler::getByLeagueId)
                .andRoute(i(RequestPredicates.POST("/leagues/{leagueId}/players")), playerHandler::create)
                .andRoute(i(RequestPredicates.POST("/leagues/{id}/teams")), leagueHandler::addTeam)
                .andRoute(i(RequestPredicates.POST("/leagues")), leagueHandler::create)
                .andRoute(i(RequestPredicates.GET("/players")), playerHandler::all)
                .andRoute(i(RequestPredicates.GET("/players/{id}")), playerHandler::getById);

    }


    private static RequestPredicate i(RequestPredicate target) {
        return new CaseInsensitiveRequestPredicate(target);
    }
}
