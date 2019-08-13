package com.manoelneto.empreendedorize.ws.dto.introducaoDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.introducao.FonteDeRecursos;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "plano" })
public class FonteDeRecursosDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Plano plano;
    private String descricao;

    public FonteDeRecursosDto() {
    }

    public FonteDeRecursosDto(FonteDeRecursos fonteDeRecursos){
        this.id = fonteDeRecursos.getId();
        this.plano = fonteDeRecursos.getPlano();
        this.descricao = fonteDeRecursos.getDescricao();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
