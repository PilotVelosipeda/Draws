package com.example.DrawLoterya.services;
import com.example.DrawLoterya.dto.TicketDto;
import com.example.DrawLoterya.model.Ticket;
import com.example.DrawLoterya.repositories.TicketRepository;
import com.example.DrawLoterya.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketCRUDService implements UserService<TicketDto> {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public TicketCRUDService(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void create(TicketDto ticketDto) {
        Ticket ticket = mapToEntity(ticketDto);
    }
    public static TicketDto mapToDto(Ticket ticket) {
        System.out.println("Метод mapToDtoв классе TicketCRUDService" + ticket);
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setName(ticket.getName());
        ticketDto.setPrice(ticket.getPrice());
        ticketDto.setDescription(ticket.getDescription());
        ticketDto.setUserEmail(
                ticket.getUser().getEmail());
        return ticketDto;
    }

    public static Ticket mapToEntity(TicketDto ticketDto) {
        System.out.println("Метод mapToEntity в классе TicketCRUDService" + ticketDto);
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setName(ticketDto.getName());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setDescription(ticketDto.getDescription());
        return ticket;
    }
    @Override
    public void update(TicketDto ticketDto) {
        Ticket ticket = mapToEntity(ticketDto);
    }
    @Override
    public String get(String key) {
        return null;
    }
}
