package br.com.cadastro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cadastro.ecommerce.model.Produto;
import br.com.cadastro.ecommerce.service.EcommerceService;

@Controller
public class EcommerceController {
	
	@Autowired
	EcommerceService ecommerceService;
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public ModelAndView getProdutos() {
		
		ModelAndView mv = new ModelAndView("produtos");
		List<Produto> produtos = ecommerceService.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
	public ModelAndView getProdutoDetail(@PathVariable("id") long id) {
		
		ModelAndView mv = new ModelAndView("produtoDetalhe");
		Produto produto = ecommerceService.findById(id);
		mv.addObject("produto", produto);
		return mv;
	}
	@RequestMapping(value = "/newproduto", method = RequestMethod.GET)
	public String getProdutoForm() {
		return "produtoForm";
	}
	@RequestMapping(value = "/newproduto", method = RequestMethod.POST)
	public String saveProduto(@Validated Produto produto, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("message", "Verifique se os campos obrigatórios foram preenchidos");
			return "redirect:/newproduto";
		}
		ecommerceService.save(produto);
		return "redirect:/produtos";
	}
	
}
