package com.univercity.repository.interfaces;

import com.univercity.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociateRepository extends JpaRepository<Associate,Long> {

	Associate getByName(String name);
}
