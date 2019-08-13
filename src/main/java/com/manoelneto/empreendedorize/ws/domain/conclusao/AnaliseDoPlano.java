package com.manoelneto.empreendedorize.ws.domain.conclusao;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.dto.conclusaoDto.AnaliseDoPlanoDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document("analiseDoPlano")
public class AnaliseDoPlano implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @DBRef(lazy = true)
    private Plano plano;

    private String descricaoAnalise;

    public AnaliseDoPlano() {
    }

    public AnaliseDoPlano(Plano plano, String descricaoAnalise) {
        this.plano = plano;
        this.descricaoAnalise = descricaoAnalise;
    }

    public AnaliseDoPlano(String id, Plano plano, String descricaoAnalise) {
        this.id = id;
        this.plano = plano;
        this.descricaoAnalise = descricaoAnalise;
    }

    public AnaliseDoPlano(AnaliseDoPlanoDto analiseDoPlanoDto){
        this.id = analiseDoPlanoDto.getId();
        this.plano = analiseDoPlanoDto.getPlano();
        this.descricaoAnalise = analiseDoPlanoDto.getDescricaoAnalise();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnaliseDoPlano)) return false;
        AnaliseDoPlano that = (AnaliseDoPlano) o;
        return id.equals(that.id) &&
                plano.equals(that.plano);
    }

    @Override
    public int hashCode() { return Objects.hash(id, plano); }
}
