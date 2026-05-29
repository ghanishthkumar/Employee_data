package com.example.backend;

import java.util.*;
import java.io.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EmployeeController {
    String fileName = "data.txt";

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee emp){
        try{
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(emp.getName()+ ","
            + emp.getAge() + ","
            + emp.getSalary() + "\n");
            fw.close();
            return "Employee added successfully";
        }
        catch(IOException e){
            return "Error";
        }
    }

    @GetMapping("/employees")
    public List<String> getEmployees() {

        List<String> employees = new ArrayList<>();

        try {

            BufferedReader br =
                    new BufferedReader(new FileReader(fileName));

            String line;

            while((line = br.readLine()) != null) {
                employees.add(line);
            }

            br.close();

        } catch(Exception e) {
            System.out.println(e);
        }

        return employees;
    }




}
