const {By,Key,Builder} = require("selenium-webdriver");
require("chromedriver");

async function example(){
    let driver = await new Builder().forBrowser("chrome").build();
     await driver.get("http://localhost:4040");

     await driver.findElement(By.name("q")).sendKeys(searchString,Key.RETURN);
     var title = await driver.getTitle();

     await driver.quit();

}

example();