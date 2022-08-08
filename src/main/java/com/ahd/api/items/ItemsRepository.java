package com.ahd.api.items;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Optional;



public interface ItemsRepository extends PagingAndSortingRepository<ItemsModel, Integer> {
    Optional<ItemsModel> findByName(String name);
}
