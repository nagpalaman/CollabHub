package com.CollabHub.MyProject.Controlller;

import com.CollabHub.MyProject.Service.InfluencerService;
import com.CollabHub.MyProject.model.Influencer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InfluencerController {
    @Autowired
    private InfluencerService influencerService;

    @GetMapping("/getMyProfile/{int userId}")
    public String getMyProfile(@PathVariable int userId){
        Influencer influencer = getMyProfile(userId);
        if(influencer==null){
            return null;
        }
        return "";
    }

}
