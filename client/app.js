const express = require('express');
const path = require('path');
const cors = require('cors');
const port = 4040;
const app = express();

app.use(cors());
  
  app.use(express.urlencoded({extended: true}))
  app.use(express.json());

  app.use('/', express.static(path.join('public')));
  app.use(express.static("./src/public", { extensions: ["js","css"] }));
  app.use(express.static("./src/views", { extensions: ["html"] }));

  app.get('/', (req, res) => {
    res.redirect('/login');
  });

app.listen(port, '0.0.0.0', () => {
  console.log(`http://localhost:${port}`);
});