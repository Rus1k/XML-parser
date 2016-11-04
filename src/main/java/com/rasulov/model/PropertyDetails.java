package com.rasulov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "property_details")
@NoArgsConstructor
@AllArgsConstructor
@Builder
//    @XmlAccessorType(XmlAccessType.FIELD)
public class PropertyDetails {


    @GeneratedValue
    @Id
    @Column(name = "details_id")
    private Long detailsId;

    @XmlElement(name = "price", required = true)
    @Column(nullable = false, name = "price")
    private BigDecimal price;

    @Column(nullable = false, length = 5, name = "currency")
    @XmlElement(name = "currency")
    private String currency;

    @Column(name = "floor_num")
    @XmlElement(name = "flor-num")
    private int floorNum;

    @Column(name = "floor_total")
    @XmlElement(name = "floors-total")
    private int floorTotal;

    @Column(name = "general_area")
    @XmlElement(name = "general-area")
    private int generalArea;

    @Column(name = "living_area")
    @XmlElement(name = "living-area")
    private int livingArea;

    @Column(name = "kitchen_area")
    @XmlElement(name = "kitchen_area")
    private int kitchenArea;

    @Column(name = "num_rooms")
    @XmlElement(name = "num_rooms")
    private int numRooms;

    @Column(name = "land_square")
    private BigDecimal landSquare;

    @Column(length = 25, name = "house_type")
    private String houseType;

    @Column(length = 200, name = "description")
    @XmlElement(name = "description")
    private String description;

    @ManyToMany(mappedBy = "propertyDetails")
    private Set<Property> properties = new HashSet<Property>();

    @Override
    public String toString() {
        return "PropertyDetails{" +
                "detailsId=" + detailsId +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", floorNum=" + floorNum +
                ", floorTotal=" + floorTotal +
                ", generalArea=" + generalArea +
                ", livingArea=" + livingArea +
                ", kitchenArea=" + kitchenArea +
                ", numRooms=" + numRooms +
                ", landSquare=" + landSquare +
                ", houseType='" + houseType + '\'' +
                ", description='" + description + '\'' +
                ", properties=" + properties +
                '}';
    }
}
