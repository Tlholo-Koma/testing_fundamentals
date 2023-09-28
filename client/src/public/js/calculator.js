let expression = '';
let display = document.getElementById('calculator-display');

document.getElementById('calculator-form').addEventListener('click', function(event) {
    const buttonValue = event.target.value;

    if (buttonValue === '=') {
        
        try {
            const result = eval(expression); // replace with api call :)
            display.textContent = result;
            expression = result.toString();
        } catch (error) {
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
