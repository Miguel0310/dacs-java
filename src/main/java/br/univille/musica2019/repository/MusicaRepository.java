package br.univille.musica2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.musica2019.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>{
	
	Musica findByNome(String nome);
	
	//Cria todo o código para acessar ao banco de Dados.
}
