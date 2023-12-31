package com.commtalk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.commtalk.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("SELECT DISTINCT c FROM Category c JOIN fetch c.boards b")
	List<Category> findAllWithBoards();
	
}
