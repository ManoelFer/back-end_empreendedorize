package com.manoelneto.empreendedorize.ws.domain.introducao;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.MissaoDaEmpresaDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document("missaoDaEmpresa")
public class MissaoDaEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @DBRef(lazy = true)
    private Plano plano;

    private String descricaoMissao;

    public MissaoDaEmpresa() {
    }

    public MissaoDaEmpresa(Plano plano, String descricaoMissao) {
        this.plano = plano;
        this.descricaoMissao = descricaoMissao;
    }

    public MissaoDaEmpresa(String id, Plano plano, String descricaoMissao) {
        this.id = id;
        this.plano = plano;
        this.descricaoMissao = descricaoMissao;
    }

    public MissaoDaEmpresa(MissaoDaEmpresaDto missaoDaEmpresaDto){
        this.id = missaoDaEmpresaDto.getId();
        this.plano = missaoDaEmpresaDto.getPlano();
        this.descricaoMissao = missaoDaEmpresaDto.getDescricaoMissao();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MissaoDaEmpresa)) return false;
        MissaoDaEmpresa that = (MissaoDaEmpresa) o;
        return id.equals(that.id) &&
                plano.equals(that.plano);
    }

    @Override
    public int hashCode() { return Objects.hash(id, plano); }
}
