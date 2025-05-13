package com.ipi.jva324.commande.service;

import com.ipi.jva324.stock.model.ProduitEnStock;

import java.util.List;

/**
 * Interface définissant les opérations concernant les produits
 * nécessaires au service de gestion des commandes
 */
public interface CommandeProduitService {

    ProduitEnStock getProduit(long id);
}