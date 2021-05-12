/* eslint-disable no-unused-vars */
/* eslint-disable camelcase */
const api = {
  async create (
    newGame,
    endpoint = 'http://localhost:8080/game'
  ) {
    const response = await fetch(endpoint, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newGame)
    })
    return response.json()
  },

  async getALL (endpoint = 'http://localhost:8080/game') {
    const res = await fetch(endpoint)
    return res.json()
  },

  async getByStudio (studio, endpoint = 'http://localhost:8080/game/studio') {
    const res = await fetch(`${endpoint}/${studio}`)
    return res.json()
  },

  async getByRating (rating, endpoint = 'http://localhost:8080/game/rating') {
    const res = await fetch(`${endpoint}/${rating}`)
    return res.json()
  },

  async update ({
    dataUpdate,
    game_id,
    endpoint = 'http://localhost:8080/game'
  } = {}) {
    const res = await fetch(`${endpoint}/${game_id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(dataUpdate)
    })
    return res.statusText
  },

  async delete (id, endpoint = 'http://localhost:8080/game/delete') {
    const response = await fetch(`${endpoint}/${id}`, { method: 'DELETE' })
    return response.statusText
  }
}

export default api
