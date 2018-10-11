package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.CurrencyDetails;

@Repository
public interface CurrencyDetailRepository extends JpaRepository<CurrencyDetails,Integer>{

  List<CurrencyDetails> findFirst10ByOrderByIdDesc();

}
