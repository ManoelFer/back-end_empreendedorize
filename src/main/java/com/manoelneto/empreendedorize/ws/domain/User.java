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
    private String email;
    private String password;
    private boolean enabled;

    @DBRef(lazy = true)
    private List<Role> roles = new ArrayList<>();

    public User(){}

    public User(String cpf, String nomeusu, String sobrenomeusu, String email) {
        this.cpf = cpf;
        this.nomeusu = nomeusu;
        this.sobrenomeusu = sobrenomeusu;
        this.email = email;
    }

    public User(String id, String cpf, String nomeusu, String sobrenomeusu, String email, String password,
                boolean enabled) {
        this.id = id;
        this.cpf = cpf;
        this.nomeusu = nomeusu;
        this.sobrenomeusu = sobrenomeusu;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public User(UserDto userDto){
        this.id = userDto.getId();
        this.cpf = userDto.getCpf();
        this.nomeusu = userDto.getNomeusu();
        this.sobrenomeusu = userDto.getSobrenomeusu();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
    }

    public User(User user){
        super();
        this.id = user.getId();
        this.cpf = user.getCpf();
        this.nomeusu = user.getNomeusu();
        this.sobrenomeusu = user.getSobrenomeusu();
        this.email = user.getEmail();
        this.password = user.getPassword();
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
