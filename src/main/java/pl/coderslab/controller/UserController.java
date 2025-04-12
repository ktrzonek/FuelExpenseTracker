package pl.coderslab.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;


@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @Transactional
    @GetMapping("/cars/{userId}")
    public String showCars(@PathVariable Long userId, HttpServletRequest request) {
        User user = userService.getUserById(userId);
        request.getSession().setAttribute("email", user.getEmail());
        request.getSession().setAttribute("userId", user.getId());
        request.getSession().setAttribute("firstName", user.getFirstName());
        request.getSession().setAttribute("lastName", user.getLastName());
        request.getSession().setAttribute("cars", user.getCarList());

        return "listPages/CarList";
    }


    @Transactional
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return "updateForms/updateUser";
    }

    @Transactional
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        User updatedUser = userService.updateUser(id, user);
        return "redirect:/user/cars/" + updatedUser.getId();
    }

    //DeleteMapping will not work with href in jsp file
    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        if (userId == null) {
            return "errorPages/errorPage";
        }
        userService.deleteUser(userId);
        return "redirect:/user/all";
    }
}
