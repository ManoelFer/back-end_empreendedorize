package com.manoelneto.empreendedorize.ws.resources.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.FonteDeRecursos;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.FonteDeRecursosDto;
import com.manoelneto.empreendedorize.ws.services.introducao.FonteDeRecursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FonteDeRecursosResource {

    @Autowired
    FonteDeRecursosService fonteDeRecursosService;

    @GetMapping("/fonteDeRecursos")
    public ResponseEntity<List<FonteDeRecursosDto>> findAll(){
        List<FonteDeRecursos> fonteDeRecursos = fonteDeRecursosService.findAll();
        List<FonteDeRecursosDto> listDTO = fonteDeRecursos.stream().map(x -> new FonteDeRecursosDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/fonteDeRecursos/{id}")
    public ResponseEntity<FonteDeRecursosDto> findById(@PathVariable String id){
        FonteDeRecursos fonteDeRecursos = fonteDeRecursosService.findById(id);
        return ResponseEntity.ok().body(new FonteDeRecursosDto(fonteDeRecursos));
    }

    @PostMapping("/fonteDeRecursos")
    public ResponseEntity<FonteDeRecursosDto> create(@RequestBody FonteDeRecursosDto fonteDeRecursosDto){
        FonteDeRecursos fonteDeRecursos = fonteDeRecursosService.fromDTO(fonteDeRecursosDto);
        return  ResponseEntity.ok().body(new FonteDeRecursosDto(fonteDeRecursosService.create(fonteDeRecursos)));
    }


    @PutMapping("/fonteDeRecursos/{id}")
    public ResponseEntity<FonteDeRecursosDto> update(@PathVariable String id, @RequestBody FonteDeRecursosDto fonteDeRecursosDto) {
        FonteDeRecursos fonteDeRecursos = fonteDeRecursosService.fromDTO(fonteDeRecursosDto);
        fonteDeRecursos.setId(id);
        return ResponseEntity.ok().body(new FonteDeRecursosDto(fonteDeRecursosService.update(fonteDeRecursos)));
    }

    @DeleteMapping("/fonteDeRecursos/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        fonteDeRecursosService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
