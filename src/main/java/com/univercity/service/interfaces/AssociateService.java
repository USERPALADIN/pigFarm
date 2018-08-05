package com.univercity.service.interfaces;

import com.univercity.model.Associate;

import java.util.List;

public interface AssociateService {

	List<Associate> getAllAssociates();

	void deleteAssociate(long id);

	void updateAssociate(Associate associate);

	void saveAssociate(Associate associate);

	Associate getByName(String name);

	Associate getById(long id);
}
