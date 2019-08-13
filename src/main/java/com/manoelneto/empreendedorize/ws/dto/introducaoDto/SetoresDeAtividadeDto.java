package com.manoelneto.empreendedorize.ws.dto.introducaoDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.introducao.SetoresDeAtividade;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "plano" })
public class SetoresDeAtividadeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Plano plano;
    private String tipoSetor;

    public SetoresDeAtividadeDto() {
    }

    public SetoresDeAtividadeDto(SetoresDeAtividade setoresDeAtividade){
        this.id = setoresDeAtividade.getId();
        this.plano = setoresDeAtividade.getPlano();
        this.tipoSetor = setoresDeAtividade.getTipoSetor();
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
}
