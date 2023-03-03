package com.example.Payroll.EmployeeService;

import com.example.Payroll.Entity.Employee;
import com.example.Payroll.EmployeeDTO.EmployeeDTO;
import com.example.Payroll.EmployeeRepo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO saveUser(EmployeeDTO employeeDTO){
        employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));
        return employeeDTO;
    }

    public List<EmployeeDTO> getAllUsers() {
        List<Employee>userList=employeeRepository.findAll();
        return modelMapper.map(userList,new TypeToken<List<EmployeeDTO>>(){}.getType());
    }

    public EmployeeDTO updateUser(EmployeeDTO userDTO){
        employeeRepository.save(modelMapper.map(userDTO,Employee.class));
        return userDTO;
    }

    public boolean deleteUser( EmployeeDTO employeeDTO){
        employeeRepository.delete(modelMapper.map(employeeDTO,Employee.class));
        return true;
    }
    public EmployeeDTO getEmployeeByEmployeeId(String id){
        Employee employee=employeeRepository.getEmployeeByEmployeeId(id);
        return modelMapper.map(employee,EmployeeDTO.class);

    }

    public EmployeeDTO getEmployeeByEmployeeIdAndAddress(int id,String address){
        Employee employee=employeeRepository.getEmployeeByEmployeeIdAndAddress(id,address);
        return modelMapper.map(employee,EmployeeDTO.class);
    }

}
