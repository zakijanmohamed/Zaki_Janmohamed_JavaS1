/* eslint-disable default-case */
import { useState, useEffect } from 'react';
import InvestigatorCard from './InvestigatorCard';
import InvestigatorForm from './InvestigatorForm';

function Investigator() {

    const [investigators, setInvestigators] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [ScopedInvestigators, setScopedInvestigators] = useState({});
    const [error, setError] = useState();

    useEffect(() => {
        fetch("http://localhost:8080/api/investigator")
            .then(response => response.json())
            .then(result => setInvestigators(result))
            .catch(console.log);
    }, []);

    function addClick() {
        
        setScopedInvestigators({ id: 0, firstName: "", lastName: "",});
        setShowForm(true);
    }

    function notify({ action, investigator, error }) {

        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }

        switch (action) {
            case "add":
                setInvestigators([...investigators, investigator]);
                break;
            case "edit":
                setInvestigators(investigators.map(e => {
                    if (e.id === investigator.id) {
                        return investigator;
                    }
                    return e;
                }));
                break;
            case "edit-form":
                setScopedInvestigators(investigator);
                setShowForm(true);
                return;
            case "delete":
                setInvestigators(investigators.filter(e => e.id !== investigator.id));
                break;
        }
        setShowForm(false);
    }

    if (showForm) {
        return <InvestigatorForm investigator={ScopedInvestigators} notify={notify} />
    }

    return (
        <>
            <div className="row mt-2">
                <div className="col-8">
                    <h1>Paranormal Investigators</h1>
                </div>
                <div className="col">
                    <button className="btn btn-primary" onClick={addClick}>Add an investigator</button>
                </div>
            </div>
            {error && <div className="alert alert-danger">{error}</div>}
            {investigators.length === 0 ? <div className="alert alert-warning">No investigators</div>
                : (<div className="row row-cols-3">
                    {investigators.map(e => <InvestigatorCard key={e.id} investigator={e} notify={notify} />)}
                </div>)}
        </>
    )
}

export default Investigator;