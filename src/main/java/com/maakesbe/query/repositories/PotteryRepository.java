package com.maakesbe.query.repositories;

import com.maakesbe.query.models.Pottery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PotteryRepository extends CrudRepository<Pottery, Long>{

}
