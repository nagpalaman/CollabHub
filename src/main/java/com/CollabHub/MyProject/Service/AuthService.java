package com.CollabHub.MyProject.Service;

import com.CollabHub.MyProject.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

//this is  service when user already logged or not but trying to access a protected page like dashboard, this will
// check if the user is authenticated or not

@Service
public class AuthService {
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof CustomUserPrincipal) ){
            CustomUserPrincipal principal = (CustomUserPrincipal) authentication.getPrincipal();
            return principal.getUser();
        }
        return null;
    }

    public Boolean isAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated()
                && !(authentication.getPrincipal() instanceof String);
    }

    public boolean hasRole(String role){
        User user = getCurrentUser();
        return user != null && user.getRole().name().equals(role);
    }
}
