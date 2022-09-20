# Installation du programme test Bierotheque

## Créer la base de donnée test
Dans HeidiSQL:  
Clic droit sur la dossier à la racine de la base projet.  
Créer base de donnée : db_datadog
Vérifier sa création dans mysql :
``` SQL
SHOW DATABASES;
```

## Cloner le repo
Dans le répertoire souhaité
``` bash
git clone `https://github.com/OlivierBillant/Spring-11-Bierotheque.git
```
- Lancer IntelliJ Idea
- Ouvrir le répertoire souhaité

**Laisser les installations de dépendances se faire.**  
Du fait de la configuration préalable du projet, on devrait retrouver :  
- H2
- Spring Data
- Spring Web
- Spring Dev Tools
- Lombok

Puis lancer **Run**
- Run
- Edit configuration
- Add new configuraion
- As application
- Select Main class : .main
- Select Modules : .main
- Lancer le projet
- Se connecter localhost:8080
