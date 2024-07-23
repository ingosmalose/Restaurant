package com.application.rest.repository;

import com.application.rest.entities.tbl_menu;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface menuRepository extends CrudRepository<tbl_menu, Long>{
    
}
