package com.manoelneto.empreendedorize.ws.repository.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.MissaoDaEmpresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoDaEmpresaRepository extends MongoRepository<MissaoDaEmpresa, String> {
}
