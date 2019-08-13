package com.manoelneto.empreendedorize.ws.services.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.SetoresDeAtividade;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.SetoresDeAtividadeDto;
import com.manoelneto.empreendedorize.ws.repository.introducao.SetoresDeAtividadeRepository;
import com.manoelneto.empreendedorize.ws.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetoresDeAtividadeService {

    @Autowired
    private SetoresDeAtividadeRepository setoresDeAtividadeRepository;

    public List<SetoresDeAtividade> findAll(){
        return setoresDeAtividadeRepository.findAll();
    }

    public SetoresDeAtividade findById(String id){
        Optional<SetoresDeAtividade> setoresDeAtividade = setoresDeAtividadeRepository.findById(id);
        return setoresDeAtividade.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public SetoresDeAtividade create(SetoresDeAtividade setoresDeAtividade){
        return setoresDeAtividadeRepository.save(setoresDeAtividade);
    }

    public SetoresDeAtividade fromDTO (SetoresDeAtividadeDto setoresDeAtividadeDto){
        return new SetoresDeAtividade(setoresDeAtividadeDto);
    }

    public SetoresDeAtividade update(SetoresDeAtividade setoresDeAtividade) {
        Optional<SetoresDeAtividade> updateSetoresDeAtividade = setoresDeAtividadeRepository.findById(setoresDeAtividade.getId());
        return updateSetoresDeAtividade.map(u -> setoresDeAtividadeRepository.save(new SetoresDeAtividade(setoresDeAtividade.getId(),
                setoresDeAtividade.getPlano(), setoresDeAtividade.getTipoSetor())))
                .orElseThrow(() -> new ObjectNotFoundException("Setor de atividade não encontrado!"));
    }

    public void delete(String id){
        setoresDeAtividadeRepository.deleteById(id);
    }
}
