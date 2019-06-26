package br.univille.musica2019.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.musica2019.model.Musica;
import br.univille.musica2019.service.MusicaService;

@RestController
@RequestMapping("/api/musicas")
public class MusicaControllerAPI {
	
	@Autowired
	private MusicaService service;
	
	@GetMapping
	public ResponseEntity<List<Musica>> listarMusicas(){
		List<Musica> lista = new ArrayList<Musica>();
		try {
			lista = service.getAll();
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return new ResponseEntity<List<Musica>>(lista,HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Musica musica){
		service.save(musica);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, 
									@RequestBody Musica musica){
		Musica musicaAtual = service.findById(id);
		if(musicaAtual != null) {
			musicaAtual.setNome(musica.getNome());
			musicaAtual.setBanda(musica.getBanda());
			musicaAtual.setData(musica.getData());
			service.save(musicaAtual);
			return ResponseEntity.ok().build();
		}
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		Musica musicaAtual = service.findById(id);
		if(musicaAtual != null) {
			service.remove(musicaAtual);
			return ResponseEntity.ok().build();
		}
		return null;
	}
	
}
