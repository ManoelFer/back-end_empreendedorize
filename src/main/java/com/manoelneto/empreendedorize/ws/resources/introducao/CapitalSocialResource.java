package com.manoelneto.empreendedorize.ws.resources.introducao;

import com.manoelneto.empreendedorize.ws.domain.introducao.CapitalSocial;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.CapitalSocialDto;
import com.manoelneto.empreendedorize.ws.services.introducao.CapitalSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CapitalSocialResource {

    @Autowired
    CapitalSocialService capitalSocialService;

    @GetMapping("/capitalSocial")
    public ResponseEntity<List<CapitalSocialDto>> findAll(){
        List<CapitalSocial> capitalSocial= capitalSocialService.findAll();
        List<CapitalSocialDto> listDTO = capitalSocial.stream().map(x -> new CapitalSocialDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/capitalSocial/{id}")
    public ResponseEntity<CapitalSocialDto> findById(@PathVariable String id){
        CapitalSocial capitalSocial = capitalSocialService.findById(id);
        return ResponseEntity.ok().body(new CapitalSocialDto(capitalSocial));
    }

    @PostMapping("/capitalSocial")
    public ResponseEntity<CapitalSocialDto> create(@RequestBody CapitalSocialDto capitalSocialDto){
        CapitalSocial capitalSocial= capitalSocialService.fromDTO(capitalSocialDto);
        return  ResponseEntity.ok().body(new CapitalSocialDto(capitalSocialService.create(capitalSocial)));
    }

    @PutMapping("/capitalSocial/{id}")
    public ResponseEntity<CapitalSocialDto> update(@PathVariable String id, @RequestBody CapitalSocialDto capitalSocialDto) {
        CapitalSocial capitalSocial = capitalSocialService.fromDTO(capitalSocialDto);
        capitalSocial.setId(id);
        return ResponseEntity.ok().body(new CapitalSocialDto(capitalSocialService.update(capitalSocial)));
    }

    @DeleteMapping("/capitalSocial/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        capitalSocialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
