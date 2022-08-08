package com.ahd.api.delegates;


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
public class DelegatesService {
    @Autowired
    private DelegatesRepository delegatesRepository;

    public DelegatesModel getDelegates(int id) {
        return delegatesRepository.findById(id).get();
    }

    public List<DelegatesModel> getListDelegates(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<DelegatesModel> pagedResult = delegatesRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<DelegatesModel>();
        }
    }

    public DelegatesModel addDelegates(DelegatesModel delegates) {
        return delegatesRepository.save(delegates);
    }

    public DelegatesModel updateDelegates(DelegatesModel delegates) {
        return delegatesRepository.save(delegates);
    }

    public void deleteDelegates(int id) {
        delegatesRepository.deleteById(id);
    }

    public DelegatesModel findByName(String name) {
        Optional<DelegatesModel> credentials = delegatesRepository.findByName(name);
        return credentials.get();
    }


}
