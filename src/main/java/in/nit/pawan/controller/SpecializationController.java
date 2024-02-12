package in.nit.pawan.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nit.pawan.entity.Specialization;
import in.nit.pawan.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {
	@Autowired
	private ISpecializationService service;
	/**
	 * 1. 
	 */
	@GetMapping("/register")
	public String displayRegister() {
		return "SpecializationRegister";
		
	}
	
	
	/**
	 * 2. On submit form save data
	 */
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute Specialization specialization,Model model) {
		Long id = service.saveSpecialization(specialization);
		String message = "Record "+id+" is created";
		model.addAttribute("message" , message);
		return "SpecializationRegister";
		
	}	
	
	/**
	 * 3. Display all specialization
	 */
	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Specialization> list = service.getAllSpecialization();
		model.addAttribute("list",list);
		return "SpecializationData";
	}
	
	/**
	 * 4. Delete by id
	 */
	@GetMapping("/delete")
	public String deleteData(@RequestParam Long id, RedirectAttributes attributes) {
		service.removeSpecialization(id);
		attributes.addAttribute("message", "Record "+id+" is removed");
		return "redirect:all";
	}
	
	/**
	 * 5. Fetch data into Edit page
	 */
	
	@GetMapping("/edit")
	public String showEditPage(@RequestParam Long id, Model model) {
		Specialization spec = service.getOneSpecialization(id);
		model.addAttribute("specialization",spec);
		return "SpecializationEdit";
	}
	
	/**
	 * 6. Update form data and redirect to all 
	 */
	
	@PostMapping("/update")
	public String updateDate(@ModelAttribute Specialization specialization, RedirectAttributes attributes) {
		service.updateSpecialization(specialization);
		attributes.addAttribute("message", "Record "+specialization.getId()+"is updated");
		
		return "redirect:all";
	}

}
