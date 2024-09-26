/*
 * (c)2022 Star Finanz GmbH, Hamburg, Germany
 *
 */
package com.janeck.web.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dme
 */
@RestController
@RequestMapping("/surface")
public class SurfaceController {

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}
}
