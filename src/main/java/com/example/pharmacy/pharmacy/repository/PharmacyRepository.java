package com.example.pharmacy.pharmacy.repository;

import com.example.pharmacy.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by KimKyungHo on 2024-02-15(015)
 */

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

}
