package ru.geekbrains.april.market.utils;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.april.market.dtos.ProductDto;
import ru.geekbrains.april.market.error_handling.ResourceNotFoundException;
import ru.geekbrains.april.market.models.Product;
import ru.geekbrains.april.market.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Cart {
    private List<ProductDto> items;
    private int sum;
    private final ProductService productService;

    @PostConstruct
    public void init() {

        items = new ArrayList<>();
        sum = 0;
    }


    public void addProductDto(Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Product doesn't exists id: " + id));
        ProductDto productDto = new ProductDto (product);
        items.add (productDto);
        sum += product.getPrice ();
    }

    public void removeProductDto(Long id) {
        for (ProductDto p:items) {
            if(p.getId ().equals (id)){
                items.remove (p);
                sum -= p.getPrice ();
            }
        }
    }

    public void clearAllProductDtos() {
        items.clear ();
        sum = 0;
    }

    public List<ProductDto> getAllItems() {
        return Collections.unmodifiableList (items);
    }

    public int getSum() {
        return sum;
    }
}
