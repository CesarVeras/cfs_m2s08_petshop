package br.senai.petshop.services;

import br.senai.petshop.models.Tutor;
import br.senai.petshop.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

	private TutorRepository repository;

	public List<Tutor> listarTutores() {
		return repository.getTutores();
	}

	public void cadastrarTutor(Tutor tutor) {
		if (tutor == null)
			return;
		repository.addTutor(tutor);
	}

	public void editarTutor(Tutor tutor) {
		List<Tutor> tutores = repository.getTutores();

		Tutor tutorParaAlterar = null;

		for (Tutor t : tutores) {
			if (t.getCpf().equals(tutor.getCpf())) {
				tutorParaAlterar = t;
				break;
			}
		}

		if (tutorParaAlterar == null)
			return;
		repository.updateTutor(
				tutorParaAlterar, tutor.getCpf(), tutor.getNome(), tutor.getTelefone(), tutor.getEmail(),
				tutor.getEndereco());
	}

	public void removerTutor(Long id) {
		List<Tutor> tutores = repository.getTutores();
		Tutor tutorParaRemover = null;

		for (Tutor t : tutores) {
			if (t.getId().equals(id)) {
				tutorParaRemover = t;
				break;
			}
		}
		if (tutorParaRemover == null)
			return;
		repository.removeTutor(tutorParaRemover);
	}
}
