package com.example.kurbernetes;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class Main {
    public static void main(String[] args) {

        try (KubernetesClient k8s = new DefaultKubernetesClient()) {

            Secret secret = k8s.secrets()
                    .create(k8s.secrets()
                            .load(Main.class.getClassLoader().getResourceAsStream("secret-template.yaml"))
                            .get());

            Pod pod = k8s.pods()
                    .create(k8s.pods()
                            .load(Main.class.getClassLoader().getResourceAsStream("pod-template.yaml"))
                            .get());

        }
    }
}
