package eu.unite.address.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
  @Id
  private String id;
  private String userId;
  private String addressName;
  private String street;
  private String city;
  private String postalCode;
  private String region;
  private String country;
  @Enumerated(EnumType.STRING)
  private AddressType type;
}
