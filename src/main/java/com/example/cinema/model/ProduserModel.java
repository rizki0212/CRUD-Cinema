package com.example.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_Produser")

public class ProduserModel {

	@Id
	@Column(name = "KODE_PRODUSER")
	private String kodeProduser;
	
	@Column(name = "NAMA_PRODUSER")
	private String namaProduser;

	public String getKodeProduser() {
		return kodeProduser;
	}

	public void setKodeProduser(String kodeProduser) {
		this.kodeProduser = kodeProduser;
	}

	public String getNamaProduser() {
		return namaProduser;
	}

	public void setNamaProduser(String namaProduser) {
		this.namaProduser = namaProduser;
	}
}
