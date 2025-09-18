# Dependency Diversification with SQLRand

## 📌 Description
Ce projet est un **prototype expérimental** qui adapte la technique [SQLRand (Boyd & Keromytis, 2004)](http://www1.cs.columbia.edu/~locasto/projects/candidacy/papers/boyd2004sqlrand.pdf)  
aux interactions entre une application **Spring Boot** et ses **dépendances logicielles**.

👉 Objectif : introduire de la **diversification aléatoire** pour réduire la monoculture logicielle et renforcer la résilience face aux attaques supply chain.

## ⚙️ Fonctionnalités principales
- **Randomisation SQL (SQLRand)** :
  - Les mots-clés SQL (`SELECT`, `FROM`, `WHERE`) sont randomisés avant exécution.
  - Une validation supprime la randomisation avant envoi à la base H2.
  - Exemple de log Maven :
    ```
    Randomized SQL: SELECT_207 * FROM_207 users WHERE_207 id > 0
    Validated SQL: SELECT * FROM users WHERE id > 0
    ```

- **Diversification des dépendances JSON** :
  - Deux bibliothèques supportées : `Jackson` et `Gson`.
  - Sélection aléatoire d’un profil Maven (`jackson` ou `gson`) à chaque build.
  - `JsonService` intercepte dynamiquement la bibliothèque disponible.

## 📂 Structure du projet
dependency-diversification-demo/
│── pom.xml
│── src/
│ ├── main/java/com/example/demo/
│ │ ├── DemoApplication.java
│ │ ├── controller/HelloController.java
│ │ ├── service/JsonService.java
│ │ ├── service/DatabaseService.java
│ │ └── service/SqlRandService.java
│ └── test/java/com/example/demo/DemoApplicationTests.java


## 🚀 Installation et exécution

### 1. Cloner le projet
```
git clone https://github.com/<ton-username>/dependency-diversification-demo.git
cd dependency-diversification-demo
```
2. Lancer les tests Maven
```
mvn clean test
```
3. Lancer l’application Spring Boot
```
mvn spring-boot:run
```

Puis accéder à :

API REST : http://localhost:8080/hello

H2 Console : http://localhost:8080/h2-console

🧪 Exemple de sortie API
{
  "message": "Hello, World!",
  "timestamp": "2025-09-17T10:15:30Z"
}


La structure JSON peut varier selon la bibliothèque choisie (Jackson ou Gson).

📊 Résultats principaux

- Les deux bibliothèques JSON produisent des sorties valides.

- SQLRand randomise correctement les requêtes SQL et les valide avant exécution.

- Le surcoût en temps de build est négligeable.

- Quelques différences apparaissent dans la gestion de types complexes (dates, collections).

📄 Rapport

Le rapport complet est disponible ici :
👉 [Dependencies Diversification in Java – Rapport PDF](https://www.overleaf.com/read/brbrgwxbfnqr#d2499a)

✨ Références

Boyd, S. W., & Keromytis, A. D. (2004). SQLRand: Preventing SQL Injection Attacks. ACNS.

Larsen, P., Homescu, A., Brunthaler, S., & Franz, M. (2014). SoK: Automated software diversity. IEEE S&P.

Documentation Spring Boot: https://spring.io/projects/spring-boot
