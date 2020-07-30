package com.example.cinema.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.model.NegaraModel;
import com.example.cinema.repository.NegaraRepository;

@Service
@Transactional
public class NegaraService {

	@Autowired
	private NegaraRepository negaraRepository;
	
	public void create(NegaraModel negaraModel) {
		this.negaraRepository.save(negaraModel);
	}
	
	public List<NegaraModel> read(){
		return this.negaraRepository.repoRead();
	}
	
	public NegaraModel search(String kodeNegara) {
		return this.negaraRepository.search(kodeNegara);
	}
	
	public void update(NegaraModel negaraModel) {
		this.negaraRepository.save(negaraModel);
	}
	
	public void delete(NegaraModel negaraModel) {
		this.negaraRepository.delete(negaraModel);
	}
	
	public List<NegaraModel> searchNama(String namaNegara){
		return this.negaraRepository.searchNamaNegara(namaNegara);
	}
}
