//package pl.coderslab.service;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import pl.coderslab.entity.User;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserService userService;
//
//    public CustomUserDetailsService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userService.getUserByEmail(email);
//        if (user == null) throw new UsernameNotFoundException("User not found");
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getEmail())
//                .password(user.getPassword())
//                .roles("USER") // możesz dodać role jeśli chcesz
//                .build();
//    }
//}
//
