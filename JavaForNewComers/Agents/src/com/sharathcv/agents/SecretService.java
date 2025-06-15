package com.sharathcv.agents;

import java.util.Scanner;

public class SecretService {
    public static void main(String[] args) {
        new SecretService().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many agents are in your team?");
        int agentCount = scanner.nextInt();

        Agent[] agents = new Agent[agentCount];

        int i = 0;
        while (i < agentCount) {
            System.out.print("Please enter the first name of agent " + (i + 1) + ": ");
            String firstName = scanner.next();
            System.out.print("Please enter the last name of agent " + (i + 1) + ": ");
            String lastName = scanner.next();
            Agent agent = new Agent(firstName, lastName);
            agents[i] = agent;
            i++;
        }

        introduceLikeSecretAgents(agents);
    }

    private void introduceLikeSecretAgents(Agent[] agents) {
        int i = 0;
        while (i < agents.length) {
            System.out.println("My name is " + agents[i].getLastName() + ", " + agents[i].getFirstName() + " "
                    + agents[i].getLastName());
            i++;
        }
    }
}
