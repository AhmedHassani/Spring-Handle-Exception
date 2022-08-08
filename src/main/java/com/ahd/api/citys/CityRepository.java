package com.ahd.api.citys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Integer> {
    Optional<CityModel> findByName(String username);
}
