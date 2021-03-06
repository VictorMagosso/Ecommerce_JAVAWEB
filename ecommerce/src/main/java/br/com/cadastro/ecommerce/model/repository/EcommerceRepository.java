package br.com.cadastro.ecommerce.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.ecommerce.model.Produto;

@Repository
public interface EcommerceRepository extends JpaRepository<Produto, Long>{

}
