const { By, Key, Builder } = require("selenium-webdriver");
require("chromedriver");
const assert = require("assert");

async function runTest() {
  let driver = await new Builder().forBrowser("chrome").build();
  try {
    await driver.get("http://localhost:4040");

    await driver.findElement(By.id("loginWithGoogle")).click();
    
    assert.strictEqual(await driver.getTitle(),"Sign in - Google Accounts")
  } catch (err) {
    console.error("Button did not open google auth - ", err);
  }
  await driver.quit();
}

runTest();
