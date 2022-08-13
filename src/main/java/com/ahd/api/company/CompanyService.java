package com.ahd.api.company;



import com.ahd.api.exception.BadRequest;
import com.ahd.api.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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

    public CompanyModel deleteCompany(int id) {
        try {
            if (companyRepository.existsById(id)) {
                CompanyModel companyModel = companyRepository.findById(id).get();
                companyRepository.deleteById(id);
                return companyModel;
            }
        }catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        }catch (HttpClientErrorException.BadRequest exception){
            throw new BadRequest("illegal request");
        }
        throw new NotFoundException(String.format("Not Found this id [%s]", id));
    }

    public CompanyModel findByName(String name) {
        Optional<CompanyModel> credentials = companyRepository.findByName(name);
        return credentials.get();
    }


}
