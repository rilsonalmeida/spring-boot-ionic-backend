package com.pulsar.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulsar.cursomc.domain.Pedido;
import com.pulsar.cursomc.repositories.PedidoRepository;
import com.pulsar.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
 	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}	

}
