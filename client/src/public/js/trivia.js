let questions = [];
let currentQuestion;
let countdownTimeout;
let score = 0;
let countdownValue = 10;
let selectedAnswer = false;

const navigationSection = document.getElementById("navigation-section");
const questionLabel = document.getElementById("question");
const scoreLabel = document.getElementById("score");
const answersSection = document.getElementById("answers-section");
const timer = document.getElementById("timer");
const tryAgainButton = document.getElementById("try-again");

async function countdown() {
  countdownValue -= 1;
  timer.style.background = `linear-gradient(white, white) content-box no-repeat, conic-gradient(rgb(0, 110, 255) ${
    100 - countdownValue * 10
  }%, 0, white) border-box`;

  if (countdownValue >= 0) {
    countdownTimeout = setTimeout(countdown, 1000);
  } else {
    removeQuestion();
  }
}

function shuffleAnswers(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
  return array;
}

function removeQuestion() {
  if (currentQuestion) {
    const currentIndex = questions.indexOf(currentQuestion);
    if (currentIndex !== -1) {
      questions.splice(currentIndex, 1);
    }
    const delay = selectedAnswer ? 1000 : 0;
    setTimeout(async () => {
      selectedAnswer = false;
      nextTriviaQuestion();
    }, delay);
  }
}
function clearTrivia() {
  clearTimeout(countdownTimeout);
  answersSection.style.display = "none";
  questionLabel.textContent = "";
  scoreLabel.textContent = `You scored ${score}/10`;
  navigationSection.style.display = "block";
}

function handleSelectedAnswer(answerButton) {
  if (!selectedAnswer) {
    selectedAnswer = true;
    if (answerButton.textContent === currentQuestion.correct_answer) {
      answerButton.style.background = "green";
      score += 1;
    } else {
      answerButton.style.background = "red";
    }

    removeQuestion();

    timer.textContent = `${score}/10`;
  }
}

async function getTriviaQuestions() {
  score = 0;
  timer.textContent = `${score}`;
  answersSection.style.display = "grid";
  scoreLabel.textContent = "";
  navigationSection.style.display = "none";
  const difficulty = ["medium","hard"]
  try {
    const response = await fetch(
      `https://opentdb.com/api.php?amount=10&category=19&difficulty=${difficulty[Math.floor(Math.random() * difficulty.length)]}&type=multiple`,
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
  countdownValue = 10;
  clearTimeout(countdownTimeout);
  countdown();

  if (questions.length == 0) {
    clearTrivia();
    return;
  }

  answersSection.textContent = "";
  try {
    const randomIndex = Math.floor(Math.random() * questions.length);
    currentQuestion = questions[randomIndex];

    questionLabel.textContent = currentQuestion.question;

    let allAnswers = [
      ...currentQuestion.incorrect_answers,
      currentQuestion.correct_answer,
    ];
    allAnswers = shuffleAnswers(allAnswers);

    for (var i = 0; i <= 3; i++) {
      const answerButton = document.createElement("button");
      answerButton.classList.add("answer-button");
      answerButton.textContent = allAnswers[i];

      answerButton.addEventListener("click", ()=>handleSelectedAnswer(answerButton));

      answersSection.appendChild(answerButton);
    }
  } catch (error) {
    console.error(error);
  }
}

document.addEventListener("DOMContentLoaded", async () => {
  await getTriviaQuestions();
});

tryAgainButton.addEventListener("click", async () => {
  await getTriviaQuestions();
});
