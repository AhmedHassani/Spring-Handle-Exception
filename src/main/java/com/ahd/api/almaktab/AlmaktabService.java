package com.ahd.api.almaktab;
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
public class AlmaktabService {

    @Autowired
    private AlmaktabRepository almaktabRepository;

    public AlmaktabModel getAlmaktab(int id) {
        return almaktabRepository.findById(id).get();
    }

    public List<AlmaktabModel> getListAlmaktab(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<AlmaktabModel> pagedResult = almaktabRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<AlmaktabModel>();
        }
    }

    public AlmaktabModel addAlmaktab(AlmaktabModel almaktab) {
        return almaktabRepository.save(almaktab);
    }

    public AlmaktabModel updateAlmaktab(AlmaktabModel almaktab) {
        return almaktabRepository.save(almaktab);
    }

    public void deleteAlmaktab(int id) {
        almaktabRepository.deleteById(id);
    }

    public AlmaktabModel findByName(String name) {
        Optional<AlmaktabModel> credentials = almaktabRepository.findByName(name);
        return credentials.get();
    }



}
