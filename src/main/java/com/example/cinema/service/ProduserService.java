package com.example.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cinema.model.ProduserModel;
import com.example.cinema.repository.ProduserRepository;

@Service
@Transactional
public class ProduserService {

	@Autowired
	private ProduserRepository produserRepository;
	
	public void create (ProduserModel produserModel) {
		this.produserRepository.save(produserModel);
	}
	
	public List<ProduserModel> read() {
		return this.produserRepository.repoRead();
	} 
	
	public ProduserModel search(String kodeProduser) {
		return this.produserRepository.search(kodeProduser);
	}
	
	public void update (ProduserModel produserModel) {
		this.produserRepository.save(produserModel);
	}
	
	public void delete (ProduserModel produserModel) {
		this.produserRepository.delete(produserModel);
	}
	
	public List <ProduserModel> searchNama(String namaProduser) {
		return this.produserRepository.searchNamaProduser(namaProduser);
	}
}
