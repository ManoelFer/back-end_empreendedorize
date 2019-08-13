package com.manoelneto.empreendedorize.ws.dto.introducaoDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.domain.introducao.DadosEmpreendedores;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "plano" })
public class DadosEmpreendedoresDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Plano plano;
    private String nomeSocio;
    private String endereco;
    private String cidade;
    private String estado;
    private String fone1;
    private String fone2;
    private String emailSocio;
    private String perfil;
    private String atribuicoes;

    public DadosEmpreendedoresDto() {
    }


    public DadosEmpreendedoresDto(DadosEmpreendedores dadosEmpreendedores){
        this.id = dadosEmpreendedores.getId();
        this.plano = dadosEmpreendedores.getPlano();
        this.nomeSocio = dadosEmpreendedores.getNomeSocio();
        this.endereco = dadosEmpreendedores.getEndereco();
        this.cidade = dadosEmpreendedores.getCidade();
        this.estado = dadosEmpreendedores.getEstado();
        this.fone1 = dadosEmpreendedores.getFone1();
        this.fone2 = dadosEmpreendedores.getFone2();
        this.emailSocio = dadosEmpreendedores.getEmailSocio();
        this.perfil = dadosEmpreendedores.getPerfil();
        this.atribuicoes = dadosEmpreendedores.getAtribuicoes();
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

    public String getNomeSocio() {
        return nomeSocio;
    }

    public void setNomeSocio(String nomeSocio) {
        this.nomeSocio = nomeSocio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getEmailSocio() {
        return emailSocio;
    }

    public void setEmailSocio(String emailSocio) {
        this.emailSocio = emailSocio;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicoes(String atribuicoes) {
        this.atribuicoes = atribuicoes;
    }
}
