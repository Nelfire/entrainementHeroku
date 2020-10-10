/**
 * 
 */
package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.MessageAjoutDto;
import dev.controller.dto.MessageDto;
import dev.services.MessageService;

@RestController
@RequestMapping("messages")
public class MessageController {

	// Déclarations
	private MessageService messageService;


	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	/**
	 * LISTER MESSAGES
	 * 
	 * @param id
	 * @return une liste d'absences Dto
	 */
	@GetMapping
	public List<MessageDto> listerMessages() {
		return messageService.listerMessages();
	}
	
	@PostMapping
	public MessageAjoutDto postMessage(@RequestBody @Valid MessageAjoutDto messageAjoutDto) {
		System.out.println("JE PASSE ICI !!!");
		return this.messageService.postMessage(messageAjoutDto);
	}


}
