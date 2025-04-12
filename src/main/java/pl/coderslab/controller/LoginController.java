package pl.coderslab.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;
import pl.coderslab.entity.Car;

import java.util.List;

@Controller
@AllArgsConstructor
public class LoginController {
    private final UserService userService;


    @GetMapping("/addUser")
    public String addUser() {
        return "addForms/addNewUser";
    }

    @Transactional
    @PostMapping("/addUser")
    public String addNewUser( @ModelAttribute User user) {
        try {
            userService.addUser(user);
            return "redirect:/start";
        } catch (IllegalArgumentException e) {
            return "errorPages/errorPageEmail";
        }
    }



    @GetMapping("/start")
    public String loginPage(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return "listPages/CarList";
        }
        return "login/log";
    }

    @PostMapping("/user/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
        User user = userService.getUserByEmail(email);
        Long userId = user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String userEmail = user.getEmail();
        List<Car> cars = user.getCarList();

        if (user != null && userService.checkPassword(user, password)) {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("userId", userId);
            request.getSession().setAttribute("firstName", firstName);
            request.getSession().setAttribute("lastName", lastName);
            request.getSession().setAttribute("email", userEmail);
            request.getSession().setAttribute("cars", cars);
            return "redirect:/user/cars/" + userId;
        } else {
            return "login/log";
        }
    }

    @GetMapping("/failure")
    public String loginFailure() {
        return "errorPages/errorPageEmail";
    }

//    @GetMapping("/user/logout")
//    public String logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//        return "redirect:/start";
//    }



}
