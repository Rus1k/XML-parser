package com.rasulov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "property_location")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyLocation {

    @GeneratedValue
    @Id
    @Column(nullable = false,name = "location_id")
    private Long locationId;

    @Column(nullable = false,length = 50,name = "region")
    private String region;

    @Column(nullable = false,length = 50,name = "district")
    private String district;

    @Column(nullable = false,length = 50,name = "locality_name")
    private String localityName;

    @Column(length = 50,name = "sub_locality_name")
    private String subLocalityName;

    @Column(nullable = false,length = 50,name = "street_address")
    private String streetAddress;

    @Column(length = 20,name = "building_number")
    private String buildingNumber;

    @ManyToMany(mappedBy = "propertyLocations")
    private Set<Property> properties = new HashSet<Property>();
}
