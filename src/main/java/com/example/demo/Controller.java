package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	MeterRegistryService meterRegistryService;
	
	
	@PostMapping("/hola-mundo")
	public ResponseDTO holaMundo(@RequestBody RequestDTO request) {
		
		meterRegistryService.requestReciveCall();
			
		if(request.getFlag().compareTo("false")==0) {
			meterRegistryService.responseOkReciveCall();
		}else {
			meterRegistryService.responseErrorReciveCall();
		}
		
		ResponseDTO response = new ResponseDTO();
		response.setCodigo("000");
		response.setMensaje("OK");
		
		return response;
	}
	

}
