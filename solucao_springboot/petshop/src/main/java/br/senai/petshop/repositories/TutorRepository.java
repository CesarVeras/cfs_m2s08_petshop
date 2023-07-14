package br.senai.petshop.repositories;

import br.senai.petshop.models.Tutor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TutorRepository {

    private List<Tutor> tutores = new ArrayList<>();
    private Long id = 0L;

    public List<Tutor> getTutores() {
        return tutores;
    }

    public void addTutor(Tutor tutor) {
        if (tutor == null) return;
        if (tutores.contains(tutor)) return;
        tutor.setId(++id);
        tutores.add(tutor);
    }

    public void updateTutor(Tutor tutor, String cpf, String nome, String telefone, String email, String endereco) {
        if (cpf != null && !cpf.equals(tutor.getCpf())) tutor.setCpf(cpf);
        if (nome != null && !nome.equals(tutor.getNome())) tutor.setNome(nome);
        if (telefone != null && !telefone.equals(tutor.getTelefone())) tutor.setTelefone(telefone);
        if (email != null && !email.equals(tutor.getEmail())) tutor.setEmail(email);
        if (endereco != null && !endereco.equals(tutor.getEndereco())) tutor.setEndereco(endereco);
    }

    public void removeTutor(Tutor tutor) {
        tutores.remove(tutor);
    }
}
