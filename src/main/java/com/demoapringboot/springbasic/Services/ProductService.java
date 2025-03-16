package com.demoapringboot.springbasic.Services;

import com.demoapringboot.springbasic.Dtos.ProductDto;
import com.demoapringboot.springbasic.Entities.Product;
import com.demoapringboot.springbasic.Repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ProductDto> getall() {

        List<Product> alldata=productRepository.findAll();

        return alldata.stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());
    }
    public List<ProductDto> getmatchingproducts() {

        List<Product> alldata=productRepository.findAll();

        List<ProductDto> match=alldata.stream()
                .filter(product -> product.getPname().equals("poorna"))
                .map(product -> modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());
       return match;

    }

    public List<ProductDto> getmatchingnames(String pname) {

        //Optional<Product> alldata=productRepository.findById(1l);//jpql select * from emp where id=id;
        List<Product> productbyname=productRepository.findByPname(pname);

        return productbyname.stream().map(p->modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }
}
