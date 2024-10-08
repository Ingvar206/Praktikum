package com.janeck.web.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janeck.web.tools.Feedback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final List<Feedback> feedbackList = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file = new File("C:\\Users\\jta\\Documents\\Projects\\web\\src\\main\\resources\\static\\feedback.json");

    @PostMapping
    public ResponseEntity<String> submitFeedback(@RequestBody Feedback feedback) throws IOException {
        System.out.println("Empfangenes Feedback: " + feedback);
        feedbackList.add(feedback);
        System.out.println("Aktualisierte Feedback-Liste: " + feedbackList);
        objectMapper.writeValue(file, feedbackList);
        System.out.println("Feedback gespeichert: " + feedback);
        return ResponseEntity.ok("Feedback submitted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        try {
            if (file.exists() && file.length() != 0) {
                Feedback[] feedbackArray = objectMapper.readValue(file, Feedback[].class);
                feedbackList.clear();
                feedbackList.addAll(List.of(feedbackArray));
                System.out.println("Feedback geladen: " + feedbackList);
            } else {
                System.out.println("Datei nicht gefunden oder leer: " + file.getAbsolutePath());
            }
            return ResponseEntity.ok(feedbackList);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}