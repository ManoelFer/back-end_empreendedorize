package com.manoelneto.empreendedorize.ws.dto;

import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.Role;
import com.manoelneto.empreendedorize.ws.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlanoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private User usu;
    private String nomePlano;
    private String dataConclusao;
    private String finalidade;

    private List<Role> roles = new ArrayList<>();

    public PlanoDto() {
    }

    public PlanoDto(Plano plano){
        this.id = plano.getId();
        this.usu = plano.getUsu();
        this.nomePlano = plano.getNomePlano();
        this.dataConclusao = plano.getDataConclusao();
        this.finalidade = plano.getFinalidade();
        this.roles = plano.getRoles();
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
}
