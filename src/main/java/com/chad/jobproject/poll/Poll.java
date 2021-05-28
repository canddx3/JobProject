package com.chad.jobproject.poll;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="poll")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Name must not be empty")
    private String name;
    private Timestamp time;
    @NotEmpty(message = "poll question can't be empty")
    private String question;
    @NotEmpty(message = "option 1 cant be empty")
    private String option1;
    @NotEmpty(message = "option 2 cant be empty")
    private String option2;
    @NotEmpty(message = "option 3 cant be empty")
    private String option3;

    public Poll() {}

    public Poll(Poll poll) {
        this.id = poll.id;
        this.name = poll.name;
        this.time = poll.time;
        this.question = poll.question;
        this.option1 = poll.option1;
        this.option2 = poll.option2;
        this.option3 = poll.option3;
    }

    public Poll(Long id, String name, Timestamp time, String question, String option1, String option2, String option3) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Poll poll = (Poll) o;
        return id.equals(poll.id) && name.equals(poll.name) && time.equals(poll.time) && question.equals(poll.question) && option1.equals(poll.option1) && option2.equals(poll.option2) && option3.equals(poll.option3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, time, question, option1, option2, option3);
    }
}
