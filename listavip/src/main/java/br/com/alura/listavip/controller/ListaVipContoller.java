package br.com.alura.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.enviadorEmail.EmailService;
import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadoService;

@Controller
@RequestMapping("/convidado")
public class ListaVipContoller {
	
	@Autowired
	private ConvidadoService service;
	
	@Autowired
	private EmailService emailservice;

	@RequestMapping("/lista")
	public String convidados(Model model) {	
		Iterable<Convidado> convidados = service.listarTodos();
		model.addAttribute("convidados", convidados);
		return "convidado/listaconvidados";
	}
	@RequestMapping("/apagar/{id}")
	public ModelAndView apagar(@PathVariable("id") Long id) {
		Convidado convidado = new Convidado();
		convidado.setId(id);
		service.deletar(convidado);
		ModelAndView modelAndView = new ModelAndView("redirect:/convidado/lista");
		return modelAndView;
	}
	
	@RequestMapping("/convidar")
	public ModelAndView convidar(Convidado convidado) {
		service.convidar(convidado);
		emailservice.enviar(convidado.getNome(), convidado.getEmail());
		ModelAndView modelAndView = new ModelAndView("redirect:/convidado/lista");
		return modelAndView;
	}
	
	
}
