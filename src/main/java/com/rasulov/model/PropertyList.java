package com.rasulov.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "PropertyList")
public class PropertyList {

    @XmlElement(name = "Property", required = true)
    public List<Property> propertiesp;

    public List<Property> getPropertiesp() {
        return propertiesp;
    }

    @Override
    public String toString() {
        return "PropertyList{" +
                "propertiesp=" + propertiesp +
                '}';
    }
}



