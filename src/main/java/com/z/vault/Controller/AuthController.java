package com.z.vault.Controller;

import com.z.vault.Configuration.JwtService;
import com.z.vault.Entities.Users;
import com.z.vault.Records.Creds;
import com.z.vault.Records.Response;
import com.z.vault.Repo.UsersRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    UsersRepo usersRepo;
    BCryptPasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    JwtService jwtService;
    public AuthController(UsersRepo usersRepo  , AuthenticationManager authenticationManager , JwtService jwtService){
        this.usersRepo = usersRepo;
        this.jwtService = jwtService;
        passwordEncoder = new BCryptPasswordEncoder(12);
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public Response UserRegister(
            @RequestBody Creds creds
            ){
        Users users = usersRepo.findByPhoneNo(creds.phoneNo());
        if(users != null){
            return new Response("011" , "user with phno already exits");
        }else{
            usersRepo.save(new Users(creds.phoneNo(), passwordEncoder.encode(creds.passwordHash())));
            return new Response("012","new user created");
        }
    }

    @PostMapping("/login")
    public Response UserLogin(
            @RequestBody Creds creds
    ){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (creds.phoneNo(),creds.passwordHash(),null));
        if(authentication.isAuthenticated()){
            return new Response("022", jwtService.generateToken(creds.phoneNo()));
        }
        else return new Response("021" , "login failed");
    }

}
