package org.example.web;

import org.example.dao.SupplierDao;
import org.example.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierDao supplierDao;

    @GetMapping("/all")
    public String getAllSuppliers(Model model) {
        List<Supplier> all = supplierDao.findAll();
        model.addAttribute("suppliers", all);
        return "supplier/suppliers";
    }
}
