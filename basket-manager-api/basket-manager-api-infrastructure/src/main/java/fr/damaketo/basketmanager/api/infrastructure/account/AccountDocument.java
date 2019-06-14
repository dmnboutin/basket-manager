
package fr.damaketo.basketmanager.api.infrastructure.account;

import fr.damaketo.basketmanager.api.domain.Account;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
@Document("account")
public class AccountDocument {

    @Id
    private String id;
    private String login;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Account toAccount() {
        final Account account = new Account();
        account.setId(this.id);
        account.setLogin(this.login);
        return account;
    }
}

