import React, { Component } from "react";
import "./Navbar.css";

class Navbar extends Component {
  state = {
    username: "Taylor Swift",
  };

  render() {
    return (
      <nav id="navbar">
        <ul>
          <a href="./home">
            <li>Home</li>
          </a>
          <a href="./contact">
            <li>Contact</li>
          </a>
          <a href="./about">
            <li>About</li>
          </a>
        </ul>

        <div className="nav-details">
          <p id="username">{this.state.username}</p>
        </div>
      </nav>
    );
  }
}

export default Navbar;