/*
 * (c)2022 Star Finanz GmbH, Hamburg, Germany
 *
 */
package com.janeck.web.resources;

import com.janeck.web.dto.ShapeDTO;
import com.janeck.web.tools.Surfacecalculator;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/surface")
@Validated
public class SurfaceController {

	private final Surfacecalculator surfacecalculator;

	public SurfaceController(Surfacecalculator surfacecalculator) {
		this.surfacecalculator = surfacecalculator;
	}

	@GetMapping("/result")
	public Map<String, Double> getResult(@Valid ShapeDTO shapeDTO) {
		double area = 0;

		switch (shapeDTO.getShape()) {
			case "square" -> area = surfacecalculator.calculateSquareArea(shapeDTO.getSquareSide());
			case "rectangle" -> area = surfacecalculator.calculateRectangleArea(shapeDTO.getRectangleHeight(), shapeDTO.getRectangleWidth());
			case "triangle" -> area = surfacecalculator.calculateTriangleArea(shapeDTO.getTriangleBase(), shapeDTO.getTriangleHeight());
			case "circle" -> area = surfacecalculator.calculateCircleArea(shapeDTO.getCircleRadius());
		}

		Map<String, Double> result = new HashMap<>();
		result.put("area", area);
		return result;
	}
}

