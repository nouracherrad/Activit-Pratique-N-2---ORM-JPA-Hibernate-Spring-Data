Bien sûr Noura ! Voici **tout le contenu précédent** déjà formaté **en Markdown** prêt à être utilisé dans un fichier `README.md` :

````markdown
# 🏥 Système de Gestion des Patients - Spring Boot Application

Ce projet est une application Java Spring Boot permettant de gérer les patients, les médecins, les rendez-vous et les consultations médicales. Il illustre les bases d'une architecture RESTful utilisant Spring Data JPA, Lombok, les relations entre entités et l'initialisation de données à l'exécution.

---

## 📌 Table des matières

- [Fonctionnalités](#-fonctionnalités)
- [Architecture du projet](#-architecture-du-projet)
- [Technologies utilisées](#-technologies-utilisées)
- [Structure du projet](#-structure-du-projet)
- [Installation et exécution](#-installation-et-exécution)
- [Modèle de données](#-modèle-de-données)
  - [Entité Patient](#entité-patient)
  - [Entité Médecin](#entité-médecin)
  - [Entité RendezVous](#entité-rendezvous)
  - [Entité Consultation](#entité-consultation)
- [Exemples d'utilisation](#-exemples-dutilisation)
- [Améliorations futures](#-améliorations-futures)
- [Auteur](#-auteur)

---

## ✅ Fonctionnalités

- Création et sauvegarde de patients, médecins, rendez-vous et consultations
- Liaison entre patients, médecins et consultations via les rendez-vous
- Initialisation automatique de données dans la base à l'exécution
- Requête et filtrage via les méthodes JPA (ex : `findByName`, `findByMalade`)
- API REST de base pour consulter les patients

---

## 🧱 Architecture du projet

L'application est basée sur une architecture en couches :

- `entities` : contient les classes JPA représentant les tables de la base de données.
- `repo` : interfaces JPA (DAO) qui permettent la manipulation des données.
- `service` : contient les méthodes métiers pour enregistrer les entités.
- `web` : API REST (contrôleurs).
- `app` : point d'entrée de l'application et initialisation de données.

---

## 🛠️ Technologies utilisées

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Spring Web (REST)
- H2 Database (in-memory)
- Lombok
- Maven

---

## 🗂️ Structure du projet

```bash
src/
├── main/
│   ├── java/
│   │   └── org.example.patient/
│   │       ├── app/                    # Classe principale Spring Boot
│   │       ├── entities/               # Entités JPA (Patient, Medecin, RendezVous, Consultation)
│   │       ├── repo/                   # Interfaces JPA Repository
│   │       ├── service/                # Interface + Implémentation de IHospital
│   │       └── web/                    # Contrôleur REST
│   └── resources/
│       ├── application.properties      # Configuration Spring Boot
└── pom.xml                             # Fichier Maven
````

---

## 🧬 Modèle de données

### Entité Patient

```java
@Entity
public class Patient {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Date dateNaissance;
    private boolean malade;
    private int score;
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezVous;
}
```

### Entité Médecin

```java
@Entity
public class Medecin {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private String email;
    private String specialite;
    @OneToMany(mappedBy = "medecin")
    private Collection<RendezVous> rendezVous;
}
```

### Entité RendezVous

```java
@Entity
public class RendezVous {
    @Id
    private String id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
```

### Entité Consultation

```java
@Entity
public class Consultation {
    @Id @GeneratedValue
    private Long id;
    private Date dateConsultation;
    private String rapport;
    @OneToOne
    private RendezVous rendezVous;
}
```

---

## 🚀 Installation et exécution

1. **Cloner le dépôt :**

```bash
git clone https://github.com/votre-utilisateur/spring-patient-app.git
cd spring-patient-app
```

2. **Lancer l'application :**

   * Via IntelliJ IDEA ou Eclipse : Exécuter la classe `PatientApplication.java`.
   * Ou via terminal :

```bash
./mvnw spring-boot:run
```

3. **Accéder à H2 Console (base de données) :**

   * URL : `http://localhost:8080/h2-console`
   * JDBC URL : `jdbc:h2:mem:testdb`
   * User : `sa` | Password : *(laisser vide)*

---

## 📊 Exemples d'utilisation

Une fois l'application lancée, vous pouvez accéder à l'API REST :

### 📍 Liste de tous les patients

```
GET http://localhost:8080/patients
```

### 📍 Accès à la base en console

Voir dans la console les patients, médecins et rendez-vous créés automatiquement via `CommandLineRunner`.

---

## 📈 Améliorations futures

* Ajout d'une interface web (Thymeleaf, Angular ou React)
* Sécurité avec Spring Security
* Gestion des exceptions personnalisées
* Tests unitaires et d'intégration
* Pagination et tri des résultats REST
* Documentation Swagger de l’API

---

## 👤 Auteur

**Noura**
Master en Systèmes Distribués et Intelligence Artificielle
📧 [noura@example.com](mailto:noura@example.com)
🔗 [Mon GitHub](https://github.com/votre-utilisateur)

---

## 📝 Licence

Ce projet est sous licence **MIT**. Vous êtes libre de le réutiliser, modifier et partager à condition de mentionner l’auteur original.

```

---

Souhaitez-vous que je vous aide à remplacer certaines parties comme l’e-mail, le lien GitHub ou ajouter des captures d'écran dans ce README ?
```
