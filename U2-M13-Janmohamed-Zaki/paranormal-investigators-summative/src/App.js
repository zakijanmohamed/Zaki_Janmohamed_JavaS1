import Encounters from './Encounters.js';
import Investigator from './Investigator.js';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  NavLink,
} from "react-router-dom";
import'./App.css';

function App() {
  return (
    <main className="container">
      <Router>
        <nav className="nav">
          <NavLink to="/investigators" className="nav-link" activeClassName="active">Investigators</NavLink>
          <NavLink to="/encounters" className="nav-link" activeClassName="active">Encounters</NavLink>
        </nav>

        <Switch>
          <Route path="/investigators">
            <Investigator />
          </Route>

          <Route path="/encounters">
            <Encounters />
          </Route>
        </Switch>

      </Router >
    </main>
  );
}

export default App;
