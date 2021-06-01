package com.chad.jobproject.poll;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name="poll")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Name must not be empty")
    @Size(min=2, max=30)
    private String name;
    Date date = new Date();
    @NotEmpty(message = "poll question can't be empty")
    @Size(min=2, max=255)
    private String question;
    @NotEmpty(message = "option 1 cant be empty")
    @Size(min=2, max=255)
    private String option1;
    @NotEmpty(message = "option 2 cant be empty")
    @Size(min=2, max=255)
    private String option2;
    @NotEmpty(message = "option 3 cant be empty")
    @Size(min=2, max=255)
    private String option3;
    private int vote1;
    private int vote2;
    private int vote3;

    public Poll() {}
    public Poll(Poll poll) {
        this.id = poll.id;
        this.name = poll.name;
        this.date = poll.date;
        this.question = poll.question;
        this.option1 = poll.option1;
        this.option2 = poll.option2;
        this.option3 = poll.option3;
        this.vote1 = poll.vote1;
        this.vote2 = poll.vote2;
        this.vote3 = poll.vote3;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getVote1() {
        return vote1;
    }

    public void setVote1(int vote1) {
        this.vote1 = vote1;
    }

    public int getVote2() {
        return vote2;
    }

    public void setVote2(int vote2) {
        this.vote2 = vote2;
    }

    public int getVote3() {
        return vote3;
    }

    public void setVote3(int vote3) {
        this.vote3 = vote3;
    }

    public Poll(Long id, String name, Date date, String question, String option1, String option2, String option3, int vote1, int vote2, int vote3) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.vote1 = vote1;
        this.vote2 = vote2;
        this.vote3 = vote3;

    }


}
