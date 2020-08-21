package br.com.cadastro.ecommerce.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.ecommerce.model.Produto;
import br.com.cadastro.ecommerce.model.repository.EcommerceRepository;
import br.com.cadastro.ecommerce.service.EcommerceService;

@Service
public class EcommerceServiceImplement implements EcommerceService {

	@Autowired
	EcommerceRepository produtoRepository;
	
	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return produtoRepository.findAll();
	}

	@Override
	public Produto findById(long id) {
		// TODO Auto-generated method stub
		return produtoRepository.findById(id).get();
	}

	@Override
	public Produto save(Produto produto) {
		// TODO Auto-generated method stub
		return produtoRepository.save(produto);
	}

}
