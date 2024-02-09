package com.tl.crud.service.impl;

import com.tl.crud.entity.Company;
import com.tl.crud.exception.NotValidFieldDataException;
import com.tl.crud.repository.CompanyRepository;
import com.tl.crud.service.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static com.tl.crud.util.ExceptionUtil.ENTITY_NOT_FOUND_EXCEPTION;

@Service
@Transactional
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    @Override
    public void create(Company entity) {
        companyRepository.save(entity);
    }

    @Override
    public void update(Company entity) {
        companyRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company findById(Long id) {
        if(id == null){
            throw new NotValidFieldDataException("Id can not be null");
        }
        return companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND_EXCEPTION));
    }

    @Override
    public Collection<Company> findAll() {
        List<Company> companyList = companyRepository.findAll();
        if(CollectionUtils.isEmpty(companyList)){
            throw new EntityNotFoundException(ENTITY_NOT_FOUND_EXCEPTION);
        }
        return companyList;
    }
}
