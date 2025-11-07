
package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Service.UsuarioService;
import com.pasteleria.Milsabores.Entity.Usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Milsabores
 */
public class UsuarioController {
    
    @Autowired
    private EmployeeService service;
    
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee e){
        return service.saveEmployee(e);
    }
    
    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> emps){
        return service.saveEmployees(emps);
    }
    
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return service.getEmployees();
    }
    
    @GetMapping("/employeeById/{empId}")
    public Employee findEmployeeById(@PathVariable int empId){
        return service.getEmployeeById(empId);
    }
    
    @GetMapping("/employeeByName/{firstName}")
    public Employee findByFirstName(@PathVariable String firstName){
        return service.getEmployeeByFirstName(firstName);
    }
    
    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId){
        return service.delteEmployee(empId);
    }
    
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee e){
        return service.updateEmployee(e);
    }
    
}
