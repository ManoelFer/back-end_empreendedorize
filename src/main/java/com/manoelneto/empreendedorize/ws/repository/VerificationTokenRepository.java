package com.manoelneto.empreendedorize.ws.repository;

import com.manoelneto.empreendedorize.ws.domain.User;
import com.manoelneto.empreendedorize.ws.domain.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends MongoRepository<VerificationToken, String> {

    Optional<VerificationToken>  findByToken(String token);

    Optional<VerificationToken> findByUser(User user);

}
