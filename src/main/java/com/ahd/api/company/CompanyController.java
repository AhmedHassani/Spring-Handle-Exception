package com.ahd.api.company;
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
    public List<CompanyModel> getListCompany(@RequestParam(defaultValue = "0") Integer pageNo,
                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return companyService.getCompanyList(pageNo,pageSize,sortBy);
    }

    @GetMapping("/company/{id}")
    public CompanyModel getCompany(@PathVariable int id) {
        return companyService.getCompany(id);
    }

    @PostMapping("/company")
    public CompanyModel addCompany(@RequestBody CompanyModel company) {
        return companyService.addCompany(company);
    }

    @PutMapping("/company")
    public CompanyModel updateCompany(@RequestBody CompanyModel company) {
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/company/delete/{id}")
    public void deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
    }

    @GetMapping("/company/search/{name}")
    public CompanyModel findByName(@PathVariable String name) {
        return companyService.findByName(name);
    }

}
