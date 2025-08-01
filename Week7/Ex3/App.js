import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
    };

    // Binding if not using arrow functions
    this.increment = this.increment.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.handleMultipleActions = this.handleMultipleActions.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  increment() {
    this.setState(prevState => ({
      count: prevState.count + 1,
    }));
  }

  decrement = () => {
    this.setState(prevState => ({
      count: prevState.count - 1,
    }));
  };

  sayHello() {
    alert("Hello! This is a static message.");
  }

  handleMultipleActions() {
    this.increment();
    this.sayHello();
  }

  sayWelcome(message) {
    alert(message);
  }

  handleClick(event) {
    // Synthetic event example
    alert("I was clicked!");
    console.log("Synthetic Event:", event);
  }

  render() {
    return (
      <div style={{ padding: "20px", fontFamily: "Arial" }}>
        <h1>React Event Examples</h1>
        
        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.handleMultipleActions}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>

        <br /><br />

        <button onClick={() => this.sayWelcome("Welcome to React Events!")}>
          Say Welcome
        </button>

        <br /><br />

        <button onClick={this.handleClick}>OnPress</button>

        <hr />

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
