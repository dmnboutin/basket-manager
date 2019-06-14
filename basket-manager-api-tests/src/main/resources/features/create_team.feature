#language: fr
#encoding: utf-8

Fonctionnalité: Création d'un compte basketmanager

  Contexte:

  Plan du Scénario: Création d'un compte basketmanager
    Soit un utilisateur connecté
    Et souhaitant créer une équipe "<equipe>" dans la ville "<ville>"
    Quand la ressource pour créer une equipe est appelée
    Alors le service renvoie un code 201
    Et le lien vers la resource team est dans les headers Location
    Exemples:
      | equipe | ville    |
      | Bulls  | Chicago  |
      | Knicks | New York |
