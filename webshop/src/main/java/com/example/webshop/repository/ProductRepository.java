package com.example.webshop.repository;

import com.example.webshop.model.ProductResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductRepository {

    List<ProductResponse> products = Arrays.asList(
            new ProductResponse(
                    "1",
                    "AMD Ryzen",
                    "aoifwoiafw aowifh wwfwewef",
                    79900,
                    Arrays.asList("AMD", "processor")
            ),
            new ProductResponse(
                    "2",
                    "Intel Core i-9",
                    "aoifwoiafw aowifh wwfwewef",
                    50900,
                    Arrays.asList("Intel", "processor")
            ),
            new ProductResponse(
                    "3",
                    "NVIDIA GeForce",
                    " wa d wdaA Woifwoiafw aowifh awdawdwwawdawdfwewef",
                    27900,
                    Arrays.asList("NVIDIA", "graphics")
            ));

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


}
