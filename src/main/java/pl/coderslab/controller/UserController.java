package pl.coderslab.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.CarInfoDTO;
import pl.coderslab.entity.Car;
import pl.coderslab.entity.FuelExpense;
import pl.coderslab.entity.User;
import pl.coderslab.service.CarService;
import pl.coderslab.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final CarService carService;


    @GetMapping("/add")
    public String addUser() {
        return "addUser";
    }
//    http://localhost:8080/user/add


    @Transactional
    @PostMapping("/add")
    public String addUser( @ModelAttribute User user, @ModelAttribute Car car, Model model) {
        try {
            User addedUser = userService.addUser(user);
            model.addAttribute("firstName", addedUser.getFirstName());
            model.addAttribute("lastName", addedUser.getLastName());
            model.addAttribute("email", addedUser.getEmail());
            model.addAttribute("userId", addedUser.getId());
            Car addedCar = carService.addCar(car);
            addedUser.getCarList().add(addedCar);
            userService.updateUserCar(addedUser);
            List<Car> cars = addedUser.getCarList();
            model.addAttribute("cars", cars);
            return "CarList";
        } catch (IllegalArgumentException e) {
            return "errorPageEmail";
        }
    }

    @Transactional
    @GetMapping("/cars/{userId}")
    public String showCars(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("userId", user.getId());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("cars", user.getCarList());
        return "CarList";
    }



    @Transactional
    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "UserList";
    }


    @Transactional
    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("email", user.getEmail());
        return "updateUser";
    }

    @Transactional
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        User updatedUser = userService.updateUser(id, user);
        return "redirect:/user/all";
    }


    @GetMapping("/info/{id}")
    public String infoPage(@PathVariable Long id, Model model) {
//        return "redirect:/user/all" + updatedUser.getEmail();
        return "infoPage";
    }


    @Transactional
    @GetMapping("/{email}")
    public ResponseEntity<Object> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        List<Car> carList = user.getCarList();
        List<CarInfoDTO> carInfoDTOList = new ArrayList<>();

        for (Car car : carList) {
            int numberOfTrips = car.getTripList().size();

            double totalFuelExpenses = car.getFuelExpenseList().stream()
                    .mapToDouble(FuelExpense::getFuelCost)
                    .sum();

            CarInfoDTO carInfoDTO = new CarInfoDTO(
                    car.getRegistrationNumber(),
                    car.getMake(),
                    car.getModel(),
                    numberOfTrips,
                    totalFuelExpenses
            );
            carInfoDTOList.add(carInfoDTO);
        }
        return ResponseEntity.ok(carInfoDTOList);
    }


//    @GetMapping("/{userId}/cars")
//    public String showCars(@PathVariable Long userId, Model model) {
//        User user = userService.getUserById(userId);
//        List<Car> cars = user.getCarList();
//        model.addAttribute("cars", cars);
//        model.addAttribute("userId", userId);
//        return "CarList";
//    }

    //DeleteMapping will not work with href in jsp file
    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        if (userId == null) {
            return "errorPage";
        }
        userService.deleteUser(userId);
        return "redirect:/user/all";
    }

    @GetMapping("/findByEmail")
    public String findByEmail(@RequestParam String enteredEmail, Model model) {
        User user = userService.getUserByEmail(enteredEmail);
        model.addAttribute("userId", user.getId());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("cars", user.getCarList());
        return "CarList";
    }







}
