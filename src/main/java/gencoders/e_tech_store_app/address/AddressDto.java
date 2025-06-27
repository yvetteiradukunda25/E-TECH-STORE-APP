package gencoders.e_tech_store_app.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long userId;
    private String street;

    private String city;

    private String state;

    private String zipCode;

    private String country;

    private String phone;
}
