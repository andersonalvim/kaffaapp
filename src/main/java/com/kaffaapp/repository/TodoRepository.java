package com.kaffaapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.kaffa.kaffaapp.models.Todo;


public interface TodoRepository extends CrudRepository<Todo, String> {
	Todo findByCodigo(long codigo);
}
