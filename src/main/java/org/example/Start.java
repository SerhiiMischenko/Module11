package org.example;


public class Start {

        public static void main(String[] args) {
            System.out.println("Client by id is "
                    + new ClientCrudService().getClientById(4).toString());
        }
}
