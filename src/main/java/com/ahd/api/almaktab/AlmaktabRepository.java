package com.ahd.api.almaktab;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface AlmaktabRepository extends PagingAndSortingRepository<AlmaktabModel, Integer> {
    Optional<AlmaktabModel> findByName(String name);
}
