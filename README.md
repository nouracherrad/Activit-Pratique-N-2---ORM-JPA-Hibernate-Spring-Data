
# 🏥 Système de Gestion des Patients - Application Spring Boot

Ce projet est une application Java Spring Boot pour la gestion des patients, des médecins, des rendez-vous et des consultations médicales. Il s’appuie sur une architecture claire en couches (entités, repository, service, contrôleur REST), illustrant comment construire une API simple mais complète avec Spring Boot.

---

## 📌 Table des matières

- [Fonctionnalités](#-fonctionnalités)
- [Architecture du projet](#-architecture-du-projet)
- [Technologies utilisées](#-technologies-utilisées)
- [Structure du projet](#-structure-du-projet)
- [Modèle de données](#-modèle-de-données)
- [Ce que j'ai réalisé](#-ce-que-jai-réalisé)
- [Installation et exécution](#-installation-et-exécution)
- [Exemples d'utilisation](#-exemples-dutilisation)
- [Auteur](#-auteur)

---

## ✅ Fonctionnalités

- Enregistrement des patients, médecins, rendez-vous et consultations
- Liaison des rendez-vous avec les patients et les médecins
- Liaison des consultations avec les rendez-vous
- Initialisation automatique des données à l'exécution
- Accès aux données via des endpoints REST simples

---

## 🧱 Architecture du projet

L’application suit une architecture en couches :

- `entities` : modèles JPA (Patient, Medecin, RendezVous, Consultation)
- `repo` : interfaces Spring Data JPA pour la communication avec la base
- `service` : couche métier (ajout de logique applicative)
- `web` : expose des endpoints REST via un contrôleur
- `app` : point d’entrée de l’application et chargement de données

---

## 🛠️ Technologies utilisées

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Lombok
- H2 Database (en mémoire)
- Spring Web
- Maven

---

## 🗂️ Structure du projet

```bash
src/
├── main/
│   ├── java/
│   │   └── org.example.patient/
│   │       ├── app/                    # Application principale
│   │       ├── entities/               # Entités JPA
│   │       ├── repo/                   # Repositories JPA
│   │       ├── service/                # Interface + implémentation métier
│   │       └── web/                    # Contrôleur REST
│   └── resources/
│       └── application.properties      # Configuration
````

---

## 🧬 Modèle de données

### Entité Patient

* Informations : nom, date de naissance, malade ou non, score
* Un patient peut avoir plusieurs rendez-vous

### Entité Médecin

* Informations : nom, email, spécialité
* Un médecin peut avoir plusieurs rendez-vous

### Entité RendezVous

* Contient la date, le statut, et est lié à un patient et un médecin
* Un rendez-vous peut avoir une consultation

### Entité Consultation

* Contient la date, un rapport médical, et est lié à un rendez-vous

---

## 💻 Ce que j'ai réalisé

### 🔹 Création des entités JPA

J’ai défini quatre classes : `Patient`, `Medecin`, `RendezVous` et `Consultation`, en utilisant :

* Les annotations JPA : `@Entity`, `@Id`, `@GeneratedValue`, `@ManyToOne`, `@OneToMany`, `@OneToOne`
* L'annotation `@Enumerated` pour le statut des rendez-vous
* Lombok : `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@Builder` pour réduire le code

---

### 🔹 Création des interfaces Repository

J’ai créé des interfaces qui étendent `JpaRepository` pour :

* Accéder facilement à la base (CRUD + requêtes personnalisées)
* Exemples :

  * `PatientRepository` avec `findByName` et `findByMalade`
  * `RendezVousRepository`, `ConsultationRepository`, etc.

---

### 🔹 Couche Service (métier)

* J’ai défini une interface `IHospitalService` et une classe d’implémentation `HospitalServiceImpl`
* Cette couche contient les méthodes métier comme :

  * `savePatient(Patient p)`
  * `saveMedecin(Medecin m)`
  * `saveRendezVous(RendezVous r)`
  * `saveConsultation(Consultation c)`
* Cela permet de centraliser la logique métier, tout en séparant les accès aux données

---

### 🔹 Initialisation des données

Dans la classe `PatientApplication.java`, j’ai utilisé `CommandLineRunner` pour :

* Ajouter automatiquement des patients et des médecins à l’exécution
* Créer un rendez-vous lié à un médecin et un patient
* Ajouter une consultation liée à ce rendez-vous
* Afficher quelques résultats dans la console pour vérification

---

### 🔹 Contrôleur REST

J’ai exposé une API REST simple dans `PatientRestController` :

```java
@RestController
@RequestMapping("/patients")
public class PatientRestController {
    private final PatientRepository patientRepository;

    public PatientRestController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Patient introuvable"));
    }
}
```

Ce contrôleur permet de consulter les patients via des requêtes HTTP `GET`.

---

## 🚀 Installation et exécution

1. **Cloner le projet :**

```bash
git clone https://github.com/votre-utilisateur/spring-patient-app.git
cd spring-patient-app
```

2. **Lancer l'application :**

```bash
./mvnw spring-boot:run
```

Ou exécuter `PatientApplication.java` dans votre IDE (IntelliJ, Eclipse...)

3. **Consulter la base H2 :**

* URL : `http://localhost:8080/h2-console`
* JDBC URL : `jdbc:h2:mem:testdb`
* User : `sa`
* Password : *(laisser vide)*

---

## 📊 Exemples d'utilisation

### ✔️ Liste des patients

```http
GET http://localhost:8080/patients
```

### ✔️ Consulter un patient par ID

```http
GET http://localhost:8080/patients/1
```

---

## 👤 Auteur

**Noura**
Étudiante en Master Systèmes Distribués et Intelligence Artificielle
📧 [noura@example.com](mailto:noura@example.com)
🔗 [Mon GitHub](https://github.com/votre-utilisateur)

```

---

Souhaites-tu que je t’aide à ajouter aussi une image de ton diagramme de classes ou des captures d’écran de ton code dans ce README ?
```
