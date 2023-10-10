package com.wooin.wantedinternship.company.repository;

import com.wooin.wantedinternship.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
