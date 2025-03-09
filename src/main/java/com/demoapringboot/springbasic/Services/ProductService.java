package com.demoapringboot.springbasic.Services;

import com.demoapringboot.springbasic.Dtos.ProductDto;
import com.demoapringboot.springbasic.Entities.Product;
import com.demoapringboot.springbasic.Repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    ProductService(ModelMapper modelMapper,ProductRepository productRepository){
        this.modelMapper=modelMapper;
        this.productRepository=productRepository;
    }

    public ProductDto createnewproduct(ProductDto productDto) {
        Product pentity=modelMapper.map(productDto,Product.class);

        Product savedproduct=productRepository.save(pentity);
        return modelMapper.map(productRepository.save(pentity), ProductDto.class);
    }

    public ProductDto getbyid(Long id) {
       // Product getproductbyid=productRepository.findById(id).orElseThrow(()->new RuntimeException("sorry no data to display"));
       Optional<Product> getproductbyid=productRepository.findById(id);

        return modelMapper.map(getproductbyid, ProductDto.class);
    }

    public Boolean delbyid(Long id) {

        Boolean isexist=productRepository.existsById(id);

        if(!isexist) return false;
       productRepository.deleteById(id);

        return true;
    }
}
