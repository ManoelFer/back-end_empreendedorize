package com.manoelneto.empreendedorize.ws.domain.introducao;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.CapitalSocialDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;


@Document("capitalSocial")
public class CapitalSocial implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @DBRef(lazy = true)
    private Plano plano;
    private Double valorParticipacao;

    public CapitalSocial() {
    }

    public CapitalSocial(Plano plano, Double valorParticipacao) {
        this.plano = plano;
        this.valorParticipacao = valorParticipacao;
    }

    public CapitalSocial(String id, Plano plano, Double valorParticipacao) {
        this.id = id;
        this.plano = plano;
        this.valorParticipacao = valorParticipacao;
    }

    public CapitalSocial(CapitalSocialDto capitalSocialDto){
        this.id = capitalSocialDto.getId();
        this.plano = capitalSocialDto.getPlano();
        this.valorParticipacao = capitalSocialDto.getValorParticipacao();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CapitalSocial)) return false;
        CapitalSocial that = (CapitalSocial) o;
        return id.equals(that.id) &&
                plano.equals(that.plano);
    }

    @Override
    public int hashCode() { return Objects.hash(id, plano); }
}
