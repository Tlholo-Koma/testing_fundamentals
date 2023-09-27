package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
// @Table (name = "quiz_history", schema = "calculator_schema")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class QuizHistory {
  // @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column(name = "history_id")
  // private Long historyId;

  // @Column(name = "user_id")
  // private Long userId;

  // @Column(name = "score")
  // private int score;

  // public QuizHistory(Long userId, int score) {
  // this.userId = userId;
  // this.score = score;
  // }
}
