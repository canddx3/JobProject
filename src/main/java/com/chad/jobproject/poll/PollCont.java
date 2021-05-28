package com.chad.jobproject.poll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Poll")
public class PollCont {
    @Autowired
    PollRepo pollRepo;

    @GetMapping
    public List<Poll> getAllVotes() { return pollRepo.findAll(); }

    @PostMapping
    public ResponseEntity<Poll> createPoll(@Valid @RequestBody Poll poll) throws Exception {
        pollRepo.save(poll);
        return ResponseEntity.ok().body(poll);
    }

    @PutMapping("{id}")
    public ResponseEntity<Poll> updatePoll(@PathVariable Long id, @Valid @RequestBody Poll poll) throws Exception {
        Poll pollMaker = this.pollRepo.findById(id)
                .orElseThrow(() -> new Exception("Poll doesn't exist"));
        pollMaker.setId(poll.getId());
        pollMaker.setName(poll.getName());
        pollMaker.setQuestion(poll.getQuestion());
        pollRepo.save(poll);
        return ResponseEntity.ok(pollMaker);
    }

    @DeleteMapping("/{id}")
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
