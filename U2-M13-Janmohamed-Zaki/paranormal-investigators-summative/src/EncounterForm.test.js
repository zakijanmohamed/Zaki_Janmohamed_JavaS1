import { render } from '@testing-library/react';
import EncounterForm from './EncounterForm.js';

test("should pre populate element", () => {


    const initial = {
        "id": 1,
        "brief": "brief brief",
        "details": "this is a test.",
        "dateTime": "14-may-2021 11:35AM",
        "imageUrl": "http://example.com/path/to/an/image.png"
    };

    render(<EncounterForm encounter={initial}  />);
    const details = document.getElementById("dateTime");
    

    expect(details.value).toBe(initial.dateTime);

});

