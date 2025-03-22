import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Cart() {
  const [userId, setUserId] = useState("");
  const [seatNumber, setSeatNumber] = useState("");
  const [baggageCount, setBaggageCount] = useState("");
  const navigate = useNavigate();

  const handleAddToCart = async () => {
    if (!userId || !seatNumber || !baggageCount) {
      alert("Please fill in all fields.");
      return;
    }

    try {
      await axios.post(`http://localhost:8080/cart/add?userId=${userId}&seatNumber=${seatNumber}&baggageCount=${baggageCount}`);
      alert("Added to cart!");
      navigate("/payment");
    } catch (error) {
      alert(error.response?.data?.message || "Failed to add to cart!");
    }
  };

  return (
    <div>
      <h3>Add Seat & Baggage to Cart</h3>
      <input type="text" placeholder="User ID" onChange={(e) => setUserId(e.target.value)} value={userId} />
      <input type="text" placeholder="Seat Number" onChange={(e) => setSeatNumber(e.target.value)} value={seatNumber} />
      <input type="number" placeholder="Baggage Count" onChange={(e) => setBaggageCount(e.target.value)} value={baggageCount} />
      <button className="btn btn-primary" onClick={handleAddToCart}>Add to Cart</button>
    </div>
  );
}

export default Cart;
