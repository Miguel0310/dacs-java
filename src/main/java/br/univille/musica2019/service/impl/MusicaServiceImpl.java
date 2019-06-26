package br.univille.musica2019.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.musica2019.model.Musica;
import br.univille.musica2019.repository.MusicaRepository;
import br.univille.musica2019.service.MusicaService;

@Service
public class MusicaServiceImpl implements MusicaService{

	@Autowired
	private MusicaRepository musicaRepository;
	
	@Override
	public List<Musica> getAll() {
		
		return musicaRepository.findAll();
	}

	@Override
	public void save(Musica musica) {
		// TODO Auto-generated method stub
		musicaRepository.save(musica);
	}

	@Override
	public void remove(Musica musica) {
		musicaRepository.delete(musica);
	}

	@Override
	public Musica findById(long id) {
		Optional<Musica> retorno = musicaRepository.findById(id);
		if(retorno.isPresent()) 
			return retorno.get();
		return null;
	}
	
}
