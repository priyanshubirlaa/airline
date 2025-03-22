import React, { useState } from "react";
import axios from "axios";

function Confirmation() {
  const [userId, setUserId] = useState("");
  const [message, setMessage] = useState("");

  const handleConfirm = async () => {
    try {
      const response = await axios.post(`http://localhost:8082/confirmation/${userId}`);
      setMessage(response.data.message);
    } catch (error) {
      alert(error.response?.data?.message || "Confirmation failed!");
    }
  };

  return (
    <div>
      <h3>Check-In Confirmation</h3>
      <input type="text" placeholder="User ID" onChange={(e) => setUserId(e.target.value)} />
      <button className="btn btn-primary" onClick={handleConfirm}>Confirm</button>
      <p>{message}</p>
    </div>
  );
}

export default Confirmation;
