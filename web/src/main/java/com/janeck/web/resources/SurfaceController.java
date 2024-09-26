/*
 * (c)2022 Star Finanz GmbH, Hamburg, Germany
 *
 */
package com.janeck.web.resources;

import com.janeck.web.tools.Surfacecalculator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/surface")
public class SurfaceController {

	private final Surfacecalculator surfacecalculator;

	public SurfaceController(Surfacecalculator surfacecalculator) {
		this.surfacecalculator = surfacecalculator;
	}

	@GetMapping("/result")
	public double getResult(
			@RequestParam() String shape,
			@RequestParam(required = false) Double squareSide,
			@RequestParam(required = false) Double rectangleHeight,
			@RequestParam(required = false) Double rectangleWidth,
			@RequestParam(required = false) Double triangleBase,
			@RequestParam(required = false) Double triangleHeight) {
		switch (shape) {
			case "square":
				return surfacecalculator.calculateSquareArea(squareSide);

			case "rectangle":
				return surfacecalculator.calculateRectangleArea(rectangleHeight, rectangleWidth);

			case "triangle":
				return surfacecalculator.calculateTriangleArea(triangleBase, triangleHeight);
		}

		return 00.7;

    }
}
