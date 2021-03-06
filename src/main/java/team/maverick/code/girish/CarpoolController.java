package team.maverick.code.girish;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.dialogflow.v2.WebhookResponse;

@RestController
public class CarpoolController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CarpoolController.class);

	@RequestMapping(name = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public @ResponseBody String handleAgentRequest(@RequestBody String webhookRequestString) throws IOException, JSONException {
		System.out.println("Received Webhook request as " + webhookRequestString.toString());
		//System.out.println("Converted Webhook request is " + new ByteArrayInputStream(webhookRequestString.trim().getBytes()).toString());
		//WebhookRequest webhookRequest = WebhookRequest.parseFrom(new ByteArrayInputStream(webhookRequestString.trim().getBytes()));
		//LOGGER.info("Received Webhook request with Intent ", webhookRequest.getQueryResult().getIntent().toString());
		JSONObject jsonObject = new JSONObject(webhookRequestString);
		System.out.println("Parsed Webhook request is " + jsonObject.toString());
		System.out.println("Received intent as " + jsonObject.getJSONObject("queryResult").getJSONObject("intent").getString("displayName"));
		
		return new JSONObject().put("fulfillmentText", "Got response from Webhook").toString();
	}
}
