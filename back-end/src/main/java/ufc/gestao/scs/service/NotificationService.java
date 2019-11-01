package ufc.gestao.scs.service;

public interface NotificationService {

    void enviarMensagem(String assunto, String corpo, String destinatario);

}