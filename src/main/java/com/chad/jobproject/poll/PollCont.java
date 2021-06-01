package com.chad.jobproject.poll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class PollCont {
    @Autowired
    PollRepo pollRepo;

    @GetMapping
    public List<Poll> getAll() { return pollRepo.findAll(); }

    @PostMapping
    public ResponseEntity<Poll> createPoll(@Valid @RequestBody Poll poll) throws Exception {
        pollRepo.save(poll);
        return ResponseEntity.ok().body(poll);
    }

    @GetMapping("/poll/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long id) throws Exception {
        Poll getPoll = pollRepo.findById(id)
                .orElseThrow(() -> new Exception("Poll doesnt exist"));
        return ResponseEntity.ok(getPoll);
    }

    @PostMapping("/vote/{id}")
    public ResponseEntity<Poll> createVotes(@PathVariable Long id, @Valid @RequestBody String optionVoted) throws Exception {
        Poll poll = pollRepo.findById(id)
                .orElseThrow(() -> new Exception("Poll doesnt exist"));
        if(optionVoted.equals("option1=")) {
            poll.setVote1(poll.getVote1() + 1);
            pollRepo.save(poll);
            return ResponseEntity.ok().body(poll);
        } else if(optionVoted.equals("option2=")) {
            poll.setVote2(poll.getVote2() + 1);
            pollRepo.save(poll);
            return ResponseEntity.ok().body(poll);
        } else {
            poll.setVote3(poll.getVote3() + 1);
            pollRepo.save(poll);
            return ResponseEntity.ok().body(poll);
        }
    }

    @PutMapping("/polls/{id}")
    public ResponseEntity<Poll> updatePoll(@PathVariable Long id, @Valid @RequestBody Poll poll) throws Exception {
        Poll pollMaker = pollRepo.findById(id)
                .orElseThrow(() -> new Exception("Poll doesn't exist"));
        pollMaker.setId(poll.getId());
        pollMaker.setName(poll.getName());
        pollMaker.setQuestion(poll.getQuestion());
        pollMaker.setOption1(poll.getOption1());
        pollMaker.setOption2(poll.getOption2());
        pollMaker.setOption3(poll.getOption3());
        pollRepo.save(poll);
        return ResponseEntity.ok(pollMaker);
    }

    @DeleteMapping("/poll/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePoll(@PathVariable Long id) throws Exception {
        Poll poll = pollRepo.findById(id)
                .orElseThrow(() -> new Exception("poll doesn't exist"));
        pollRepo.delete(poll);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        pollRepo.delete(poll);
        return ResponseEntity.ok(response);
    }
}
