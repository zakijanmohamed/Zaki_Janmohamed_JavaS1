/* eslint-disable camelcase */
function renderUserRows (game) {
  return (
    game
      .map(
        ({ game_id, title, esrb_rating, description, price, studio, quantity }) => `
  <tr>
    <td>${game_id}</td>
    <td><input value="${title}" data-key="title" /></td>
    <td><input value="${esrb_rating}" data-key="esrb_rating" /></td>
    <td><input value="${description}" data-key="description" /></td>
    <td><input value="${price}" data-key="price" /></td>
    <td><input value="${studio}" data-key="studio" /></td>
    <td><input value="${quantity}" data-key="quantity" /></td>
    <td><button type="button" class="btn btn-danger btn-sm">Delete</button></td>
    <td><button type="button" class="btn btn-success btn-sm">Update</button></td>
  </tr>
  `
      )

      // Join the mapped array back into an HTML string with line breaks
      .join('\n')
  )
}

const Table = ({ data, dataSorting }) => `
<table class="table">
  <thead>
    <tr>
    <th scope="row">ID<i class="bi ${dataSorting.game_id}data-key="id"></i></th>

      <th scope="col">Title<i class="bi ${dataSorting.title}"</th>

      <th scope="col">ESRB Rating <i class="bi ${dataSorting.esrb_rating}"</th>

      <th scope="col">Description <i class="bi ${dataSorting.description}"</th>

      <th scope="col">Price <i class="bi ${dataSorting.price}"</th>

      <th scope="col">Studio <i class="bi ${dataSorting.studio}"</th>

      <th scope="col">Quantity <i class="bi ${dataSorting.quantity}"</th>
    </tr>
  </thead>
  <tbody>
   ${renderUserRows(data)}
  </tbody>
</table>
`

export default Table
