package com.example.stripe.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.stripe.model.MSBusinessProfile;
import com.example.stripe.service.MESSAGE_MODEL.KEY;
import com.example.stripe.service.MSProfileService;
import com.example.stripe.service.MSWhatsApp;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MSProfileController implements MSWhatsApp {

	@Autowired
	private MSProfileService service;

	@PostMapping("/profiles/save")
	public String saveProfile(@ModelAttribute(name = "profileImage") MSBusinessProfile profileImage,
			RedirectAttributes ra, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String fileType = multipartFile.getContentType();
		int length = multipartFile.getBytes().length;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String sessionJson = createUploadSession(fileName, fileType, length);
			Map<String, String> sessionObj = mapper.readValue(sessionJson, Map.class);
			String uploadId = sessionObj.get("id");
			String fileDataJson = uploadFileData( multipartFile.getInputStream(),  uploadId, fileType);
			 Map<String, String> fileDataObj = mapper.readValue(fileDataJson, Map.class);
			 String fileHandle = fileDataObj.get("h");
			BUSINESS_PROFILE.put(KEY.email, profileImage.getEmail());
		BUSINESS_PROFILE.put(KEY.address, profileImage.getAddress());
		BUSINESS_PROFILE.put(KEY.vertical, profileImage.getVertical());
		BUSINESS_PROFILE.put(KEY.about, profileImage.getAbout());
		BUSINESS_PROFILE.put(KEY.description, profileImage.getDescription());
		BUSINESS_PROFILE.put(KEY.profile_picture_handle, fileHandle);
		String updatedProfileJson = updateBusinessProfile(BUSINESS_PROFILE);
		
        

        

            // convert JSON string to Map
            Map<String, String> updatedProfileObj = mapper.readValue(updatedProfileJson, Map.class);
            profileImage.setImage(fileHandle);
        }catch (IOException ioe) {
        	ioe.printStackTrace();
        }
		
		
		MSBusinessProfile savedProfileImage = service.save(profileImage);
/*
		String uploadDir = "/profile-logo/" + savedProfileImage.getId();

		Path uploadPath = Paths.get(uploadDir);
		try {
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			InputStream inputStream = multipartFile.getInputStream();
			Path filePath = uploadPath.resolve(fileName);

			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException();
		}
*/
		ra.addFlashAttribute("message", "The profile has been saved successfully.");

		return "redirect:/profiles";
	}

	@GetMapping("/profiles")
	public String listAll(Model model) {
		return listByPage(1, model, "name", "asc", null);
	}

	@GetMapping("/profiles/page/{pageNum}")
	public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model,
			@Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
		// TODO Auto-generated method stub
		Page<MSBusinessProfile> page = service.listAll(pageNum, sortField, sortDir, keyword);
		if (page != null) {
			List<MSBusinessProfile> listProfiles = page.getContent();

			model.addAttribute("listProfiles", listProfiles);

			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements());
			model.addAttribute("currentPage", pageNum);
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("keyword", keyword);

			long startCount = (pageNum - 1) * MSProfileService.PROFILES_PER_PAGE + 1;
			model.addAttribute("startCount", startCount);

			long endCount = startCount + MSProfileService.PROFILES_PER_PAGE - 1;
			if (endCount > page.getTotalElements()) {
				endCount = page.getTotalElements();
			}

			model.addAttribute("endCount", endCount);

			if (page.getTotalPages() > 1) {
				model.addAttribute("pageTitle", "Profiles (page " + pageNum + ")");
			} else {
				model.addAttribute("pageTitle", "Profiles");
			}
		}
		return "profiles";
	}

	@GetMapping("/profiles/new")
	public String newProfile(Model model) {
		// TODO Auto-generated method stub

		model.addAttribute("pageTitle", "Create new Profile");

		model.addAttribute("profile", new MSBusinessProfile());

		return "profile_form";
	}
}
