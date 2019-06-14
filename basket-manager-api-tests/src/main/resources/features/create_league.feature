#language: fr
#encoding: utf-8

Fonctionnalité: Création d'un compte basketmanager

  Contexte:

  Plan du Scénario: Création d'un compte basketmanager
    Soit un utilisateur connecté
    Et souhaitant créer une ligue "<ligue>" de "<nbEquipe>" équipes
    Quand la ressource pour créer une league est appelée
    Alors le service renvoie un code 201
    Et le lien vers la resource league est dans les headers Location
    Exemples:
      | ligue     | nbEquipe |
      | NBA       | 5        |
      | Euroligue | 10       |
