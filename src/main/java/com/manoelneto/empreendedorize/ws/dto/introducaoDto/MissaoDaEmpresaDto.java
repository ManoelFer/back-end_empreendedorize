package com.manoelneto.empreendedorize.ws.dto.introducaoDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.introducao.MissaoDaEmpresa;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "plano" })
public class MissaoDaEmpresaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Plano plano;
    private String descricaoMissao;

    public MissaoDaEmpresaDto() {
    }

    public MissaoDaEmpresaDto(MissaoDaEmpresa missaoDaEmpresa){
        this.id = missaoDaEmpresa.getId();
        this.plano = missaoDaEmpresa.getPlano();
        this.descricaoMissao = missaoDaEmpresa.getDescricaoMissao();
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

    public String getDescricaoMissao() {
        return descricaoMissao;
    }

    public void setDescricaoMissao(String descricaoMissao) {
        this.descricaoMissao = descricaoMissao;
    }
}
