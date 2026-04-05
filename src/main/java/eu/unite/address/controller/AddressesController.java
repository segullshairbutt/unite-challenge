package eu.unite.address.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.unite.address.model.Address;
import eu.unite.address.model.AddressType;
import eu.unite.address.repository.AddressesRepository;

@RestController
@RequestMapping("/addresses")
public class AddressesController {

    private final AddressesRepository addressesRepository;

    public AddressesController(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    @GetMapping
    public List<Address> getAddresses(
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String type) {

        if (userId != null && type != null) {
            AddressType addressType = AddressType.valueOf(type);
            return addressesRepository.findByUserIdAndType(userId, addressType);
        } else if (userId != null) {
            return addressesRepository.findByUserId(userId);
        } else if (type != null) {
            AddressType addressType = AddressType.valueOf(type);
            return addressesRepository.findByType(addressType);
        } else {
            return addressesRepository.findAll();
        }
    }
}
