package com.CollabHub.MyProject.Controlller;

import com.CollabHub.MyProject.Service.AuthService;
import com.CollabHub.MyProject.Service.BrandService;
import com.CollabHub.MyProject.Service.InfluencerService;
import com.CollabHub.MyProject.Service.UserService;
import com.CollabHub.MyProject.model.BrandProfile;
import com.CollabHub.MyProject.model.Influencer;
import com.CollabHub.MyProject.model.Role;
import com.CollabHub.MyProject.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private InfluencerService influencerService;
    @Autowired
    private AuthService authService;

    @GetMapping("/register")
    public String showRegisterationForm(Model model){
        //if already logged in redirect to dashboard
        if(authService.isAuthenticated()){
            return "redirect:/dashboard";
        }

        model.addAttribute("user",new User());
        return "register";
    }


//    @Valid -> it will validate the form details-> BindingResult - if there is some error it will put it in this object to show the user gracefully whats wrong with the data povided
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult,
                               @RequestParam String confirmPassword, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "register";
        }

        if(!user.getPassword().equals(confirmPassword)){
            redirectAttributes.addFlashAttribute("error","Passwords dont match!");
            return "redirect:/register";
        }

        if(userService.emailExists(user.getEmail())){
            redirectAttributes.addFlashAttribute("error","email already exists!");
            return "redirect:/register";
        }

        try{
            User savedUser = userService.saveUser(user);

            if(user.getRole()== Role.BRAND){
                BrandProfile brandProfile = new BrandProfile();
                brandProfile.setUser(savedUser);
                brandService.saveBrand(brandProfile);
            } else if (user.getRole()==Role.INFLUENCER) {
                Influencer influencer = new Influencer();
                influencer.setUser(savedUser);
                influencerService.saveInfluencer(influencer);
            }
            redirectAttributes.addFlashAttribute("success","Registration Successful! Please Login");
            return "redirect:/login";
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error","registration failed!, Try again");
            return "redirect:/register";
        }
    }

    //check for error string in url and its optional
    public String showLoginForm(@RequestParam(value="error",required = false)String error,
                                @RequestParam(value = "logout",required = false)String logout,
                                Model model){
          if(authService.isAuthenticated()){
              return "redirect:/dashboard";
          }

        if (error != null) {
            model.addAttribute("error", "Invalid email or password!");
        }

        if (logout != null) {
            model.addAttribute("success", "You have been logged out successfully.");
        }
        return "login";
    }


}
