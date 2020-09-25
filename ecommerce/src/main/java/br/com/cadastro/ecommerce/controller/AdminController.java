package br.com.cadastro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cadastro.ecommerce.model.Admin;
import br.com.cadastro.ecommerce.service.AdminService;

@RestController
public class AdminController {

	private AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView getRegistration() {
		ModelAndView mv = new ModelAndView("registration");
		return mv;
	}
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String saveAdminAccount(@Validated Admin admin, BindingResult results, RedirectAttributes attributes) {
		if (results.hasErrors()) {
			attributes.addFlashAttribute("message", "Verifique se os campos obrigatórios foram preenchidos corretamente");
			return "redirect:/registration?error";
		}
		adminService.save(admin);
		attributes.addFlashAttribute("messagesuccess", "Administrador registrado com sucesso!");
		return "redirect:/registration?success";
	}
}
