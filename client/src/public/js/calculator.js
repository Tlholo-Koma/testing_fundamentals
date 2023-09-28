let expression = '';
let display = document.getElementById('calculator-display');

document.getElementById('calculator-form').addEventListener('click', async function(event) {
    const buttonValue = event.target.value;

    if (buttonValue === '=') {
        
        try {
            let data = JSON.stringify({
                "expression": expression
            });
            const response = await (await apiPost('/calculator/calculate', data)).json();
            const result = response['result']; // replace with api call :)
            display.textContent = result;
            expression = result.toString();
        } catch (error) {
            console.log(error);
            display.textContent = 'Error';
            expression = '';
        }
    } else if (buttonValue === 'C') {
        expression = '';
        display.textContent = '0';
    } else {
        expression += buttonValue;
        display.textContent = expression;
    }
});


async function makeRequest() {
    return await (await apiPost('/calculator/calculate')).json();
}