package br.com.cadastro.ecommerce.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cadastro.ecommerce.model.Produto;

public interface EcommerceRepository extends JpaRepository<Produto, Long>{

}
