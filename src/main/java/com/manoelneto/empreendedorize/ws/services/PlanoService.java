package com.manoelneto.empreendedorize.ws.services;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.User;
import com.manoelneto.empreendedorize.ws.dto.PlanoDto;
import com.manoelneto.empreendedorize.ws.repository.PlanoRepository;
import com.manoelneto.empreendedorize.ws.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public List<Plano> findAll(User user) {
        return planoRepository.getPlanoByUsu(user);
    }

    public Plano findByID(String id){
        Optional<Plano> user = planoRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public Plano create(Plano plano){
        return planoRepository.save(plano);
    }

    public Plano fromDTO(PlanoDto planoDto){ return new Plano(planoDto); }

    public Plano update(Plano plano) {
        Optional<Plano> updatePlano = planoRepository.findById(plano.getId());
        return updatePlano.map(u -> planoRepository.save(new Plano(plano.getUsu(),plano.getNomePlano(),plano.getDataConclusao(),plano.getFinalidade())))
                .orElseThrow(() -> new ObjectNotFoundException("Plano não encontrado!"));
    }

    public void delete(String id){
        planoRepository.deleteById(id);
    }
}
