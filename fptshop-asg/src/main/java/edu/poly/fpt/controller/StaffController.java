package edu.poly.fpt.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.fpt.dtos.StaffDto;
import edu.poly.fpt.models.Depart;
import edu.poly.fpt.models.Staff;
import edu.poly.fpt.service.StaffService;

@Controller
@RequestMapping("staffs")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("staffs", staffService.findAll());
		return "staffs/list";
	}
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		StaffDto staff = new StaffDto();
		model.addAttribute("staffDto", staff);
		return "staffs/addOrEdit";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,@Validated StaffDto staffDTO, 
			BindingResult result) {
		
		if (result.hasErrors()) {
			model.addAttribute("message", "Please input all required fields !!");
			model.addAttribute("staffDto", staffDTO);
			return "staffs/addOrEdit";
		}
		
		if (staffDTO.getId()!= null && staffDTO.getId()>0 ) {
			model.addAttribute("mesaage", "The Staff updated !!");
		} else {
			model.addAttribute("mesaage", "New Staff inserted !!");
		}
		
		Path path = Paths.get("images/");
		
		try(InputStream inputStream =staffDTO.getImage().getInputStream()) {
			Files.copy(inputStream, path.resolve(staffDTO.getImage().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			String filename = staffDTO.getImage().getOriginalFilename();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("massage", "Error" + e.getMessage());
		}
		
		Staff staff = new Staff();
		staff.setBirthday(staffDTO.getBirthday());
		staff.setName(staffDTO.getName());
		staff.setPhoto(staffDTO.getImage().getOriginalFilename());
		Depart depart = new Depart();
		depart.setId(staffDTO.getDepartId());
		staffService.save(staff);
		
		model.addAttribute("staffDto", staffDTO);
		
		return "staffs/addOrEdit";
	}
	@ModelAttribute(name = "departs")
	public List<Depart> getDepart(){
		return staffService.findAllDeparts();
	}
}
