package fr.damaketo.basketmanager.api.infrastructure.account;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface AccountMongoRepository extends ReactiveMongoRepository<AccountDocument, String> {

}
