import React, { Component } from "react";
import Navbar from "./components/Navbar";
import User from "./components/User";

class App extends Component {
  state = {
    userA: {
      firstName: "Khanh",
      avatarUrl:
        "https://i.natgeofe.com/n/46b07b5e-1264-42e1-ae4b-8a021226e2d0/domestic-cat_thumb.jpg",
    },
    userB: {
      firstName: "My",
      avatarUrl:
        "https://media.npr.org/assets/img/2021/08/11/gettyimages-1279899488_wide-f3860ceb0ef19643c335cb34df3fa1de166e2761-s1100-c50.jpg",
    },
    clickCount: 0,
    backColor: "yellow",
    bootcamp: "Ironhack",
  };

  colorMapper = () => {
    const hexColor = "#" + Math.floor(Math.random() * 16777215).toString(16);
    return hexColor;
  };

  render() {
    return (
      <div className="App">
        <Navbar></Navbar>

        <div className="text-center">
          <h1>React - state</h1>
          <p>Count is: {this.state.clickCount}</p>
          <button onClick={this.clickHandler}> Click me </button>
        </div>

        <User
          theColor={this.state.backColor}
          firstName={this.state.userA.firstName}
          image={this.state.userA.avatarUrl}
          bootcampName={this.state.bootcamp}
        />
        <User
          firstName={this.state.userB.firstName}
          image={this.state.userB.avatarUrl}
          bootcampName={this.state.bootcamp}
        />
      </div>
    );
  }

  clickHandler = () => {
    if (this.state.clickCount % 4 === 0) {
      const newColor = this.colorMapper();
      const updatedCount = this.state.clickCount + 1;
      this.setState({
        backColor: newColor,
        clickCount: updatedCount,
      }); // Use `this.setState()` to update the state object
    } else {
      const updatedCount = this.state.clickCount + 1;
      this.setState({ clickCount: updatedCount });
    }
  };
}

export default App;
