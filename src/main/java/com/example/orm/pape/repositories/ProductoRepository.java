package com.example.orm.pape.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.orm.pape.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository <ProductoModel, Long> {
	
}