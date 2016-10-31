package com.rasulov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "property_details")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyDetails {


    @GeneratedValue
    @Id
    @Column(nullable = false, name = "details_id")
    private Long detailsId;

    @Column(nullable = false, name = "price")
    private BigDecimal price;

    @Column(nullable = false, length = 5, name = "currency")
    private String currency;

    @Column(name = "floor_num")
    private int floorNum;

    @Column(name = "floor_total")
    private int floorTotal;

    @Column(name = "general_area")
    private int generalArea;

    @Column(name = "living_area")
    private int livingArea;

    @Column(name = "kitchen_area")
    private int kitchenArea;

    @Column(name = "num_rooms")
    private int numRooms;

    @Column(name = "land_square")
    private BigDecimal landSquare;

    @Column(length = 25, name = "house_type")
    private String houseType;

    @Column(length = 200, name = "description")
    private String description;

    @ManyToMany(mappedBy = "propertyDetails")
    private Set<Property> properties = new HashSet<Property>();

}
