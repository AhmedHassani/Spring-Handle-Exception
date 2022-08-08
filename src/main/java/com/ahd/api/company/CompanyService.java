package com.ahd.api.company;


import com.ahd.api.almaktab.AlmaktabModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyModel getCompany(int id) {
        return companyRepository.findById(id).get();
    }


    public List<CompanyModel> getCompanyList(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<CompanyModel> pagedResult = companyRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<CompanyModel>();
        }
    }

    public CompanyModel addCompany(CompanyModel company) {
        return companyRepository.save(company);
    }

    public CompanyModel updateCompany(CompanyModel company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(int id) {
        companyRepository.deleteById(id);
    }

    public CompanyModel findByName(String name) {
        Optional<CompanyModel> credentials = companyRepository.findByName(name);
        return credentials.get();
    }


}
