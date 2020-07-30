package com.example.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cinema.model.ProduserModel;
import com.example.cinema.service.ProduserService;

@Controller
@RequestMapping("/produser")
public class ProduserController {

@Autowired ProduserService produserService;
	
	@RequestMapping("/home")
	public String getHome() {
		String page ="/produser/home";
		return page;
	}
	
	@RequestMapping("/add")
	public String doAdd() {
		String page ="/produser/add";
		return page;
	}
	
	@RequestMapping("/create")
	public String doCreate(HttpServletRequest request, Model model) {
		String kodeProduser =request.getParameter("kodeProduser");
		String namaProduser =request.getParameter("namaProduser");
		
		ProduserModel produserModel = new ProduserModel();
		
		produserModel.setKodeProduser(kodeProduser);
		produserModel.setNamaProduser(namaProduser);
		
		this.produserService.create(produserModel);
		this.produserRead(model);
		
		System.out.println(kodeProduser);
		System.out.println(namaProduser);
		
		String page ="/produser/home";
		return page;
	}
	
	public void produserRead (Model model) {
		List<ProduserModel> produserModelList = new ArrayList<ProduserModel>();
		produserModelList = this.produserService.read();
		model.addAttribute("produserModelList", produserModelList);
	}
	
	@RequestMapping(value="/detail")
	public String doDetail(HttpServletRequest request, Model model) {
		
		String kodeProduser = request.getParameter("kodeProduser");
		System.out.println(kodeProduser);
		
		ProduserModel produserModel = new ProduserModel();
		produserModel = this.produserService.search(kodeProduser);
		model.addAttribute("produserModel", produserModel); 
		
		String page = "/produser/detail";
		return page;
	}
	
	@RequestMapping("/ubah")
	public String doUbah(HttpServletRequest request, Model model) {
		String kodeProduser = request.getParameter("kodeProduser");
				
		ProduserModel produserModel = new ProduserModel();
		produserModel = this.produserService.search(kodeProduser);
		model.addAttribute("produserModel", produserModel);
		
		String page = "/produser/ubah";
	return page;
	}
	
	@RequestMapping("/update")
	public String doUpdate(HttpServletRequest request, Model model) {
		String kodeProduser =request.getParameter("kodeProduser");
		String namaProduser =request.getParameter("namaProduser");
		
		ProduserModel produserModel = new ProduserModel();
		
		produserModel.setKodeProduser(kodeProduser);
		produserModel.setNamaProduser(namaProduser);
		
		this.produserService.create(produserModel);
		this.produserRead(model);
		
		System.out.println(kodeProduser);
		System.out.println(namaProduser);
		
		String page ="/produser/home";
		return page;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		String kodeProduser = request.getParameter("kodeProduser");
		ProduserModel produserModel = new ProduserModel();
		produserModel = this.produserService.search(kodeProduser);
		this.produserService.delete(produserModel);
		
		String delete ="/produser/home";
		return delete;
	}
	
	@RequestMapping("/list")
	public String goList (Model model) {
		this.produserRead(model);
		
		String list ="/produser/list";
		return list;
	}
	
	@RequestMapping(value="/search")
	public String cariNamaProduser(HttpServletRequest request, Model model) {
				
		String namaProduser = request.getParameter("namaProduser");
				
		List<ProduserModel> produserModelList = new ArrayList<ProduserModel>();
		produserModelList = produserService.searchNama(namaProduser);
		model.addAttribute("produserModelList", produserModelList);
		String html = "/produser/search";
		return html;
	}
}
