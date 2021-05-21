import React from "react";
import {
  BrowserRouter as Router,


  NavLink, Route, Switch
} from "react-router-dom";
import './App.css';

import Games from './GameComponent/Games.js';
import { useState } from "react";



function App() {

  const [userRole, setUserRole] = useState("");
  const [shoppingCart, setShoppingCart] = useState([]);


  function addToCart(product, quantity) {
    const newItem = { product: product, quantity: quantity }
    const clone = [...shoppingCart]
    clone.push(newItem)
    setShoppingCart(clone)
  }
  console.log(shoppingCart)


  return (
    <main className="container">

      <button
        type="button"
        value="Customer"
        onClick={() => setUserRole("Customer")}
        className="btn btn-outline-primary"
      >
        Customer
      </button>
      <button
        type="button"
        value="Admin"
        onClick={() => setUserRole("Admin")}
        className="btn btn-outline-secondary"
      >
        Admin
      </button>

      {userRole === "" ? null : (
        <Router>

          <nav className="nav">

            <NavLink to="/games" className="nav-link" activeClassName="active">Games</NavLink>

            <NavLink to="/consoles" className="nav-link" activeClassName="active">Console</NavLink>

            <NavLink to="/tshirts" className="nav-link" activeClassName="active">T-Shirts</NavLink>

          </nav>


          <Switch>
            <Route path="/consoles">
              <p>Consoles</p>
            </Route>
            <Route path="/tshirts">
              <p>T-Shirts</p>
            </Route>
            <Route path="/games">
              <Games userRole={userRole} addToCart={addToCart} />
            </Route>
          </Switch>

        </Router >


      )}
    </main>
  );
}

export default App;
