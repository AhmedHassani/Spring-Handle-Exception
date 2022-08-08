package com.ahd.api.delegates;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface DelegatesRepository extends PagingAndSortingRepository<DelegatesModel, Integer> {
    Optional<DelegatesModel> findByName(String name);
}
