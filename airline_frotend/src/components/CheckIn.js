import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function CheckIn() {
  const [userId, setUserId] = useState("");
  const navigate = useNavigate();

  const handleCheckIn = async () => {
    try {
      await axios.post(`http://localhost:8081/checkin/${userId}`);
      alert("Check-in successful!");
      navigate("/seats");
    } catch (error) {
      alert(error.response?.data?.message || "Check-in failed!");
    }
  };

  return (
    <div>
      <h3>Check-In</h3>
      <input type="text" placeholder="Enter User ID" onChange={(e) => setUserId(e.target.value)} />
      <button className="btn btn-primary" onClick={handleCheckIn}>Check-In</button>
    </div>
  );
}

export default CheckIn;
