package com.example.cart.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.cart.model.dto.ProductDTO;
import com.example.cart.model.dto.UserDTO;
import com.example.cart.model.entity.Product;
import com.example.cart.model.entity.ProductImage;
import com.example.cart.model.entity.User;
import com.example.cart.repository.ProductRepository;
import com.example.cart.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ProductDTO> getAllProducts() {
		
		List<Product> products = productRepository.findAll();
        
        List<ProductDTO> productDTOs = products.stream()
                                               .map(product -> modelMapper.map(product, ProductDTO.class))
                                               .collect(Collectors.toList());
		return productDTOs;
	}

	@Override
	public Optional<ProductDTO> getProductById(Long id) {

		Optional<Product> optProduct = productRepository.findById(id);
		if(optProduct.isEmpty()) Optional.empty();
	
		ProductDTO productDTO = modelMapper.map(optProduct.get(), ProductDTO.class);
		return Optional.of(productDTO);
		
	}

	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) {
		
		// ProductDTO 轉 Product
		Product product = modelMapper.map(productDTO, Product.class);
		// 配置 ProductImage
		ProductImage productImage = new ProductImage();
		productImage.setImageBase64(productDTO.getImageBase64());
		product.setProductImage(productImage);

		// 儲存
		productRepository.save(product);

		return modelMapper.map(product, ProductDTO.class);

	}

}