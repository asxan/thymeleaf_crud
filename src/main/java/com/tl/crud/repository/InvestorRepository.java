package com.tl.crud.repository;

import com.tl.crud.entity.Investor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface InvestorRepository extends BaseRepository<Investor>{
    @Query("select i from Investor i where i.secondName like %:n%")
    Collection<Investor> getInvestors(@Param("n") String n);
}
