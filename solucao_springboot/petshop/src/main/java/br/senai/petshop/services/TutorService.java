package br.senai.petshop.services;

import br.senai.petshop.models.Tutor;
import br.senai.petshop.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorService {

    public static List<Tutor> listarTutores() {
        return TutorRepository.getTutores();
    }

    public static void cadastrarTutor(Tutor tutor) {
        if (tutor == null) return;
        TutorRepository.addTutor(tutor);
    }

    public static void editarTutor(Tutor tutor) {
        List<Tutor> tutores = TutorRepository.getTutores();

        Tutor tutorParaAlterar = null;

        for (Tutor t : tutores) {
            if (t.getCpf().equals(tutor.getCpf())) {
                tutorParaAlterar = t;
                break;
            }
        }

        if (tutorParaAlterar == null) return;
        TutorRepository.updateTutor(
                tutorParaAlterar, tutor.getCpf(), tutor.getNome(), tutor.getTelefone(), tutor.getEmail(), tutor.getEndereco());
    }


    public static void removerTutor(Long id) {
        List<Tutor> tutores = TutorRepository.getTutores();
        Tutor tutorParaRemover = null;

        for (Tutor t : tutores) {
            if (t.getId().equals(id)) {
                tutorParaRemover = t;
                break;
            }
        }
        if (tutorParaRemover == null) return;
        TutorRepository.removeTutor(tutorParaRemover);
    }
}


