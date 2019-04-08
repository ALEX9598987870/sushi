package br.com.cron.sushi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "pratos")
public class Prato implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String nome;
	
	private Double preco;
	
	private String foto;
	
	@Transient
	private MultipartFile file;

	public Prato() {
	}

	
	public Prato(Integer codigo, String nome, Double preco, String foto, MultipartFile file) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.foto = foto;
		this.file = file;
	}

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


	
	@Override
	public String toString() {
		return "codigo=" + codigo;
	}

	
	
	
}

