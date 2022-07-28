import React, { Component, useState } from "react";

// export default class Counter extends Component {
//   state = { count: 0 };

//   handleIncrement = () => {
//     this.setState({
//       count: this.state.count + 1
//     });
//   };

//   handleDecrement = () => {
//     this.setState({
//       count: this.state.count - 1
//     });
//   };

//   handleReset = () => {
//     this.setState({ count: 0 });
//   };

//   render() {
//     return (
//       <div>
//         <button onClick={this.handleDecrement}>-</button>
//         <span>{this.state.count}</span>
//         <button onClick={this.handleIncrement}>+</button>
//         <br />
//         <button onClick={this.handleReset}>Reset</button>
//       </div>
//     );
//   }
// }

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <button onClick={() => setCount(count - 1)}>-</button>
      <span>{count}</span>
      <button onClick={() => setCount(count + 1)}>+</button>
      <br />
      <button onClick={() => setCount(0)}>Reset</button>
    </div>
  );
}

export default Counter;
