package com.example.stripe.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.stripe.net.RESTClient;
import com.example.stripe.service.MESSAGE_MODEL.KEY;

public interface MSWhatsApp {
	public static final String URL = "https://graph.facebook.com/v18.0/230322800167053/messages";
	public static final String VERSION = "v19.0";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String AUTHORIZATION = "Authorization";
	public static final String ACCESS_TOKEN = "EAAfZCa59vZCnEBO1AUfDLksSQg7gK6Jct4bvRrZCxYVwrYvuBzw0bUEvCaHDcQAhko4USyXDBLXJKzZA1KIrSqZASVSN1xpZBJUbWLMnKkhEScwkANl1qvE91UvafCwib1fxI9VP1nsDK1uhCdIICKQaN70sVqsJT2qeBH70e3PHICDHeneuPU06VAJZC4dNSJ9NB9FMN7GQNaCBfOBPqMm";
	public static final String PHONE_NUMBER_ID = "180596011813447";
	public static final String WABA_ID = "180763898463089";
	public static final String TEST_NUMBER = "447593340707";
	public static final String APP_ID = "1385717212050330";
	public static final String ACCEPT_ENCODING = "Accept-Encoding";
	public static final String ACCEPT = "Accept";
	public static final String GZIP_DEFLATE_BR = "gzip, deflate, br";
	public static final String CONNECTION = "Connection";
	public static final String KEEP_ALIVE = "keep-alive";
	public static final String ACCEPT_ALL = "*/*";
	public static final String BUSINESS_ID = "";
	public static final String DOMAIN = "https://graph.facebook.com/";
	
	public enum MESSAGE_TYPE {
		AUDIO, IMAGE, DOCUMENT, STICKER, VIDEO, CONTACTS;

		Map<String, Object> getId() {
			Map<String, Object> identifier;
			switch (this) {
			case AUDIO:
				identifier = AUDIO_ID;
				break;
			case VIDEO:
				identifier = VIDEO_ID;
				break;
			case DOCUMENT:
				identifier = DOCUMENT_ID;
				break;
			case IMAGE:
				identifier = IMAGE_ID;
				break;
			case STICKER:
				identifier = STICKER_ID;
				break;
			default:
				identifier = IMAGE_ID;
			}
			return identifier;
		}

		Map<String, Object> getLink() {
			Map<String, Object> identifier;
			switch (this) {
			case AUDIO:
				identifier = AUDIO_LINK;
				break;
			case VIDEO:
				identifier = VIDEO_LINK;
				break;
			case DOCUMENT:
				identifier = DOCUMENT_LINK;
				break;
			case IMAGE:
				identifier = IMAGE_LINK;
				break;
			case STICKER:
				identifier = STICKER_LINK;
				break;
			default:
				identifier = IMAGE_LINK;
			}
			return identifier;
		}

		Map<String, Object> getMessage() {
			Map<String, Object> identifier;
			switch (this) {
			case AUDIO:
				identifier = AUDIO_MESSAGE;
				break;
			case VIDEO:
				identifier = VIDEO_MESSAGE;
				break;
			case DOCUMENT:
				identifier = DOCUMENT_MESSAGE;
				break;
			case IMAGE:
				identifier = IMAGE_MESSAGE;
				break;
			case STICKER:
				identifier = STICKER_MESSAGE;
				break;
			case CONTACTS:
				identifier = new CONTACTS_MESSAGE().toMap();
				break;
			default:
				identifier = IMAGE_MESSAGE;
			}
			return identifier;
		}
	};

	public static final Map<String, String> POST_HEADERS = new HashMap<String, String>() {
		{
			put(AUTHORIZATION, "Bearer " + ACCESS_TOKEN);
			put(CONTENT_TYPE, "application/json");
		}
	};

	public static final Map<String, Object> POST_DATA = new HashMap<String, Object>() {
		{
			put("messaging_product", "whatsapp");
			put("Content-Type", "application/json");
			put("to", "447593340709");
			put("type", "template");
			put("template", POST_TEMPLATE);
		}
	};

	public static final Map<String, Object> POST_TEMPLATE = new HashMap<String, Object>() {
		{
			put("name", "hello_world");
			put("language", POST_LANGUAGE);
		}
	};

	public static final Map<String, String> POST_LANGUAGE = new HashMap<String, String>() {
		{
			put("code", "en_US");
		}
	};

