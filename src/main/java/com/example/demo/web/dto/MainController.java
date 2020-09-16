package com.example.demo.web.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "index";
	}

	@GetMapping("/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable (value = "id") long id,Model model) {
		User user = userService.getUserByID(id);
		model.addAttribute("user", user);
		return "update_user";
	}
	
	@PostMapping("updateuser")
	public String updateUser(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable (value = "id") long id) {
		userService.deleteUser(id);
		return "redirect:/";
	}

}
