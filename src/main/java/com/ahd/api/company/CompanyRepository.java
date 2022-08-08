package com.ahd.api.company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<CompanyModel, Integer> {
    Optional<CompanyModel> findByName(String username);
}



