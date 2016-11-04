package com.rasulov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "property_location")
@NoArgsConstructor
@AllArgsConstructor
@Builder
//    @XmlAccessorType(XmlAccessType.FIELD)
public class PropertyLocation {

    @GeneratedValue
    @Id
    @Column(name = "location_id")
    private Long locationId;

    @Column(nullable = false,length = 50,name = "region")
    @XmlElement(name = "Region")
    private String region;

    @Column(nullable = false,length = 50,name = "district")
    @XmlElement(name = "District")
    private String district;

    @Column(nullable = false,length = 50,name = "locality_name")
    @XmlElement(name = "Locality-name")
    private String localityName;

    @Column(length = 50,name = "sub_locality_name")
    @XmlElement(name = "Sub-locality-name")
    private String subLocalityName;

    @Column(nullable = false,length = 50,name = "street_address")
    @XmlElement(name = "Street-address")
    private String streetAddress;

    @Column(length = 20,name = "building_number")
    @XmlElement(name = "Street-address")
    private String buildingNumber;

    @ManyToMany(mappedBy = "propertyLocations")
    private Set<Property> properties = new HashSet<Property>();

    @Override
    public String toString() {
        return "PropertyLocation{" +
                "locationId=" + locationId +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", localityName='" + localityName + '\'' +
                ", subLocalityName='" + subLocalityName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", properties=" + properties +
                '}';
    }
}
