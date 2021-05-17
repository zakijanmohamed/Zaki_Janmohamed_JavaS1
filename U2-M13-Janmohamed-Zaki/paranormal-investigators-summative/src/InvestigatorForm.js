import { useState } from 'react';

function InvestigatorForm({ investigator: initialInvestigator, notify }) {

    const [investigator, setInvestigator] = useState(initialInvestigator);
    const isAdd = initialInvestigator.id === 0;

    function handleChange(evt) {
        const clone = { ...investigator };
        clone[evt.target.name] = evt.target.value;
        setInvestigator(clone);
    }

    function handleSubmit(evt) {
        evt.preventDefault();

        const url = isAdd ? "http://localhost:8080/api/investigator" : `http://localhost:8080/api/investigator/${investigator.id}`;
        const method = isAdd ? "POST" : "PUT";
        const expectedStatus = isAdd ? 201 : 204;

        const init = {
            method,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(investigator)
        };

        fetch(url, init)
            .then(response => {
                if (response.status === expectedStatus) {
                    if (isAdd) {
                        return response.json();
                    } else {
                        return investigator;
                    }
                }
                return Promise.reject(`Didn't receive expected status: ${expectedStatus}`);
            })
            .then(result => notify({
                action: isAdd ? "add" : "edit",
                investigator: result
            }))
            .catch(error => notify({ error }));

    }

    return (
        <>
            <h1>{investigator.id > 0 ? "Edit" : "Add"} Investigator</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName"
                        className="form-control"
                        value={investigator.firstName} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="lastName">Last Name</label>
                    <textarea id="lastName" name="lastName" className="form-control"
                        value={investigator.lastName} onChange={handleChange}></textarea>
                </div>
                <div className="mb-3">
                    <button className="btn btn-primary mr-3" type="submit">Save</button>
                    <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "cancel" })}>Cancel</button>
                </div>
            </form>
        </>
    );
}

export default InvestigatorForm;