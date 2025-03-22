import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import CheckIn from "./components/CheckIn";
import SeatSelection from "./components/SeatSelection";
import Cart from "./components/Cart";
import Payment from "./components/Payment";
import Confirmation from "./components/Confirmation";

function App() {
  return (
    <Router>
      <div className="container mt-4">
        <h2 className="text-center">Flight Booking System</h2>
        <Routes>
          <Route path="/" element={<CheckIn />} />
          <Route path="/seats" element={<SeatSelection />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/payment" element={<Payment />} />
          <Route path="/confirmation" element={<Confirmation />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
