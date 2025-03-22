import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function SeatSelection() {
  const [seats, setSeats] = useState([]);
  const [selectedSeat, setSelectedSeat] = useState("");
  const [showSeats, setShowSeats] = useState(false); // Toggle seat map visibility
  const navigate = useNavigate();

  // Fetch seat map when button is clicked
  const fetchSeatMap = async () => {
    try {
      const response = await axios.get("http://localhost:8084/seat/map");
      const uniqueSeats = response.data.reduce((acc, seat) => {
        if (!acc.find(s => s.seatNumber === seat.seatNumber)) {
          acc.push(seat);
        }
        return acc;
      }, []);
      setSeats(uniqueSeats);
      setShowSeats(true);
    } catch (error) {
      console.error("Error fetching seat map:", error);
      alert("Failed to load seat map!");
    }
  };

  // Handle seat selection confirmation
  const handleSelectSeat = async () => {
    if (!selectedSeat) {
      alert("Please select a seat before confirming.");
      return;
    }

    try {
      await axios.post(`http://localhost:8084/seat/select/${selectedSeat}`);
      alert(`Seat ${selectedSeat} selected successfully!`);
      navigate("/cart");
    } catch (error) {
      alert(error.response?.data?.message || "Seat selection failed!");
    }
  };

  return (
    <div>
      <h3>Seat Selection</h3>
      {!showSeats ? (
        <button className="btn btn-primary" onClick={fetchSeatMap}>
          Select a Seat
        </button>
      ) : (
        <>
          <select onChange={(e) => setSelectedSeat(e.target.value)} value={selectedSeat}>
            <option value="">Select a seat</option>
            {seats.map((seat) => (
              <option key={seat.id} value={seat.seatNumber} disabled={seat.booked}>
                {seat.seatNumber} {seat.booked ? "(Booked)" : ""}
              </option>
            ))}
          </select>
          <button className="btn btn-success" onClick={handleSelectSeat} disabled={!selectedSeat}>
            Confirm Seat
          </button>
        </>
      )}
    </div>
  );
}

export default SeatSelection;
