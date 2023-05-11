package com.ecommerce.site.controller;

import com.ecommerce.site.dao.ProduitRepository;
import com.ecommerce.site.entity.Categorie;
import com.ecommerce.site.entity.Produit;
import com.ecommerce.site.entity.User;
import com.ecommerce.site.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GuestController {
    @Autowired
    IGestionProduit gestionProduit;

    @Autowired
    IGestionCategrie gestionCategrie;

    @Autowired
    private UserService userService;


    @Autowired
    private EmailSenderService emailSenderService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) throws Exception{
        return userService.registerNewUser(user);
    }


    @GetMapping("/guest/products")
    public List<Produit> getAllProduct()
    {
        return gestionProduit.getAllProduit();
    }

    @GetMapping("/guest/products/{pageNum}/{size}")
    public Page<Produit> getPaginatedProduct(@PathVariable int pageNum, @PathVariable int size)
    {
        return gestionProduit.findPaginetedProduit(pageNum, size);
    }
    @GetMapping("/guest/cherche/{mc}")
    public List<Produit> cherche(@PathVariable("mc") String mc){
        return gestionProduit.getProduitsByKeyWord(mc);
    }
    @Autowired
    ProduitRepository pr;
    @GetMapping("/guest/getProduit/{id}")
    public Produit getProduit(@PathVariable("id") int id){

//        Produit p = gestionProduit.getProduitById(id);
//        System.out.println("$$$$$$$$");
//        System.out.println(p);
        pr.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
//        if (p == null) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
        return  pr.findById(id).get();
    }

    //get Images url
    @GetMapping(path = "/guest/getImage/{imgName}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable("imgName") String imgName) throws IOException {

        File f = new File(System.getProperty("user.home"));
        Path p = Paths.get(f + "/Downloads/uploads/" + imgName);
        return Files.readAllBytes(p);
    }
    @PostMapping("/guest/sendMail/{email}")
    public void sendMail(@PathVariable("email") String email){
        emailSenderService.sendSimpleEmail(email,"URGENT!!", "Le serveur est en panne");
    }
    @GetMapping("/guest/categories")
    public List<Categorie> getAllCategories()
    {
        return gestionCategrie.getCategories();
    }
    @GetMapping("/guest/getCategorie/{id}")
    public Categorie getCategorie(@PathVariable("id") int id){
        return gestionCategrie.getCategorieById(id);
    }

    @GetMapping("/guest/geProduitByCategorie/{id}")
    public List<Produit> getProduitByCategorie(@PathVariable("id") int id){
        return gestionProduit.getAllProduitByCatId(id);
    }
    @GetMapping("/guest/chercheCat/{mc}")
    public List<Categorie> chercheCategorie(@PathVariable("mc") String mc){
        return gestionCategrie.getCategorieByKeyWord(mc);
    }

}
