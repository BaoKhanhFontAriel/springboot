import React, { useState, useEffect } from "react";

// export default class Form extends Component {
//   state = {
//     name: "",
//     surname: ""
//   };

//   handleInputChange = event => {
//     const { target } = event;
//     const { value } = target;
//     const { name } = target;

//     this.setState({
//       [name]: value
//     });
//   };

//   handleSubmit = event => {
//     event.preventDefault();
//     const { name, surname } = this.state;
//     const result = `Hi ${name} ${surname}`;
//     alert(result);
//   };

//   render() {
//     const { name, surname } = this.state;
//     return (
//       <form onSubmit={this.handleSubmit}>
//         <label>
//           Name:
//           <input
//             type="text"
//             name="name"
//             value={name}
//             onChange={this.handleInputChange}
//           />
//         </label>
//         <br />
//         <label>
//           Surname:
//           <input
//             type="text"
//             name="surname"
//             value={surname}
//             onChange={this.handleInputChange}
//           />
//         </label>
//         <br />
//         <input type="submit" value="Submit" />
//       </form>
//     );
//   }
// }

function Form() {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    alert(`Hi ${name} ${surname}`);
  };
  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input
          type="text"
          name="name"
          value={name}
          onChange={(event) => {
            setName(event.target.value);
          }}
        />
      </label>
      <br />
      <label>
        Surname:
        <input
          type="text"
          name="surname"
          value={surname}
          onChange={(event) => {
            setSurname(event.target.value);
          }}
        />
      </label>
      <br />
      <input type="submit" value="Submit" />
    </form>
  );
}

export default Form;
