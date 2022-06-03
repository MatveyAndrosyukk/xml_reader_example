package org.example;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;

/**
 * Hello world!
 */
public class XMLHotelReader {
    public static void main(String[] args) {
        File xmlFile = new File("Hotels.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
//          getting document
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

//          getting hotels
            NodeList nodeListHotels = document.getElementsByTagName("Hotel");
            List<Hotel> hotels = new ArrayList<>();

            for (int i = 0; i < nodeListHotels.getLength(); i++) {
                hotels.add(getHotel(nodeListHotels.item(i)));
            }

//          printing hotels
            printHotels(hotels);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Hotel getHotel(Node node) {
        Hotel hotel = new Hotel();
        Address address = new Address();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element hotelElement = (Element) node;
            hotel.setName(getTagValue("Name", hotelElement));
            hotel.setPrice(hotelElement.getAttribute("Price"));

            Element addressElement = (Element) hotelElement.getElementsByTagName("Address").item(0);
            address.setAddressLine(getTagValue("AddressLine", addressElement));
            address.setCity(getTagValue("City", addressElement));
            address.setCountry(getTagValue("Country", addressElement));
            address.setState(getTagValue("State", addressElement));

            hotel.setAddress(address);
        }

        return hotel;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    private static void printHotels(List<Hotel> hotels) {
        System.out.println("<Hotels>");
        for (Hotel hotel : hotels) {
            boolean isHiltonInNY = hotel.getName().contains("Hilton")
                    && (hotel.getAddress().getState().equals("New York")
                    || hotel.getAddress().getState().equals("NY"));

            if (isHiltonInNY) {
                printHotel(hotel);
            }
        }
        System.out.println("</Hotels>");
    }

    private static void printHotel(Hotel hotel) {
        Address address = hotel.getAddress();
        System.out.format("\t<Hotel Price=\"%s\">\n"
                        + "\t\t<Name>%s</Name>\n"
                        + "\t\t<Address>\n"
                        + "\t\t\t<AddressLine>%s</AddressLine>\n"
                        + "\t\t\t<City>%s</City>\n"
                        + "\t\t\t<Country>%s</Country>\n"
                        + "\t\t\t<State>%s</State>\n"
                        + "\t\t</Address>\n"
                        + "\t</Hotel>\n",
                hotel.getPrice(), hotel.getName(), address.getAddressLine(), address.getCity(), address.getCountry(), address.getState());
    }

}
