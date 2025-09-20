package com.CollabHub.MyProject.Controlller;

import com.CollabHub.MyProject.Service.CampaignService;
import com.CollabHub.MyProject.model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CampaignService campaignService;

    @GetMapping("/")
    public String home(Model model){
        List<Campaign> campaignList = campaignService.getActiveCampaigns();
        model.addAttribute("campaigns",campaignList);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
