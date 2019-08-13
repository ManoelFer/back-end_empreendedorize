package com.manoelneto.empreendedorize.ws.resources.introducao;

import com.manoelneto.empreendedorize.ws.dto.introducaoDto.DadosEmpreendedoresDto;
import com.manoelneto.empreendedorize.ws.services.introducao.DadosEmpreendedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.manoelneto.empreendedorize.ws.domain.introducao.DadosEmpreendedores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DadosEmpreendedoresResource {

    @Autowired
    DadosEmpreendedoresService dadosEmpreendedoresService;

    @GetMapping("/dadosEmpreendedores")
    public  ResponseEntity<List<DadosEmpreendedoresDto>> findAll(){
        List<DadosEmpreendedores> dadosEmpreendedores = dadosEmpreendedoresService.findAll();
        List<DadosEmpreendedoresDto> listDTO = dadosEmpreendedores.stream().map(x -> new DadosEmpreendedoresDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/dadosEmpreendedores/{id}")
    public ResponseEntity<DadosEmpreendedoresDto> findById(@PathVariable String id){
        DadosEmpreendedores dadosEmpreendedores = dadosEmpreendedoresService.findById(id);
        return ResponseEntity.ok().body(new DadosEmpreendedoresDto(dadosEmpreendedores));
    }

    @PostMapping("/dadosEmpreendedores")
    public ResponseEntity<DadosEmpreendedoresDto> create(@RequestBody DadosEmpreendedoresDto dadosEmpreendedoresDto){
        DadosEmpreendedores dadosEmpreendedores = dadosEmpreendedoresService.fromDTO(dadosEmpreendedoresDto);
        return  ResponseEntity.ok().body(new DadosEmpreendedoresDto(dadosEmpreendedoresService.create(dadosEmpreendedores)));
    }

    @PutMapping("/dadosEmpreendedores/{id}")
    public ResponseEntity<DadosEmpreendedoresDto> update(@PathVariable String id, @RequestBody DadosEmpreendedoresDto dadosEmpreendedoresDto) {
        DadosEmpreendedores dadosEmpreendedores = dadosEmpreendedoresService.fromDTO(dadosEmpreendedoresDto);
        dadosEmpreendedores.setId(id);
        return ResponseEntity.ok().body(new DadosEmpreendedoresDto(dadosEmpreendedoresService.update(dadosEmpreendedores)));
    }

    @DeleteMapping("/dadosEmpreendedores/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        dadosEmpreendedoresService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
