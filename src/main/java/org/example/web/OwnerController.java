package org.example.web;

import org.example.dao.OwnerJdbcDao;
import org.example.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/owner")
public class OwnerController {
    @Autowired
    OwnerJdbcDao ownerJdbcDao;

    @GetMapping("/all")
    public String getSuppliers(Model model) {
        List<Owner> owners = ownerJdbcDao.findAll();
        model.addAttribute("owners", owners);
        return "owner/owners";
    }

    @GetMapping("/add")
    public String addOwner() {
        return "owner/add-owner";
    }

    @PostMapping("/save")
    public String saveOwner(@ModelAttribute Owner owner) {
        ownerJdbcDao.save(owner);
        return "redirect:/owner/all";
    }

    @GetMapping("/edit/{id}")
    public String editOwner(@PathVariable Long id, @ModelAttribute Owner owner, Model model) {
        Owner ownerById = ownerJdbcDao.findOwnerById(id);
        model.addAttribute("owner", ownerById);
        return "owner/edit-owner";
    }

    @PostMapping("/update")
    public String updateOwner(@ModelAttribute Owner owner) {
        ownerJdbcDao.update(owner);
        return "redirect:/owner/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id ) {
        ownerJdbcDao.delete(id);
        return "redirect:/owner/all";
    }
}
