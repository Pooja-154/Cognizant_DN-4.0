import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: "",
      euros: "",
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({
      rupees: event.target.value,
    });
  }

  handleSubmit(event) {
    event.preventDefault(); // prevent page reload
    const rupees = parseFloat(this.state.rupees);
    const euroRate = 0.011; // Example conversion rate
    if (!isNaN(rupees)) {
      this.setState({
        euros: (rupees * euroRate).toFixed(2),
      });
    } else {
      alert("Enter a valid amount");
    }
  }

  render() {
    return (
      <div>
        <h2>Currency Convertor (INR to EUR)</h2>
        <form onSubmit={this.handleSubmit}>
          <input
            type="number"
            value={this.state.rupees}
            onChange={this.handleChange}
            placeholder="Enter amount in ₹"
          />
          <button type="submit">Convert</button>
        </form>
        {this.state.euros && (
          <p>Equivalent in Euros: €{this.state.euros}</p>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
