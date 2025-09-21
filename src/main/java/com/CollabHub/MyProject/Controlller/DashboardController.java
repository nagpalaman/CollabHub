package com.CollabHub.MyProject.Controlller;

import com.CollabHub.MyProject.Service.AuthService;
import com.CollabHub.MyProject.Service.BrandService;
import com.CollabHub.MyProject.Service.CampaignService;
import com.CollabHub.MyProject.Service.InfluencerService;
import com.CollabHub.MyProject.model.Influencer;
import com.CollabHub.MyProject.model.Role;
import com.CollabHub.MyProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private AuthService authService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private InfluencerService influencerService;
    @Autowired
    private CampaignService campaignService;

    @GetMapping("/dashboard")
    public String dashboard(){
        User currUser = authService.getCurrentUser();

        if(currUser==null){
            return "redirect:/login";
        }

        if(currUser.getRole()== Role.BRAND){
            return "redirect:/brand/dashboard";
        } else if (currUser.getRole()==Role.INFLUENCER) {
            return "redirect:/influencer/dashboard";
        }

        return "redirect:/";
    }

    
}
