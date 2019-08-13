package com.manoelneto.empreendedorize.ws.services.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.DadosEmpreendedores;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.DadosEmpreendedoresDto;
import com.manoelneto.empreendedorize.ws.repository.introducao.DadosEmpreendedoresRepository;
import com.manoelneto.empreendedorize.ws.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DadosEmpreendedoresService {

    @Autowired
    private DadosEmpreendedoresRepository dadosEmpreendedoresRepository;

    public List<DadosEmpreendedores> findAll(){
        return dadosEmpreendedoresRepository.findAll();
    }

    public DadosEmpreendedores findById(String id){
        Optional<DadosEmpreendedores> dadosEmpreendedores = dadosEmpreendedoresRepository.findById(id);
        return dadosEmpreendedores.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public DadosEmpreendedores create(DadosEmpreendedores dadosEmpreendedores){
        return dadosEmpreendedoresRepository.save(dadosEmpreendedores);
    }

    public DadosEmpreendedores fromDTO (DadosEmpreendedoresDto dadosEmpreendedoresDto){
        return new DadosEmpreendedores(dadosEmpreendedoresDto);
    }

    public DadosEmpreendedores update(DadosEmpreendedores dadosEmpreendedores) {
        Optional<DadosEmpreendedores> updateDadosEmpreendedores = dadosEmpreendedoresRepository.findById(dadosEmpreendedores.getId());
        return updateDadosEmpreendedores.map(u -> dadosEmpreendedoresRepository.save(new DadosEmpreendedores(dadosEmpreendedores.getId(),
                dadosEmpreendedores.getPlano(), dadosEmpreendedores.getNomeSocio(), dadosEmpreendedores.getEndereco(),
                dadosEmpreendedores.getCidade(), dadosEmpreendedores.getEstado(), dadosEmpreendedores.getFone1(),
                dadosEmpreendedores.getFone2(), dadosEmpreendedores.getEmailSocio(), dadosEmpreendedores.getPerfil(),
                dadosEmpreendedores.getAtribuicoes())))
                .orElseThrow(() -> new ObjectNotFoundException("Dados do sócio não encontrado!"));
    }

    public void delete(String id){
        dadosEmpreendedoresRepository.deleteById(id);
    }
}
