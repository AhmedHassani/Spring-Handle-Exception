package com.ahd.api.almaktab;
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
public class AlmaktabService {

    @Autowired
    private AlmaktabRepository almaktabRepository;

    public AlmaktabModel getAlmaktab(int id) {
        try {
            if (almaktabRepository.existsById(id)) {
                return almaktabRepository.findById(id).get();
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        }
        throw new NotFoundException(String.format("Not Found this id [%s]", id));
    }

    public List<AlmaktabModel> getListAlmaktab(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<AlmaktabModel> pagedResult = almaktabRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public AlmaktabModel addAlmaktab(AlmaktabModel almaktab) {
        return almaktabRepository.save(almaktab);
    }

    public AlmaktabModel updateAlmaktab(AlmaktabModel almaktab) {
        try {
            if (almaktabRepository.existsById(almaktab.getId())) {
                return almaktabRepository.save(almaktab);
            }
        }catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", almaktab.getId()));
        }catch (HttpClientErrorException.BadRequest exception){
            throw new BadRequest("illegal request");
        }
        throw new NotFoundException(String.format("Not Found this id [%s]", almaktab.getId()));
    }

    public AlmaktabModel deleteAlmaktab(int id) {
        try {
            if (almaktabRepository.existsById(id)) {
                AlmaktabModel almaktabModel = almaktabRepository.findById(id).get();
                almaktabRepository.deleteById(id);
                return almaktabModel;
            }
        }catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        }catch (HttpClientErrorException.BadRequest exception){
            throw new BadRequest("illegal request");
        }
        throw new NotFoundException(String.format("Not Found this id [%s]", id));
    }

    public AlmaktabModel findByName(String name) {
        Optional<AlmaktabModel> credentials = almaktabRepository.findByName(name);
        return credentials.get();
    }



}
