package com.maakesbe.services.repositories;

import com.maakesbe.services.models.Pottery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PotteryRepository extends CrudRepository<Pottery, Long>{

}
