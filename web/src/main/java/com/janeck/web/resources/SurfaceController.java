/*
 * (c)2022 Star Finanz GmbH, Hamburg, Germany
 *
 */
package com.janeck.web.resources;

import com.google.gson.Gson;
import com.janeck.web.dto.ShapeDTO;
import com.janeck.web.tools.CalculationHistory;
import com.janeck.web.tools.SurfaceCalculator;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/surface")
@Validated
public class SurfaceController {
	private final SurfaceCalculator surfacecalculator;
	private final List<CalculationHistory> history = new ArrayList<>();
	private final Gson gson = new Gson();
	private final File historyFile = new File("C:\\Users\\jta\\Documents\\Projects\\web\\src\\main\\resources\\static\\history.json");

	public SurfaceController(SurfaceCalculator surfacecalculator) {
		this.surfacecalculator = surfacecalculator;
		loadHistoryFromFile();
	}

	private void loadHistoryFromFile() {
		try (FileReader reader = new FileReader(historyFile)) {
			if (historyFile.exists() && historyFile.length() != 0) {
				CalculationHistory[] historyArray = gson.fromJson(reader, CalculationHistory[].class);
				history.clear();
				history.addAll(List.of(historyArray));
				System.out.println("Historie geladen: " + history);
			} else {
				System.out.println("Datei nicht gefunden oder leer: " + historyFile.getAbsolutePath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveHistoryToFile() {
		try (FileWriter writer = new FileWriter(historyFile)) {
			gson.toJson(history, writer);
			System.out.println("Historie gespeichert: " + history);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/resultarea")
	public Map<String, Double> getResultArea(@Valid ShapeDTO shapeDTO) {
		double area = 0;

		switch (shapeDTO.getShape()) {
			case "square" -> area = surfacecalculator.calculateSquareArea(shapeDTO.getSquareSide());
			case "rectangle" -> area = surfacecalculator.calculateRectangleArea(shapeDTO.getRectangleHeight(), shapeDTO.getRectangleWidth());
			case "triangle" -> area = surfacecalculator.calculateTriangleArea(shapeDTO.getTriangleBase(), shapeDTO.getTriangleHeight());
			case "circle" -> area = Math.round(surfacecalculator.calculateCircleArea(shapeDTO.getCircleRadius()) * 100.0) / 100.0;
		}
		history.add(new CalculationHistory("area", shapeDTO.getShape(), area));
		saveHistoryToFile();

		Map<String, Double> result = new HashMap<>();
		result.put("area", area);
		return result;
	}

	@GetMapping("/resultcircumference")
	public Map<String, Double> getResultCircumference(@Valid ShapeDTO shapeDTO) {
		double circumference = 0;

		switch (shapeDTO.getShape()) {
			case "square" -> circumference = surfacecalculator.calculateSquareCircumference(shapeDTO.getSquareSide());
			case "rectangle" -> circumference = surfacecalculator.calculateRectangleCircumference(shapeDTO.getRectangleHeight(), shapeDTO.getRectangleWidth());
			case "triangle" -> circumference = surfacecalculator.calculateTriangleCircumference(shapeDTO.getTriangleBase());
			case "circle" -> circumference = surfacecalculator.calculateCircleCircumference(shapeDTO.getCircleRadius());
		}

		history.add(new CalculationHistory("circumference", shapeDTO.getShape(), circumference));
		saveHistoryToFile();

		Map<String, Double> result = new HashMap<>();
		result.put("circumference", circumference);
		return result;
	}

	@GetMapping("/history")
	public List<CalculationHistory> getHistory() {
		return history;
	}
}

