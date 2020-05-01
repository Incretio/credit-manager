package com.incretio.creditmanager.controller;

import com.incretio.creditmanager.entity.Credit;
import com.incretio.creditmanager.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credit")
public class CreditContoller {

    private CreditService creditService;

    @Autowired
    public void setCreditService(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/list")
    public String creditList(Model model) {
        model.addAttribute("creditsList", creditService.getAllCredits());
        return "credit_list";
    }

    @PostMapping("/add")
    public String addCredit(Model model, @RequestParam("name") String name) {
        Credit credit = creditService.saveCredit(name);
        return "redirect:/credit/details/" + credit.getId();
    }

    @GetMapping("/details/{id}")
    public String addCredit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("credit", creditService.findById(id));
        return "credit_details";
    }

    @GetMapping("/delete/{id}")
    public String deleteCredit(Model model, @PathVariable("id") Long id) {
        creditService.deleteById(id);
        model.addAttribute("creditsList", creditService.getAllCredits());
        return "credit_list";
    }

    @PostMapping("/save")
    @ResponseBody
    public Credit saveCredit(Model model, @RequestBody Credit credit) {
        return creditService.saveCredit(credit);
    }

}
