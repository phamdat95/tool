package dat.pham.controller;

import dat.pham.service.PoskMaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PoskMaskController {

	@Autowired
	private PoskMaskService poskMaskService;

	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public String get(@RequestPart(name = "ffff", required = false) MultipartFile file) {
		poskMaskService.get(file);
		return "ok";
	}

	@RequestMapping(value = "/ducanh", method = RequestMethod.POST)
	public String toolDucAnh(@RequestPart(name = "ffff", required = false) MultipartFile file) {
		try {
			poskMaskService.toolDucAnh(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public String toolExportXLSX() {
		try {
			poskMaskService.getXLSX();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ok";
	}
}
