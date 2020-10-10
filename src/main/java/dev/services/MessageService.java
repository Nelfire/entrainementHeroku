package dev.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.dto.MessageAjoutDto;
import dev.controller.dto.MessageDto;
import dev.entites.Collegue;
import dev.entites.Message;
import dev.exceptions.CollegueAuthentifieNonRecupereException;
import dev.repository.CollegueRepo;
import dev.repository.MessageRepo;

@Service
public class MessageService {

	// Déclarations
	private MessageRepo messageRepository;
	private CollegueRepo collegueRepository;

	/**
	 * Constructeur
	 *
	 * @param soldeRepository
	 */
	public MessageService(MessageRepo messageRepository, CollegueRepo collegueRepository) {
		this.messageRepository = messageRepository;
		this.collegueRepository = collegueRepository;
	}

	/**
	 * @param id
	 * @return la liste des soldes du collègue authentifié
	 */
	public List<MessageDto> listerMessages() {

		List<MessageDto> listeMessages = new ArrayList<>();

		for (Message message : messageRepository.findAll()) {

				MessageDto messageDto = new MessageDto(message.getDatePublication(),message.getCollegue().getEmail(),message.getContenu());

				listeMessages.add(messageDto);
			
		}
		return listeMessages;
	}
	
	@Transactional
	public MessageAjoutDto postMessage(@Valid MessageAjoutDto messageDto) {
		System.out.println("coucou");
		String email = messageDto.getEmailCollegue();

		Collegue collegue = collegueRepository.findByEmail(email).orElseThrow(() -> new CollegueAuthentifieNonRecupereException("Le collègue authentifié n'a pas été récupéré"));

		Message message = new Message(messageDto.getDatePublication(),collegue,messageDto.getContenu());
		this.messageRepository.save(message);
		System.out.println(message);
		return new MessageAjoutDto(messageDto.getDatePublication(),messageDto.getEmailCollegue(),messageDto.getContenu());
		
	}

}
