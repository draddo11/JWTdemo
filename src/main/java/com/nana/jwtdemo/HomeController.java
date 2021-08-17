package com.nana.jwtdemo;

import com.nana.jwtdemo.models.JwtRequest;
import com.nana.jwtdemo.models.JwtResponse;
import com.nana.jwtdemo.service.MyUserDetailsService;
import com.nana.jwtdemo.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired

    @GetMapping("/")
    public String home() {
        return "Welcome to JWT Tutorial";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials", e);
        }

        final UserDetails userDetails
                = myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }

}










//    @PostMapping("/authenticate")
//    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
//        try (authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        jwtRequest.getUsername(),
//                        jwtRequest.getPassword()
//                )
//        );
//
//    }catch (BadCredentialsException e) {
//        throw new Exception("Invalid Credential".e);
//    };
//    final UserDetails userDetails=
//            userDetailsService.loadUserByUsername(jwtRequest.getUsername());
//    final String token =
//            jwtUtility.generatedToken(userDetails);
//    return new JwtResponse(token);
//   };
//
//}