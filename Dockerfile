# Étape 1 : Utiliser une image Java légère
FROM eclipse-temurin:17-jdk-alpine

# Étape 2 : Créer un dossier pour l'application
WORKDIR /app

# Étape 3 : Copier le fichier JAR généré (vérifie le nom dans ton dossier target)
COPY target/*.jar app.jar

# Étape 4 : Exposer le port 8080
EXPOSE 8080

# Étape 5 : Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]