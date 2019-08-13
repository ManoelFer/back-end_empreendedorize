package com.manoelneto.empreendedorize.ws.domain.introducao;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.SetoresDeAtividadeDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document("setoresDeAtividade")
public class SetoresDeAtividade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @DBRef(lazy = true)
    private Plano plano;


    private String tipoSetor;

    public SetoresDeAtividade() {
    }

    public SetoresDeAtividade(Plano plano, String tipoSetor) {
        this.plano = plano;
        this.tipoSetor = tipoSetor;
    }

    public SetoresDeAtividade(String id, Plano plano, String tipoSetor) {
        this.id = id;
        this.plano = plano;
        this.tipoSetor = tipoSetor;
    }

    public SetoresDeAtividade(SetoresDeAtividadeDto setoresDeAtividadeDto){
        this.id = setoresDeAtividadeDto.getId();
        this.plano = setoresDeAtividadeDto.getPlano();
        this.tipoSetor = setoresDeAtividadeDto.getTipoSetor();
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

    public String getTipoSetor() {
        return tipoSetor;
    }

    public void setTipoSetor(String tipoSetor) {
        this.tipoSetor = tipoSetor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetoresDeAtividade)) return false;
        SetoresDeAtividade that = (SetoresDeAtividade) o;
        return id.equals(that.id) &&
                plano.equals(that.plano);
    }

    @Override
    public int hashCode() { return Objects.hash(id, plano); }
}
