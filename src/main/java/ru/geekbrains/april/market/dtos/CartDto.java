package ru.geekbrains.april.market.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.april.market.utils.Cart;

import javax.validation.constraints.Min;
import java.util.List;

@Data
@NoArgsConstructor
public class CartDto {
    private List<ProductDto> items;
    private int totalItems;

    @Min(value = 1, message = "Min price = 1")
    private int totalPrice;

    public CartDto(Cart cart) {
        this.items = cart.getAllItems ();
        this.totalItems = cart.getAllItems ().size();
        this.totalPrice = cart.getSum();
    }
}
