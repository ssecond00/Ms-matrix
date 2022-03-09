package com.matrix.ss.repository;

import com.matrix.ss.negocio.ProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface ProductsRepository extends PagingAndSortingRepository<ProductEntity,Integer> {


    Optional<ProductEntity> findById(Integer integer);

    Optional<ProductEntity> findBynombre(String nombre);
}
