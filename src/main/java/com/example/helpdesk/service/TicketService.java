package com.example.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // ADD TICKET
    public Ticket saveTicket(Ticket ticket) {

        ticket.setStatus("PENDING");

        Ticket savedTicket = ticketRepository.save(ticket);

        messagingTemplate.convertAndSend("/topic/tickets", "updated");

        return savedTicket;
    }

    // GET ALL TICKETS
    public List<Ticket> getAllTickets() {

        return ticketRepository.findAll();
    }

    // UPDATE STATUS
    public Ticket updateTicketStatus(Long id, String status) {

        Ticket ticket = ticketRepository.findById(id).orElse(null);

        if(ticket != null) {

            ticket.setStatus(status);

            Ticket updatedTicket = ticketRepository.save(ticket);

            messagingTemplate.convertAndSend("/topic/tickets", "updated");

            return updatedTicket;
        }

        return null;
    }

    // DELETE TICKET
    public void deleteTicket(Long id) {

        ticketRepository.deleteById(id);

        messagingTemplate.convertAndSend("/topic/tickets", "updated");
    }
}