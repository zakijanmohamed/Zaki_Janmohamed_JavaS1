
function GameTable({ game, notify, userRole, addToCart }) {



  function handleDelete() {
    fetch(`http://localhost:8080/game/${game.id}`, { method: "DELETE" })
      .then(() => notify({ action: "delete", game }))
      .catch(error => notify({ action: "delete", error }));
  }




  function createQuantityOptions(max) {

    const returnVal = []
    for (let i = 1; i <= max; i++) {
      let nextOption = <option key={i} value={i}>{i}</option>
      returnVal.push(nextOption)
    }
    return returnVal
  }

  return (


    <div className="col">
      <div className="card">
        <div className="card-header">
          {game.title}  <br></br>  $ {game.price}
          <br></br>
          {game.description}
        </div>
        <div className="card-body">
          <h5>Rated: {game.esrbRating}</h5>
          <h5>Studio: {game.studio}</h5>
          <h5>Game Id: {game.id}</h5>
          <h5>Availiblity: {game.quantity}</h5>
        </div>
        {userRole === "Admin" ? (
          <div className="card-footer d-flex justify-content-center">
            <button className="btn btn-danger mr-3" onClick={handleDelete}>Delete</button>
            <button className="btn btn-secondary" onClick={() => notify({ action: "edit-form", game })}>Edit</button>
          </div>
        ) : <div><button className="btn btn-danger mr-3" onClick={() => addToCart(game, document.querySelector(`#inlineFormCustomSelectPref-${game.id}`).value)}>Add to Cart</button>


          <select className="custom-select my-1 mr-sm-2" id={`inlineFormCustomSelectPref-${game.id}`}>
            <option selected>Select Quantity...</option>

            {createQuantityOptions(game.quantity)}

          </select>

        </div>

        }
      </div>
    </div>
  )
}


export default GameTable;

