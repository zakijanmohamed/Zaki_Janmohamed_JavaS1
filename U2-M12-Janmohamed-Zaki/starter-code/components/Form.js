const Form = () => `
<form>
    <div class="mb-3">
      <label for="title" class="form-label">Title</label>
      <input type="text" class="form-control" id="title" name="title">
      <button onclick="add" id="searchByTitle"class="btn btn-primary">Search by...</button>
    </div>

    <div class="mb-3">
    <label for="ESRB Rating" class="form-label">ESRB Rating</label>
    <input type="text" class="form-control" id="ESRB Rating" name="esrb_rating" id="rating">
    <button onclick="add" class="btn btn-primary">Search by...</button>

  </div>

  <div class="mb-3">
      <label for="Description" class="form-label">Description</label>
      <input type="text" class="form-control" id="description" name="description">
    </div>

    <div class="mb-3">
      <label for="title" class="form-label">Price $</label>
      <input type="text"  class="form-control" id="Price" name="price">
    </div>

    <div class="mb-3">
      <label for="title" class="form-label">Studio</label>
      <input type="text" class="form-control" id="Studio" name="studio">
      <button onclick="add" class="btn btn-primary">Search by...</button>
    </div>

    <div class="mb-3">
      <label for="title" class="form-label">Quantity</label>
      <input type="number" class="form-control" id="Quantity" name="quantity">
    </div>

  <button onclick="add" class="btn btn-primary">Add</button>


</form>
`

export default Form
