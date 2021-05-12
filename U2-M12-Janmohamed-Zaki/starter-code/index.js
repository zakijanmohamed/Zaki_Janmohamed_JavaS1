/* eslint-disable camelcase */
import Table from './components/Table.js'
import Form from './components/Form.js'
import api from './api/index.js'

const root = document.querySelector('#root')

const state = {
  data: [],
  dataSorting: {
    game_id: 'bi-sort-alpha-down',
    name: 'bi-sort-alpha-down',
    esrb_rating: 'bi-sort-alpha-down'
  }
}

function render () {
  root.innerHTML = state.data.length
    ? `
  ${Table(state)}
  ${Form()}
  `
    : '<p>No games to display!</p>'

  root.querySelector('form')?.addEventListener('submit', (event) => {
    event.preventDefault()

    const newGame = {
      ...Object.fromEntries(new FormData(event.target))
    }
    api.create(newGame).then((game) => {
      state.data = [...state.data, game]
      render()
    })
  })

  root.querySelectorAll('.btn-danger').forEach((button) => {
    button.addEventListener('click', function () {
      const id4Deletion = this.closest('tr').querySelector('td').innerText
      api.delete(id4Deletion).then(() => {
        state.data = state.data.filter(({ game_id }) => game_id !== Number(id4Deletion))
        render()
      })
    })
  })

  root.querySelectorAll('table input').forEach((input) => {
    input.addEventListener('change', function () {
      const key4Update = this.dataset.key
      const value4Update = this.value
      const id4Update = this.closest('tr').querySelector('td').innerText
      const all = this.closest('tr').querySelectorAll('input')
      api
        .update(
          {
            dataUpdate: {
              title: all[0].value,
              esrb_rating: all[1].value,
              description: all[2].value,
              price: all[3].value,
              studio: all[4].value,
              quantity: all[5].value,
              game_id: id4Update
            },
            game_id: id4Update
          }
        )
        .then(() => {
          const user2Update = state.data.find(
            ({ game_id }) => game_id === Number(id4Update)
          )
          const updatedUser = {
            ...user2Update,
            ...{ [key4Update]: value4Update }
          }
          state.data = [
            ...state.data.filter(({ id }) => id !== Number(id4Update)),
            updatedUser
          ].sort((currentItem, nextItem) => currentItem.id > nextItem.id)
          render()
        })
    })
  })

  root.querySelectorAll('table i').forEach((icon) => {
    icon.addEventListener('click', function () {
      const key4Sorting = this.dataset.key
      state.dataSorting[key4Sorting] = state.dataSorting[key4Sorting].endsWith(
        'down'
      )
        ? 'bi-sort-alpha-up'
        : 'bi-sort-alpha-down'
      state.data = state.data.sort((currentItem, nextItem) =>
        state.dataSorting[key4Sorting].endsWith('down')
          ? currentItem[key4Sorting] > nextItem[key4Sorting]
          : currentItem[key4Sorting] < nextItem[key4Sorting]
      )
      render()
    })
  })
}

(async () => {
  state.data = await api.getALL()
  console.log(state.data)
  render()
})()
