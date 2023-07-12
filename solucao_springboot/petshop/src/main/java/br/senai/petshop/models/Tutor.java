package br.senai.petshop.models;

import java.util.ArrayList;
import java.util.Objects;

public class Tutor {
    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    public Tutor() {}

    public Tutor(String cpf, String nome, String telefone, String email, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Tutor(Long id, String cpf, String nome, String telefone, String email, String endereco) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return Objects.equals(id, tutor.id) && Objects.equals(cpf, tutor.cpf) && Objects.equals(nome, tutor.nome) && Objects.equals(telefone, tutor.telefone) && Objects.equals(email, tutor.email) && Objects.equals(endereco, tutor.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, nome, telefone, email, endereco);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
