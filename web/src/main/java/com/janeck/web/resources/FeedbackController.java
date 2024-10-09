package com.janeck.web.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janeck.web.tools.Feedback;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final List<Feedback> feedbackList = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file = new File("C:\\Users\\jta\\Documents\\Projects\\web\\src\\main\\resources\\static\\feedback.json");

    public FeedbackController() {
        loadFeedbackFromFile();
    }

    private void loadFeedbackFromFile() {
        try {
            if (file.exists() && file.length() != 0) {
                Feedback[] feedbackArray = objectMapper.readValue(file, Feedback[].class);
                feedbackList.clear();
                feedbackList.addAll(List.of(feedbackArray));
                System.out.println("Feedback geladen: " + feedbackList);
            } else {
                System.out.println("Datei nicht gefunden oder leer: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping
    public ResponseEntity<String> submitFeedback(@RequestBody Feedback feedback) throws IOException {
        System.out.println("Empfangenes Feedback: " + feedback);
        feedbackList.add(feedback);
        objectMapper.writeValue(file, feedbackList);
        System.out.println("Feedback gespeichert: " + feedback);
        return ResponseEntity.ok("Feedback erfolgreich eingereicht");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackList);
    }

    @GetMapping("/view")
    public ResponseEntity<byte[]> getAalPage() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/feedback-view.html");
        byte[] content = Files.readAllBytes(Path.of(resource.getURI()));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}