import { act, render } from '@testing-library/react';
import Encounters from './Encounters.js';

const data = [
    {
        "id": 1,
        "brief": "brief brief",
        "details": "this is a test.",
        "dateTime": "14-may-2021 11:35AM",
        "imageUrl": "http://example.com/path/to/an/image.png"
    },
    {
        "id": 2,
        "brief": "brief brief",
        "details": "this is a test.",
        "dateTime": "14-may-2021 11:35AM",
        "imageUrl": "http://example.com/path/to/an/image.png"
    },
    {
        "id": 3,
        "brief": "brief brief",
        "details": "this is a test.",
        "dateTime": "14-may-2021 11:35AM",
        "imageUrl": "http://example.com/path/to/an/image.png"
    }
];

test("should render 3 encounters", async () => {

    jest.spyOn(global, "fetch").mockImplementation(() =>
        Promise.resolve({
            json: () => Promise.resolve(data)
        }));

    await act(async () => {
        render(<Encounters />);
    });

    const cards = document.querySelectorAll('div[class="card"]');
    expect(cards.length).toBe(3);
});