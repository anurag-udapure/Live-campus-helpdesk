package com.example.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.service.TicketService;

@RestController
@RequestMapping("/tickets")
@CrossOrigin("*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // ADD TICKET
    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.saveTicket(ticket);
    }

    // GET ALL TICKETS
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // UPDATE STATUS
    @PutMapping("/{id}")
    public Ticket updateStatus(@PathVariable Long id,
                               @RequestParam String status) {

        return ticketService.updateTicketStatus(id, status);
    }

    // DELETE TICKET
    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {

        ticketService.deleteTicket(id);

        return "Ticket Deleted Successfully";
    }
}