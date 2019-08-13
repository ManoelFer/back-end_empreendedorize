package com.manoelneto.empreendedorize.ws.resources.conclusaoResources;

import com.manoelneto.empreendedorize.ws.domain.conclusao.AnaliseDoPlano;
import com.manoelneto.empreendedorize.ws.dto.conclusaoDto.AnaliseDoPlanoDto;
import com.manoelneto.empreendedorize.ws.services.conclusaoService.AnaliseDoPlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AnaliseDoPlanoResource {

    @Autowired
    AnaliseDoPlanoService analiseDoPlanoService;

    @GetMapping("/analiseDoPlano")
    public ResponseEntity<List<AnaliseDoPlanoDto>> findAll(){
        List<AnaliseDoPlano> analiseDoPlano = analiseDoPlanoService.findAll();
        List<AnaliseDoPlanoDto> listDTO = analiseDoPlano.stream().map(x -> new AnaliseDoPlanoDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/analiseDoPlano/{id}")
    public ResponseEntity<AnaliseDoPlanoDto> findById(@PathVariable String id){
        AnaliseDoPlano analiseDoPlano = analiseDoPlanoService.findById(id);
        return ResponseEntity.ok().body(new AnaliseDoPlanoDto(analiseDoPlano));
    }

    @PostMapping("/analiseDoPlano")
    public ResponseEntity<AnaliseDoPlanoDto> create(@RequestBody AnaliseDoPlanoDto analiseDoPlanoDto){
        AnaliseDoPlano analiseDoPlano = analiseDoPlanoService.fromDTO(analiseDoPlanoDto);
        return  ResponseEntity.ok().body(new AnaliseDoPlanoDto(analiseDoPlanoService.create(analiseDoPlano)));
    }

    @PutMapping("/analiseDoPlano/{id}")
    public ResponseEntity<AnaliseDoPlanoDto> update(@PathVariable String id, @RequestBody AnaliseDoPlanoDto analiseDoPlanoDto) {
        AnaliseDoPlano analiseDoPlano = analiseDoPlanoService.fromDTO(analiseDoPlanoDto);
        analiseDoPlano.setId(id);
        return ResponseEntity.ok().body(new AnaliseDoPlanoDto(analiseDoPlanoService.update(analiseDoPlano)));
    }

    @DeleteMapping("/analiseDoPlano/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        analiseDoPlanoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
