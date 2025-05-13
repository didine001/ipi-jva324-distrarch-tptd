package com.ipi.jva324.commande.service;

import com.ipi.jva324.commande.service.CommandeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ipi.jva324.stock.model.ProduitEnStock;

/**
 * Implémentation du service de produits qui consomme les produits
 * via l'API REST HAL du microservice Stock
 */

@Component
public class CommandeProduitServiceRESTHALImpl implements CommandeProduitService {

    @Value("${stock.apiUrl:http://localhost:8080/api/data-rest/produitEnStocks}")
    private String stockApiUrl;

    @Autowired
    private RestTemplate restTemplate;


    public ProduitEnStock getProduit(long id) {
        return restTemplate.getForObject(stockApiUrl + "/" + id, ProduitEnStock.class);
    }

/*    @Override
    public List<ProduitEnStock> getProduits() {
        return null;
    }*/
}