package com.ipi.jva324.commande.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // et non @RestController sinon home.html affiche "home" (réponse REST) et non le template rendu correspondant !
//@RequestMapping(value = "/") // /accueil / home NON PREFIX TODO pas besoin SAUF pour ex. nombre ?!
public class HomeController {

    @GetMapping("/")
    //@GetMapping(value = { "", "/" })
    public String index() {
        return "index";
    }

}