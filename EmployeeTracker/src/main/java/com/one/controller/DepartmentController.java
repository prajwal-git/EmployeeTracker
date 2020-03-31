package com.one.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.one.model.Department;
import com.one.repository.DepartmentRepository;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentRepository depRepo;
	
	@RequestMapping("/listDepartment")
	public ModelAndView listDepartment() {
		List<Department> department = depRepo.findAll();
//		for(Department dp: department) {
//			System.out.println(dp);
//		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("DeptObject",department);
		mv.setViewName("viewDepartment");
		return mv;
		
	}
	
	
	@GetMapping("/showFormDepartment")
	public ModelAndView showDepartmentForm() {
		ModelAndView mv = new ModelAndView();
		Department dp = new Department();
		mv.addObject("Department", dp);
		mv.setViewName("addDepartmentForm");
			
		return mv;
		
	}
	
	@PostMapping("/addDepartment")
	public String addDepartment(Department dp) {
		
		depRepo.save(dp);
		return "redirect:/listDepartment";	
		
	}
	
	@RequestMapping("/showFormDepartmentUpdate")
	public ModelAndView updateDepartment(@RequestParam int id) {
		
		Optional<Department> department = depRepo.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("Department", department);
		mv.setViewName("addDepartmentForm");
		return mv;
		
	}
	
	@GetMapping("/deleteDepartment")
	public String deleteDepartment(@RequestParam int id) {
		
		Department department = depRepo.getOne(id);
		depRepo.delete(department);
		return "redirect:/listDepartment";	
	}

}
