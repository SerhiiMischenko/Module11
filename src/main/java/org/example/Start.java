package org.example;



public class Start {

        public static void main(String[] args) {
            ClientCrudService clientCrudService = new ClientCrudService();
            System.out.println(clientCrudService.getClient(1L));
            clientCrudService.createClient("Serhii Mischenko");
            clientCrudService.updateClient(1L, "John Snow");
            clientCrudService.deleteClient(17L);
            PlanetCrudService planetCrudService = new PlanetCrudService();
            planetCrudService.createPlanet("CENTAVRA", "Centavra");
            System.out.println(planetCrudService.getPlanet(null));
            planetCrudService.updatePlanet("CENTAVRA", "AlphaCentavra");
            planetCrudService.deletePlanet("CENTAVRA");
        }
}
