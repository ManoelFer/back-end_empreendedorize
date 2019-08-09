package com.manoelneto.empreendedorize.ws.domain;


import com.manoelneto.empreendedorize.ws.dto.PlanoDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "planos")
public class Plano implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @DBRef (lazy = true)
    private User usu;

    private String nomePlano;
    private String dataConclusao;
    private String finalidade;

    @DBRef (lazy = true)
    private List<Role> roles = new ArrayList<>();

    public Plano() {}

    public Plano(User usu, String nomePlano, String dataConclusao, String finalidade) {
        this.usu = usu;
        this.nomePlano = nomePlano;
        this.dataConclusao = dataConclusao;
        this.finalidade = finalidade;
    }

    public Plano(String id, User usu, String nomePlano, String dataConclusao, String finalidade) {
        this.id = id;
        this.usu = usu;
        this.nomePlano = nomePlano;
        this.dataConclusao = dataConclusao;
        this.finalidade = finalidade;
    }

    public Plano(PlanoDto planoDto){
        this.id = planoDto.getId();
        this.usu = planoDto.getUsu();
        this.nomePlano = planoDto.getNomePlano();
        this.dataConclusao = planoDto.getDataConclusao();
        this.finalidade = planoDto.getFinalidade();
    }

    public Plano(Plano plano){
        super();
        this.id = plano.getId();
        this.usu = plano.getUsu();
        this.nomePlano = plano.getNomePlano();
        this.dataConclusao = plano.getDataConclusao();
        this.finalidade = plano.getFinalidade();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUsu() {
        return usu;
    }

    public void setUsu(User usu) {
        this.usu = usu;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plano)) return false;
        Plano plano = (Plano) o;
        return id.equals(plano.id) &&
                usu.equals(plano.usu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usu);
    }
}
