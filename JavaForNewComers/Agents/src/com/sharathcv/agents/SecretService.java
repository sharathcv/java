package com.sharathcv.agents;

import java.util.Scanner;

public class SecretService {
    public static void main(String[] args) {
        new SecretService().run();
    }

    private void run() {
        Agent[] agents = new Agent[] {
                new Agent("Top", "Agent"),
                new Agent("Super", "Agent"),
                new Agent("Secret", "Agent")
        };

        introduceLikeSecretAgents(agents);
    }

    private void introduceLikeSecretAgents(Agent[] agents) {
        for (Agent agent : agents) {
            System.out.println(
                    "My name is " + agent.getLastName() + ", " + agent.getFirstName() + " " + agent.getLastName());
        }
    }
}
