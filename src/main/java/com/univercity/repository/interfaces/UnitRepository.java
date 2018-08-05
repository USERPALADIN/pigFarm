package com.univercity.repository.interfaces;

import com.univercity.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit,Long>{
	Unit getByName(String name);
}
