package com.example.stripe.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.example.stripe.net.RESTClient;
import com.example.stripe.repository.MSWhatsAppRepository;
import com.example.stripe.service.MESSAGE_MODEL.KEY;

@Service
public class MSWhatsAppService implements MSWhatsApp{

	@Autowired
	MSWhatsAppRepository repository;
	
	public String register(String phoneNumberId) {
		return registerPhone(phoneNumberId) ;
	}

	public String deregister(String phoneNumberId) {
		return deregisterPhone(phoneNumberId) ;
	}
	
	String text(String recipientPhoneNumber, String text) {
  		return sendTextMessage(recipientPhoneNumber, text);
	}
	
	String previewURL(String recipientPhoneNumber, String previewURL) {
		return sendTextMessageWithPreviewURL(recipientPhoneNumber, previewURL);
	}
	
	
	String imageURL(String recipientPhoneNumber, String imageURL) {
		return sendImageMessageByURL(recipientPhoneNumber, imageURL);
	}
	
	
	String audioURL(String recipientPhoneNumber, String audioURL) {
		return sendAudioMessageByURL(recipientPhoneNumber, audioURL);
	}
	
	
	String sendDocumentMessageByURL(String recipientPhoneNumber, String documentURL) {
		return sendDocumentMessageByURL(recipientPhoneNumber, documentURL, "See attachment");
	}
	
	
	public String updateBusinessProfile(String text) {
		
		return updateBusinessProfile(BUSINESS_PROFILE);
	}
	
	
	public String getPhoneNumbers() {
		return getPhoneNumbers();
	}
	
	
	public String getBusinessProfileId() {
		return getBusinessProfileId();
	}
	
	
	public HttpEntity<byte[]> downloadJpeg(String mediaURL) {
		byte[] image = downloadMedia("https://pps.whatsapp.net/v/t61.24694-24/417341724_383816014589351_6309006714023920586_n.jpg?ccb=11-4&oh=01_AdTivGVWj8-nGtBkijijsRR_2R-MBg3EAQHvSIi8PMaLAA&oe=65EB8758&_nc_sid=e6ed6c&_nc_cat=105");
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    headers.setContentLength(image.length);

	    return new HttpEntity<byte[]>(image, headers);
	}
	
	
	public String sendReplyToTextMessage(String fromPhoneNumber, String text, String messageId) {
		return sendReplyToTextMessage( fromPhoneNumber,  text,  messageId);
	}

	public String setPhoneNumber(String phoneNumber, String verifiedName) {
		// TODO Auto-generated method stub
		PHONE_NUMBER phone = new PHONE_NUMBER();
		phone.put(KEY.phone_number, phoneNumber);
		phone.put(KEY.verified_name, verifiedName);
		return setPhoneNumbers(phone);
	}
}
