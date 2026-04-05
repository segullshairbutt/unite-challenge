package eu.unite.address.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.unite.address.model.Address;
import eu.unite.address.model.AddressType;

@Repository
public interface AddressesRepository extends JpaRepository<Address, String> {
    
    List<Address> findByUserId(String userId);
    
    List<Address> findByType(AddressType type);
    
    List<Address> findByUserIdAndType(String userId, AddressType type);
}
