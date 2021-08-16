package com.pradip.vm.shape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pradip.vm.shape.model.Model;

public interface ShapeRepository extends JpaRepository<Model, Long> {
}