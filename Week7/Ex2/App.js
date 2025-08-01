import React from "react";
import "./App.css";

// Single office object (for explanation)
const office = {
  name: "Workspace One",
  rent: 55000,
  address: "123 MG Road, Bangalore",
  image: "https://via.placeholder.com/300x200?text=Office+Space"
};

// List of office spaces
const officeList = [
  {
    name: "Workspace One",
    rent: 55000,
    address: "123 MG Road, Bangalore",
    image: "https://via.placeholder.com/300x200?text=Office+1"
  },
  {
    name: "SkyView Offices",
    rent: 75000,
    address: "456 Indiranagar, Bangalore",
    image: "https://via.placeholder.com/300x200?text=Office+2"
  },
  {
    name: "EcoSpace Hub",
    rent: 60000,
    address: "789 Koramangala, Bangalore",
    image: "https://via.placeholder.com/300x200?text=Office+3"
  }
];

// Inline style for container
const containerStyle = {
  padding: "20px",
  fontFamily: "Arial"
};

// Helper function to apply rent-based color
const getRentStyle = rent => ({
  color: rent < 60000 ? "red" : "green",
  fontWeight: "bold"
});

function App() {
  return (
    <div style={containerStyle}>
      {/* Heading using JSX */}
      <h1>Office Space R
