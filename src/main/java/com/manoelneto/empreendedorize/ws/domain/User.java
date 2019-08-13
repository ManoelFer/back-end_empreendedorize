package com.manoelneto.empreendedorize.ws.domain;

import com.manoelneto.empreendedorize.ws.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection="users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String cpf;
    private String nomeusu;
    private String  sobrenomeusu;
    private String fone1;
    private String fone2;
    private String email;
    private String password;
    private String endereco;
    private String cidade;
    private String estado;
    private String curriculo;
    private boolean enabled;

    @DBRef(lazy = true)
    private List<Role> roles = new ArrayList<>();

    public User(){}

    public User(String cpf, String nomeusu, String sobrenomeusu, String fone1, String fone2, String email,
                String endereco, String cidade, String estado, String curriculo) {
        this.cpf = cpf;
        this.nomeusu = nomeusu;
        this.sobrenomeusu = sobrenomeusu;
        this.fone1 = fone1;
        this.fone2 = fone2;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.curriculo = curriculo;
    }

    public User(String id, String cpf, String nomeusu, String sobrenomeusu, String fone1, String fone2, String email,
                String password, String endereco, String cidade, String estado, String curriculo, boolean enabled) {
        this.id = id;
        this.cpf = cpf;
        this.nomeusu = nomeusu;
        this.sobrenomeusu = sobrenomeusu;
        this.fone1 = fone1;
        this.fone2 = fone2;
        this.email = email;
        this.password = password;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.curriculo = curriculo;
        this.enabled = enabled;
    }

    public User(UserDto userDto){
        this.id = userDto.getId();
        this.cpf = userDto.getCpf();
        this.nomeusu = userDto.getNomeusu();
        this.sobrenomeusu = userDto.getSobrenomeusu();
        this.fone1 = userDto.getFone1();
        this.fone2 = userDto.getFone2();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.endereco = userDto.getEndereco();
        this.cidade = userDto.getCidade();
        this.estado = userDto.getEstado();
        this.curriculo = userDto.getCurriculo();
    }

    public User(User user){
        super();
        this.id = user.getId();
        this.cpf = user.getCpf();
        this.nomeusu = user.getNomeusu();
        this.sobrenomeusu = user.getSobrenomeusu();
        this.fone1 = user.getFone1();
        this.fone2 = user.getFone2();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.endereco = user.getEndereco();
        this.cidade = user.getCidade();
        this.estado = user.getEstado();
        this.curriculo = user.getCurriculo();
        this.roles = user.getRoles();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeusu() {
        return nomeusu;
    }

    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }

    public String getSobrenomeusu() {
        return sobrenomeusu;
    }

    public void setSobrenomeusu(String sobrenomeusu) {
        this.sobrenomeusu = sobrenomeusu;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
