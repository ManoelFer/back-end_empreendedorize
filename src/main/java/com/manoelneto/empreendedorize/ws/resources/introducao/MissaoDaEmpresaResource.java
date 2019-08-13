package com.manoelneto.empreendedorize.ws.resources.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.MissaoDaEmpresa;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.MissaoDaEmpresaDto;
import com.manoelneto.empreendedorize.ws.services.introducao.MissaoDaEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MissaoDaEmpresaResource {

    @Autowired
    MissaoDaEmpresaService missaoDaEmpresaService;

    @GetMapping("/missaoDaEmpresa")
    public ResponseEntity<List<MissaoDaEmpresaDto>> findAll(){
        List<MissaoDaEmpresa> missaoDaEmpresa = missaoDaEmpresaService.findAll();
        List<MissaoDaEmpresaDto> listDTO = missaoDaEmpresa.stream().map(x -> new MissaoDaEmpresaDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/missaoDaEmpresa/{id}")
    public ResponseEntity<MissaoDaEmpresaDto> findById(@PathVariable String id){
        MissaoDaEmpresa missaoDaEmpresa = missaoDaEmpresaService.findById(id);
        return ResponseEntity.ok().body(new MissaoDaEmpresaDto(missaoDaEmpresa));
    }

    @PostMapping("/missaoDaEmpresa")
    public ResponseEntity<MissaoDaEmpresaDto> create(@RequestBody MissaoDaEmpresaDto missaoDaEmpresaDto){
        MissaoDaEmpresa missaoDaEmpresa = missaoDaEmpresaService.fromDTO(missaoDaEmpresaDto);
        return  ResponseEntity.ok().body(new MissaoDaEmpresaDto(missaoDaEmpresaService.create(missaoDaEmpresa)));
    }

    @PutMapping("/missaoDaEmpresa/{id}")
    public ResponseEntity<MissaoDaEmpresaDto> update(@PathVariable String id, @RequestBody MissaoDaEmpresaDto missaoDaEmpresaDto) {
        MissaoDaEmpresa missaoDaEmpresa = missaoDaEmpresaService.fromDTO(missaoDaEmpresaDto);
        missaoDaEmpresa.setId(id);
        return ResponseEntity.ok().body(new MissaoDaEmpresaDto(missaoDaEmpresaService.update(missaoDaEmpresa)));
    }

    @DeleteMapping("/missaoDaEmpresa/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        missaoDaEmpresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
