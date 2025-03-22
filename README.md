# Airline Booking Microservices

This project consists of microservices for airline check-in, seat selection, baggage addition, and payment processing.

## Technologies Used
- Spring Boot (Backend)
- React (Frontend)
- MySQL (Database)
- Axios (API Calls)

## Microservices
1. **Check-in Service** (`localhost:8081/checkin/{userId}`)
2. **Seat Selection Service** (`localhost:8084/seat/map`, `localhost:8084/seat/select/{seatNumber}`)
3. **Cart Service** (`localhost:8080/cart/add?userId={userId}&seatNumber={seatNumber}&baggageCount={count}`)
4. **Payment Service** (`localhost:8083/payment/pay?userId={userId}&amount={amount}`)
5. **Check-in Confirmation** (`localhost:8082/confirmation/{userId}`)

## Setup Instructions
### Backend
1. Clone the repository: `git clone (https://github.com/priyanshubirlaa/airline)
2. Navigate to the backend project directory.
3. Start MySQL and configure database settings in `application.properties`.
4. Build and run each Spring Boot microservice individually using:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend
1. Navigate to the `react-frontend` directory.
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the React application:
   ```sh
   npm start
   ```

## Features
- Users can **check-in** and get a confirmation.
- A **seat map** is displayed, allowing users to select seats.
- Users can add **seats and baggage** to a cart before checkout.
- Payments are processed via the **Payment Service**.
- **Check-in confirmation** is displayed after payment.

## Usage
1. Open the React app in a browser (`localhost:3000`).
2. Select a seat and add baggage to the cart.
3. Proceed to payment and complete the transaction.
4. Receive a **check-in confirmation** via `localhost:8082/confirmation/{userId}`.

### Notes
- Users **cannot** check in again once checked in.
- Seats **cannot** be selected if already booked.
- Payments **cannot** be made twice for the same seat.

## API Endpoints
| Service | Endpoint |
|---------|----------|
| Check-in | `GET localhost:8081/checkin/{userId}` |
| Seat Map | `GET localhost:8084/seat/map` |
| Select Seat | `POST localhost:8084/seat/select/{seatNumber}` |
| Add to Cart | `POST localhost:8080/cart/add?userId={userId}&seatNumber={seatNumber}&baggageCount={count}` |
| Payment | `POST localhost:8083/payment/pay?userId={userId}&amount={amount}` |
| Check-in Confirmation | `GET localhost:8082/confirmation/{userId}` |

## Author
Priyanshu Birla

