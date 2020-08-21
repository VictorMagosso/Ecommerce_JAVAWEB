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

//        List<Produto> produtoList = new ArrayList<>();
//        Produto produto1 = new Produto();
//        produto1.setNome("Pneu");
//        produto1.setDescricao("Para carros de pequeno porte/passeio");
//        produto1.setPreco(150);
//        
//        Produto produto2 = new Produto();
//        produto2.setNome("Calota 19'");
//        produto2.setDescricao("Calotas para carros de pequeno porte");
//        produto2.setPreco(35);
//        
//        produtoList.add(produto1);
//        produtoList.add(produto2);
//
//        for(Produto produto: produtoList){
//            Produto produtoSaved = ecommerceRepository.save(produto);
//            System.out.println(produtoSaved.getId());
//        }
    }
}
