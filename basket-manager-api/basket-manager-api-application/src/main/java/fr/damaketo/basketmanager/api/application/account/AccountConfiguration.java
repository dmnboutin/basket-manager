
package fr.damaketo.basketmanager.api.application.account;

import fr.damaketo.basketmanager.api.domain.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class AccountConfiguration {

    @Bean
    CreateAccount createAccount(final AccountRepository accountRepository) {
        return new CreateAccount(accountRepository);
    }

    @Bean
    GetAccount getAccount(final AccountRepository accountRepository) {
        return new GetAccount(accountRepository);
    }

    @Bean
    UpdateAccount updateAccount(final AccountRepository accountRepository) {
        return new UpdateAccount(accountRepository);
    }
}
