# Fournisseur - Application de Gestion des Commandes d'Achat

## Description

**Fournisseur** est une application de gestion des commandes d'achat permettant de suivre les commandes passées à des fournisseurs, gérer les produits associés et évaluer la qualité de service de chaque fournisseur. L'application permet aux utilisateurs de créer, consulter et supprimer des commandes d'achat. De plus, elle calcule automatiquement la note et la qualité de service de chaque fournisseur en fonction de l'historique des commandes.

## Fonctionnalités principales

### Gestion des fournisseurs

- Ajouter, modifier et supprimer des fournisseurs.
- Enregistrer des informations de contact et des évaluations des fournisseurs (qualité de service et note).
- Calcul automatique de la note et de la qualité de service des fournisseurs, basé sur les informations historiques des commandes.

### Gestion des commandes d'achat

- Créer des commandes d'achat avec un fournisseur et des produits associés.
- Visualiser toutes les commandes d'achat avec les détails des fournisseurs et des produits.
- Supprimer des commandes existantes.

### Gestion des lignes de commande

- Ajouter des produits spécifiques à une commande avec des informations sur la quantité et le prix unitaire.

### Calcul automatique de la qualité de service et de la note

- Chaque fournisseur se voit attribuer une note et une qualité de service automatiquement calculées à partir de l'historique des commandes.
- La note est calculée en fonction du délai moyen de livraison des commandes passées avec ce fournisseur.
- Un fournisseur avec un délai de livraison plus court et des commandes régulières aura une meilleure note et une qualité de service plus élevée.
- Les utilisateurs peuvent consulter ces informations pour évaluer et choisir le meilleur fournisseur.

## Méthode de calcul de la qualité et de la note

### Qualité de service :
- Calculée sur la base de la ponctualité des livraisons. Un fournisseur avec des délais de livraison courts et constants est jugé de meilleure qualité.

### Note du fournisseur :
- Calculée en fonction du délai moyen de livraison de toutes les commandes passées avec le fournisseur.
- Les fournisseurs ayant un délai moyen de livraison faible (plus rapide) recevront une meilleure note.
- La note varie de 1 à 5, avec **5** étant la meilleure note.

### Exemple d'évaluation :
- Un fournisseur avec un délai de livraison moyen de **3 jours** pourrait avoir une note de **4.5** et une qualité de service **excellente**.
- Un fournisseur dont le délai moyen de livraison est **15 jours** pourrait recevoir une note de **2.5** et une qualité de service **moyenne**.

## Fonctionnalités supplémentaires

- **Recherche et filtre** : Recherchez les commandes d'achat ou les fournisseurs en fonction du nom, du contact, de la qualité ou du délai de livraison.
- **Historique des achats** : Affichez l'historique des achats avec un suivi complet des produits commandés, des quantités, des prix et des délais de livraison.

## Conclusion

Le projet **Fournisseur** permet une gestion complète des commandes d'achat avec une évaluation automatique de la qualité des fournisseurs. Grâce à l'historique des commandes, la note et la qualité de service sont mises à jour automatiquement, offrant aux utilisateurs un moyen simple d'évaluer et de comparer les fournisseurs en fonction de leur performance.

Cela permet aux entreprises de prendre des décisions basées sur des données fiables et objectives concernant leurs fournisseurs, tout en améliorant la gestion des stocks et des achats.

---

## Installation

### Prérequis

- **JDK 11 ou supérieur** : Téléchargez et installez Java depuis [openjdk.java.net](https://openjdk.java.net/).
- **Maven** ou **Gradle** : Utilisez l'un de ces outils pour la gestion des dépendances et la construction du projet.
- **Base de données H2** ou **MySQL** pour le stockage des données.

### Cloner le projet

Clonez le dépôt en utilisant git :

```bash
git clone https://github.com/wassimdgh/fournisseur.git
