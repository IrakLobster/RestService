package org.ibs.service.domain.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends CrudRepository<Departament, Long> {

}
