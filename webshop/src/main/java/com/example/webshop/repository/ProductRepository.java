package com.example.webshop.repository;

import com.example.webshop.model.ProductResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    public List<ProductResponse> findAll(String tag){
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

        if(tag == null)
            return products;
        else {
            List<ProductResponse> filtered = new ArrayList<>();
            for (ProductResponse p: products){

                List<String> lowercaseTags = new ArrayList<>();

                for(String t: p.getTags()){
                    lowercaseTags.add(t.toLowerCase());
                }

                if (lowercaseTags.contains(tag.toLowerCase())) {
                    filtered.add(p);
                }
            }
            return filtered;

        }
    }

}
