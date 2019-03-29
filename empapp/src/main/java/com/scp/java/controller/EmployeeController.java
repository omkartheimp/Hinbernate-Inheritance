package com.scp.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scp.java.bean.EmpBean;
import com.scp.java.service.EmpService;

//UI -- DispatcherServlet -- handlerMapping -- Controller -- Service --Dao -- Service --Controller --Dispatherservlet --viewresoulver--dispathrsrvlt -- view
//UI -- DispatcherServlet -- handlerMapping -- Controller -- Service --Dao -- Service --Controller --Dispatherservlet-- controller-- service --dao --service --controller --distpt --viewresourlver--dispt --view

//Multiaction -- handler -- Interviewresoulver --ViewResolver

//@Controller
@Controller
public class EmployeeController {

	@Autowired
	EmpService empService;

	@RequestMapping(value = {"/home"}, method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("emplist", empService.getAllEmp());
		
		System.out.println(empService.getAllEmp());
		
		model.addAttribute("employee", new EmpBean());
		return "index";
	}
	
	//For add and update person both
	@RequestMapping(value= "/emp/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("employee") EmpBean bean){
		if(bean.getEmpId() == 0)
			empService.addEmp(bean);
		else
			empService.updateEmp(bean);
		return "redirect:/home";
	}
	
	@RequestMapping("/scp/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		empService.deleteEmp(id);
        return "redirect:/home";
    }
 
    @RequestMapping("/scp/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
    	EmpBean toBeUpdated = empService.getEmp(id);
    	model.addAttribute("employee", toBeUpdated);
    	model.addAttribute("emplist", empService.getAllEmp());
        return "index";
    }
	
}


