import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore 
        name="Pooja B" 
        school="DSATM" 
        total={470} 
        goal={5} 
      />
    </div>
  );
}

export default App;
