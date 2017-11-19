//package com.thesis.project.security;
//
//import com.thesis.project.model.Person;
//import com.thesis.project.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class MyAuthenticationProvider implements AuthenticationProvider{
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        Optional<Person> optionalUserModel = authorizedUser(username,password);
//        if(optionalUserModel.isPresent()) {
//            Authentication auth = new UsernamePasswordAuthenticationToken(username, password, AuthorityUtils.NO_AUTHORITIES);
//            return auth;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//
//    private Optional<Person> authorizedUser(String username, String password) {
//        Optional<Person> optionalUserModel = Optional.ofNullable(userRepository.findByUsername(username));
//        if (optionalUserModel.isPresent()) {
//            if (optionalUserModel.get().getPassword().equals(password)) {
//                return optionalUserModel;
//            }
//        }
//        return Optional.empty();
//    }
//}
