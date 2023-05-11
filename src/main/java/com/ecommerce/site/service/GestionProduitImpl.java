package com.ecommerce.site.service;

import com.ecommerce.site.dao.CategorieRepository;
import com.ecommerce.site.dao.ProduitRepository;
import com.ecommerce.site.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class GestionProduitImpl implements IGestionProduit{


    ProduitRepository pr;

    public GestionProduitImpl(ProduitRepository pr){
        this.pr = pr;
    }
    @Autowired
    CategorieRepository cr;
    @Override
    public void addProduit(Produit p) {
        pr.save(p);
    }

    @Override
    public void modifier(Produit p) {
        pr.save(p);
    }

    @Override
    public void delete(int id) {
        pr.deleteById(id);
    }

    @Override
    public List<Produit> getAllProduit() {
        return pr.findAll();
    }
    @Override
    public Page<Produit> findPaginetedProduit(int pageNum, int size) {

        Pageable pageable = PageRequest.of(pageNum - 1, size);
        return  pr.findAll(pageable);
    }

    @Override
    public List<Produit> getAllProduitByCatId(int id) {
        return pr.getByCategorie(cr.findById(id).get());
    }

    @Override
    public Produit getProduitById(int id) {
        return pr.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Override
    public List<Produit> getProduitsByKeyWord(String key) {
        return pr.findByNameContains(key);
    }
}
