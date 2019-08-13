package com.manoelneto.empreendedorize.ws.services.conclusaoService;

import com.manoelneto.empreendedorize.ws.domain.conclusao.AnaliseDoPlano;
import com.manoelneto.empreendedorize.ws.dto.conclusaoDto.AnaliseDoPlanoDto;
import com.manoelneto.empreendedorize.ws.repository.conclusao.AnaliseDoPlanoRepository;
import com.manoelneto.empreendedorize.ws.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnaliseDoPlanoService {

    @Autowired
    private AnaliseDoPlanoRepository analiseDoPlanoRepository;

    public List<AnaliseDoPlano> findAll(){
        return analiseDoPlanoRepository.findAll();
    }

    public AnaliseDoPlano findById(String id){
        Optional<AnaliseDoPlano> analiseDoPlano = analiseDoPlanoRepository.findById(id);
        return analiseDoPlano.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public AnaliseDoPlano create(AnaliseDoPlano analiseDoPlano){
        return analiseDoPlanoRepository.save(analiseDoPlano);
    }

    public AnaliseDoPlano fromDTO (AnaliseDoPlanoDto analiseDoPlanoDto){
        return new AnaliseDoPlano(analiseDoPlanoDto);
    }

    public AnaliseDoPlano update(AnaliseDoPlano analiseDoPlano) {
        Optional<AnaliseDoPlano> updateAnaliseDoPlano = analiseDoPlanoRepository.findById(analiseDoPlano.getId());
        return updateAnaliseDoPlano.map(u -> analiseDoPlanoRepository.save(new AnaliseDoPlano(analiseDoPlano.getId(),
                analiseDoPlano.getPlano(), analiseDoPlano.getDescricaoAnalise())))
                .orElseThrow(() -> new ObjectNotFoundException("Análise do plano não encontrada!"));
    }

    public void delete(String id){
        analiseDoPlanoRepository.deleteById(id);
    }
}
