package com.scp.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scp.java.bean.EmpBean;
import com.scp.java.service.EmpService;

@RestController
public class EmployeeeRestController {

	@Autowired
	EmpService empService;

	@RequestMapping(value = {"/emp"}, method = RequestMethod.GET)
	public List<EmpBean> listPersons(Model model) {
		model.addAttribute("emplist", empService.getAllEmp());
		return empService.getAllEmp();
		//model.addAttribute("employee", new EmpBean());
		//return "index";
	}
	
	//For add and update person both
	@RequestMapping(value= "/emp", method = RequestMethod.POST)
	public boolean addPerson(@RequestBody EmpBean bean){
		System.out.println(bean);
	if(bean.getEmpId() <=0)
			return empService.addEmp(bean);
	else 
			return empService.updateEmp(bean)!=null;
	}
	
//	@RequestMapping("/scp/remove/{id}")
	@RequestMapping(value= "/emp/{id}", method = RequestMethod.DELETE)
    public boolean removePerson(@PathVariable("id") int id){
		return empService.deleteEmp(id);
        //return "redirect:/home";
    }
	
 /*
    @RequestMapping("/scp/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
    	EmpBean toBeUpdated = empService.getEmp(id);
    	model.addAttribute("employee", toBeUpdated);
    	model.addAttribute("emplist", empService.getAllEmp());
        return "index";
    }*/
	

}
