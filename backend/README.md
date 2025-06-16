# Madrasati - Backend
Ce projet constitue le backend de l'application Madrasati. Il est développé en Java avec Spring Boot.
## Technologies utilisees

- Java 21
- Spring Boot
- MySQL
- Maven

## Lancer le projet en local
### Prérequis
- Java 21 (`sdkman` recommandé)
- MySQL (port 3306)
- Maven (`./mvnw` fourni)

### Configuration
Configurer `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/madrasati
spring.datasource.username=TON_UTILISATEUR
spring.datasource.password=TON_MDP
spring.jpa.hibernate.dll-auto=update
```

### Démarrage
```bash
./mvnw spring-boot:run
```
## Arborescence
```css
backend/
|-- src/
|-- pom.xml
|-- application.properties
|-- ...
```

## A Venir
- Authentification JWT
- Gestion Multi-établissement
- API REST sécurisée