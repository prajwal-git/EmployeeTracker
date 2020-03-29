package com.one.controller;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.one.model.Employee;
import com.one.repository.EmployeeRepository;

@Controller
//we now use REST CONTROLLER FOR MORE ANNOTATIONS
//@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public  EmployeeController() {
		// TODO Auto-generated constructor stub
		
		System.out.println("Controller Check");
	}
	
	@GetMapping("/")
	public String dashBoard() {
		return "index";
	}

	@GetMapping("showFormEmployee")
	public ModelAndView showEmployeeForm() {
		ModelAndView mv = new ModelAndView();
		Employee theEmployee = new Employee();
		mv.addObject("Employee", theEmployee);
		mv.setViewName("addEmployeeForm");
		return mv;
	}
	
	@GetMapping("showFormEmployeeUpdate")
	public ModelAndView showEmployeeFormUpdate(@RequestParam int id) {
		Optional<Employee> employee = empRepo.findById(id);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("Employee", employee);
		mv.setViewName("addEmployeeForm");
		return mv;
	}	
	
	@PostMapping("addEmployee")
	public String addemployee(Employee emp) {
		empRepo.save(emp);
		return "redirect:/listEmployee";	
	}
	
//	@PostMapping("/addEmployeeRest")
//	@ResponseBody
//	public Employee addemployeeRest(@RequestBody Employee emp) {
//		empRepo.save(emp);
//		return emp;
//	}	
	
//	@PutMapping("/addEmployeeRestPut")
//	@ResponseBody
//	public Employee addemployeeRestPut(@RequestBody Employee emp) {
//		empRepo.save(emp);
//		return emp;
//	}		
	
	@GetMapping("fetchEmployee")
	public ModelAndView fetchEmployee(@RequestParam int id) {
		
		Employee employee = empRepo.findById(id).orElse(new Employee());
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmpObject", employee);
		mv.setViewName("ViewEmployee");
		return mv;
	}
	
	//Request Mapping to display as String , Json 
	
	@RequestMapping("fetchAllEmployee")
	@ResponseBody
//	public String fetchAllEmployee() {
//		
//		System.out.println("Printing All Employee");
//		return empRepo.findAll().toString();
//	}
	public List<Employee> fetchAllEmployee() {
	
	System.out.println("Printing All Employee");
	return empRepo.findAll();
}	
	

	//Request Mapping to display as String , Json 
	//Maven uses Jackson API to convert entity to JSON format
	//Optional is Like LIST for Java 8 
	//REST API
//	@RequestMapping("/getEmployee/{id}")
//	@ResponseBody
//	public Optional<Employee> getEmployee(@PathVariable("id") int input) {
//		
//		//System.out.println("Printing All Employee");
//		return empRepo.findById(input);
//	}	
//	
	//@PathVariable // for JSON request
	
//	@RequestMapping(path ="/getEmployeeJson/{id}", produces = {"application/json"})
//	@ResponseBody
//	public Optional<Employee> getEmployeeJson(@PathVariable("id") int input) {
//		
//		//System.out.println("Printing All Employee");
//		return empRepo.findById(input);
//	}	
		
	

	@RequestMapping("fetchEmployeeName")
	public ModelAndView fetchEmployee(@RequestParam String empName) {
		
		List<Employee> employee = (List<Employee>) empRepo.findByempName(empName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmpObject", employee);
		mv.setViewName("ViewEmployee");
		return mv;
	}
	
	
	@RequestMapping("fetchEmployeeIdGreaterThan")
	public ModelAndView findByidGreaterThan(@RequestParam int id) {
		
		List<Employee> employee = (List<Employee>) empRepo.findByidGreaterThan(id);
		//Map<Integer,Employee> EmployeeMap = new HashMap<Integer,Employee>();
		for(Employee em :employee) {
			//EmployeeMap.put(em.getId(), em);
			System.out.println(em);
	}		
		ModelAndView mv = new ModelAndView();
		//mv.addAllObjects(EmployeeMap);
		mv.addObject("EmpObject", employee);
		mv.setViewName("ViewEmployee");
		return mv;
	}	
	
	@RequestMapping("listEmployee")
	public ModelAndView listEmployee(Employee emp) {
		
		List<Employee> employee = (List<Employee>) empRepo.findAll();
//		for(Employee em :employee) {
//			System.out.println(em);
//		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmpObject", employee);
		mv.setViewName("ViewEmployee");
		
		return mv;
		
	}
	
	
	@RequestMapping("fetchbyDeptNameSorted")
	public String fetchEmployeebyDeptSorted(@RequestParam String empDept) {
		
		List<Employee> employee = (List<Employee>) empRepo.findBydeptSorted(empDept);
		
		for(Employee em :employee) {
			System.out.println(em);
		}
		
		return "ViewEmployee";
	}	
	

	// from REST API
	//@DeleteMapping("/deleteEmployee/{id}")
	@GetMapping("/deleteEmployee")
	public String deleteEmployeebyId(@RequestParam int id) {
		
		//empRepo.deleteById(id);
		
		Employee employee = empRepo.getOne(id);
		empRepo.delete(employee);
		
		return "redirect:/listEmployee";
	}
	

}
