/* eslint-disable default-case */
import { useEffect, useState } from 'react';
import GameForm from './GameForm';
import GameTable from './GameTable';

var num

function Games({ userRole, addToCart }) {

  const [games, setGames] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [ScopedGames, setScopedGames] = useState({});
  const [error, setError] = useState();
  const [filterText, setFilterText] = useState("");




  useEffect(() => {
    fetch("http://localhost:8080/game")
      .then(response => response.json())
      .then(result => setGames(result))
      .catch(console.log);
  }, []);

  function addClick() {

    setScopedGames({ id: 0, title: "", esrbRating: "", description: "", price: "", studio: "", quantity: "", });
    setShowForm(true);
  }




  function updateFilterTextStudio(evt) {
    num = 1
    setFilterText(evt.target.value)


  }
  function updateFilterTextRating(evt) {
    num = 2
    setFilterText(evt.target.value)


  }
  function updateFilterTextTitle(evt) {
    num = 3
    setFilterText(evt.target.value)


  }

  function getFilteredGames(games) {


    if (num === 1) {
      return games.filter(g => g.studio.toLowerCase().includes(filterText.toLowerCase()))
    }
    else if (num === 2) {

      return games.filter(g => g.esrbRating.toLowerCase().includes(filterText.toLowerCase()))
    }

    else if (num === 3) {
      return games.filter(g => g.title.toLowerCase().includes(filterText.toLowerCase()))

    } else {
      return games.filter(g => g.studio.toLowerCase().includes(filterText.toLowerCase()))
    }
  }

  function notify({ action, game, error }) {

    if (error) {
      setError(error);
      setShowForm(false);
      return;
    }


    switch (action) {
      case "add":
        setGames([...games, game]);
        break;
      case "edit":
        setGames(games.map(e => {
          if (e.id === game.id) {
            return game;
          }
          return e;
        }));
        break;
      case "edit-form":
        setScopedGames(game);
        setShowForm(true);
        return;
      case "delete":
        setGames(games.filter(e => e.id !== game.id));
        break;
    }
    setError(undefined)
    setShowForm(false);
  }


  if (showForm) {
    return <GameForm game={ScopedGames} notify={notify} />
  }



  return (
    <>

      <div className="row mt-2">
        <div className="col-8">
          <h1>Games</h1>

          <input type="text" placeholder="Search By Studio.." onChange={updateFilterTextStudio} ></input>

          <input type="text" placeholder="Search By Rating.." onChange={updateFilterTextRating} ></input>

          <input type="text" placeholder="Search By Title.." onChange={updateFilterTextTitle} ></input>

        </div>

        {userRole === "Admin" ? (
          <div className="col">
            <button className="btn btn-primary" onClick={addClick}>Add a game </button>
          </div>
        ) : <div className="col"> <button className="btn btn-primary" >Checkout </button></div>}
      </div>


      {error && <div className="alert alert-danger">{error}</div>}
      {games.length === 0 ? <div className="alert alert-warning">No games</div>
        : (<div className="row row-cols-3">
          {getFilteredGames(games).map(e => <GameTable key={e.id} game={e}
            notify={notify} userRole={userRole} addToCart={addToCart} />)}
        </div>)}
    </>
  )
}

export default Games;

