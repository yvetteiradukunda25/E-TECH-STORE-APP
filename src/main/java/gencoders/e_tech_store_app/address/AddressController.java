package gencoders.e_tech_store_app.address;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/create")
    public Address create(@RequestBody AddressDto dto) {
        return addressService.createAddress(dto);
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PutMapping("/update/{id}")
    public Address update(@PathVariable Long id, @RequestBody AddressDto dto) {
        return addressService.updateAddress(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
