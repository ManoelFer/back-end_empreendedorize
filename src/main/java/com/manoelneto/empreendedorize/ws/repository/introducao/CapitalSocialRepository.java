package com.manoelneto.empreendedorize.ws.repository.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.CapitalSocial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitalSocialRepository extends MongoRepository<CapitalSocial, String> {
}
