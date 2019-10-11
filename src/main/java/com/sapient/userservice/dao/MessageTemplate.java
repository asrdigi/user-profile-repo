package com.sapient.userservice.dao;

public class MessageTemplate {
    private String message;
    private String modeOfNotification;
    private String phoneNumber;
    private String email;
    public String getModeOfNotification() {
		return modeOfNotification;
	}

	public void setModeOfNotification(String modeOfNotification) {
		this.modeOfNotification = modeOfNotification;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MessageTemplate(String message, String modeOfNotification, String phoneNumber, String email) {
		super();
		this.message = message;
		this.modeOfNotification = modeOfNotification;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public MessageTemplate() {
        
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
	public String toString() {
		return "MessageTemplate [message=" + message + ", modeOfNotification=" + modeOfNotification + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}
    
}
    
