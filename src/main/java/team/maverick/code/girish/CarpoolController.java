package team.maverick.code.girish;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.dialogflow.v2.Context;
import com.google.cloud.dialogflow.v2.ContextOrBuilder;
import com.google.cloud.dialogflow.v2.EventInput;
import com.google.cloud.dialogflow.v2.EventInputOrBuilder;
import com.google.cloud.dialogflow.v2.WebhookRequest;
import com.google.cloud.dialogflow.v2.WebhookResponse;
import com.google.cloud.dialogflow.v2.WebhookResponseOrBuilder;
import com.google.cloud.dialogflow.v2.Intent.Message;
import com.google.cloud.dialogflow.v2.Intent.MessageOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;

@RestController
public class CarpoolController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CarpoolController.class);

	@RequestMapping(name = "/", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody WebhookResponse handleAgentRequest(@RequestBody WebhookRequest webhookRequest) {
		System.out.println("Received Webhook request as " + webhookRequest.toString());
		LOGGER.info("Received Webhook request with Intent ", webhookRequest.getQueryResult().getIntent().toString());
		return WebhookResponse.newBuilder().build();
	}
}
