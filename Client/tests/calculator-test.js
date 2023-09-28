const { By, Key, Builder, until } = require("selenium-webdriver");
require("chromedriver");
const assert = require("assert");
let driver;

async function testOperation(a, b, operation) {
  const buttons = await driver.findElements(By.className("calculator-button"));
  const calcDisplay = await driver.findElement(By.id("calculator-display"));
  const calcOperators = {
    addition: 3,
    subtraction: 7,
    multiplication: 11,
    division: 14,
    equal: 17,
    clear: 13,
  };

  for (let i = 0; i <= buttons.length - 1; i++) {
    if ((await buttons[i].getText()) == a) {
      buttons[i].click();
    }
  }
  buttons[calcOperators[operation]].click();

  for (let i = 0; i <= buttons.length - 1; i++) {
    if ((await buttons[i].getText()) == b) {
      buttons[i].click();
    }
  }

  buttons[calcOperators["equal"]].click();

  let expectedResult;
  switch (operation) {
    case "addition":
      expectedResult = a + b;
      break;
    case "subtraction":
      expectedResult = a - b;
      break;
    case "division":
      expectedResult = a / b;
      break;
    case "multiplication":
      expectedResult = a * b;
      break;
    default:
      throw new Error("Invalid operation type: " + operation);
  }

  setTimeout(async () => {
    assert.strictEqual(
      await calcDisplay.getText(),
      parseFloat(expectedResult).toFixed(1).toString()
    );
    buttons[calcOperators["clear"]].click();  
  }, 1000);


}

async function runTest() {
 driver = await new Builder().forBrowser("chrome").build();
  try {
    await driver.get("http://localhost:4040/calculator");
    await testOperation(9, 2, "subtraction");
    //  await testOperation(91, 2, "addition");

  } catch (err) {
    console.error(err);
  }finally{
    //  await driver.quit();
  }
    
}

runTest();
