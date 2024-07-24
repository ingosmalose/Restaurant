package com.application.rest.repository;

import com.application.rest.entity.Reservation;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface reservationRepository extends CrudRepository<Reservation, Long>{
        
       
}
