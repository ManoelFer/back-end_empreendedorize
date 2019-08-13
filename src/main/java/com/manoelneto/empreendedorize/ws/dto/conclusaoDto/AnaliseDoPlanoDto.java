package com.manoelneto.empreendedorize.ws.dto.conclusaoDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.conclusao.AnaliseDoPlano;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "plano" })
public class AnaliseDoPlanoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Plano plano;
    private String descricaoAnalise;

    public AnaliseDoPlanoDto() {
    }

    public AnaliseDoPlanoDto(AnaliseDoPlano analiseDoPlano){
        this.id = analiseDoPlano.getId();
        this.plano = analiseDoPlano.getPlano();
        this.descricaoAnalise = analiseDoPlano.getDescricaoAnalise();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public String getDescricaoAnalise() {
        return descricaoAnalise;
    }

    public void setDescricaoAnalise(String descricaoAnalise) {
        this.descricaoAnalise = descricaoAnalise;
    }
}
