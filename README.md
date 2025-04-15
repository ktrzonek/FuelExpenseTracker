# Fuel Expense Tracker 

A web application for managing car-related expenses, trips, and user profiles.

<br>

### Description
This application allows users to manage their car-related expenses, log trips, and view a detailed list of expenses. Users can add, update, and delete their cars, view a summary of fuel and car expenses, and keep track of trips taken. 
Additionaly, they can also add expenses related to a particular trip.

---

### Features
- **User Management**: Allows users to register, log in, and update their profiles.
- **Car Management**: Add, update, and delete cars from the user's profile.
- **Expense Tracking**: Record and manage fuel expenses and other car-related costs.
- **Trip Logging**: Log and track trips for each car, including costs associated with each trip.
- **Data Filtering**: View expenses and trips by month.
- **Total Calculation**: Automatically calculates and displays the total costs (fuel and car expenses) for a specific month or for all time.

---

### Technologies Used

- **Backend**: 
    - Java
    - Spring Boot
    - Spring MVC
    - Spring Data JPA
    - Spring Security
    - Spring Boot DevTools
    - Spring Boot Starter Web

- **Frontend**: 
    - JSP (Java Server Pages) for rendering dynamic content on the server side
    - HTML for structuring web pages
    - CSS for styling and designing the layout of the application
    - Some JavaScript snippets (e.g., `onclick` for navigation)
    - JSTL (Jakarta Standard Tag Library) for simplifying the logic within JSP pages

- **Database**: 
    - MySQL

- **Build Tools**: 
    - Maven

- **Other**: 
    - Lombok for code generation like getters/setters
    - Jakarta Servlet
    - Tomcat for embedded server
    - Jakarta JSP

---

### Screenshots

Here are some screenshots of the application:

#### Car Management Page

<img width="1724" alt="car_management_page" src="https://github.com/user-attachments/assets/3f42d6b4-d01d-4458-a21d-1005576c2896" />


#### Car Info Page

<img width="1724" alt="car_info_page" src="https://github.com/user-attachments/assets/df6060cd-ec2f-4721-b593-1a74c4a3c74f" />


#### Car Info Page - Expenses
  
<img width="1724" alt="car_info_page_expenses" src="https://github.com/user-attachments/assets/87ec362a-cedf-4f8e-88b7-d24c0bbaf9d7" />


#### Car Add Form

<img width="1724" alt="car_add" src="https://github.com/user-attachments/assets/a169e3c5-cd76-42dd-89fd-3472116c1ee9" />


#### Car Expense Add Form

<img width="1724" alt="car_expense_add" src="https://github.com/user-attachments/assets/1ea6cc73-f277-44c9-a2f9-948ff1c1df02" />


#### Trip Expenses List

<img width="1724" alt="trip_expenses_list" src="https://github.com/user-attachments/assets/caf18a97-261d-416b-91fd-7c63cd7aaf44" />


---

### Database Initialization

This project includes a `data.sql` file that contains sample data for initializing the database. It populates the database with some default user and car data to help with testing and development.
The `data.sql` file is placed in the `src/main/resources` directory of the project. You can manually execute the `data.sql` script against your database using your database management tool (e.g., MySQL).

#### Accessing the Application:

Once the application is running, open your browser and go to: `http://localhost:8080/start`

Two example accounts are created in the `data.sql` file for testing purposes. To log into the application, use the following credentials:

- **User 1**:  
  - **Login**: `a.nowak@example.com`  
  - **Password**: `testuser11`

- **User 2**:  
  - **Login**: `ak@example.com`  
  - **Password**: `testuser22` 

**Note:** Since the passwords are hashed (for security reasons), you will not be able to directly see or retrieve the plaintext passwords from the database. Given credentials are for testing purposes only.

---

### Used Templates

This project utilizes the **SB Admin 2** template, which is a free Bootstrap-based admin dashboard theme. It provides a clean and responsive design for the application. The template is used for styling and structuring the user interface, including the layout of the pages, navigation bars, and forms.

- **Template**: [SB Admin 2 by Start Bootstrap](https://startbootstrap.com/theme/sb-admin-2)
