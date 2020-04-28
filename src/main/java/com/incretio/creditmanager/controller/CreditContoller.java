package com.incretio.creditmanager.controller;

import com.incretio.creditmanager.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
