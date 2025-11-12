/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppoo_decorator;

/**
 *
 * @author proft
 */
public class TelegramDecorator extends BaseNotifierDecorator {

    public TelegramDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        String phoneNbr = databaseService.getPhoneNbrFromUsername(getUsername());
        System.out.println("Sending " + msg + " by Telegram on " + phoneNbr);
    }
}
