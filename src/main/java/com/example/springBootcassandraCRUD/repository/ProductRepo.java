package com.example.springBootcassandraCRUD.repository;

import com.example.springBootcassandraCRUD.entity.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CassandraRepository<Product,Integer> {
}
