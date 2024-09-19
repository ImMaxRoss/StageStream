package com.cognixia.stagestream.services;

import com.cognixia.stagestream.models.Product;
import com.cognixia.stagestream.dto.ProductDTO;
import com.cognixia.stagestream.dto.ProductResponse;

public interface ProductService {

	ProductDTO addProduct(String category, Product product);

	ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	ProductResponse searchByCategory(String category, Integer pageNumber, Integer pageSize, String sortBy,
			String sortOrder);

	ProductDTO updateProduct(Long productId, Product product);


	ProductResponse searchProductByKeyword(String keyword, Integer pageNumber, Integer pageSize, String sortBy,
			String sortOrder);

	String deleteProduct(Long productId);

}