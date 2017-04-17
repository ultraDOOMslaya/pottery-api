package com.maakesbe.query.repositories;

import com.maakesbe.query.models.PotteryType;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PotteryTypeRepository extends CrudRepository<PotteryType, Long>{
}
