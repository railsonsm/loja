package br.com.alura.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	@Autowired
	private ConvidadoRepository repository;
	
	public Iterable<Convidado> listarTodos(){
		return repository.findAll();
	}
	
	public void convidar(Convidado convidado) {
		repository.save(convidado);
	}
	
	public void deletar(Convidado convidado) {
		repository.delete(convidado);
	}
}
