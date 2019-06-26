package br.univille.musica2019.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.musica2019.model.Musica;

@Service
public interface MusicaService {
	
	List<Musica> getAll();

	void save(Musica musica);
	
	void remove(Musica musica);
	
	Musica findById(long id);
}
//Interface para nao implementar as regras de negocio no Código.
