package br.univille.musica2019.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.musica2019.model.Musica;
import br.univille.musica2019.repository.MusicaRepository;
import br.univille.musica2019.service.MusicaService;

@Controller
@RequestMapping("/musica")
public class MusicaController {
	
	@Autowired
	private MusicaService service;
	
	@GetMapping()
	public ModelAndView index() {
		
		return new ModelAndView("musica/index","musicas",service.getAll());
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Musica musica) {
		return new ModelAndView("musica/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Musica musica ) {
		service.save(musica);
		return new ModelAndView("redirect:/musica");
	}
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Musica musica) {

		return new ModelAndView("musica/form","musica",musica);
	}
	
	@GetMapping(value="/excluir/{id}")
	public ModelAndView remove(@PathVariable ("id") Musica musica) {
		service.remove(musica);
		return new ModelAndView ("redirect:/musica");
	}
	
}
