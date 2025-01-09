# Projet Android - Lieux Remarquables

## Objectif

L'objectif de ce projet est de créer une application Android qui récupère et affiche des lieux remarquables sur une carte. L'application doit inclure les fonctionnalités suivantes :

- Récupération des données des lieux remarquables depuis l'API : https://api.npoint.io/0d8d21037d4ba542976e
- Affichage des lieux sur une carte, centrée sur Grenoble lors de l'ouverture de l'application
- Un clic sur un élément de la carte permet d'accéder à une `Activity` présentant le détail de l'élément (LIBELLE, COMMUNE, type)
- Une `Toolbar` avec un `MenuItem` permettant d'accéder à une `Activity` contenant les informations générales sur l'application
- L'application est composée de 3 `Activity`

## Fonctionnalités

1. **Récupération des données**
   - Les données des lieux remarquables sont récupérées depuis l'API : https://api.npoint.io/0d8d21037d4ba542976e

2. **Affichage sur une carte**
   - Les lieux sont affichés sur une carte Google Maps, centrée sur Grenoble lors de l'ouverture de l'application

3. **Détail des lieux**
   - Un clic sur un marqueur de la carte ouvre une `Activity` présentant le détail du lieu (LIBELLE, COMMUNE, type)

4. **Informations générales**
   - Une `Toolbar` avec un `MenuItem` permet d'accéder à une `Activity` contenant les informations générales sur l'application

## Structure de l'application

L'application est composée de 3 `Activity` :
1. `MainActivity` : Affiche la carte avec les lieux remarquables
2. `RemarkablePlaceDetailActivity` : Affiche les détails d'un lieu remarquable
3. `AboutActivity` : Affiche les informations générales sur l'application

## Pour Commencer

### Prérequis

Android Studio installé sur votre machine

- Ouvrir le projet dans Android Studio
- Démarrez Android Studio
- Sélectionnez Open an existing Android Studio project
- Choisissez le répertoire du projet cloné
- Exécuter l'application
- Cliquez sur le bouton Run dans Android Studio
- Sélectionnez un émulateur ou un appareil physique pour exécuter l'application

## Librairies Utilisées

Google Maps : Pour afficher les lieux sur une carte
Retrofit : Pour récupérer les données depuis l'API
Gson : Pour parser les données JSON

## API

Les données des lieux remarquables sont récupérées depuis l'API suivante :

URL : https://api.npoint.io/0d8d21037d4ba542976e
Explications des Données Affichées
LIBELLE : Le nom du lieu remarquable
COMMUNE : La commune où se trouve le lieu
Type : Le type de lieu (par exemple, loisir, historique, etc.)
Latitude et Longitude : Les coordonnées géographiques du lieu