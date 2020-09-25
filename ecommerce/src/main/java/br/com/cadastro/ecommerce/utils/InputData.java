package br.com.cadastro.ecommerce.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.ecommerce.model.Produto;
import br.com.cadastro.ecommerce.model.repository.EcommerceRepository;

@Component
public class InputData {
	
	@Autowired
    EcommerceRepository ecommerceRepository;

    @PostConstruct
    public void saveProdutos(){

    }
}
