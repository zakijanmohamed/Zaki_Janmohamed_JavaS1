import { useEffect, useState } from 'react';

function EncounterForm({ encounter: initialEncounter, notify }) {

    const [encounter, setEncounter] = useState(initialEncounter);
    const isAdd = initialEncounter.id === 0;

    const [investigator, setInvestigator] = useState([]);

    function getSelectValues(select) {
        var result = [];
        var options = select && select.options;
        var opt;
        for (var i=0, iLen=options.length; i<iLen; i++) {
          opt = options[i];
          if (opt.selected) {
            result.push(opt.value || opt.text);
          }
        }
        return result;
    } 

    useEffect(() =>{
        fetch("http://localhost:8080/api/investigator")
        .then(response => response.json())
        .then(result => setInvestigator(result))
        .catch(console.log);
    }, []);
    

    function handleChange(evt) {
        const clone = { ...encounter };

        if (evt.target.name === "investigators"){
            console.log(getSelectValues(evt.target))

            const getSelect = getSelectValues(evt.target);
            const selectArray =getSelect.map(i => ({id:i}))
            clone.investigators = selectArray;
        }
        else {
            clone[evt.target.name] = evt.target.value
        }

        setEncounter(clone)
    }
    

    function handleSubmit(evt) {
        evt.preventDefault();

        const url = isAdd ? "http://localhost:8080/api/encounter" : `http://localhost:8080/api/encounter/${encounter.id}`;
        const method = isAdd ? "POST" : "PUT";
        const expectedStatus = isAdd ? 201 : 204;

        const init = {
            method,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(encounter)
        };

        fetch(url, init)
            .then(response => {
                if (response.status === expectedStatus) {
                    if (isAdd) {
                        return response.json();
                    } else {
                        return encounter;
                    }
                }
                return Promise.reject(`Didn't receive expected status: ${expectedStatus}`);
            })
            .then(result => notify({
                action: isAdd ? "add" : "edit",
                encounter: result
            }))
            .catch(error => notify({ error }));

    }

    return (
        <>
            <h1>{encounter.id > 0 ? "Edit" : "Add"} Encounter</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="brief">Brief</label>
                    <input type="text" id="brief" name="brief"
                        className="form-control"
                        value={encounter.brief} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="details">Details</label>
                    <textarea id="details" name="details" className="form-control"
                        value={encounter.details} onChange={handleChange}></textarea>
                </div>
                <div className="mb-3">
                    <label htmlFor="dateTime">Date &amp; Time</label>
                    <input type="text" id="dateTime" name="dateTime"
                        className="form-control"
                        value={encounter.dateTime} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="imageUrl">Image</label>
                    <input type="url" id="imageUrl" name="imageUrl"
                        className="form-control"
                        value={encounter.imageUrl || ""} onChange={handleChange} />
                </div>

                <div class = "form-group">
                <select name ="investigators" class = "select" multiple aria-label = "multiple select" onChange={handleChange}>
                    {investigator.map(investigators => <option  name = "investigators" key = {investigators.id} value = {investigators.id}> 
                    {investigators.firstName}{investigators.lastName}</option>)}
                </select>
                </div>

                <div className="mb-3">
                    <button className="btn btn-primary mr-3" name = "hello" type="submit">Save</button>
                    <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "cancel" })}>Cancel</button>
                </div>
            </form>
        </>
    );
}

export default EncounterForm;