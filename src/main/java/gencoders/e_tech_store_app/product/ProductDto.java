package gencoders.e_tech_store_app.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String product_Name;
    private String product_Type;
    private String description; //Product overview
    private BigDecimal price;
    private BigDecimal  discount_price;
    private int stock_quantity;
    private String brand; //Apple, samsung
    private String image_Url;
}
