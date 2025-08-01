import React from "react";

const IndianPlayers = () => {
  const allPlayers = ["Virat", "Rohit", "Gill", "Pant", "Rahul", "Jadeja", "Bumrah", "Shami", "Siraj", "Kuldeep", "Ashwin"];

  const oddPlayers = allPlayers.filter((_, index) => index % 2 === 0);
  const evenPlayers = allPlayers.filter((_, index) => index % 2 !== 0);

  const T20players = ["Virat", "Rohit", "Gill"];
  const RanjiTrophy = ["Pujara", "Saha", "Karun Nair"];

  const allCricketers = [...T20players, ...RanjiTrophy];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        {oddPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h2>Merged List of Cricketers (T20 + Ranji)</h2>
      <ul>
        {allCricketers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
