package com.example.stripe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stripe.nessages.MSText;
import com.example.stripe.service.MSWhatsAppService;

@RestController
public class MSWhatsAppController {

	@Autowired
	private MSWhatsAppService service;

	@PostMapping("/whatsapp/register")
	String register(@RequestBody MSText text) {
  		return service.register("447593340709");
	}
	
	@PostMapping("/whatsapp/phone_number")
	String setPhoneNumber(@RequestBody MSText text) {
  		return service.setPhoneNumber("07593340709", text.getBody());
	}
	
	@PostMapping("/whatsapp/text")
	String text(@RequestBody MSText text) {
  		String textResponse = service.text("447593340709", text.getBody());
  		System.out.println(textResponse);
  		return textResponse;
	}
	
	@PostMapping("/whatsapp/previewURL")
	String previewURL(@RequestBody MSText previewURL) {
		return service.previewURL("447593340709", previewURL.getBody());
	}
	
	@PostMapping("/whatsapp/imageURL")
	String imageURL(@RequestBody MSText imageURL) {
		return service.imageURL("447593340709", imageURL.getBody());
	}
	
	@PostMapping("/whatsapp/audioURL")
	String audioURL(@RequestBody MSText audioURL) {
		return service.audioURL("447593340709", audioURL.getBody());
	}
	
	@PostMapping("/whatsapp/documentURL")
	String sendDocumentMessageByURL(@RequestBody MSText documentURL) {
		return service.sendDocumentMessageByURL("447593340709", documentURL.getBody());
	}
	
	@PostMapping("/whatsapp/profile")
	String updateBusinessProfile(@RequestBody MSText text) {
		
		return service.updateBusinessProfile(text.getBody());
	}
	
	@GetMapping("/whatsapp/numbers.json")
	String getNumbers() {
		return service.getPhoneNumbers();
	}
	
	@GetMapping("/whatsapp/profile.json")
	String getProfile() {
		return service.getProfileId();
	}
	
	@GetMapping(value = "/whatsapp/download/{mediaURL}", produces = MediaType.IMAGE_JPEG_VALUE, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
	@ResponseBody HttpEntity<byte[]> download(@PathVariable("mediaURL") String mediaURL) {
		

	    return service.downloadJpeg(mediaURL);
	}
	
	@PostMapping("/whatsapp/text/{messageId}")
	public String replyToText(@RequestBody MSText text, @PathVariable("messageId") String messageId) {
		return service.sendReplyToTextMessage( "+447593340709",  text.getBody(),  messageId);
	}
	
}
