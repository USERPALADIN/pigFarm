package com.univercity.service.Impl;

import com.univercity.model.Unit;
import com.univercity.repository.interfaces.UnitRepository;
import com.univercity.service.interfaces.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

	private final UnitRepository unitRepository;

	@Autowired
	public UnitServiceImpl(UnitRepository unitRepository) {
		this.unitRepository = unitRepository;
	}

	@Override
	public List<Unit> getAllUnits() {
		return  unitRepository.findAll();
	}

	@Override
	public Unit getByName(String name) {
		return unitRepository.getByName(name);
	}

	@Override
	public void addUnit(Unit unit) {
		unitRepository.saveAndFlush(unit);
	}
}
