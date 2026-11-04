package net.lecnam.ecue2.revisions;

public class Exec {
    static void main() {
        Client client1 = new Client("Jean","Dupont","123456");
        Client client2 = new Client("Marie","Sylia","987654");
        Client client3 = new Client("Christine","Japot","987654");

        System.out.println(client1.toString());

        System.out.println("Client 2 = client 3 ? : " + client2.equals(client3));
    }
}
