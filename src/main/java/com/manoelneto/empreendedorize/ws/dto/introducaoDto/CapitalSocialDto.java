package com.manoelneto.empreendedorize.ws.dto.introducaoDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.introducao.CapitalSocial;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "plano" })
public class CapitalSocialDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Plano plano;
    private Double valorParticipacao;

    public CapitalSocialDto() {
    }

    public CapitalSocialDto(CapitalSocial capitalSocial){
        this.id = capitalSocial.getId();
        this.plano = capitalSocial.getPlano();
        this.valorParticipacao = capitalSocial.getValorParticipacao();
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

    public Double getValorParticipacao() {
        return valorParticipacao;
    }

    public void setValorParticipacao(Double valorParticipacao) {
        this.valorParticipacao = valorParticipacao;
    }
}
