package com.univercity.service.interfaces;

import com.univercity.model.Unit;

import java.util.List;

public interface UnitService {

	List<Unit> getAllUnits();

	Unit getByName(String name);

	void addUnit(Unit unit);
}
