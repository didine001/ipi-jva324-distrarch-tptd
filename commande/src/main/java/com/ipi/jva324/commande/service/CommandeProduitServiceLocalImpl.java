package com.ipi.jva324.commande.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.service.ProduitService;

import java.util.List;

/**
 * Implémentation locale du service de produits pour les commandes
 * Utilise directement le ProduitService
 */
//@Component
public class CommandeProduitServiceLocalImpl implements CommandeProduitService {

    @Autowired
    private CommandeProduitService commandeProduitService;

    public ProduitEnStock getProduit(long id) {
        return commandeProduitService.getProduit(id);
    }

/*    @Override
    public List<ProduitEnStock> getProduits() {
        return null;
    }*/
}