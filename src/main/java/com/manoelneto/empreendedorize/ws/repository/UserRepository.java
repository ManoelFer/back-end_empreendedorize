package com.manoelneto.empreendedorize.ws.repository;

import com.manoelneto.empreendedorize.ws.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

        Optional<User> findByEmail (String email);
}
