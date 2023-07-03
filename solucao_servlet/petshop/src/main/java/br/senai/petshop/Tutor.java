package br.senai.petshop;

import java.util.ArrayList;
import java.util.Objects;

public class Tutor {
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Pet> pets;

    public Tutor() {}

    public Tutor(String cpf, String nome, String telefone, String email, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
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

    public ArrayList<Pet> getPets() {
        return this.pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public void removePet(Pet pet) {
        this.pets.remove(pet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return Objects.equals(cpf, tutor.cpf) && Objects.equals(nome, tutor.nome) && Objects.equals(telefone, tutor.telefone) && Objects.equals(email, tutor.email) && Objects.equals(endereco, tutor.endereco) && Objects.equals(pets, tutor.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, telefone, email, endereco, pets);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", pets=" + pets +
                '}';
    }
}
