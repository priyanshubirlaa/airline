# Airline Booking System

## Overview
This is a microservices-based airline booking system that allows users to:
- **Check-in**
- **Select a seat**
- **Add baggage**
- **Add seat & baggage to the cart**
- **Make a payment**
- **Receive a check-in confirmation**

The backend is built with **Spring Boot (Java)**, and the frontend is built with **React.js**.

---

## Technologies Used
### Backend
- Spring Boot
- Spring Data JPA
- MySQL (Database)
- Spring Security (for authentication)
- RESTful APIs

### Frontend
- React.js
- Axios (for API calls)
- React Router (for navigation)
- Bootstrap (for UI styling)

---

## Backend Setup (Spring Boot)
1. Clone the repository:
   ```sh
   git clone https://github.com/priyanshubirlaa/airline
   cd airline-booking-system
   ```
2. Import the project into an IDE (e.g., IntelliJ, Eclipse).
3. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/airline_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Build and run the Spring Boot services:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

### Microservices & Endpoints
| Service  | Port  | Endpoints |
|----------|------|----------|
| Check-in Service | `8081` | `/checkin/{userId}` |
| Seat Selection | `8084` | `/seat/map`, `/seat/select/{seatNumber}` |
| Cart Service | `8080` | `/cart/add?userId={id}&seatNumber={seat}&baggageCount={count}` |
| Payment Service | `8083` | `/payment/pay?userId={id}&amount={amount}` |

---

## Frontend Setup (React)
1. Navigate to the frontend directory:
   ```sh
   cd airline-frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the development server:
   ```sh
   npm start
   ```

### React Pages
| Page | Path | Functionality |
|------|------|--------------|
| Home | `/` | Landing page |
| Seat Selection | `/seat-selection` | Displays available seats, allows seat selection |
| Cart | `/cart` | Allows users to add seat & baggage to cart |
| Payment | `/payment` | Handles payment transactions |
| Confirmation | `/confirmation` | Displays check-in confirmation |

---

## Key Features & Restrictions
- **A user cannot check in twice**
- **A user cannot select a booked seat**
- **Cannot pay twice for the same booking**
- **Prevents duplicate seat selections**

---

## Future Improvements
- Implement JWT authentication for security.
- Add email notifications after booking confirmation.
- Enhance UI with better seat selection visualization.

---

## Contributors
- **Your Name** - [GitHub](https://github.com/your-profile)

---

## License
This project is licensed under the MIT License.

