package com.manoelneto.empreendedorize.ws.repository;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanoRepository extends MongoRepository <Plano, String> {

}
