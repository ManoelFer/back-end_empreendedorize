package com.manoelneto.empreendedorize.ws.repository.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.SetoresDeAtividade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetoresDeAtividadeRepository extends MongoRepository<SetoresDeAtividade, String> {
}
