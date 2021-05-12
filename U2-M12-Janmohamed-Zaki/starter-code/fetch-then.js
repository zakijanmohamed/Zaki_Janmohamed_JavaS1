fetch('http://localhost:8080/game')
  .then(
    (res) => res.json()
  )
  .then((game) => {
    console.log(game)
  })
