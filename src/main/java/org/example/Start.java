package org.example;


public class Start {

        public static void main(String[] args) {
            System.out.println("Client by id is "
                    + new ClientCrudService().getClient(null).toString());
            System.out.println("Planet by id is "
                    + new PlanetCrudService().getPlanet("EARTH").toString());
        }
}
