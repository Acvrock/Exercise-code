package com.acvrock.service;


import com.acvrock.domain.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
