package br.com.alura.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Controller
public class ListaVipContoller {
	
	@Autowired
	private ConvidadoRepository repository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("lista")
	public String convidados(Model model) {	
		Iterable<Convidado> convidados = repository.findAll();
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}
	
	@RequestMapping("convidar")
	public ModelAndView convidar(Convidado convidado) {
		repository.save(convidado);
		ModelAndView modelAndView = new ModelAndView("redirect:lista");
		return modelAndView;
	}
	
	
}
