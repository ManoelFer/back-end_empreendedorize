package com.manoelneto.empreendedorize.ws.services.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.CapitalSocial;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.CapitalSocialDto;
import com.manoelneto.empreendedorize.ws.repository.introducao.CapitalSocialRepository;
import com.manoelneto.empreendedorize.ws.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapitalSocialService {

    @Autowired
    private CapitalSocialRepository capitalSocialRepository;

    public List<CapitalSocial> findAll(){
        return capitalSocialRepository.findAll();
    }

    public CapitalSocial findById(String id){
        Optional<CapitalSocial> capitalSocial = capitalSocialRepository.findById(id);
        return capitalSocial.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public CapitalSocial create(CapitalSocial capitalSocial){
        return capitalSocialRepository.save(capitalSocial);
    }

    public CapitalSocial fromDTO (CapitalSocialDto capitalSocialDto){
        return new CapitalSocial(capitalSocialDto);
    }

    public CapitalSocial update(CapitalSocial capitalSocial) {
        Optional<CapitalSocial> updateCapitalSocial = capitalSocialRepository.findById(capitalSocial.getId());
        return updateCapitalSocial.map(u -> capitalSocialRepository.save(new CapitalSocial(capitalSocial.getId(),
                capitalSocial.getPlano(), capitalSocial.getValorParticipacao())))
                .orElseThrow(() -> new ObjectNotFoundException("Capital social não encontrada!"));
    }

    public void delete(String id){
        capitalSocialRepository.deleteById(id);
    }
}
