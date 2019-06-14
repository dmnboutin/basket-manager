#language: fr
#encoding: utf-8

Fonctionnalité: Création d'un compte basketmanager

  Contexte:

  Plan du Scénario: Création d'un compte basketmanager
    Soit un utilisateur souhaitant créer un compte avec le login "<login>"
    Quand la ressource pour créer un compte est appelée
    Alors le service renvoie un code 201
    Et le lien vers la resource account est dans les headers Location
    Exemples:
      | login              |
      | damaketo@gmail.com |