	public static final List<String> WEBSITES = Arrays.asList("https://brixtonmasjid.co.uk");

	public static final MESSAGE_MODEL BUSINESS_PROFILE = new MESSAGE_MODEL() {
		{
			put(KEY.messaging_product, "whatsapp");
			put(KEY.address, "<business-address>");
			put(KEY.description, "<business-description>");
			put(KEY.vertical, "<business-industry>");
			put(KEY.about, "<profile-about-text>");
			put(KEY.email, "<business-email>");
			put(KEY.websites, WEBSITES);
			put(KEY.profile_picture_handle,
					"4:VGVzdC5wbmc=:aW1hZ2UvanBlZw==:ARat4Mt-L09JON3f30SmDkdyPSuyBkDDYiB4TFXuXISjdgHoNp2b7j882_9Jzr2tPrdKxi92UygyVzTivJiOvmebMpZ6MIjTik3gTyI3ZCQAgQ:e:1659995302:2022308451254161:636685196:ARZf1ftR5N6-qSLtklU");
		}
	};

	Map<String, Object> TEXT = new HashMap<>() {
		{
			put("preview_url", false);
			put("body", "text-message-content");

		}
	};

	Map<String, Object> TEXT_WITH_PREVIEW_URL = new HashMap<>() {
		{
			put("preview_url", true);
			put("body", "Please visit https://youtu.be/hpltvTEiRrY.");

		}
	};

	Map<String, Object> ID = new HashMap<>() {
		{
			put("id", "<IMAGE_OBJECT_ID>");
		}
	};

	Map<String, Object> LINK = new HashMap<>() {
		{
			put("link", "http(s)://image-url");
		}
	};

	Map<String, Object> STICKER_ID = new HashMap<>(ID);

	Map<String, Object> STICKER_LINK = new HashMap<>(LINK);

	Map<String, Object> IMAGE_ID = new HashMap<>(ID) {
		{
			put("id", "<IMAGE_OBJECT_ID>");
		}
	};

	Map<String, Object> IMAGE_LINK = new HashMap<>(LINK) {
		{
			put("link", "http(s)://image-url");
		}
	};

	Map<String, Object> VIDEO_ID = new HashMap<>(ID) {
		{
			put("caption", "<VIDEO_CAPTION_TEXT>");
		}
	};

	Map<String, Object> VIDEO_LINK = new HashMap<>(LINK) {
		{
			put("caption", "<VIDEO_CAPTION_TEXT>");
		}
	};

	Map<String, Object> AUDIO_ID = new HashMap<>(ID) {
		{
			put("id", "<AUDIO_OBJECT_ID>");
		}
	};

	Map<String, Object> AUDIO_LINK = new HashMap<>(LINK) {
		{
			put("link", "http(s)://audio-url");
		}
	};
	
	Map<String, Object> DOCUMENT_ID = new HashMap<>(ID) {
		{
			put("id", "<DOCUMENT_OBJECT_ID>");
			put("caption", "<DOCUMENT_CAPTION_TO_SEND>");
			put("filename", "<DOCUMENT_FILENAME>");
		}
	};

	Map<String, Object> DOCUMENT_LINK = new HashMap<>(LINK) {
		{
			put("link", "http(s)://audio-url");
			put("caption", "<DOCUMENT_CAPTION_TO_SEND>");
			put("filename", "<DOCUMENT_FILENAME>");
		}
	};

	Map<String, Object> EMAIL = new HashMap<>() {
		{
			put("email", "test@fb.com");
			put("type", "WORK");
		}
	};

	

	

	Map<String, Object> MESSAGE = new HashMap<>() {
		{
			put("messaging_product", "whatsapp");
			put("recipient_type", "individual");
			put("to", "{{Recipient-Phone-Number}}");
		}
	};

	Map<String, Object> VIDEO_MESSAGE = new HashMap<>(MESSAGE) {
		{
			put("type", "video");
			put("video", VIDEO_ID);
		}
	};

	Map<String, Object> IMAGE_MESSAGE = new HashMap<>(MESSAGE) {
		{
			put("type", "image");
			put("image", IMAGE_ID);
		}
	};

	Map<String, Object> DOCUMENT_MESSAGE = new HashMap<>(MESSAGE) {
		{
			put("type", "document");
			put("document", DOCUMENT_ID);
		}
	};

	Map<String, Object> AUDIO_MESSAGE = new HashMap<>(MESSAGE) {
		{
			put("type", "audio");
			put("audio", AUDIO_ID);
		}
	};

