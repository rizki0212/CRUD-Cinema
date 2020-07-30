package com.example.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_ARTIS")
public class ArtisModel {

	@Id
	@Column(name="KODE_ARTIS")
	private String kodeArtis;
	
	@Column(name="NAMA_ARTIS")
	private String namaArtis;
	
	@Column(name="JENIS_KELAMIN")
	private String jenisKelamin;
	
	@Column(name="BAYARAN")
	private Integer bayaran;
	
	@Column(name="AWARD")
	private Integer award;

	//Ini yang Buat Join nya
	@Column(name="NEGARA")
	private String kodeNegara;
	

	@ManyToOne
	@JoinColumn(name="NEGARA", nullable=true, insertable=false, updatable=false)
	private NegaraModel negaraModel;
	//Ini yang Buat Join nya

	//SETTER GETTER
	public String getKodeArtis() {
		return kodeArtis;
	}

	public void setKodeArtis(String kodeArtis) {
		this.kodeArtis = kodeArtis;
	}

	public String getNamaArtis() {
		return namaArtis;
	}

	public void setNamaArtis(String namaArtis) {
		this.namaArtis = namaArtis;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public Integer getBayaran() {
		return bayaran;
	}

	public void setBayaran(Integer bayaran) {
		this.bayaran = bayaran;
	}

	public Integer getAward() {
		return award;
	}

	public void setAward(Integer award) {
		this.award = award;
	}

	public String getKodeNegara() {
		return kodeNegara;
	}

	public void setKodeNegara(String kodeNegara) {
		this.kodeNegara = kodeNegara;
	}
	
	
	public NegaraModel getNegaraModel() {
		return negaraModel;
	}

	public void setNegaraModel(NegaraModel negaraModel) {
		this.negaraModel = negaraModel;
	}
	
}
