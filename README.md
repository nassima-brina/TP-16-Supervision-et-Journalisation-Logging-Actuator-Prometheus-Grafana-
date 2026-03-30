## TP 16 — Supervision, Logging et Monitoring (Actuator, Prometheus, Grafana)

**Cours** : Développement JakartaEE : Spring 
---

## Contexte

Dans un environnement de production, la supervision applicative est essentielle pour anticiper les incidents et évaluer la santé du système. Ce TP vise à doter une application Spring Boot de capacités de supervision, de journalisation et de monitoring en utilisant la stack standard du marché : **Spring Boot Actuator**, **Prometheus** et **Grafana**.

L'objectif est de passer d'une application "boîte noire" à une infrastructure observable, capable de générer des alertes proactives et des tableaux de bord dynamiques.

---

## Objectifs

- **Spring Boot Actuator** : Exposer des indicateurs de performance (uptime, état de la JVM, requêtes HTTP).
- **Logging** : Mettre en œuvre une journalisation structurée et configurable avec SLF4J.
- **Prometheus** : Configurer un collecteur centralisé pour scrapper les métriques de l'application.
- **Grafana** : Visualiser les métriques via des dashboards et configurer des alertes de latence.
- **Docker Compose** : Orchestrer la pile complète de supervision (App + Prometheus + Grafana).

---

## Technologies utilisées

- **Spring Boot 3.x** / Java 17
- **Micrometer Registry Prometheus**
- **Prometheus** (Time Series Database)
- **Grafana** (Visualisation & Alerting)
- **Docker & Docker Compose**
- **MySQL 8.0**

---

## Structure du Projet

<img width="1442" height="901" alt="image" src="https://github.com/user-attachments/assets/6143d162-2374-4c57-a8e6-ca9f9d51eb40" />


##  Activation et Configuration d'Actuator

1. Configuration des propriétés dans application.properties pour exposer les endpoints.
2. Vérification des endpoints de santé et des métriques :
   - Health Check : http://localhost:8080/actuator/health
   - Prometheus Metrics : http://localhost:8080/actuator/prometheus
- Health Check
  
![WhatsApp Image 2026-03-29 at 20 52 52](https://github.com/user-attachments/assets/01d6e4b6-80d5-422d-8c2f-f0e5628a087f)

- Infos générales

![WhatsApp Image 2026-03-29 at 20 55 32](https://github.com/user-attachments/assets/fe0b2afb-671a-4b14-96df-39aeb552c13e)

- Métriques JVM 

![WhatsApp Image 2026-03-29 at 20 57 35](https://github.com/user-attachments/assets/9b56d98c-ce97-4db6-b67c-46f26a99cd9a)


##  Configuration de Prometheus

1. Modification du fichier prometheus.yml pour ajouter la cible (target) de l'application Spring Boot.
2. Visualisation des cibles dans l'interface Prometheus (Port 9090).

![WhatsApp Image 2026-03-29 at 21 10 53](https://github.com/user-attachments/assets/d3be664b-e97c-4b9e-900b-30771ae96c4a)

![WhatsApp Image 2026-03-29 at 21 31 05](https://github.com/user-attachments/assets/a5aa2e97-71dc-4871-993b-a5ead668fc15)

![WhatsApp Image 2026-03-29 at 21 35 34](https://github.com/user-attachments/assets/9fc1d134-677a-49db-b75a-3055b55f12b3)

![WhatsApp Image 2026-03-29 at 21 35 39](https://github.com/user-attachments/assets/7eeb7bbb-e509-4f06-a04b-ea53ef477495)

![WhatsApp Image 2026-03-29 at 21 36 10](https://github.com/user-attachments/assets/fbc8b04b-18ef-4116-a913-9964fb53879c)

---

##  Visualisation avec Grafana

1. Connexion de Grafana à Prometheus en tant que Source de Données.
2. Importation du Dashboard Spring Boot Statistics (ID: 4701).

![WhatsApp Image 2026-03-29 at 21 52 42](https://github.com/user-attachments/assets/19c05ffd-591d-4ac4-81ff-c13aa45c9721)

![WhatsApp Image 2026-03-29 at 22 39 10](https://github.com/user-attachments/assets/d21c692b-d45f-48e3-8734-9e2f17394611)

---

## Alerting et Supervision Proactive

1. Configuration d'une alerte ApplicationDown dans Prometheus pour détecter les arrêts critiques.
2. Création d'une alerte de Latence > 2s directement dans Grafana avec notification par email.

![WhatsApp Image 2026-03-29 at 22 52 28](https://github.com/user-attachments/assets/1c451ab5-25e2-449e-9173-bf75353a6e9b)

![WhatsApp Image 2026-03-29 at 22 56 59](https://github.com/user-attachments/assets/88419259-1036-4a6d-b623-f12af0b60421)

![WhatsApp Image 2026-03-29 at 23 10 53](https://github.com/user-attachments/assets/80c28c0f-a090-4adb-9003-8507c95e79f3)

---

##  Conteneurisation de la Supervision (Docker Compose)

1. Construction de l'image Docker de l'application :

   docker build -t spring-monitoring:1.0 .

2. Lancement de l'infrastructure complète avec Docker Compose :

   docker-compose up -d

3. Vérification des conteneurs actifs :

   docker ps


![WhatsApp Image 2026-03-29 at 23 25 52](https://github.com/user-attachments/assets/28854097-2947-444f-8d48-b0634246b146)


---

## Conclusion

Ce TP m'a permis de maîtriser la chaîne complète d'observabilité. Grâce à l'intégration d'Actuator, Prometheus et Grafana, j'ai appris à transformer des logs et des métriques brutes en informations exploitables pour garantir la résilience d'une architecture distribuée.
