package com.example.oenskeseddel.Controller;

import com.example.oenskeseddel.Model.Bruger;
import com.example.oenskeseddel.Model.Login;
import com.example.oenskeseddel.Service.BrugerService;
import com.example.oenskeseddel.Service.ØnskeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private BrugerService brugerService;
    private ØnskeService ønskeService;
    public HomeController(BrugerService brugerService) {
        this.brugerService = brugerService;
    }

    @GetMapping("/")
    public String index() {
        return "Home/index";
    }

    // make methods in this line.
    // metode til "opret bruger" knappen på forsiden
    @GetMapping("/createBruger")
    public String createBruger() {
        return "Home/createBruger";
    }


    // når oplysninger er indtastet
    @PostMapping("/createNewBruger")
    public String createNew(@ModelAttribute Bruger bruger) {
        brugerService.addBruger(bruger);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute Login login) {
        return "Home/login";
    }

    @GetMapping("/deleteØnske/{id}")
    public String deleteØnske(@PathVariable("id")int id){
        boolean deleted = ønskeService.deleteØnske(id);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
}

