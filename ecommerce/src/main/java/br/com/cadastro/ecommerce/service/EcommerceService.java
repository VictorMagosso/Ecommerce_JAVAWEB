package br.com.cadastro.ecommerce.service;

import br.com.cadastro.ecommerce.model.Produto;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EcommerceService {

	List<Produto> findAll();
	Produto findById(long id);
	Produto save(Produto produto);
}
