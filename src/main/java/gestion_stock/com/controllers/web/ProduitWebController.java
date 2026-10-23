package gestion_stock.com.controllers.web;

import gestion_stock.com.repositories.ProduitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produits")
public class ProduitWebController {
    private final ProduitRepository produitRepository;
    public ProduitWebController(ProduitRepository produitRepository) { this.produitRepository = produitRepository; }

    @GetMapping
    public String afficherProduits(Model model) {
        model.addAttribute("produits", produitRepository.findAll());
        return "produits";
    }
}