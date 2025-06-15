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

        for (int i = 0; i < agentCount; i++) {
            System.out.print("Please enter the first name of agent " + (i + 1) + ": ");
            String firstName = scanner.next();
            System.out.print("Please enter the last name of agent " + (i + 1) + ": ");
            String lastName = scanner.next();
            Agent agent = new Agent(firstName, lastName);
            agents[i] = agent;
        }

        introduceLikeSecretAgents(agents);
    }

    private void introduceLikeSecretAgents(Agent[] agents) {
        for (Agent agent : agents) {
            System.out.println(
                    "My name is " + agent.getLastName() + ", " + agent.getFirstName() + " " + agent.getLastName());
        }
    }
}
