package com.example.Payroll.Controller;

import com.example.Payroll.EmployeeDTO.EmployeeDTO;
import com.example.Payroll.EmployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getEmployee")
    public List<EmployeeDTO> getUser(){
        return employeeService.getAllUsers();
    }

    @PostMapping("/postEmployee")
    public EmployeeDTO postUser(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveUser(employeeDTO);
    }

    @PutMapping("/putEmployee")
    public EmployeeDTO putUser(EmployeeDTO employeeDTO){
        return employeeService.updateUser(employeeDTO);
    }

    @DeleteMapping("/deleteEmployee")
    public boolean deleteUser(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.deleteUser(employeeDTO);
    }

    @GetMapping("/getEmployeeByEmployeeId/{id}")
    public EmployeeDTO getEmployeeByEmployeeId(@PathVariable String id){
        return employeeService.getEmployeeByEmployeeId(id);
    }

    @GetMapping("/getEmployeeByEmployeeIdAndAddress/{id}/{address}")
    public EmployeeDTO getEmployeeByEmployeeId(@PathVariable int id,@PathVariable String address){
        return employeeService.getEmployeeByEmployeeIdAndAddress(id,address);
    }


}
