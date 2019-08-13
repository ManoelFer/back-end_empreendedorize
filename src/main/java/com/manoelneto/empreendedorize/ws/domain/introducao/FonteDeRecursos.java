package com.manoelneto.empreendedorize.ws.domain.introducao;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.FonteDeRecursosDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document("fonteDeRecursos")
public class FonteDeRecursos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @DBRef(lazy = true)
    private Plano plano;

    private String descricao;

    public FonteDeRecursos() {
    }

    public FonteDeRecursos(Plano plano, String descricao) {
        this.plano = plano;
        this.descricao = descricao;
    }

    public FonteDeRecursos(String id, Plano plano, String descricao) {
        this.id = id;
        this.plano = plano;
        this.descricao = descricao;
    }

    public FonteDeRecursos (FonteDeRecursosDto fonteDeRecursosDto){
        this.id = fonteDeRecursosDto.getId();
        this.plano = fonteDeRecursosDto.getPlano();
        this.descricao = fonteDeRecursosDto.getDescricao();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FonteDeRecursos)) return false;
        FonteDeRecursos that = (FonteDeRecursos) o;
        return id.equals(that.id) &&
                plano.equals(that.plano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plano);
    }
}
