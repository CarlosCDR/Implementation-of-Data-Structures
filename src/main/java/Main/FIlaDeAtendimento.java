package Main;

import dataStructure.Queue;
import java.sql.SQLOutput;
import java.util.Random;

public class FIlaDeAtendimento {

    public static void main(String[] args) {

        int n = 5;
        var random = new Random();
        int cliente = random.nextInt(101);
        Queue queue = new Queue(cliente);
        System.out.println("Chegou o cliente: " + cliente);
        //simula chegada dos cliente
        for (int i = 2; i <= n; i++) {
            cliente = random.nextInt(101);
            System.out.println("Chegou o cliente: " + cliente);
            queue.enqueue(cliente);
        }
        //Atendimento dos cliente
        var node = queue.dequeue();{
            while (node != null) {
                System.out.println("Cliente Atendido: " + node.getValue());
                node = queue.dequeue();
            }

        }
    }

}
