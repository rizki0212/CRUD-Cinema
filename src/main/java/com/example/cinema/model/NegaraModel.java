package com.example.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_NEGARA")
public class NegaraModel {
	
	@Id
	@Column(name="KODE_NEGARA")
	private String kodeNegara;
	
	@Column(name="NAMA_NEGARA")
	private String namaNegara;

	public String getKodeNegara() {
		return kodeNegara;
	}

	public void setKodeNegara(String kodeNegara) {
		this.kodeNegara = kodeNegara;
	}

	public String getNamaNegara() {
		return namaNegara;
	}

	public void setNamaNegara(String namaNegara) {
		this.namaNegara = namaNegara;
	}
	
	
}
