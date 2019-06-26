package br.univille.musica2019.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity

public class Musica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=1000)
	private String nome;
	@Column(length=1000)
	private String banda;
	@Temporal(value=TemporalType.TIME)
	@DateTimeFormat(pattern = "mm:ss")
	private Date data;
	
	/**
	 * ID da música
	 * @return O valor a retornar vai ser o ID da música.
	 */
	public long getId() {
		return id;
	}
	/**
	 * Setter da ID da musica.
	 * @param id == O parametro utilizado é o valor da ID da música.
	 */
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBanda() {
		return banda;
	}
	public void setBanda(String banda) {
		this.banda = banda;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	

}
