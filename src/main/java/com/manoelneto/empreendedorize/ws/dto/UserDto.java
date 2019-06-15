package com.manoelneto.empreendedorize.ws.dto;

import com.manoelneto.empreendedorize.ws.domain.Role;
import com.manoelneto.empreendedorize.ws.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String cpf;
    private String nomeusu;
    private String  sobrenomeusu;
    private String email;
    private String password;
    private boolean enabled;

    private List<Role> roles = new ArrayList<>();

    public UserDto() {}

    public UserDto(User user){
     this.id = user.getId();
     this.cpf = user.getCpf();
     this.nomeusu = user.getNomeusu();
     this.sobrenomeusu = user.getSobrenomeusu();
     this.email = user.getEmail();
     this.enabled = user.isEnabled();
     this.roles  = user.getRoles();
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

    public boolean isEnabled() {
        return enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
