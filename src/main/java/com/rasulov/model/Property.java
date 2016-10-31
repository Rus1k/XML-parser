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
@Table(name = "property")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property {

    @GeneratedValue
    @Id
    @Column(nullable = false, name = "property_listing_id")
    private Long propertyListingId;

    @Column(length = 25, nullable = false, name = "property_type")
    private String propertyType;

    @Column(length = 25, nullable = false, name = "property_status")
    private String propertyStatus;

    @Column(length = 25, nullable = false, name = "listing_type")
    private String listingType;

    @Column(name = "listing_agent_id")
    private int listingAgentId;

    @Column(nullable = false, name = "location_id")
    private int locationId;

    @Column(nullable = false, name = "details_id")
    private int detailsId;

    @Column(name = "property_images")
    private int images;

    @Column(name = "property_videos")
    private int videos;

    @ManyToMany
    @JoinTable(name = "property_to_details",
            joinColumns = {@JoinColumn(name = "property_listing_id")},
            inverseJoinColumns = {@JoinColumn(name = "details_id")})
    private Set<PropertyDetails> propertyDetails = new HashSet<PropertyDetails>();

    @ManyToMany
    @JoinTable(name = "property_to_location",
            joinColumns = {@JoinColumn(name = "property_listing_id")},
            inverseJoinColumns = {@JoinColumn(name = "location_id")})
    private Set<PropertyLocation> propertyLocations = new HashSet<PropertyLocation>();

}
