package com.example.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_GENRE")
public class GenreModel {
	
	@Id
	@Column(name="KODE_GENRE")
	private String kodeGenre;
	
	@Column(name="NAMA_GENRE")
	private String namaGenre;

	public String getKodeGenre() {
		return kodeGenre;
	}

	public void setKodeGenre(String kodeGenre) {
		this.kodeGenre = kodeGenre;
	}

	public String getNamaGenre() {
		return namaGenre;
	}

	public void setNamaGenre(String namaGenre) {
		this.namaGenre = namaGenre;
	}

}
