package gencoders.e_tech_store_app.address;

import gencoders.e_tech_store_app.user.User;
import gencoders.e_tech_store_app.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;


    public Address createAddress(AddressDto dto) {
        User user  = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = new Address();
       address.setUser(user);
       address.setStreet(dto.getStreet());
       address.setCity(dto.getCity());
       address.setState(dto.getState());
       address.setZipCode(dto.getZipCode());
       address.setCountry(dto.getCountry());
       address.setPhone(dto.getPhone());
      return addressRepository.save(address);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public Address updateAddress(Long id, AddressDto dto) {

        User user  = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        address.setUser(user);
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());
        address.setCountry(dto.getCountry());
        address.setPhone(dto.getPhone());
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
