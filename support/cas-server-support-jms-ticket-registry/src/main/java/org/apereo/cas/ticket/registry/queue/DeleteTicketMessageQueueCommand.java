package org.apereo.cas.ticket.registry.queue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.StringBean;
import org.apereo.cas.ticket.registry.TicketRegistry;
import lombok.Getter;

/**
 * This is {@link DeleteTicketMessageQueueCommand}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@Slf4j
@Getter
public class DeleteTicketMessageQueueCommand extends BaseMessageQueueCommand {

    private static final long serialVersionUID = 8183330712274484245L;

    @JsonProperty
    private String ticketId;

    @JsonCreator
    public DeleteTicketMessageQueueCommand(@JsonProperty("id") final StringBean id, @JsonProperty("ticketId") final String ticketId) {
        super(id);
        this.ticketId = ticketId;
    }

    @Override
    public void execute(final TicketRegistry registry) {
        LOGGER.debug("Executing queue command on ticket registry id [{}] to delete ticket [{}]", getId().getId(), ticketId);
        registry.deleteTicket(this.ticketId);
    }
}
