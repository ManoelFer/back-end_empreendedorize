package com.manoelneto.empreendedorize.ws.services.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.FonteDeRecursos;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.FonteDeRecursosDto;
import com.manoelneto.empreendedorize.ws.repository.introducao.FonteDeRecursosRepository;
import com.manoelneto.empreendedorize.ws.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FonteDeRecursosService {

    @Autowired
    private FonteDeRecursosRepository fonteDeRecursosRepository;

    public List<FonteDeRecursos> findAll(){
        return fonteDeRecursosRepository.findAll();
    }

    public FonteDeRecursos findById(String id){
        Optional<FonteDeRecursos> fonteDeRecursos = fonteDeRecursosRepository.findById(id);
        return fonteDeRecursos.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public FonteDeRecursos create(FonteDeRecursos fonteDeRecursos){
        return fonteDeRecursosRepository.save(fonteDeRecursos);
    }

    public FonteDeRecursos fromDTO (FonteDeRecursosDto fonteDeRecursosDto){
        return new FonteDeRecursos(fonteDeRecursosDto);
    }

    public FonteDeRecursos update(FonteDeRecursos fonteDeRecursos) {
        Optional<FonteDeRecursos> updateFonteDeRecursos = fonteDeRecursosRepository.findById(fonteDeRecursos.getId());
        return updateFonteDeRecursos.map(u -> fonteDeRecursosRepository.save(new FonteDeRecursos(fonteDeRecursos.getId(),
                fonteDeRecursos.getPlano(), fonteDeRecursos.getDescricao())))
                .orElseThrow(() -> new ObjectNotFoundException("Fonte de recursos não encontrada!"));
    }

    public void delete(String id){
        fonteDeRecursosRepository.deleteById(id);
    }
}
