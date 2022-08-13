package com.ahd.api.company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company")
    public ResponseEntity getListCompany(@RequestParam(defaultValue = "0") Integer pageNo,
                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity(companyService.getCompanyList(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity getCompany(@PathVariable int id) {
        return new ResponseEntity(companyService.getCompany(id), HttpStatus.OK);
    }

    @PostMapping("/company")
    public ResponseEntity addCompany(@RequestBody CompanyModel company) {

        return new ResponseEntity(companyService.addCompany(company), HttpStatus.CREATED);
    }

    @PutMapping("/company")
    public ResponseEntity updateCompany(@RequestBody CompanyModel company) {
        return new ResponseEntity(companyService.updateCompany(company), HttpStatus.CREATED);
    }

    @DeleteMapping("/company/delete/{id}")
    public ResponseEntity deleteCompany(@PathVariable int id) {
        return new ResponseEntity(companyService.deleteCompany(id), HttpStatus.OK);
    }

    @GetMapping("/company/search/{name}")
    public ResponseEntity findByName(@PathVariable String name) {
        return new ResponseEntity(companyService.findByName(name), HttpStatus.OK);
    }

}
