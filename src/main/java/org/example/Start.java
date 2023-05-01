package org.example;


import org.example.entity.Client;

public class Start {

        public static void main(String[] args) {
            ClientCrudService clientCrudService = new ClientCrudService();
            //clientCrudService.getClient(null);
            clientCrudService.createClient("Serhii Mischenko");
        }
}
