async function getALL () {
  const resp = await fetch('http://localhost:8080/game')
  const game = await resp.json()
  return game
}

(async () => {
  console.log(await getALL())
})()

