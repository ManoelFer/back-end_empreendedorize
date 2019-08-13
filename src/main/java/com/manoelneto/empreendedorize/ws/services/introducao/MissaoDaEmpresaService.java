package com.manoelneto.empreendedorize.ws.services.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.MissaoDaEmpresa;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.MissaoDaEmpresaDto;
import com.manoelneto.empreendedorize.ws.repository.introducao.MissaoDaEmpresaRepository;
import com.manoelneto.empreendedorize.ws.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoDaEmpresaService {

    @Autowired
    private MissaoDaEmpresaRepository missaoDaEmpresaRepository;


    public List<MissaoDaEmpresa> findAll(){
        return missaoDaEmpresaRepository.findAll();
    }

    public MissaoDaEmpresa findById(String id){
        Optional<MissaoDaEmpresa> missaoDaEmpresa = missaoDaEmpresaRepository.findById(id);
        return missaoDaEmpresa.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public MissaoDaEmpresa create(MissaoDaEmpresa missaoDaEmpresa){
        return missaoDaEmpresaRepository.save(missaoDaEmpresa);
    }

    public MissaoDaEmpresa fromDTO (MissaoDaEmpresaDto missaoDaEmpresaDto){
        return new MissaoDaEmpresa(missaoDaEmpresaDto);
    }

    public MissaoDaEmpresa update(MissaoDaEmpresa missaoDaEmpresa) {
        Optional<MissaoDaEmpresa> updateMissaoDaEmpresa = missaoDaEmpresaRepository.findById(missaoDaEmpresa.getId());
        return updateMissaoDaEmpresa.map(u -> missaoDaEmpresaRepository.save(new MissaoDaEmpresa(missaoDaEmpresa.getId(),
                missaoDaEmpresa.getPlano(), missaoDaEmpresa.getDescricaoMissao())))
                .orElseThrow(() -> new ObjectNotFoundException("Missão da empresa não encontrada!"));
    }

    public void delete(String id){
        missaoDaEmpresaRepository.deleteById(id);
    }
}
