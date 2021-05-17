import { render } from '@testing-library/react';
import InvestigatorForm from './Investigator.js';

test("should pre populate element", () => {


    const initial = {
        "id": 1,
        "firstName": "first",
        "lastName": "last"
    };

    render(<InvestigatorForm Investigator={initial}  />);

    const id = document.getByText("firstName");
    

    expect(id.value).toBe(initial.firstName);

});
