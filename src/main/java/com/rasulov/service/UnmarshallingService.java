package com.rasulov.service;


import com.rasulov.model.PropertyList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

@Service
@Slf4j
public class UnmarshallingService {
    public void unmarshallingTest()throws JAXBException {
        URL resource = UnmarshallingService.class.getClassLoader().getResource("files/blagovest_all.xml");
        JAXBContext jc = JAXBContext.newInstance(PropertyList.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        log.info("Found resource {}", resource.getPath());

        PropertyList property = (PropertyList) unmarshaller.unmarshal(resource);
        log.info("Parsed property {}", property);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        System.out.println("________" + property.toString());

        marshaller.marshal(property, System.out);



    }
}
