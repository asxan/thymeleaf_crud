package com.tl.crud.repository;

import com.tl.crud.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CompanyRepository extends BaseRepository<Company> {
    Collection<Company> findAllByIndustry(String industry);
}
