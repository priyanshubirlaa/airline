import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Payment() {
  const [userId, setUserId] = useState("");
  const [amount, setAmount] = useState("");
  const navigate = useNavigate();

  const handlePayment = async () => {
    if (!userId || !amount) {
      alert("Please enter both User ID and Amount.");
      return;
    }

    try {
      await axios.post(`http://localhost:8083/payment/pay?userId=${userId}&amount=${amount}`);
      alert("Payment successful!");
      navigate("/confirmation");
    } catch (error) {
      alert(error.response?.data?.message || "Payment failed!");
    }
  };

  return (
    <div>
      <h3>Payment</h3>
      <input type="text" placeholder="User ID" value={userId} onChange={(e) => setUserId(e.target.value)} />
      <input type="number" placeholder="Amount" value={amount} onChange={(e) => setAmount(e.target.value)} />
      <button className="btn btn-success" onClick={handlePayment}>Pay Now</button>
    </div>
  );
}

export default Payment;
