package com.example.orm.pape.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.orm.pape.models.OrdenModel;

@Repository
public interface OrdenRepository extends CrudRepository <OrdenModel, Long> {
	
}