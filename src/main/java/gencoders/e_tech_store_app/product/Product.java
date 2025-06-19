package gencoders.e_tech_store_app.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String product_Name;
    private String description; //Product overview
    private BigDecimal price;
    private String product_Type;
    private BigDecimal  discount_price;
    private int stock_quantity;
    private String brand; //Apple, samsung
    private String image_Url;

   //category_id, FK to categories
}
