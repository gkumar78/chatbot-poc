package team.maverick.code.girish;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserData {
	@JsonProperty("user_id")
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	
}
