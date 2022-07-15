package dh.telegram.currency;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import javassist.Loader;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.nio.charset.Charset;

public class SimpleCurrencyBot extends TelegramLongPollingBot {

    private final String token;

    public SimpleCurrencyBot() throws IOException {

        token = Resources.toString(Resources.getResource("bot-token.tkn"), Charsets.UTF_8);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Currency exchange bot";
    }

    @Override
    public String getBotToken() {
        return token;
    }



}
