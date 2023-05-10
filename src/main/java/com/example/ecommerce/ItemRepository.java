package com.example.ecommerce;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional(readOnly = true)
public interface ItemRepository extends JpaRepository<Item, Long> {
	
}