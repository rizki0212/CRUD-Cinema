package com.example.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_FILM")
public class FilmModel {

	@Id
	@Column(name="KODE_FILM")
	private String kodeFilm;
	
	@Column(name="NAMA_FILM")
	private String namaFilm;
	
	@Column(name="GENRE")
	private String kodeGenre;

	@ManyToOne
	@JoinColumn(name="GENRE", nullable=true, insertable=false, updatable=false)
	private GenreModel genreModel;

	@Column(name="ARTIS")
	private String kodeArtis;
	
	@ManyToOne
	@JoinColumn(name="ARTIS", nullable=true, insertable=false, updatable=false)
	private ArtisModel artisModel;
	
	@Column(name="PRODUSER")
	private String kodeProduser;
	

	@ManyToOne
	@JoinColumn(name="PRODUSER", nullable=true, insertable=false, updatable=false)
	private ProduserModel produserModel;
	
	@Column(name="PENDAPATAN")
	private int pendapatanFilm;
	
	@Column(name="NOMINASI")
	private int nominasiFilm;
	
	
	
	public String getKodeFilm() {
		return kodeFilm;
	}

	public void setKodeFilm(String kodeFilm) {
		this.kodeFilm = kodeFilm;
	}

	public String getNamaFilm() {
		return namaFilm;
	}

	public void setNamaFilm(String namaFilm) {
		this.namaFilm = namaFilm;
	}

	public String getKodeGenre() {
		return kodeGenre;
	}

	public void setKodeGenre(String kodeGenre) {
		this.kodeGenre = kodeGenre;
	}

	public GenreModel getGenreModel() {
		return genreModel;
	}

	public void setGenreModel(GenreModel genreModel) {
		this.genreModel = genreModel;
	}
	
	public String getKodeArtis() {
		return kodeArtis;
	}

	public void setKodeArtis(String kodeArtis) {
		this.kodeArtis = kodeArtis;
	}
	
	public ArtisModel getArtisModel() {
		return artisModel;
	}

	public void setArtisModel(ArtisModel artisModel) {
		this.artisModel = artisModel;
	}

	public String getKodeProduser() {
		return kodeProduser;
	}

	public void setKodeProduser(String kodeProduser) {
		this.kodeProduser = kodeProduser;
	}
	
	public ProduserModel getProduserModel() {
		return produserModel;
	}

	public void setProduserModel(ProduserModel produserModel) {
		this.produserModel = produserModel;
	}

	public int getPendapatanFilm() {
		return pendapatanFilm;
	}

	public void setPendapatanFilm(int pendapatanFilm) {
		this.pendapatanFilm = pendapatanFilm;
	}

	public int getNominasiFilm() {
		return nominasiFilm;
	}

	public void setNominasiFilm(int nominasiFilm) {
		this.nominasiFilm = nominasiFilm;
	}
	
}
