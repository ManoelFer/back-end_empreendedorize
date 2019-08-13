package com.manoelneto.empreendedorize.ws.resources.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.SetoresDeAtividade;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.SetoresDeAtividadeDto;
import com.manoelneto.empreendedorize.ws.services.introducao.SetoresDeAtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SetoresDeAtividadeResource {

    @Autowired
    SetoresDeAtividadeService setoresDeAtividadeService;

    @GetMapping("/setoresDeAtividade")
    public ResponseEntity<List<SetoresDeAtividadeDto>> findAll(){
        List<SetoresDeAtividade> setoresDeAtividade= setoresDeAtividadeService.findAll();
        List<SetoresDeAtividadeDto> listDTO = setoresDeAtividade.stream().map(x -> new SetoresDeAtividadeDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/setoresDeAtividade/{id}")
    public ResponseEntity<SetoresDeAtividadeDto> findById(@PathVariable String id){
        SetoresDeAtividade setoresDeAtividade = setoresDeAtividadeService.findById(id);
        return ResponseEntity.ok().body(new SetoresDeAtividadeDto(setoresDeAtividade));
    }

    @PostMapping("/setoresDeAtividade")
    public ResponseEntity<SetoresDeAtividadeDto> create(@RequestBody SetoresDeAtividadeDto setoresDeAtividadeDto){
        SetoresDeAtividade setoresDeAtividade= setoresDeAtividadeService.fromDTO(setoresDeAtividadeDto);
        return  ResponseEntity.ok().body(new SetoresDeAtividadeDto(setoresDeAtividadeService.create(setoresDeAtividade)));
    }

    @PutMapping("/setoresDeAtividade/{id}")
    public ResponseEntity<SetoresDeAtividadeDto> update(@PathVariable String id, @RequestBody SetoresDeAtividadeDto setoresDeAtividadeDto) {
        SetoresDeAtividade setoresDeAtividade = setoresDeAtividadeService.fromDTO(setoresDeAtividadeDto);
        setoresDeAtividade.setId(id);
        return ResponseEntity.ok().body(new SetoresDeAtividadeDto(setoresDeAtividadeService.update(setoresDeAtividade)));
    }

    @DeleteMapping("/setoresDeAtividade/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        setoresDeAtividadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
