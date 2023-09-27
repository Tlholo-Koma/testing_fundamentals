const sample = [
  {
    question: "1+1?",
    correctAnswer: 2,
    incorrectAnswers: [10, 1, 3],
  },
  {
    question: "2+2?",
    correctAnswer: 4,
    incorrectAnswers: [55, 11, 3],
  },
  {
    question: "1fb1?",
    correctAnswer: 2,
    incorrectAnswers: [10, 1, 3],
  },
];

let data;

const button = document.getElementById("submit");
const questionLabel = document.getElementById("question");
const answersSection = document.getElementById("answers-section");

//adding scoring system and already seen questions

async function generateTriviaQuestions() {
console.log(sample)

  answersSection.textContent=""
  try {
    const response = await fetch("https://opentdb.com/api.php?amount=10&category=19&difficulty=medium&type=multiple", {
      headers: {
        "Accept": "application/json",
      },
    });

    data = await response.json();
    console.log(data.results)
    data = data.results[Math.floor(Math.random() * data.results.length)];

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

        } else {
          answerButton.style.background = "red";
        }
        setTimeout(async () => {
          await generateTriviaQuestions();
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
  await generateTriviaQuestions();
});
