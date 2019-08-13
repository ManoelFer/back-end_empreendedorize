package com.manoelneto.empreendedorize.ws.domain.introducao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manoelneto.empreendedorize.ws.domain.Plano;
import com.manoelneto.empreendedorize.ws.dto.introducaoDto.DadosEmpreendedoresDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.Objects;

@Document("dadosEmpreendedores")
public class DadosEmpreendedores implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @DBRef(lazy = true)
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

    public DadosEmpreendedores() {
    }

    public DadosEmpreendedores(Plano plano, String nomeSocio, String endereco, String cidade, String estado, String fone1, String fone2, String emailSocio, String perfil, String atribuicoes) {
        this.plano = plano;
        this.nomeSocio = nomeSocio;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.fone1 = fone1;
        this.fone2 = fone2;
        this.emailSocio = emailSocio;
        this.perfil = perfil;
        this.atribuicoes = atribuicoes;
    }

    public DadosEmpreendedores(String id, Plano plano, String nomeSocio, String endereco, String cidade, String estado, String fone1, String fone2, String emailSocio, String perfil, String atribuicoes) {
        this.id = id;
        this.plano = plano;
        this.nomeSocio = nomeSocio;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.fone1 = fone1;
        this.fone2 = fone2;
        this.emailSocio = emailSocio;
        this.perfil = perfil;
        this.atribuicoes = atribuicoes;
    }

    public DadosEmpreendedores(DadosEmpreendedoresDto dadosEmpreendedoresDto){
        this.id = dadosEmpreendedoresDto.getId();
        this.plano = dadosEmpreendedoresDto.getPlano();
        this.nomeSocio = dadosEmpreendedoresDto.getNomeSocio();
        this.endereco = dadosEmpreendedoresDto.getEndereco();
        this.cidade = dadosEmpreendedoresDto.getCidade();
        this.estado = dadosEmpreendedoresDto.getEstado();
        this.fone1 = dadosEmpreendedoresDto.getFone1();
        this.fone2 = dadosEmpreendedoresDto.getFone2();
        this.emailSocio = dadosEmpreendedoresDto.getEmailSocio();
        this.perfil = dadosEmpreendedoresDto.getPerfil();
        this.atribuicoes = dadosEmpreendedoresDto.getAtribuicoes();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DadosEmpreendedores)) return false;
        DadosEmpreendedores that = (DadosEmpreendedores) o;
        return id.equals(that.id) &&
                plano.equals(that.plano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plano);
    }
}