	Map<String, Object> STICKER_MESSAGE = new HashMap<>(MESSAGE) {
		{
			put("type", "sticker");
			put("sticker", STICKER_ID);
		}
	};

	Map<String, Object> MESSAGE_CONTEXT = new HashMap<>() {
		{
			put("message_id", "<MSGID_OF_PREV_MSG>");
		}
	};

	Map<String, Object> REACTION = new HashMap<>() {
		{
			put("message_id", "wamid.HBgLM...");
			put("emoji", "\uD83D\uDE00");
		}
	};

	Map<String, Object> REACTION_MESSAGE = new HashMap<>(MESSAGE) {
		{

			put("type", "reaction");
			put("reaction", REACTION);
		}
	};

	Map<String, Object> TEXT_MESSAGE = new HashMap<>(MESSAGE) {
		{

			put("type", "text");
			put("text", TEXT);
		}
	};

	Map<String, Object> PREVIEW_URL_MESSAGE = new HashMap<>() {
		{
			put("messaging_product", "whatsapp");
			put("to", "{{Recipient-Phone-Number}}");
			put("text", TEXT_WITH_PREVIEW_URL);
		}
	};

	Map<String, Object> REPLY_TEXT_MESSAGE = new HashMap<>(TEXT_MESSAGE) {
		{
			put("context", MESSAGE_CONTEXT);
		}
	};

