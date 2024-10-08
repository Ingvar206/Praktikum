/*
 * (c)2022 Star Finanz GmbH, Hamburg, Germany
 *
 */
package com.janeck.web.resources;

import com.janeck.web.dto.ShapeDTO;
import com.janeck.web.tools.CalculationHistory;
import com.janeck.web.tools.Surfacecalculator;
import jakarta.validation.Valid;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/surface")
@Validated
public class SurfaceController {
	private final Surfacecalculator surfacecalculator;

	private final List<CalculationHistory> history = new ArrayList<>();

	public SurfaceController(Surfacecalculator surfacecalculator) {
		this.surfacecalculator = surfacecalculator;
	}

	@GetMapping("/resultarea")
	public Map<String, Double> getResultArea(@Valid ShapeDTO shapeDTO) {
		double area = 0;

		switch (shapeDTO.getShape()) {
			case "square" -> area = surfacecalculator.calculateSquareArea(shapeDTO.getSquareSide());
			case "rectangle" -> area = surfacecalculator.calculateRectangleArea(shapeDTO.getRectangleHeight(), shapeDTO.getRectangleWidth());
			case "triangle" -> area = surfacecalculator.calculateTriangleArea(shapeDTO.getTriangleBase(), shapeDTO.getTriangleHeight());
			case "circle" -> area = surfacecalculator.calculateCircleArea(shapeDTO.getCircleRadius());

		}
		history.add(new CalculationHistory("area", shapeDTO.getShape(), area));

		Map<String, Double> result = new HashMap<>();
		result.put("area", area);
		return result;
	}

	@GetMapping("/resultcircumference")
	public Map<String, Double> getResultCircumference(@Valid ShapeDTO shapeDTO){
		double circumference = 0;

		switch (shapeDTO.getShape()) {
			case "square" -> circumference = surfacecalculator.calculateSquareCircumference(shapeDTO.getSquareSide());
			case "rectangle" -> circumference = surfacecalculator.calculateRectangleCircumference(shapeDTO.getRectangleHeight(), shapeDTO.getRectangleWidth());
			case "triangle" -> circumference = surfacecalculator.calculateTriangleCircumference(shapeDTO.getTriangleBase());
			case "circle" -> circumference = surfacecalculator.calculateCircleCircumference(shapeDTO.getCircleRadius());

		}

		history.add(new CalculationHistory("circumference", shapeDTO.getShape(), circumference));

		Map<String, Double> result = new HashMap<>();
		result.put("circumference", circumference);
		return result;
	}

	@GetMapping("/aal")
	public ResponseEntity<byte[]> getAalPage() throws IOException {
		ClassPathResource resource = new ClassPathResource("static/aal.html");
		byte[] content = Files.readAllBytes(Path.of(resource.getURI()));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
		return new ResponseEntity<>(content, headers, HttpStatus.OK);
	}

	@GetMapping("/feedback")
	public ResponseEntity<byte[]> getFeedbackPage() throws IOException {
		ClassPathResource resource = new ClassPathResource("static/feedback.html");
		byte[] content = Files.readAllBytes(Path.of(resource.getURI()));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
		return new ResponseEntity<>(content, headers, HttpStatus.OK);
	}

	@GetMapping("/afterfeedback")
	public ResponseEntity<byte[]> getAfterFeedbackPage() throws IOException {
		ClassPathResource resource = new ClassPathResource("static/afterfeedback.html");
		byte[] content = Files.readAllBytes(Path.of(resource.getURI()));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
		return new ResponseEntity<>(content, headers, HttpStatus.OK);
	}
	@GetMapping("/history")
	public List<CalculationHistory> getHistory() {
		return history;
	}
	@GetMapping("/historyPage")
	public ResponseEntity<byte[]> getHistoryPage() throws IOException {
		ClassPathResource resource = new ClassPathResource("static/history.html");
		byte[] content = Files.readAllBytes(Path.of(resource.getURI()));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
		return new ResponseEntity<>(content, headers, HttpStatus.OK);
	}
}

