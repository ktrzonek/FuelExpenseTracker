package pl.coderslab.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.service.CarService;
import pl.coderslab.service.UserService;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final UserService userService;


    @GetMapping("/add")
    public String showFormAddCar(HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        return "addForms/addCar";
    }

    @Transactional
    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car, HttpServletRequest request) {
        try {
            Long userId = (Long) request.getSession().getAttribute("userId");
            Car addedCar = carService.addCar(car);
            User user = userService.getUserById(userId);
            user.getCarList().add(addedCar);
            userService.updateUserCar(user);
            return "redirect:/user/cars/" + user.getId();
        } catch (IllegalArgumentException e) {
            return "errorPages/errorPage";
        }
    }


    @GetMapping("/update/{carId}")
    public String showFormUpdateCar(@PathVariable Long carId, Model model) {
        Car car = carService.getById(carId);
        model.addAttribute("carId", car.getId());
        model.addAttribute("make", car.getMake());
        model.addAttribute("model", car.getModel());
        model.addAttribute("registrationNumber", car.getRegistrationNumber());
        model.addAttribute("fuelType", car.getFuelType());
        return "updateForms/updateCar";
    }

    @Transactional
    @PostMapping("/update/{carId}")
    public String updateCar(@PathVariable Long carId, @ModelAttribute Car car, HttpServletRequest request) {
        Car updatedCar = carService.updateCar(carId, car);
        Long userId = (Long) request.getSession().getAttribute("userId");
        return "redirect:/user/cars/" + userId;
    }

    @GetMapping("/delete/{carId}")
    public String deleteUser(@PathVariable Long carId, HttpServletRequest request) {
        carService.deleteCar(carId);
        Long userId = (Long) request.getSession().getAttribute("userId");
        return "redirect:/user/cars/" + userId;
    }


    @GetMapping("/show/{carId}")
    public String showCarInfo(@PathVariable Long carId, @RequestParam(required = false) String month, Model model) {
        Car car = carService.getById(carId);
        model.addAttribute("carId", car.getId());
        model.addAttribute("make", car.getMake());
        model.addAttribute("model", car.getModel());
        model.addAttribute("registrationNumber", car.getRegistrationNumber());
        model.addAttribute("fuelType", car.getFuelType());

        if (month != null && !month.isEmpty()) {
            YearMonth yearMonth = YearMonth.parse(month);
            //extracting the month name for the title
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
            String formattedMonth = yearMonth.format(formatter);
            model.addAttribute("selectedMonthFormatted", formattedMonth);

            List<FuelExpense> filteredFuel = car.getFuelExpenseList().stream()
                    .filter(exp -> YearMonth.from(exp.getDate()).equals(yearMonth))
                    .toList();

            List<CarExpense> filteredCar = car.getCarExpenseList().stream()
                    .filter(exp -> YearMonth.from(exp.getDate()).equals(yearMonth))
                    .toList();

            List<Trip> filteredTrips = car.getTripList().stream()
                    .filter(trip -> YearMonth.from(trip.getDate()).equals(yearMonth))
                    .toList();

            model.addAttribute("fuelExpenses", filteredFuel);
            model.addAttribute("carExpenses", filteredCar);
            model.addAttribute("trips", filteredTrips);

            model.addAttribute("totalFuelExpense", carService.getTotalFuelCostForCarByMonth(carId, yearMonth));
            model.addAttribute("totalCarExpense", carService.getTotalCarExpenseCostForCarByMonth(carId, yearMonth));

            model.addAttribute("selectedMonth", month);
        } else {
            model.addAttribute("fuelExpenses", car.getFuelExpenseList());
            model.addAttribute("carExpenses", car.getCarExpenseList());
            model.addAttribute("trips", car.getTripList());

            model.addAttribute("totalFuelExpense", carService.getTotalFuelCostForCar(carId));
            model.addAttribute("totalCarExpense", carService.getTotalCarExpenseCostForCar(carId));
        }
        return "listPages/CarInfo";
    }
}
