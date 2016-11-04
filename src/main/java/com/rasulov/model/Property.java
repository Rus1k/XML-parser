package com.rasulov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

//@Data
@Entity
@Table(name = "property")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class Property {

    @GeneratedValue
    @Id
    @Column(name = "property_listing_id")
    @XmlAttribute
    private Long propertyListingId;


    @Column(length = 25, nullable = false, name = "property_type")
    @XmlAttribute(name = "ListingID")
    private String propertyType;

    @Column(length = 25, nullable = false, name = "property_status")
    @XmlAttribute(name = "Status")
    private String propertyStatus;

    @Column(length = 25, nullable = false, name = "listing_type")
    @XmlAttribute(name = "Type")
    private String listingType;

    @Column(name = "listing_agent_id")
    private int listingAgentId;

    @Column(nullable = false, name = "location_id")
    private int locationId;


    @Column(nullable = false, name = "details_id")
    private int detailsId;

    @XmlElement(name = "images")
    @Column(name = "property_images")
    private int images;

    @XmlElement(name = "videos")
    @Column(name = "property_videos")
    private int videos;

    @ManyToMany
    @JoinTable(name = "property_to_details",
            joinColumns = {@JoinColumn(name = "property_listing_id")},
            inverseJoinColumns = {@JoinColumn(name = "details_id")})
    @XmlElement(name = "Details", required = true)
    private List<PropertyDetails> propertyDetails;

    @ManyToMany
    @JoinTable(name = "property_to_location",
            joinColumns = {@JoinColumn(name = "property_listing_id")},
            inverseJoinColumns = {@JoinColumn(name = "location_id")})
    @XmlElement(name = "Location", required = true)
    private List<PropertyLocation> propertyLocations;

    @Override
    public String toString() {
        return "PropertyList{" +
                "propertyListingId=" + propertyListingId +
                ", propertyType='" + propertyType + '\'' +
                ", propertyStatus='" + propertyStatus + '\'' +
                ", listingType='" + listingType + '\'' +
                ", listingAgentId=" + listingAgentId +
                ", locationId=" + locationId +
                ", detailsId=" + detailsId +
                ", images=" + images +
                ", videos=" + videos +
                ", propertyDetails=" + propertyDetails +
                ", propertyLocations=" + propertyLocations +
                '}';
    }
}