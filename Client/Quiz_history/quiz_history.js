const historyHeading = document.getElementById("history-for-heading");
const userName =  document.createTextNode(" Selena Williams"); //replace with backend call for userName

historyHeading.appendChild(userName);

const scoreList = document.getElementById("score-history");
const scores = [];

scores.push({score: 2, date:"2023-01-01"});
scores.push({score: 9, date: "2023-02-02"});

// fetch('<backendurl>')
// .then(response => {
//   if(!response.ok){
//     throw new Error('Response not ok');
//   }
//   else{
//     return response.json();
//   }
// })
// .then( data => {
//   data.forEach(element => {
//     if(element.hasOwnProperty('score') && element.hasOwnProperty('time')){
//       scores.push({
//         score:element.score,
//         time: element.time,
//       })
//       const scoreElement = document.createElement('li');
//       scoreElement.textContent = `Score: ${element.score} - Date: ${element.date}`;
//       scoreList.appendChild(scoreElement);
//     }
//   });
// })
// .catch(error =>{
//   console.log("error in fetch");
//   // Do something here;
// })

scores.forEach(element => {
    const scoreElement = document.createElement('li');
    scoreElement.textContent = `Score: ${element.score} - Date: ${element.date}`;
    scoreList.appendChild(scoreElement);
})
