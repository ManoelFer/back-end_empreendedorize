package com.manoelneto.empreendedorize.ws.services.email;

import com.manoelneto.empreendedorize.ws.domain.User;
import com.manoelneto.empreendedorize.ws.domain.VerificationToken;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendHtmlEmail(MimeMessage msg);
    void sendConfirmationHtmlEmail(User user, VerificationToken vToken);
}
