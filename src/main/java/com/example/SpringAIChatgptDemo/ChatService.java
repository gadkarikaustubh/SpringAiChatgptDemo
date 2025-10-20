package com.example.SpringAIChatgptDemo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.ModelOptions;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

	private final ChatModel chatModel;

	public ChatService(ChatModel chatModel) {
	
		this.chatModel = chatModel;
	}
	
	
	public String getResponse(String prompt) {
		return chatModel.call(prompt);
	}
	
	public String getResponseFromOptions (String prompt) {
		
	
	ModelOptions modelOptions = ModelOptions.builder()
		    .with("model", "gpt-4o-mini")
		    .with("temperature", 0.7)
		    .with("max_tokens", 150)
		    .build();

		OpenAiChatOptions openAiChatOptions = OpenAiChatOptions.builder()
		    .withModelOptions(modelOptions)
		    .build();
	
	ChatResponse chatResponse = chatModel.call(new Prompt(prompt));
	return	chatResponse.getResult().getOutput().getText();
	}
	
}
