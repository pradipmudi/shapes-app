package com.pradip.vm.shape.repository;

import org.springframework.data.repository.CrudRepository;

import com.pradip.vm.shape.model.Model;

public interface ShapeRepository extends CrudRepository<Model, Long> {

}