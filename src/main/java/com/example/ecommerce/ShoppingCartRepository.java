package com.example.ecommerce;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional(readOnly = true)
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
