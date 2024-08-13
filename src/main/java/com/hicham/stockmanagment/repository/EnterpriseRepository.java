package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Entreprise,Integer> {
}
