let expression = '';
let display = document.getElementById('calculator-display');
let isFinal = false;

document.getElementById('calculator-form').addEventListener('click', async function(event) {
    const buttonValue = event.target.value;

    if (buttonValue === '=') {
        
        try {
            let data = JSON.stringify({
                "expression": expression
            });
            const response = await (await apiPost('/calculator/calculate', data)).json();
            const result = response['result']; // replace with api call :)
            console.log(response);
            display.textContent = result;
            expression = result.toString();
            isFinal=true;
        } catch (error) {
            console.log(error);
            display.textContent = 'Error';
            expression = '';
        }
    } else if (buttonValue === 'C') {
        expression = '';
        display.textContent = '0';
        isFinal = false;
    } else {
        if(isFinal){
            expression = buttonValue;
            display.textContent = buttonValue;
            isFinal=false;
        }
        else{
            expression += buttonValue;
            display.textContent = expression;
        }
    }
});

async function makeRequest() {
    return await (await apiPost('/calculator/calculate')).json();
}