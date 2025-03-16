package com.demoapringboot.springbasic.Controllers;

import com.demoapringboot.springbasic.Dtos.ProductDto;
import com.demoapringboot.springbasic.Services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {


    private final ProductService productService;
    private final ModelMapper modelMapper;
    ProductController(ProductService productService,ModelMapper modelMapper){
        this.productService=productService;
        this.modelMapper=modelMapper;
    }

    //Lombok error
    //change lombok dependency and use stable version
    //mvn clean install
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){

       ProductDto posted=productService.createnewproduct(productDto);
       return new ResponseEntity<>(posted,HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public  ResponseEntity<ProductDto> getByid(@PathVariable Long id){
        return ResponseEntity.ok(productService.getbyid(id));
    }

    @GetMapping("/getall")
    public  ResponseEntity<List<ProductDto>> getall(){
        return ResponseEntity.ok(productService.getall());
    }

    @GetMapping("/matchingname")
    public  ResponseEntity<List<ProductDto>> getallmatchingproducts(){
        return ResponseEntity.ok(productService.getmatchingproducts());
    }

    @GetMapping("search/{name}")
    public  ResponseEntity<List<ProductDto>> getallmatchingnames(@PathVariable String name){
        return ResponseEntity.ok(productService.getmatchingnames(name));
    }

    @GetMapping("nameprice/{name}/{price}")
    public  ResponseEntity<List<ProductDto>> getallbynameprice(@PathVariable String name,@PathVariable(name="price") Integer sal ){
        return ResponseEntity.ok(productService.getallbynameprice(name,sal));
    }

    @GetMapping("price/{price}")
    public  ResponseEntity<List<ProductDto>> getallbyprice(@PathVariable(name="price") Integer sal ){
        return ResponseEntity.ok(productService.getallbyprice(sal));
    }

    @GetMapping("CustomQuery/{price}")
    public  ResponseEntity<?> custom(@PathVariable(name="price") Integer sal ){
        return ResponseEntity.ok(productService.customq(sal));
    }


    @DeleteMapping("/{id}")
    public  ResponseEntity<String> delByid(@PathVariable Long id){
        if(!productService.delbyid(id)){
            return ResponseEntity.ok("id not found");
        }
        return ResponseEntity.ok("Successfully deleted id:"+id);
    }




}
