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
import pl.coderslab.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/add")
    public String addUser() {
        return "addUserjsp";
    }
//    http://localhost:8080/user/add


    @Transactional
    @PostMapping("/add")
    public String addUser( @ModelAttribute User user, Model model) {
        try {
            User addedUser = userService.addUser(user);
            model.addAttribute("firstName", addedUser.getFirstName());
            model.addAttribute("lastName", addedUser.getLastName());
            model.addAttribute("email", addedUser.getEmail());
            model.addAttribute("userId", addedUser.getId());
            return "AddNewUserCar";
        } catch (IllegalArgumentException e) {
            return "errorPage";
        }
    }



    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "UserList";
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }


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


    @GetMapping("/{userId}/cars")
    public String showCars(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        List<Car> cars = user.getCarList();
        model.addAttribute("cars", cars);
        model.addAttribute("userId", userId);
        return "CarList";
    }







}
