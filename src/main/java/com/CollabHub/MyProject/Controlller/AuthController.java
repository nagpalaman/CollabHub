package com.CollabHub.MyProject.Controlller;

import com.CollabHub.MyProject.Service.BrandService;
import com.CollabHub.MyProject.Service.InfluencerService;
import com.CollabHub.MyProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private InfluencerService influencerService;


}
