package com.ouss.saleservice.repository;

import com.ouss.saleservice.entites.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
