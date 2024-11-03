package com.example.webshop.repository;

import com.example.webshop.model.ProductCreateRequest;
import com.example.webshop.model.ProductResponse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductRepository {

    List<ProductResponse> products = new ArrayList<>();

    public ProductRepository(){
        products.add(
                new ProductResponse(
                        UUID.randomUUID().toString(),
                        "AMD Ryzen",
                        "aoifwoiafw aowifh wwfwewef",
                        79900,
                        Arrays.asList("AMD", "processor")
        ));
        products.add(
                new ProductResponse(
                        UUID.randomUUID().toString(),
                        "Intel Core i-9",
                        "aoifwoiafw aowifh wwfwewef",
                        50900,
                        Arrays.asList("Intel", "processor")
        ));
        products.add(
                new ProductResponse(
                        UUID.randomUUID().toString(),
                        "NVIDIA GeForce",
                        " wa d wdaA Woifwoiafw aowifh awdawdwwawdawdfwewef",
                        27900,
                        Arrays.asList("NVIDIA", "graphics")
        ));
    }




    public List<ProductResponse> findAll(String tag){

        if(tag == null)
            return products;
        else {
            String lowerCaseTag = tag.toLowerCase();
            List<ProductResponse> filtered =
                    products.stream()
                            .filter(p -> lowercaseTags(p).contains(tag))
                            .collect(Collectors.toList());

            return filtered;

        }
    }


    private List<String> lowercaseTags(ProductResponse p){
        return p.getTags().stream()
                .map(tag -> tag.toLowerCase())
                .collect(Collectors.toList());
    }


    public Optional<ProductResponse> findById(String id) {
        Optional<ProductResponse> product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return product;
    }

    public void deleteById(String id) {
        this.products = products.stream()
                .filter(p -> !p.getId().equals(id))
                .collect(Collectors.toList());
    }

    public ProductResponse save(ProductCreateRequest request) {
        ProductResponse response = new ProductResponse(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getDescription(),
                request.getPriceInCent(),
                request.getTags()
        );
        products.add(
                response
        );
        return response;
    }
}
