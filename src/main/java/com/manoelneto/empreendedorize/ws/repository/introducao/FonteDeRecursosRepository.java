package com.manoelneto.empreendedorize.ws.repository.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.FonteDeRecursos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonteDeRecursosRepository extends MongoRepository<FonteDeRecursos, String> {
}
