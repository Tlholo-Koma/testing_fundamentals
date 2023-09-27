let questions=[];
let score =0;

const navigationSection = document.getElementById("navigation-section");
const questionLabel = document.getElementById("question");
const scoreLabel = document.getElementById("score");
const answersSection = document.getElementById("answers-section");
const timer = document.getElementById("timer");
const tryAgainButton = document.getElementById("try-again");
//to add timer
async function getTriviaQuestions() {
  score=0;
  timer.textContent = `${score}/10`;
  answersSection.style.display = "grid";
  scoreLabel.textContent = "";
  navigationSection.style.display = "none";
  try {
    const response = await fetch(
      "https://opentdb.com/api.php?amount=10&category=19&difficulty=medium&type=multiple",
      {
        headers: {
          Accept: "application/json",
        },
      }
    );

    const data = await response.json();
    questions = data.results;
    await nextTriviaQuestion();
  } catch (error) {
    console.error(error);
  }
}

async function nextTriviaQuestion() {
  console.log(questions);

  if (questions.length == 0) {
    answersSection.style.display = "none";
    questionLabel.textContent = "";
    scoreLabel.textContent = `You scored ${score}/10`;
    navigationSection.style.display = "block";
    return;
  }

  answersSection.textContent = "";

  try {
    const randomIndex = Math.floor(Math.random() * questions.length);
    const data = questions[randomIndex];

    questionLabel.textContent = data.question;

    let allAnswers = [...data.incorrect_answers, data.correct_answer];
    allAnswers = shuffleAnswers(allAnswers);

    for (var i = 0; i <= 3; i++) {
      const answerButton = document.createElement("button");
      answerButton.classList.add("answer-button");
      answerButton.textContent = allAnswers[i];
    
      answerButton.addEventListener("click", () => {
        if (answerButton.textContent == data.correct_answer) {
          answerButton.style.background = "green";
          score += 1;
        } else {
          answerButton.style.background = "red";
        }

        const ind = questions.indexOf(data);
        if (ind !== -1) {
          questions.splice(ind, 1);
        }

        timer.textContent = `${score}/10`;

        setTimeout(async () => {
          await nextTriviaQuestion();
        }, 1000);
      });

      answersSection.appendChild(answerButton);
    }
  } catch (error) {
    console.error(error);
  }
}

function shuffleAnswers(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
  return array;
}

document.addEventListener("DOMContentLoaded", async () => {
  await getTriviaQuestions();
 
});

tryAgainButton.addEventListener("click",async ()=>{
  await getTriviaQuestions();
})