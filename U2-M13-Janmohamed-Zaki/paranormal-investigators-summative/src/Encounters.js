/* eslint-disable default-case */
import { useState, useEffect } from 'react';
import EncounterCard from './EncounterCard.js';
import EncounterForm from './EncounterForm.js';

function Encounters() {

    const [encounters, setEncounters] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [scopedEncounter, setScopedEncounter] = useState({});
    const [error, setError] = useState();
    const [refresh, setRefresh] = useState(0);
    const[ investigators, setInvestigators] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/encounter")
            .then(response => response.json())
            .then(result => setEncounters(result))
            .catch(console.log);
    }, [refresh]);

    function addClick() {
        const now = new Date();
        const year = now.getFullYear();
        const month = new Intl.DateTimeFormat("en-US", { month: "short" }).format(now);
        const day = new Intl.DateTimeFormat("en-US", { day: "2-digit" }).format(now);
        const time = new Intl.DateTimeFormat("en-US", { hour: "2-digit", minute: "2-digit" })
            .format(now).replace(" ", "");
        console.log(time);
        setScopedEncounter({ id: 0, brief: "", details: "", dateTime: `${day}-${month}-${year} ${time}` });
        setShowForm(true);
    }

    function notify({ action, encounter, error, investigator }) {

        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }

        switch (action) {
            case "add":
                setEncounters([...encounters, encounter]);
                setInvestigators([...investigators, investigator])
                break;
            case "edit":
                setRefresh(refresh+1)
                break;
            case "edit-form":
                setScopedEncounter(encounter);
                setShowForm(true);
                return;
            case "delete":
                setEncounters(encounters.filter(e => e.id !== encounter.id));
                break;
        }
        setShowForm(false);
    }

    if (showForm) {
        return <EncounterForm encounter={scopedEncounter} notify={notify} />
    }

    return (
        <>
            <div className="row mt-2">
                <div className="col-8">
                    <h1>Paranormal Encounters</h1>
                </div>
                <div className="col">
                    <button className="btn btn-primary" onClick={addClick}>Add an Encounter</button>
                </div>
            </div>
            {error && <div className="alert alert-danger">{error}</div>}
            {encounters.length === 0 ? <div className="alert alert-warning">No Encounters</div>
                : (<div className="row row-cols-3">
                    {encounters.map(e => <EncounterCard key={e.id} encounter={e} notify={notify} />)}
                </div>)}
        </>
    )
}

export default Encounters;