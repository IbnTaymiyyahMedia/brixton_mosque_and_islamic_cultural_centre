package com.example.stripe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.stripe.model.MSProduct;
import com.example.stripe.nessages.MSChange;
import com.example.stripe.nessages.MSEntry;
import com.example.stripe.nessages.MSError;
import com.example.stripe.nessages.MSErrorData;
import com.example.stripe.nessages.MSMessage;
import com.example.stripe.nessages.MSMetadata;
import com.example.stripe.nessages.MSStatus;
import com.example.stripe.nessages.MSText;
import com.example.stripe.nessages.MSTextMessage;
import com.example.stripe.nessages.MSValue;
import com.example.stripe.repository.MSProductRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;

import com.stripe.model.checkout.Session;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.ProductCreateParams.Type;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class StripeController {

	private static final String YOUR_DOMAIN = "http://localhost:5000";

	@Autowired
	private MSProductRepository repository;

	@GetMapping("/load")
	public MSProduct load() {
		MSProduct myProduct;
		try {
			myProduct = createProduct("£5 Zakaat",
					"£5/Month Make your Zakat payment to help families in need who are struggling. They need our help and support.",
					"Zakaat", 500L);
			repository.save(myProduct);
			myProduct = createProduct("£10 Zakaat",
					"£10/Month Make your Zakat payment to help families in need who are struggling. They need our help and support.",
					"Zakaat", 1000L);
			repository.save(myProduct);
			myProduct = createProduct("£15 Zakaat",
					"£15/Month Make your Zakat payment to help families in need who are struggling. They need our help and support.",
					"Zakaat", 1500L);
			repository.save(myProduct);
			myProduct = createProduct("£20 Zakaat",
					"£20/Month Make your Zakat payment to help families in need who are struggling. They need our help and support.",
					"Zakaat", 2000L);
			repository.save(myProduct);
			myProduct = createProduct("£25 Zakaat",
					"£25/Month Make your Zakat payment to help families in need who are struggling. They need our help and support.",
					"Zakaat", 2500L);
			repository.save(myProduct);

			myProduct = createProduct("£5 Sadaqah", "£5/Month Sadaqah wipes out sins like water extinguishes fire.",
					"Sadaqah", 500L);
			repository.save(myProduct);
			myProduct = createProduct("£10 Sadaqah", "£10/Month Sadaqah wipes out sins like water extinguishes fire.",
					"Sadaqah", 1000L);
			repository.save(myProduct);
			myProduct = createProduct("£15 Sadaqah", "£15/Month Sadaqah wipes out sins like water extinguishes fire.",
					"Sadaqah", 1500L);
			repository.save(myProduct);
			myProduct = createProduct("£20 Sadaqah", "£20/Month Sadaqah wipes out sins like water extinguishes fire.",
					"Sadaqah", 2000L);
			repository.save(myProduct);
			myProduct = createProduct("£25 Sadaqah", "£25/Month Sadaqah wipes out sins like water extinguishes fire.",
					"Sadaqah", 2500L);
			repository.save(myProduct);

			myProduct = createProduct("£5 Mosque Fund",
					"£5/Month We are very grateful for any and all donations made to The Brixton Mosque & Islamic Cultural Centre regardless of the amount.",
					"Mosque Fund", 500L);
			repository.save(myProduct);
			myProduct = createProduct("£10 Mosque Fund",
					"£10/Month Please donate generously as this ensures that the mosque is maintained, and the Muslim and wider community continuously benefits to the maximum extent. Be assured that all donations are strictly kept separate for the Mosque only. ",
					"Mosque Fund", 1000L);
			repository.save(myProduct);
			myProduct = createProduct("£15 Mosque Fund",
					"£15/Month Whoever builds a masjid for the sake of Allah, Allah builds for him a mansion in Jannah\" (Al-Hadith, Sahih Bukhari). ",
					"Mosque Fund", 1500L);
			repository.save(myProduct);
			myProduct = createProduct("£20 Mosque Fund",
					"£20/Month Whoever builds a masjid for the sake of Allah, Allah builds for him a mansion in Jannah\" (Al-Hadith, Sahih Bukhari). ",
					"Mosque Fund", 2000L);
			repository.save(myProduct);
			myProduct = createProduct("£25 Mosque Fund",
					"£25/Month Whoever builds a masjid for the sake of Allah, Allah builds for him a mansion in Jannah\" (Al-Hadith, Sahih Bukhari). ",
					"Mosque Fund", 2500L);
			repository.save(myProduct);

			myProduct = createProduct("Electric Bill Subscription",
					"£5/Month Please sponsor and help the mosque by donating generously to help pay for the Electricity thats used every month.",
					"Utilities", 500L);
			repository.save(myProduct);
			myProduct = createProduct("Gas Bill Subscription",
					"£5/Month Please sponsor and help the mosque by donating generously to help pay for the Gas thats used every month.",
					"Utilities", 500L);
			repository.save(myProduct);
			myProduct = createProduct("Water Rate Subscription",
					"£5/Month Please sponsor and help the mosque by donating generously to help pay for the Water thats used every month.",
					"Utilities", 500L);
			repository.save(myProduct);
			myProduct = createProduct("Telephone Bill Subscription",
					"£5/Month Please sponsor and help the mosque by donating generously to help pay for the Telephone thats used every month.",
					"Utilities", 500L);
			repository.save(myProduct);
			myProduct = createProduct("Service Charge Subscription",
					"£5/Month Please sponsor and help the mosque by donating generously to help pay for the cleaning, and maintenance which constitutes a significant budget every month.",
					"Utilities", 500L);
			repository.save(myProduct);
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			myProduct = new MSProduct();
		}
		return myProduct;
	}

	@GetMapping(path = "/products.json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<MSProduct> products() {
		return repository.findAll();
	}

	private MSProduct createProduct(String name, String description, String category, Long amount)
			throws StripeException {

		ProductCreateParams productParams = ProductCreateParams.builder().setName(name).setType(Type.SERVICE)
				.setDescription(description).setShippable(false).build();
		Product product;

		product = Product.create(productParams);
		Map<String, String> metadata = new HashMap<>();
		product.setMetadata(metadata);

		System.out.println("Success! Here is your starter subscription product id: " + product.getId());

		PriceCreateParams params = PriceCreateParams.builder().setProduct(product.getId()).setCurrency("gbp")
				.setUnitAmount(amount).setRecurring(PriceCreateParams.Recurring.builder()
						.setInterval(PriceCreateParams.Recurring.Interval.MONTH).build())
				.build();

		Price price = Price.create(params);
		product.setDefaultPriceObject(price);

		MSProduct myProduct = toModel(product);
		myProduct.setCategory(category);
		System.out.println("Success! Here is your starter subscription price id: " + price.getId());
		return myProduct;
	}

	public void session() {
		SessionCreateParams params = SessionCreateParams.builder().setMode(SessionCreateParams.Mode.PAYMENT)
				.setSuccessUrl(YOUR_DOMAIN + "/success.html").setCancelUrl(YOUR_DOMAIN + "/cancel.html")
				.addLineItem(SessionCreateParams.LineItem.builder().setQuantity(1L)
						// Provide the exact Price ID (for example, pr_1234) of the product you want to
						// sell
						.setPrice("{{PRICE_ID}}").build())
				.build();
		try {
			Session session = Session.create(params);
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void success() {

	}

	public void cancel() {

	}

	@GetMapping("/pricetLink")
	public RedirectView priceLink(@RequestParam(name = "priceId", required = false) String priceId) {
		PaymentLinkCreateParams params = PaymentLinkCreateParams.builder()
				.addLineItem(PaymentLinkCreateParams.LineItem.builder().setPrice(priceId).setQuantity(1L).build())
				.build();

		try {
			PaymentLink paymentLink = PaymentLink.create(params);
			return new RedirectView(paymentLink.getUrl());
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new RedirectView(YOUR_DOMAIN + "/cancel.html");
		}

	}

	@GetMapping("/meta/callback")
	public String callback(@RequestParam(value = "hub.mode") String mode,
			@RequestParam(value = "hub.challenge") String challenge,
			@RequestParam(value = "hub.verify_token") String verifyToken, HttpServletResponse response) {
		if (mode != null && verifyToken != null) {
			if (mode.compareTo("subscribe") == 0 && verifyToken.compareTo("adrianjohnsontoken") == 0) {

				response.setStatus(HttpServletResponse.SC_OK);
				return challenge;
			} else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return "";
			}
		}
		return "";
	}

	@GetMapping("/productPrice")
	public MSProduct productPrice(@RequestParam(name = "productId", required = false) String productId) {
		try {
			Product product = Product.retrieve(productId);
			MSProduct model = toModel(product);
			return model;
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new MSProduct();
		}
	}

	@PostMapping("/meta/callback")
	void callback(@RequestBody MSTextMessage textMessage) {
		if (textMessage != null && textMessage.getEntry() != null) {
			List<MSEntry> entries = textMessage.getEntry();
			if (!entries.isEmpty()) {
				MSEntry entry = entries.get(0);
				if (entry != null && entry.getChanges() != null) {
					List<MSChange> changes = entry.getChanges();
					if (!changes.isEmpty()) {
						MSChange change = changes.get(0);
						if (change.getValue() != null) {
							MSValue value = change.getValue();
							List<MSError> errors = value.getErrors();
							List<MSStatus> statuses = value.getStatuses();
							if(statuses != null) {
							MSStatus status = statuses.get(0);
							
							List<MSError> statusErrors = status.getErrors();
							if(statusErrors != null && !statusErrors.isEmpty()) {
							MSError statusError = statusErrors.get(0);
							MSErrorData errorData = statusError.getError_data();
							String details = errorData.getDetails();
							}
							if (value.getMessages() != null) {
								List<MSMessage> messages = value.getMessages();
								MSMetadata metadata = value.getMetadata();
								if (!messages.isEmpty()) {
									MSMessage message = messages.get(0);
									if (message.getText() != null) {
										MSText text = message.getText();
										if (text.getBody() != null) {
											System.out.println("message " + text.getBody());
										}
									}
								}
							}
							}
						}
					}
				}
			}
		}

	}

	private MSProduct toModel(Product product) {
		MSProduct myProduct = new MSProduct();
		myProduct.setActive(product.getActive());
		myProduct.setCreated(product.getCreated());
		myProduct.setDeleted(product.getDeleted());
		myProduct.setDescription(product.getDescription());
		myProduct.setProductId(product.getId());
		myProduct.setLivemode(product.getLivemode());
		List<String> images = product.getImages();
		if (images != null && !images.isEmpty()) {
			myProduct.setImage(images.get(0));
		}
		myProduct.setShippable(product.getShippable());
		myProduct.setStatementDescriptor(product.getStatementDescriptor());
		myProduct.setName(product.getName());
		myProduct.setType(product.getType());
		myProduct.setUnitLabel(product.getUnitLabel());
		myProduct.setUpdated(product.getUpdated());
		myProduct.setUrl(product.getUrl());
		Price price = product.getDefaultPriceObject();
		if (price != null) {
			myProduct.setPriceId(price.getId());
			myProduct.setBillingScheme(price.getBillingScheme());
			myProduct.setCurrency(price.getCurrency());
			myProduct.setLookupKey(price.getLookupKey());
			myProduct.setNickname(price.getNickname());
			myProduct.setTaxBehavior(price.getTaxBehavior());
			myProduct.setTiersMode(price.getTiersMode());
			myProduct.setUnitAmount(price.getUnitAmount());

		}

		return myProduct;
	}
}
