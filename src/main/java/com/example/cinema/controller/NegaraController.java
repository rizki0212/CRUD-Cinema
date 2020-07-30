package com.example.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cinema.model.NegaraModel;
import com.example.cinema.service.NegaraService;

@Controller
@RequestMapping("/negara")
public class NegaraController {

@Autowired NegaraService negaraService;
	
	@RequestMapping("/home")
	public String getHome() {
		String page ="/negara/home";
		return page;
	}
	
	@RequestMapping("/add")	
	public String doAdd() {
		String page ="/negara/add";
		return page;
	}
	
	@RequestMapping("/create")
	public String doCreate(HttpServletRequest request, Model model) {
		String kodeNegara =request.getParameter("kodeNegara");
		String namaNegara =request.getParameter("namaNegara");
		
		NegaraModel negaraModel = new NegaraModel();
		
		negaraModel.setKodeNegara(kodeNegara);
		negaraModel.setNamaNegara(namaNegara);
		
		this.negaraService.create(negaraModel);
		this.negaraRead(model);
		
		System.out.println(kodeNegara);
		System.out.println(namaNegara);
		
		String page ="/negara/home";
		return page;
	}
	
	public void negaraRead (Model model) {
		List<NegaraModel> negaraModelList = new ArrayList<NegaraModel>();
		negaraModelList = this.negaraService.read();
		model.addAttribute("negaraModelList", negaraModelList);
	}
	
	@RequestMapping(value="/detail")
	public String doDetail(HttpServletRequest request, Model model) {
		
		String kodeNegara = request.getParameter("kodeNegara");
		System.out.println(kodeNegara);
		
		NegaraModel negaraModel = new NegaraModel();
		negaraModel = this.negaraService.search(kodeNegara);
		model.addAttribute("negaraModel", negaraModel); 
		
		String page = "/negara/detail";
		return page;
	}
	
	@RequestMapping("/ubah")
	public String doUbah(HttpServletRequest request, Model model) {
		String kodeNegara = request.getParameter("kodeNegara");
				
		NegaraModel negaraModel = new NegaraModel();
		negaraModel = this.negaraService.search(kodeNegara);
		model.addAttribute("negaraModel", negaraModel);
		
		String page = "/negara/ubah";
	return page;
	}
	
	@RequestMapping("/update")
	public String doUpdate(HttpServletRequest request, Model model) {
		String kodeNegara =request.getParameter("kodeNegara");
		String namaNegara =request.getParameter("namaNegara");
		
		NegaraModel negaraModel = new NegaraModel();
		
		negaraModel.setKodeNegara(kodeNegara);
		negaraModel.setNamaNegara(namaNegara);
		
		this.negaraService.create(negaraModel);
		this.negaraRead(model);
		
		System.out.println(kodeNegara);
		System.out.println(namaNegara);
		
		String page ="/negara/home";
		return page;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		String kodeNegara = request.getParameter("kodeNegara");
		NegaraModel negaraModel = new NegaraModel();
		negaraModel = this.negaraService.search(kodeNegara);
		this.negaraService.delete(negaraModel);
		
		String delete ="/negara/home";
		return delete;
	}
	
	@RequestMapping("/list")
	public String goList (Model model) {
		this.negaraRead(model);
		
		String list ="/negara/list";
		return list;
	}
	
	@RequestMapping(value="/search")
	public String cariNamaNegara(HttpServletRequest request, Model model) {
				
		String namaNegara = request.getParameter("namaNegara");
				
		List<NegaraModel> negaraModelList = new ArrayList<NegaraModel>();
		negaraModelList = negaraService.searchNama(namaNegara);
		model.addAttribute("genreModelList", negaraModelList);
		String html = "/negara/search";
		return html;
	}
}
