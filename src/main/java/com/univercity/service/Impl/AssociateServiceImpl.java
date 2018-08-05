package com.univercity.service.Impl;

import com.univercity.model.Associate;
import com.univercity.repository.interfaces.AssociateRepository;
import com.univercity.service.interfaces.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssociateServiceImpl implements AssociateService {

	private final AssociateRepository associateRepository;

	@Autowired
	public AssociateServiceImpl(AssociateRepository associateRepository) {
		this.associateRepository = associateRepository;
	}

	@Override
	public List<Associate> getAllAssociates() {
		return associateRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteAssociate(long id) {
		associateRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateAssociate(Associate associate) {
		associateRepository.saveAndFlush(associate);
	}

	@Override
	public void saveAssociate(Associate associate) {
		associateRepository.saveAndFlush(associate);
	}

	@Override
	public Associate getByName(String name) {
		return  associateRepository.getByName(name);
	}

	@Override
	public Associate getById(long id) {
		return associateRepository.getOne(id);
	}
}
