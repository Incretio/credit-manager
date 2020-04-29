package com.incretio.creditmanager.controller;

import com.incretio.creditmanager.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("credit")
public class CreditContoller {

    private CreditService creditService;

    @Autowired
    public void setCreditService(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("list")
    public String creditList(Model model) {
        model.addAttribute("creditsList", creditService.getAllCredits());
        return "credit_list";
    }

    @PostMapping("add")
    public String addCredit(Model model, @RequestParam("name") String name) {
        model.addAttribute("credit", creditService.addAndGetCredit(name));
        return "credit_details";
    }

    @GetMapping("/details/{uid}")
    public String addCredit(Model model, @PathVariable("uid") Long uid) {
        model.addAttribute("credit", creditService.getByUid(uid));
        return "credit_details";
    }

    @GetMapping("/delete/{uid}")
    public String deleteCredit(Model model, @PathVariable("uid") Long uid) {
        creditService.deleteByUid(uid);
        model.addAttribute("creditsList", creditService.getAllCredits());
        return "credit_list";
    }

}
