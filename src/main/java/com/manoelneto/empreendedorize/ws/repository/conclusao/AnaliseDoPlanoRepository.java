package com.manoelneto.empreendedorize.ws.repository.conclusao;


import com.manoelneto.empreendedorize.ws.domain.conclusao.AnaliseDoPlano;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseDoPlanoRepository  extends MongoRepository<AnaliseDoPlano, String> {
}
