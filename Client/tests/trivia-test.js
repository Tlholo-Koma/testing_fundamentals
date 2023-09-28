const { By, Key, Builder } = require("selenium-webdriver");
require("chromedriver");
const assert = require("assert");
let driver;

async function runTest() {
  driver = await new Builder().forBrowser("chrome").build();
  try {
    await driver.get("http://localhost:4040/trivia");

    setTimeout(async () => {
      const buttons = await driver.findElements(By.className("answer-button"));
      console.log("styl1e", await buttons[0].getCssValue("background-color"));
      buttons[0].click();
      console.log("style", await buttons[0].getCssValue("background-color"));

      assert.notStrictEqual(await buttons[0].getCssValue("background-color"),"rgba(239, 239, 239, 1)")
    }, 3000);
    
    // await driver.quit();
  } catch (err) {
    console.error(err);
  }
  
}

runTest();