	public default String registerPhone(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId + "/register";
		Map<String, Object> data = new HashMap<String, Object>() {
			{
				put("messaging_product", "whatsapp");
				put("pin", "123456");
			}
		};
		try {
			return RESTClient.post(url, data, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String success = "{\"success\": \"false\"}";
			return success;
		}
	}

	public default String deregisterPhone(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId + "/deregister";
		Map<String, Object> data = new HashMap<String, Object>() {
			{
				put("messaging_product", "whatsapp");
				put("pin", "123456");
			}
		};
		try {
			return RESTClient.post(url, data, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String success = "{\"success\": \"false\"}";
			return success;
		}
	}

	public default String migrateAccount(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId + "/register";
		Map<String, Object> backup = new HashMap<>() {
			{
				put("data", "BACKUP_DATA");
				put("password", "P455w0rd##");
			}
		};
		Map<String, Object> data = new HashMap<String, Object>() {
			{
				put("messaging_product", "whatsapp");
				put("pin", "123456");
				put("backup", backup);
			}
		};

		try {
			return RESTClient.post(url, data, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String success = "{\"success\": \"false\"}";
			return success;
		}
	}

	public default String getBusinessComplianceInfo(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId + "/business_compliance_info";

		try {
			return RESTClient.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String success = "{\"data\": []}";
			return success;
		}
	}

	public default String businessComplianceInfo(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId + "/business_compliance_info";
		Map<String, Object> grievance_officer_details = new HashMap<>() {
			{
				put("name", "Chandravati P.");
				put("email", "chandravati@luckyshrub.com");
				put("landline_number", "+913857614343");
				put("mobile_number", "+913854559033");
			}
		};
		Map<String, Object> customer_care_details = new HashMap<>() {
			{
				put("email", "support@luckyshrub.com");
				put("landline_number", "+913857614343");
				put("mobile_number", "+913854559033");
			}
		};
		Map<String, Object> data = new HashMap<String, Object>() {
			{
				put("messaging_product", "whatsapp");
				put("entity_name", "Lucky Shrub");
				put("entity_type", "PARTNERSHIP");
				put("is_registered", true);
				put("grievance_officer_details", grievance_officer_details);
				put("customer_care_details", customer_care_details);
			}
		};

		try {
			return RESTClient.post(url, data, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String success = "{\"success\": \"false\"}";
			return success;
		}
	}

	public default String getPhoneNumbers() {
		String url = DOMAIN + VERSION + "/" + WABA_ID + "/phone_numbers";
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.remove(CONTENT_TYPE);
		try {
			return RESTClient.httpGet(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String setPhoneNumbers(PHONE_NUMBER phoneNumber) {
		String url = DOMAIN + VERSION + "/" + WABA_ID + "/phone_numbers";
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.remove(CONTENT_TYPE);
		try {
			return RESTClient.postJSON(url, phoneNumber.toMap(), headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String getPhoneNumberById(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId;
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.remove(CONTENT_TYPE);
		try {
			return RESTClient.get(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String getDisplayNameStatus() {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "?fields=name_status";
		try {
			return  RESTClient.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String getSharedWABAId() {
		String url = "https://graph.facebook.com/" + VERSION + "/debug_token";
		Map<String,String> headers = new HashMap<>(POST_HEADERS) {
			{
				put(ACCEPT,  ACCEPT_ALL);
				put(ACCEPT_ENCODING, GZIP_DEFLATE_BR);
				put(CONNECTION, KEEP_ALIVE);
			}
		};
		try {
			return  RESTClient.get(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String getListOfSharedWABAs() {
		String url = DOMAIN + VERSION + "/" + BUSINESS_ID + "/client_whatsapp_business_accounts";
		Map<String,String> headers = new HashMap<>(POST_HEADERS) {
			{
				put(ACCEPT,  ACCEPT_ALL);
				put(ACCEPT_ENCODING, GZIP_DEFLATE_BR);
				put(CONNECTION, KEEP_ALIVE);
			}
		};
		try {
			return  RESTClient.get(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String subscribeToAWABA() {
		String url = DOMAIN + VERSION + "/" +  WABA_ID + "/subscribed_apps";
		Map<String,String> headers = new HashMap<>(POST_HEADERS) {
			{
				put(ACCEPT,  ACCEPT_ALL);
				put(ACCEPT_ENCODING, GZIP_DEFLATE_BR);
				put(CONNECTION, KEEP_ALIVE);
				remove(CONTENT_TYPE);
			}
		};
		try {
			return RESTClient.post(url, new HashMap<String,Object>(), headers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String getAllSubscriptionsForAWABA() {
		String url = DOMAIN + VERSION + "/" + WABA_ID + "/subscribed_apps";
		Map<String,String> headers = new HashMap<>(POST_HEADERS) {
			{
				put(ACCEPT,  ACCEPT_ALL);
				put(ACCEPT_ENCODING, GZIP_DEFLATE_BR);
				put(CONNECTION, KEEP_ALIVE);
			}
		};
		try {
			return  RESTClient.get(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default boolean unsubscribeFromAWABA() {
		String url = DOMAIN + VERSION + "/" + WABA_ID + "/subscribed_apps";
		Map<String,String> headers = new HashMap<>(POST_HEADERS) {
			{
				put(ACCEPT,  ACCEPT_ALL);
				put(ACCEPT_ENCODING, GZIP_DEFLATE_BR);
				put(CONNECTION, KEEP_ALIVE);
				remove(CONTENT_TYPE);
			}
		};
		try {
			return  RESTClient.delete(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public default String overrideCallbackURL() {
		String url = DOMAIN + VERSION + "/" + WABA_ID + "/subscribed_apps";
		Map<String,String> headers = new HashMap<>(POST_HEADERS) {
			{
				put(ACCEPT,  ACCEPT_ALL);
				put(ACCEPT_ENCODING, GZIP_DEFLATE_BR);
				put(CONNECTION, KEEP_ALIVE);
			}
		};
		
		MESSAGE_MODEL data = new MESSAGE_MODEL() {
			{
			    put(KEY.override_callback_uri, "https://alternate-endpoint-callback.com/webhook");
			 put(KEY.verify_token, "myvoiceismypassport?");
			}
		};
		try {
			return  RESTClient.postJSON(url, data.toMap(), headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String requestVerificationCode(String codeMethod, String locale) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/request_code";
		Map<String,Object> body = new HashMap<>() {
			{
				put(KEY.code_method.name(), codeMethod);
				put(KEY.locale.name(), locale);
			}
		};
		try {
			return RESTClient.postJSON(url, body, POST_HEADERS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String sendOrderDetailsMessage(String codeMethod, String locale) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/request_code";
		Map<String,Object> body = new HashMap<>() {
			{
				put(KEY.code_method.name(), codeMethod);
				put(KEY.locale.name(), locale);
			}
		};
		try {
			return RESTClient.postJSON(url, body, POST_HEADERS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String sendOrderStatusMessage(String codeMethod, String locale) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/request_code";
		Map<String,Object> body = new HashMap<>() {
			{
				put(KEY.code_method.name(), codeMethod);
				put(KEY.locale.name(), locale);
			}
		};
		try {
			return RESTClient.postJSON(url, body, POST_HEADERS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String verifyCode(String requestedVerifyCode) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/verify_code";
		Map<String,Object> body = new HashMap<>() {
			{
				put(KEY.code.name(), requestedVerifyCode);
			}
		};
		try {
			return RESTClient.postJSON(url, body, POST_HEADERS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default String setTwoStepVerificationCode(String pin) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID;
		Map<String,Object> body = new HashMap<>() {
			{
				put(KEY.pin.name(), pin);
			}
		};
		try {
			return RESTClient.postJSON(url, body, POST_HEADERS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	
	
	public default String createUploadSession(String fileName, String fileType, long fileLength) {
		String url = DOMAIN + VERSION
				+ "/app/uploads/?file_length=" + fileLength + "&file_type="+fileType+"&file_name=" + fileName;
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.remove(CONTENT_TYPE);
		try {
			return RESTClient.postJSON(url, new HashMap<>(), headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String success = "{\"id\": \"upload:MTphdHRhY2htZW50Ojlk2mJiZxUwLWV6MDUtNDIwMy05yTA3LWQ4ZDPmZGFkNTM0NT8=?sig=ARZqkGCA_uQMxC8nHKI\"}";
			return success;
		}
	}

	public default String uploadFileData(InputStream inputStream, String uploadId, String contentType) {
		String url = DOMAIN + VERSION + "/" + uploadId;
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.put(CONTENT_TYPE, contentType);
		headers.put("file_offset", "0");
		headers.put(AUTHORIZATION, "OAuth " + ACCESS_TOKEN);
		try {
			return RESTClient.post(url, inputStream, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String success = "{\"h\": \"2:c2FtcGxlLm1wNA==:image/jpeg:GKAj0gAUCZmJ1voFADip2iIAAAAAbugbAAAA:e:1472075513:ARZ_3ybzrQqEaluMUdI\"}";
			return success;
		}
	}

	public default String queryFileUploadStatus(String uploadId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + uploadId;
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.put(AUTHORIZATION, "OAuth " + ACCESS_TOKEN);

		try {
			return RESTClient.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String success = "{ \"id\": \"upload:MTphdHRhY2htZW50Ojlk2mJiZxUwLWV6MDUtNDIwMy05yTA3LWQ4ZDPmZGFkNTM0NT8=?sig=ARZqkGCA_uQMxC8nHKI\", \"file_offset\": 0 }";
			return success;
		}
	}

	public default String getBusinessProfileId() {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID
				+ "/whatsapp_business_profile?fields=about,address,description,email,profile_picture_url,websites,vertical";
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.put(AUTHORIZATION, "Bearer " + ACCESS_TOKEN);

		try {
			return RESTClient.get(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String success = "{\"data\": [{\"business_profile\": {"
					+ "                \"messaging_product\": \"whatsapp\","
					+ "                \"address\": \"business-address\","
					+ "                \"description\": \"business-description\","
					+ "                \"vertical\": \"business-industry\","
					+ "                \"about\": \"profile-about-text\","
					+ "                \"email\": \"business-email\"," + "                \"websites\": ["
					+ "                    \"https://website-1\"," + "                    \"https://website-2\""
					+ "                ],"
					+ "                \"profile_picture_url\": \"<PROFILE_PICTURE_URL>\"                \n"
					+ "            }" + "        }" + "    ]" + "}";
			return success;
		}
	}

	public default String updateBusinessProfile(MESSAGE_MODEL businessProfile) {

		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/whatsapp_business_profile";

		try {
			return RESTClient.postJSON(url, businessProfile.toMap(), POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String uploadImageFormData(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId + "/media";
		try {
			Map<String, String> headers = new HashMap<>(POST_HEADERS);
			headers.remove(AUTHORIZATION);
			headers.put(CONTENT_TYPE, "application/x-www-form-urlencoded");
			Map<String, String> data = new HashMap<>() {
				{
					put("messaging_product", "whatsapp");
					put("file", "/upload/sample.png");
				}
			};
			return RESTClient.postFormData(url, data, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String uploadImageJSON(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId + "/media";
		try {
			Map<String, String> headers = new HashMap<>(POST_HEADERS);

			Map<String, Object> data = new HashMap<>() {
				{
					put("messaging_product", "whatsapp");
					put("file", "@/local/path/file.jpg;type=image/jpeg");
				}
			};
			return RESTClient.postJSON(url, data, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String uploadStickerFileFormData(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId + "/media";
		try {
			Map<String, String> headers = new HashMap<>(POST_HEADERS);
			headers.remove(AUTHORIZATION);
			headers.put(CONTENT_TYPE, "application/x-www-form-urlencoded");
			Map<String, String> data = new HashMap<>() {
				{
					put("messaging_product", "whatsapp");
					put("file", "/upload/sample.webp");
				}
			};
			return RESTClient.postFormData(url, data, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String uploadStickerFileJSON(String phoneNumberId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + phoneNumberId + "/media";
		try {

			Map<String, Object> data = new HashMap<>() {
				{
					put("messaging_product", "whatsapp");
					put("file", "@/local/path/file.webp;type=webp");
				}
			};
			return RESTClient.postJSON(url, data, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String getMediaURL(String phoneNumberId, String mediaId) {
		String url = DOMAIN + VERSION + "/" + mediaId + "?phone_number_id=" + phoneNumberId;
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.remove(CONTENT_TYPE);
		try {
			return RESTClient.get(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default boolean deleteMedia(String phoneNumberId, String mediaId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + mediaId + "/?phone_number_id=" + phoneNumberId;
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.remove(CONTENT_TYPE);
		try {
			return RESTClient.delete(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public default byte[] downloadMedia(String mediaURL) {
		String url = DOMAIN + VERSION + "/" + mediaURL;
		Map<String, String> headers = new HashMap<>(POST_HEADERS);
		headers.remove(CONTENT_TYPE);
		try {
			return RESTClient.getBytes(url, headers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new byte[0];
		}
	}

	public default String sendTextMessage(String content) {
		return sendTextMessage(TEST_NUMBER, content);
	}
	
	public default String sendTextMessage(String phoneNumberId, String content) {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> text = new HashMap<>(TEXT);
		text.put("body", content);
		Map<String, Object> textMessage = new HashMap<>(TEXT_MESSAGE);
		textMessage.put("text", text);
		textMessage.put("to", phoneNumberId);
		try {
			return RESTClient.postJSON(url, textMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendReplyToTextMessage(String fromPhoneNumber, String content, String messageId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + fromPhoneNumber + "/messages";
		Map<String, Object> context = new HashMap<>(MESSAGE_CONTEXT);
		context.put("message_id", messageId);
		Map<String, Object> text = new HashMap<>(TEXT);
		text.put("body", content);
		Map<String, Object> replyTextMessage = new HashMap<>(REPLY_TEXT_MESSAGE);
		replyTextMessage.put("text", text);
		replyTextMessage.put("to", TEST_NUMBER);
		replyTextMessage.put("context", context);
		try {
			return RESTClient.postJSON(url, replyTextMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendTextMessageWithPreviewURL(String phoneNumberId, String content) {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> previewURL = new HashMap<>(TEXT_WITH_PREVIEW_URL);
		previewURL.put("body", content);
		Map<String, Object> previewURLMessage = new HashMap<>(PREVIEW_URL_MESSAGE);
		previewURLMessage.put("text", previewURL);
		previewURLMessage.put("to", phoneNumberId);
		try {
			return RESTClient.postJSON(url, previewURLMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendReplyWithReactionMessage(String phoneNumberId, String emoji, String messageId) {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/messages";

		Map<String, Object> reaction = new HashMap<>(REACTION);
		reaction.put("emoji", emoji);
		reaction.put("message_id", messageId);
		Map<String, Object> replyReactionMessage = new HashMap<>(REACTION_MESSAGE);
		replyReactionMessage.put("reaction", reaction);
		replyReactionMessage.put("to", phoneNumberId);
		try {
			return RESTClient.postJSON(url, replyReactionMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendImageMessageById(String phoneNumberId, String imageId) {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> image = new HashMap<>(IMAGE_ID);
		image.put("id", imageId);
		Map<String, Object> imageMessage = new HashMap<>(IMAGE_MESSAGE);
		imageMessage.put("image", image);
		imageMessage.put("to", phoneNumberId);
		try {
			return RESTClient.postJSON(url, imageMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}

	}

	public default String sendReplyToImageMessageById(String recipientPhoneNumber, String messageId,
			String imageObjectId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> context = new HashMap<>(MESSAGE_CONTEXT);
		context.put("message_id", messageId);
		Map<String, Object> image = new HashMap<>(IMAGE_ID);
		image.put("id", imageObjectId);
		Map<String, Object> replyImageMessage = new HashMap<>(IMAGE_MESSAGE);
		replyImageMessage.put("image", image);
		replyImageMessage.put("to", recipientPhoneNumber);
		replyImageMessage.put("context", context);
		try {
			return RESTClient.postJSON(url, replyImageMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendImageMessageByURL(String recipientPhoneNumber, String imageURL) {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> image = new HashMap<>(IMAGE_LINK);
		image.put("link", imageURL);
		Map<String, Object> imageMessage = new HashMap<>(IMAGE_MESSAGE);
		imageMessage.put("image", image);
		imageMessage.put("to", recipientPhoneNumber);
		try {
			return RESTClient.postJSON(url, imageMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}

	}

	public default String sendReplyToImageMessageByURL(String recipientPhoneNumber, String messageId, String imageURL) {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> context = new HashMap<>(MESSAGE_CONTEXT);
		context.put("message_id", messageId);
		Map<String, Object> image = new HashMap<>(IMAGE_LINK);
		image.put("link", imageURL);
		Map<String, Object> replyImageMessage = new HashMap<>(IMAGE_MESSAGE);
		replyImageMessage.put("image", image);
		replyImageMessage.put("to", recipientPhoneNumber);
		replyImageMessage.put("context", context);
		try {
			return RESTClient.postJSON(url, replyImageMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendAudioMessageById(String recipientphoneNumber, String audioId) {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> audio = new HashMap<>(AUDIO_ID);
		audio.put("id", audioId);
		Map<String, Object> audioMessage = new HashMap<>(AUDIO_MESSAGE);
		audioMessage.put("audio", audio);
		audioMessage.put("to", recipientphoneNumber);
		try {
			return RESTClient.postJSON(url, audioMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}

	}

	public default String sendReplyToAudioMessageById(String recipientPhoneNumber, String messageId,
			String audioObjectId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> context = new HashMap<>(MESSAGE_CONTEXT);
		context.put("message_id", messageId);
		Map<String, Object> audio = new HashMap<>(AUDIO_ID);
		audio.put("id", audioObjectId);
		Map<String, Object> replyAudioMessage = new HashMap<>(AUDIO_MESSAGE);
		replyAudioMessage.put("audio", audio);
		replyAudioMessage.put("to", recipientPhoneNumber);
		replyAudioMessage.put("context", context);
		try {
			return RESTClient.postJSON(url, replyAudioMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendAudioMessageByURL(String recipientPhoneNumber, String audioURL) {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> audio = new HashMap<>(AUDIO_LINK);
		audio.put("link", audioURL);
		Map<String, Object> audioMessage = new HashMap<>(AUDIO_MESSAGE);
		audioMessage.put("audio", audio);
		audioMessage.put("to", recipientPhoneNumber);
		try {
			return RESTClient.postJSON(url, audioMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}

	}

	public default String sendReplyToAudioMessageByURL(String recipientPhoneNumber, String messageId, String audioURL) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> context = new HashMap<>(MESSAGE_CONTEXT);
		context.put("message_id", messageId);
		Map<String, Object> audio = new HashMap<>(AUDIO_LINK);
		audio.put("link", audioURL);
		Map<String, Object> replyAudioMessage = new HashMap<>(AUDIO_MESSAGE);
		replyAudioMessage.put("audio", audio);
		replyAudioMessage.put("to", recipientPhoneNumber);
		replyAudioMessage.put("context", context);
		try {
			return RESTClient.postJSON(url, replyAudioMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendDocumentMessageById(String recipientphoneNumber, String documentId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> document = new HashMap<>(DOCUMENT_ID);
		document.put("id", documentId);
		Map<String, Object> documentMessage = new HashMap<>(DOCUMENT_MESSAGE);
		documentMessage.put("document", document);
		documentMessage.put("to", recipientphoneNumber);
		try {
			return RESTClient.postJSON(url, documentMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}

	}

	public default String sendReplyToDocumentMessageById(String recipientPhoneNumber, String messageId,
			String documentObjectId, String filename, String caption) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> context = new HashMap<>(MESSAGE_CONTEXT);
		context.put("message_id", messageId);
		Map<String, Object> document = new HashMap<>(DOCUMENT_ID);
		document.put("id", documentObjectId);
		document.put("filename", filename);
		document.put("caption", caption);
		Map<String, Object> replyAudioMessage = new HashMap<>(DOCUMENT_MESSAGE);
		replyAudioMessage.put("document", document);
		replyAudioMessage.put("to", recipientPhoneNumber);
		replyAudioMessage.put("context", context);
		try {
			return RESTClient.postJSON(url, replyAudioMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendDocumentMessageByURL(String recipientPhoneNumber, String documentURL, String caption) {
		String url = DOMAIN + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> document = new HashMap<>(DOCUMENT_LINK);
		document.put("link", documentURL);
		document.remove("filename");
		document.put("caption", caption);
		Map<String, Object> documentMessage = new HashMap<>(DOCUMENT_MESSAGE);
		documentMessage.put("document", document);
		documentMessage.put("to", recipientPhoneNumber);
		try {
			return RESTClient.postJSON(url, documentMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}

	}

	public default String sendReplyToDocumentMessageByURL(String recipientPhoneNumber, String messageId,
			String documentURL, String caption) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> context = new HashMap<>(MESSAGE_CONTEXT);
		context.put("message_id", messageId);
		Map<String, Object> document = new HashMap<>(DOCUMENT_LINK);
		document.put("caption", caption);
		document.remove("filename");
		document.put("link", documentURL);
		Map<String, Object> replyDocumentMessage = new HashMap<>(DOCUMENT_MESSAGE);
		replyDocumentMessage.put("document", document);
		replyDocumentMessage.put("to", recipientPhoneNumber);
		replyDocumentMessage.put("context", context);
		try {
			return RESTClient.postJSON(url, replyDocumentMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendMessageById(MESSAGE_TYPE type, String recipientphoneNumber, String id) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> identifier = new HashMap<>(type.getId());
		identifier.put("id", id);
		Map<String, Object> message = new HashMap<>(type.getMessage());
		message.put(type.name(), identifier);
		message.put("to", recipientphoneNumber);
		try {
			return RESTClient.postJSON(url, message, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}

	}

	public default String sendReplyToMessageById(MESSAGE_TYPE type, String recipientPhoneNumber, String messageId,
			String resourceId, String filename, String caption) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> context = new HashMap<>(MESSAGE_CONTEXT);
		context.put("message_id", messageId);
		Map<String, Object> identifier = new HashMap<>(type.getId());
		identifier.put("id", resourceId);
		if (type == MESSAGE_TYPE.DOCUMENT) {
			identifier.put("filename", filename);
			identifier.put("caption", caption);
		}
		Map<String, Object> message = new HashMap<>(type.getMessage());
		message.put(type.name(), identifier);
		message.put("to", recipientPhoneNumber);
		message.put("context", context);
		try {
			return RESTClient.postJSON(url, message, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}

	public default String sendMessageByURL(MESSAGE_TYPE type, String recipientPhoneNumber, String resourceURL,
			String caption) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> link = new HashMap<>(type.getLink());
		link.put("link", resourceURL);
		if (type == MESSAGE_TYPE.DOCUMENT) {
			link.remove("filename");
			link.put("caption", caption);
		}
		Map<String, Object> message = new HashMap<>(type.getMessage());
		message.put(type.name(), link);
		message.put("to", recipientPhoneNumber);
		try {
			return RESTClient.postJSON(url, message, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}

	}

	public default String sendReplyToMessageByURL(MESSAGE_TYPE type, String recipientPhoneNumber, String messageId,
			String resourceURL, String caption) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		Map<String, Object> context = new HashMap<>(MESSAGE_CONTEXT);
		context.put("message_id", messageId);
		Map<String, Object> link = new HashMap<>(type.getLink());
		if (type == MESSAGE_TYPE.DOCUMENT) {
			link.put("caption", caption);
			link.remove("filename");
		}
		link.put("link", resourceURL);
		Map<String, Object> replyMessage = new HashMap<>(type.getMessage());
		replyMessage.put(type.name(), link);
		replyMessage.put("to", recipientPhoneNumber);
		replyMessage.put("context", context);
		try {
			return RESTClient.postJSON(url, replyMessage, POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	public default <T extends MESSAGE_MODEL> String sendMessage(String recipientPhoneNumber, T requestBody, String messageId) {
		String url = "https://graph.facebook.com/" + VERSION + "/" + PHONE_NUMBER_ID + "/messages";
		if(messageId != null) {
			requestBody.setContext(messageId);
		}
		requestBody.put(CONTACTS_MESSAGE.KEY.to, recipientPhoneNumber);
		try {
			return RESTClient.postJSON(url, requestBody.toMap(), POST_HEADERS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
}
