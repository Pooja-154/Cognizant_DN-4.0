import React from "react";

const ListofPlayers = () => {
  const players = [
    { name: "Virat", score: 85 },
    { name: "Rohit", score: 95 },
    { name: "Gill", score: 45 },
    { name: "Pant", score: 65 },
    { name: "Rahul", score: 75 },
    { name: "Jadeja", score: 55 },
    { name: "Bumrah", score: 92 },
    { name: "Shami", score: 40 },
    { name: "Siraj", score: 35 },
    { name: "Kuldeep", score: 60 },
    { name: "Ashwin", score: 88 }
  ];

  const filteredPlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players with Scores</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h2>Players with Scores below 70</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
